package cn.wzy.socketDemo.NIO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

	private Selector selector;
	private ByteBuffer buffer = ByteBuffer.allocate(1024);
	private ServerSocket serverSocket;
	private int sum = 0;
	private Set<String> names = new HashSet<>();

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
			client.register(selector,SelectionKey.OP_READ);
			sum++;
			System.out.println("receive connection from " + client.getRemoteAddress());
			write(client,"welcome to room, please input your name\n");
			boardMsg("当前人数：" + sum,null);
			key.interestOps(SelectionKey.OP_ACCEPT);
		} else if (key.isReadable()) {
			client = ((SocketChannel) key.channel());
			try {
				String[] msg = rec(client).split("###");
				if (msg.length > 0) {
					if (msg.length == 1){
						if (names.contains(msg[0])){
							write(client,msg[0] + " is repeated. please retry!");
						} else{
							names.add(msg[0]);
							write(client,"hello " + msg[0]);
						}
					} else if (msg.length == 2){
						System.out.println(client.getRemoteAddress() + " named " + msg[0] + " said " + msg[1]);
						boardMsg(msg[0] + " say " + msg[1], client);
					}
				}
				key.interestOps(SelectionKey.OP_READ);
			} catch (Exception e) {
				System.out.println("receive connection from " + client.getRemoteAddress());
				sum--;
				if (client != null)
					client.close();
			}
		}
	}

	private void boardMsg(String msg, SocketChannel except) throws IOException {
		for (SelectionKey k : selector.keys()) {
			Channel target = k.channel();
			if (target instanceof SocketChannel && target != except) {
				write((SocketChannel)target,msg);
			}
		}
	}

	private String rec(SocketChannel channel) throws IOException {
		buffer.clear();
		int count = channel.read(buffer);
		return new String(buffer.array(),0,count);
	}

	private void write(SocketChannel channel, String content) throws IOException {
		buffer.clear();
		buffer.put(content.getBytes());
		buffer.flip();
		channel.write(buffer);
	}

	public static void main(String[] args) throws IOException {
		NIOServer nioServer = new NIOServer(7777);
		nioServer.listen();
	}
}
