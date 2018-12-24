package cn.wzy.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * zookeeper listener demo
 */
public class ListenerDemo implements Watcher {
	public static abstract class Subscriber {
		abstract String target();

		abstract void process(WatchedEvent event,String newValue);
	}

	private static ZooKeeper zooKeeper;
	private static final List<Subscriber> subscribers = new ArrayList<>();
	private CountDownLatch latch = new CountDownLatch(1);

	@Override
	public void process(WatchedEvent watchedEvent) {
		if (watchedEvent.getState().equals(Event.KeeperState.SyncConnected)) {
			//init done
			latch.countDown();
		} else if (watchedEvent.getState().equals(Event.KeeperState.Disconnected)) {
			System.out.println("Disconnected!");
		}
		//foreach
		synchronized (subscribers) {
			for (Subscriber subscribe : subscribers) {
				if (subscribe.target().equals(watchedEvent.getPath())) {
					try {
						//listening again
						String data = new String(zooKeeper.getData(watchedEvent.getPath(),true,null),"utf-8");
						subscribe.process(watchedEvent,data);
					} catch (KeeperException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * command : get path watch
	 */
	public boolean addSubscriber(Subscriber subscriber) {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		//add a subscriber
		synchronized (subscribers) {
			subscribers.add(subscriber);
		}
		try {
			//start listener
			zooKeeper.getData(subscriber.target(), true, null);
		} catch (KeeperException e) {
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * command : get path
	 */
	public static String get(String znode, boolean watch,String charset) {
		try {
			return new String(zooKeeper.getData(znode,watch,null),charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * command : set path data
	 */
	public static Stat set(String znode, String data, int version) {
		try {
			return zooKeeper.setData(znode,data.getBytes(),version);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * command : create path data [createMode]
	 */
	public static String create(String znode, String data, CreateMode createMode) {
		try {
			return zooKeeper.create(znode, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, createMode);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * command : ls path
	 */
	public static Stat exists(String znode, boolean watch) {
		try {
			zooKeeper.exists(znode, watch);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * command : delete path data
	 */
	public static void delete(String znode) {
		try {
			zooKeeper.delete(znode, -1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (KeeperException e) {
			e.printStackTrace();
		}
	}

	public ListenerDemo(String url, Integer timeOut) throws IOException {
		zooKeeper = new ZooKeeper(url, timeOut, this);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		ListenerDemo demo = new ListenerDemo("192.168.0.115:2181", 500);
		boolean res = demo.addSubscriber(new Subscriber() {
			@Override
			String target() {
				return "/config/aaa/bbb";
			}

			@Override
			void process(WatchedEvent event, String newValue) {
				System.out.println(target() + ", the new value is : " + newValue);
			}
		});
		System.out.println(res);
		while (true) {
//			set("/config/aaa/bbb",System.currentTimeMillis() + "",-1);
			Thread.sleep(2000);
		}
	}

}