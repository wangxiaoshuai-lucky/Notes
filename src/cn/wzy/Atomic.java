package cn.wzy;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Atomic {

	static class User{
		String name;
		int id;
		User next;
	}

	AtomicStampedReference<User> top = new AtomicStampedReference<>(null,0);

	void push(User user){
		User old;
		int stamp;
		do{
			old = top.getReference();
			stamp = top.getStamp();
			user.next = old;
		} while (!top.compareAndSet(old,user,stamp,stamp+1));
	}

	User pop(){
		User old, next;
		int stamp;
		do{
			old = top.getReference();
			if(old == null)
				return null;
			stamp = top.getStamp();
			next = old.next;
		} while (!top.compareAndSet(old,next,stamp,stamp+1));
		return old;
	}
}
