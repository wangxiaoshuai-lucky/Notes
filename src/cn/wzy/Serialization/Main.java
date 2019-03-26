package cn.wzy.Serialization;

import java.io.*;

public class Main implements Serializable{
	static class Child extends Main{
		int code;
	}
	int id;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectOutput output = new ObjectOutputStream(new FileOutputStream("./out.txt"));
		Child main = new Child();
		main.code = 1555;
		main.id = 1555;
		output.writeObject(main);
		output.flush();
		output.close();
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("./out.txt"));
		Child main1 = (Child) input.readObject();
		System.out.println(main1.code);//1555
	}
}
