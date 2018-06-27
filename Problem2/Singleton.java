package Problem2;
/*
 * 静态内部类实现单例模式
 * 第一次加载Singleton类时不会初始化instance，
 * 只有在第一次调用getInstance()方法时，虚拟机会加载InnerInstance内部类，初始化instance。
 * 
 */
public class Singleton {
	private static class InnerInstance{		//定义内部静态类
		private static final Singleton instance = new Singleton();	//创建内部类对象
	}
	
	private Singleton(){};				//私有化构造函数
	public static Singleton getInstance() {			//得到实例函数
		return InnerInstance.instance;				//返回实例
	}
	
}
