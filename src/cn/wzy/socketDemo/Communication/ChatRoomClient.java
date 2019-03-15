package cn.wzy.socketDemo.Communication;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class ChatRoomClient {

	private Selector selector = null;
	static final int port = 9999;
	private Charset charset = Charset.forName("UTF-8");
	private SocketChannel sc = null;
	private String name = "";
	private static String USER_EXIST = "system message: user exist, please change a name";
	private static String USER_CONTENT_SPILIT = "#@#";

	public void init() throws IOException {
		selector = Selector.open();
		//连接远程主机的IP和端口
		sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
		//开辟一个新线程来读取从服务器端的数据
		new Thread(new ClientThread()).start();
		//在主线程中 从键盘读取数据输入到服务器端
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if ("".equals(line)) continue; //不允许发空消息
			if ("".equals(name)) {
				name = line;
				line = name + USER_CONTENT_SPILIT;
			} else {
				line = name + USER_CONTENT_SPILIT + line;
			}
			sc.write(charset.encode(line));//sc既能写也能读，这边是写
		}

	}

	private class ClientThread implements Runnable {
		public void run() {
			try {
				while (true) {
					int readyChannels = selector.select();
					if (readyChannels == 0) continue;
					Set selectedKeys = selector.selectedKeys();  //可以通过这个方法，知道可用通道的集合
					Iterator keyIterator = selectedKeys.iterator();
					while (keyIterator.hasNext()) {
						SelectionKey sk = (SelectionKey) keyIterator.next();
						keyIterator.remove();
						dealWithSelectionKey(sk);
					}
				}
			} catch (IOException io) {
			}
		}

		private void dealWithSelectionKey(SelectionKey sk) throws IOException {
			if (sk.isReadable()) {
				SocketChannel sc = (SocketChannel) sk.channel();
				ByteBuffer buff = ByteBuffer.allocate(1024);
				String content = "";
				while (sc.read(buff) > 0) {
					buff.flip();
					content += charset.decode(buff);
				}
				if (USER_EXIST.equals(content)) {
					name = "";
				}
				System.out.println(content);
				sk.interestOps(SelectionKey.OP_READ);
			}
		}
	}


	public static void main(String[] args) throws IOException {
		new ChatRoomClient().init();
	}
}