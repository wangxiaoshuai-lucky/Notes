package cn.wzy.socketDemo.NIO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NIOServer {

	private Selector selector;
	private ByteBuffer buffer = ByteBuffer.allocate(2048);
	private ServerSocket serverSocket;
	private Map<String, Object> set = new HashMap<>();
	private Map<String, String> names = new HashMap<>();

	public NIOServer(int port) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocket = serverSocketChannel.socket();
		serverSocket.bind(new InetSocketAddress(port));
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("server start on " + port);
	}

	public void listen() throws IOException {
		while (true) {
			selector.select();
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				handleKey(key);
			}
			selector.selectedKeys().clear();
		}
	}

	private void handleKey(SelectionKey key) throws IOException {
		ServerSocketChannel server;
		SocketChannel client;
		if (key.isAcceptable()) {
			server = ((ServerSocketChannel) key.channel());
			client = server.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);
			System.out.println("receive connection from " + client.getRemoteAddress());
			boardMsg("当前有" + (names.size() + 1) + "人\n", null);
			write(client, "欢迎来到聊天室，请输入你的昵称！");
			key.interestOps(SelectionKey.OP_ACCEPT);
		} else if (key.isReadable()) {
			client = ((SocketChannel) key.channel());
			try {
				String[] msg = rec(client).split("###");
				if (msg.length > 0) {
					if (msg.length == 1) {
						if (set.containsKey(msg[0])) {
							write(client, " 重复的昵称：" + msg[0] + " ! 请重新输入!");
						} else {
							set.put(msg[0], null);
							names.put(client.getRemoteAddress().toString(),msg[0]);
							write(client, "hello " + msg[0]);
						}
					} else if (msg.length == 2) {
						System.out.println(client.getRemoteAddress() + " named " + msg[0] + " said： " + msg[1]);
						boardMsg(msg[0] + " 说: " + msg[1], client);
					}
				}
				key.interestOps(SelectionKey.OP_READ);
			} catch (Exception e) {
				String address = client.getRemoteAddress().toString();
				System.out.println("receive disconnection from " + address);
				String name = names.get(address);
				set.remove(name);
				names.remove(address);
				client.close();
				boardMsg(name + " 离开了聊天室!" + "还剩" + names.size() + "人!", null);
			}
		}
	}

	private void boardMsg(String msg, SocketChannel except) throws IOException {
		for (SelectionKey k : selector.keys()) {
			Channel target = k.channel();
			if (target.isOpen() && target instanceof SocketChannel && target != except) {
				write((SocketChannel) target, msg);
			}
		}
	}

	private String rec(SocketChannel channel) throws IOException {
		buffer.clear();
		int count = channel.read(buffer);
		return new String(buffer.array(), 0, count, StandardCharsets.UTF_8);
	}

	private void write(SocketChannel channel, String content) throws IOException {
		buffer.clear();
		buffer.put(content.getBytes(StandardCharsets.UTF_8));
		buffer.flip();
		channel.write(buffer);
	}

	public static void main(String[] args) throws IOException {
		NIOServer nioServer = new NIOServer(7777);
		nioServer.listen();
	}
}
