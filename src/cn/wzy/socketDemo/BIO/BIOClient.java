package cn.wzy.socketDemo.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class BIOClient {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 7777);
		OutputStream outputStream = socket.getOutputStream();
		InputStream inputStream = socket.getInputStream();
		String[] msgs = new String[]{
			"hello server.",
			"i'm coming.",
			"i'm a client.",
			"exit."
		};
		//接受线程
		new Thread(() -> {
			try {
				while (true) {
					System.out.println(recv(inputStream));
				}
			} catch (IOException e) {
//				e.printStackTrace();
			} finally {
				System.out.println("您已断开.");
			}
		}).start();

		//发送线程
		new Thread(() -> {
			try {
				for (String msg : msgs) {
					Thread.sleep(2000);
					send(outputStream, msg);
					if (msg.equals("exit.")) {
						socket.close();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	static void send(OutputStream outputStream, String msg) throws IOException {
		outputStream.write(msg.getBytes());
		outputStream.flush();
	}

	static String recv(InputStream inputStream) throws IOException {
		byte[] bytes = new byte[1024];
		int len = inputStream.read(bytes);
		if (len == -1) {
			return "";
		}
		String msg = new String(Arrays.copyOfRange(bytes, 0, len));
		return msg;
	}
}
