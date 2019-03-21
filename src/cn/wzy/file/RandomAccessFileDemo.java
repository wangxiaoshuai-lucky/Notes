package cn.wzy.file;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\阿里\\test.txt","rw");
		ByteArrayOutputStream buff = new ByteArrayOutputStream();
		byte[] bytes = new byte[4];
		int len;
		while ((len = file.read(bytes)) != -1) {
			buff.write(bytes,0,len);
		}
		System.out.println(new String(buff.toByteArray()));
		buff.close();
		file.close();
	}
}
