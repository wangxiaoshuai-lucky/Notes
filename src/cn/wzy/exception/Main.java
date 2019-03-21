package cn.wzy.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());
	public static void main(String[] args) throws RuntimeException,NullPointerException {
		RuntimeException exception = new NullPointerException();
		exception = new RuntimeException();
		exception.initCause(new Throwable("我也不知道我哪儿错了"));
		throw exception;
	}
}
