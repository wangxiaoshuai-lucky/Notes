package cn.wzy.exception;

public class Main {
	public static void main(String[] args) throws RuntimeException,NullPointerException {
		RuntimeException exception = new NullPointerException();
		exception = new RuntimeException();
		exception.initCause(new Throwable("我也不知道我哪儿错了"));
		throw exception;
	}
}
