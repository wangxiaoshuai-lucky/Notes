package cn.wzy.zookeeper;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import java.io.IOException;

/**
 *
 * zookeeper连接
 */
public class CreateSession implements Watcher{
	private static ZooKeeper zooKeeper;

	@Override
	public void process(WatchedEvent watchedEvent) {

		if(watchedEvent.getState().equals(Event.KeeperState.SyncConnected)) {
			doBus();
		}
		System.out.println("接收内容："+watchedEvent.toString());
	}

	private void doBus() {
		System.out.println("做业务！");
	}

	public static void main(String[] args) {
		try {
			zooKeeper = new ZooKeeper("192.168.0.115:2181",5000, new CreateSession());
			System.out.println(zooKeeper.getState());
			Thread.sleep(5000);
			while (true) {}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}