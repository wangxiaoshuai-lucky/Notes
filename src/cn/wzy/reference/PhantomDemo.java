package cn.wzy.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomDemo {
	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		PhantomReference<Object> pf = new PhantomReference<>(obj, new ReferenceQueue<>());
		while (true) {
			System.out.printf("pf.get() = %d, isEnqueued: %b\n", pf.get(), pf.isEnqueued());
			if (pf.isEnqueued())
				break;
			obj = new int[102400000];
		}
	}
}