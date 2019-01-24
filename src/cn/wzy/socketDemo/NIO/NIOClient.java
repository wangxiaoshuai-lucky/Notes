package cn.wzy.socketDemo.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {

	private static int flag = 1;
	private static ByteBuffer inBuffer = ByteBuffer.allocate(1024);
	private static ByteBuffer outBuffer = ByteBuffer.allocate(1024);
	private final static InetSocketAddress address = new InetSocketAddress("127.0.0.1", 7777);


	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		Selector selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		socketChannel.connect(address);


		while (true) {
			selector.select();
			Set<SelectionKey> set = selector.selectedKeys();
			Iterator<SelectionKey> iterator = set.iterator();
			SocketChannel client;
			int count;
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				if (key.isConnectable()) {
					client = ((SocketChannel) key.channel());
					client.configureBlocking(false);
					if (client.isConnectionPending()) {
						client.finishConnect();
						outBuffer.clear();
						outBuffer.put("hello".getBytes());
						outBuffer.flip();
						client.write(outBuffer);
					}
					client.register(selector, SelectionKey.OP_READ);
				} else if (key.isReadable()) {
					client = ((SocketChannel) key.channel());
					inBuffer.clear();
					count = client.read(inBuffer);
					if (count > 0) {
						inBuffer.flip();
						System.out.println(new String(inBuffer.array(), 0, count, "utf-8"));
						client.register(selector, SelectionKey.OP_WRITE);
					}
				} else if (key.isWritable()) {
					client = ((SocketChannel) key.channel());
					outBuffer.clear();
					System.out.print("发送数据:");
					outBuffer.put(("send msg " + flag++).getBytes());
					outBuffer.flip();
					client.write(outBuffer);
					client.register(selector, SelectionKey.OP_READ);
				}
			}
			set.clear();
		}
	}
}
