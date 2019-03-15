package cn.wzy.socketDemo.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NIOClient {

	private static ByteBuffer buffer = ByteBuffer.allocate(1024);
	private final static InetSocketAddress address = new InetSocketAddress("120.77.151.141", 7777);

	static private String rec(SocketChannel channel) throws IOException {
		buffer.clear();
		int count = channel.read(buffer);
		return new String(buffer.array(),0,count);
	}

	static private void write(SocketChannel channel, String content) throws IOException {
		buffer.clear();
		buffer.put(content.getBytes());
		buffer.flip();
		channel.write(buffer);
	}

	private static volatile boolean success = false;
	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		SocketChannel socketChannel = SocketChannel.open(address);
		socketChannel.configureBlocking(false);
		socketChannel.register(selector, SelectionKey.OP_READ);
		new Thread(()->{
			SocketChannel client = null;
			try {
				while (true) {
					selector.select();
					Set<SelectionKey> set = selector.selectedKeys();
					Iterator<SelectionKey> iterator = set.iterator();
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						iterator.remove();
						if (key.isReadable()) {
							client = ((SocketChannel) key.channel());
							String msg = rec(client);
							if (msg.contains("hello"))
								success = true;
							System.out.println(msg);
							key.interestOps(SelectionKey.OP_READ);
						}
					}
					set.clear();
				}
			} catch (Exception e){
				if (client != null) {
					try {
						client.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}).start();
		Scanner scanner = new Scanner(System.in);
		String name = null;
		while(true) {
			name = scanner.next();
			if (success)
				break;
			write(socketChannel,name);
		}
		while (scanner.hasNext()) {
			String msg = scanner.next();
			write(socketChannel,name + "###" + msg);
		}
	}
}
