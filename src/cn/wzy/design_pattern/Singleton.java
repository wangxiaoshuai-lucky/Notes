package cn.wzy.design_pattern;

/**
 * 单例模式
 */
public class Singleton {
	private static Singleton singleton;

	static Singleton getInstance(){
		if (singleton == null) {
			synchronized(Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
