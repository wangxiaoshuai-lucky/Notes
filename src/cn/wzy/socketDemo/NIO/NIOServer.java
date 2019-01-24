package cn.wzy.socketDemo.NIO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {

	private int flag = 1;
	private Selector selector;
	private ByteBuffer inBuffer = ByteBuffer.allocate(1024);
	private ByteBuffer outBuffer = ByteBuffer.allocate(1024);
	private ServerSocket serverSocket;

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
		}
	}

	private void handleKey(SelectionKey key) throws IOException {
		ServerSocketChannel server;
		SocketChannel client;
		int count;
		if (key.isAcceptable()) {
			System.out.println("收到连接");
			server = ((ServerSocketChannel) key.channel());
			client = server.accept();
			client.configureBlocking(false);
			client.register(selector,SelectionKey.OP_READ);
		} else if (key.isReadable()) {
			client = ((SocketChannel) key.channel());
			inBuffer.clear();
			try {
				count = client.read(inBuffer);
				if (count > 0) {
					System.out.print("收到数据：");
					System.out.println(new String(inBuffer.array(),0,count,"utf-8"));
					client.register(selector,SelectionKey.OP_WRITE);
				}
			} catch (Exception e) {
				System.out.println("客户端断开");
				client.register(selector,0);
			}
		} else if (key.isWritable()) {
			System.out.println("send successfully");
			client = ((SocketChannel) key.channel());
			outBuffer.clear();
			outBuffer.put(("some txt" + flag++).getBytes());
			outBuffer.flip();
			client.write(outBuffer);
			client.register(selector,SelectionKey.OP_READ);
		}
	}

	public static void main(String[] args) throws IOException {
		NIOServer nioServer = new NIOServer(7777);
		nioServer.listen();
	}
}
