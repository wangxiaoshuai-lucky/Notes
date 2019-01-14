package cn.wzy.Thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeStreamDemo {
	public static void main(String[] args) {
		Sender sender = new Sender();
		Recive recive = new Recive();
		PipedInputStream pi = recive.getPipedInputputStream();
		PipedOutputStream po = sender.getPipedOutputStream();
		try {
			pi.connect(po);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		new Thread(recive).start();
		new Thread(sender).start();
	}
}

class Sender implements Runnable {
	PipedOutputStream out = new PipedOutputStream();

	PipedOutputStream getPipedOutputStream() {
		return out;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
			out.write("Hello , Reciver!".getBytes());

			out.write("Hello , Reciver!".getBytes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class Recive implements Runnable {
	PipedInputStream in = new PipedInputStream();

	PipedInputStream getPipedInputputStream() {
		return in;
	}

	@Override
	public void run() {
		byte[] bys = new byte[1024];
		try {
			in.read(bys);
			System.out.println("读取到的信息：" + new String(bys).trim());
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
