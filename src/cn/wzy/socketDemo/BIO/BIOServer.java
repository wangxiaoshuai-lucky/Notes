package cn.wzy.socketDemo.BIO;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class BIOServer {

	static class ChatThread extends Thread {
		private Socket socket;
		private InputStream inputStream;
		private OutputStream outputStream;

		ChatThread(Socket socket) throws IOException {
			this.socket = socket;
			this.inputStream = socket.getInputStream();
			this.outputStream = socket.getOutputStream();
		}

		@Override
		public void run() {
			try {
				while (true) {
					byte[] bytes = new byte[1024];
					int len = inputStream.read(bytes);
					if(len == -1) {
						break;
					}
					String msg = new String(Arrays.copyOfRange(bytes, 0, len));
					System.out.println(msg);
					outputStream.write("hello client".getBytes());
					outputStream.flush();
				}
			} catch (IOException e) {
//				e.printStackTrace();
			} finally {
				System.out.println("连接断开");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(7777);
		while (true) {
			Socket accept = serverSocket.accept();
			new ChatThread(accept).start();
		}
	}
}
