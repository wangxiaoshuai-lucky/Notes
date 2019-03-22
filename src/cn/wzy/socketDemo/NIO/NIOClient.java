package cn.wzy.socketDemo.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NIOClient {

	private static ByteBuffer buffer = ByteBuffer.allocate(1024);
	private final static InetSocketAddress address = new InetSocketAddress("127.0.0.1", 7777);

	static private String rec(SocketChannel channel) throws IOException {
		buffer.clear();
		int count = channel.read(buffer);
		return new String(buffer.array(), 0, count, StandardCharsets.UTF_8);
	}

	static private void write(SocketChannel channel, String content) throws IOException {
		buffer.clear();
		buffer.put(content.getBytes(StandardCharsets.UTF_8));
		buffer.flip();
		channel.write(buffer);
	}

	private static volatile boolean success = false;

	private static volatile String name = "wzy";

	public static void main(String[] args) throws IOException, InterruptedException {
		Selector selector = Selector.open();
		SocketChannel socketChannel = SocketChannel.open(address);
		socketChannel.configureBlocking(false);
		socketChannel.register(selector, SelectionKey.OP_READ);
		new Thread(() -> {
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
							if (msg.contains("hello")) {
								name = msg.substring(6);
								success = true;
							}
							System.out.println(msg);
							key.interestOps(SelectionKey.OP_READ);
						}
					}
					set.clear();
				}
			} catch (Exception e) {
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
		String tmp = null;
		while (true) {
			tmp = scanner.nextLine();
			if (success)
				break;
			write(socketChannel, tmp);
		}
		write(socketChannel, name + "###" + tmp);
		while (true) {
			String msg = scanner.nextLine();
			if (!msg.trim().equals(""))
				write(socketChannel, name + "###" + msg);
		}
	}
}
