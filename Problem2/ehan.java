package Problem2;
/*
 * 饿汉式
 * 一上来就把单例对象创建出来了，要用的时候直接返回即可
 * 单例在还没有使用到的时候，初始化就已经完成了。
 * 也就是说，如果程序从头到位都没用使用这个单例的话，
 * 单例的对象还是会创建。这就造成了不必要的资源浪费。
 */
public class ehan {
	private static ehan instance = new ehan();//初始化并创建对象
	private ehan(){}								//私有构造函数
		
	public static ehan getInstance(){			//得到实例函数
		return instance;
	}

}
