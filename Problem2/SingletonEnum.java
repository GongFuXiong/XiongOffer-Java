package Problem2;
/*
 * 枚举单例
 * 默认枚举实例的创建是线程安全的，
 * 即使反序列化也不会生成新的实例，任何情况下都是一个单例。
 */
public enum SingletonEnum {
	instance;
	public void getInstance() {
		System.out.println("do something");
	}

}
