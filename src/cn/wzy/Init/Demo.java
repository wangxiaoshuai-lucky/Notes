package cn.wzy.Init;

import java.io.*;

public class Demo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Child child = new Child();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("G:\\KnowledgePoints\\docs\\java\\child.txt")));
		oos.writeObject(child);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("G:\\KnowledgePoints\\docs\\java\\child.txt")));
		Child origin = (Child) ois.readObject();
		System.out.println(origin.i);
	}
}
