package cn.wzy.socketDemo.Communication;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChatRoomServer {

	private Selector selector = null;
	static final int port = 9999;
	private Charset charset = Charset.forName("UTF-8");
	private static HashSet<String> users = new HashSet<String>();
	private static String USER_EXIST = "system message: user exist, please change a name";
	private static String USER_CONTENT_SPILIT = "#@#";

	public void init() throws IOException {
		selector = Selector.open();
		ServerSocketChannel server = ServerSocketChannel.open();
		server.bind(new InetSocketAddress(port));
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("Server is listening now...");

		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0)
				continue;
			Set selectedKeys = selector.selectedKeys();
			Iterator keyIterator = selectedKeys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey sk = (SelectionKey) keyIterator.next();
				keyIterator.remove();
				dealWithSelectionKey(server, sk);
			}
		}
	}

	public void dealWithSelectionKey(ServerSocketChannel server, SelectionKey sk) throws IOException {
		if (sk.isAcceptable()) {
			SocketChannel sc = server.accept();
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);
			sk.interestOps(SelectionKey.OP_ACCEPT);
			System.out.println("Server is listening from client :" + sc.getRemoteAddress());
			sc.write(charset.encode("Please input your name."));
		}
		if (sk.isReadable()) {
			SocketChannel sc = (SocketChannel) sk.channel();
			ByteBuffer buff = ByteBuffer.allocate(1024);
			StringBuilder content = new StringBuilder();
			try {
				while (sc.read(buff) > 0) {
					buff.flip();
					content.append(charset.decode(buff));
				}
				System.out.println("Server is listening from client " + sc.getRemoteAddress() + " data rev is: " + content);
				sk.interestOps(SelectionKey.OP_READ);
			} catch (IOException io) {
				sk.cancel();
				if (sk.channel() != null) {
					sk.channel().close();
				}
			}
			if (content.length() > 0) {
				String[] arrayContent = content.toString().split(USER_CONTENT_SPILIT);
				if (arrayContent != null && arrayContent.length == 1) {
					String name = arrayContent[0];
					if (users.contains(name)) {
						sc.write(charset.encode(USER_EXIST));
					} else {
						users.add(name);
						int num = OnlineNum(selector);
						String message = "welcome " + name + " to chat room! Online numbers:" + num;
						BroadCast(selector, null, message);
					}
				}
				else if (arrayContent != null && arrayContent.length > 1) {
					String name = arrayContent[0];
					String message = content.substring(name.length() + USER_CONTENT_SPILIT.length());
					message = name + " say " + message;
					if (users.contains(name)) {
						BroadCast(selector, sc, message);
					}
				}
			}
		}
	}
	public static int OnlineNum(Selector selector) {
		int res = 0;
		for (SelectionKey key : selector.keys()) {
			Channel targetchannel = key.channel();

			if (targetchannel instanceof SocketChannel) {
				res++;
			}
		}
		return res;
	}

	public void BroadCast(Selector selector, SocketChannel except, String content) throws IOException {
		for (SelectionKey key : selector.keys()) {
			Channel targetchannel = key.channel();
			if (targetchannel instanceof SocketChannel && targetchannel != except) {
				SocketChannel dest = (SocketChannel) targetchannel;
				dest.write(charset.encode(content));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		new ChatRoomServer().init();
	}
}
