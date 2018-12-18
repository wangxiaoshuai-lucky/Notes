package cn.wzy.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>(12);
		queue.put(12);
		queue.take();
	}
}
