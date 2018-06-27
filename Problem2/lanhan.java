package Problem2;
/*
 * 知道要使用的时候采取创建实例的对象。
 * 我们在获取实例的方法上加了锁，避免多线程引发的创建多个单例的情况。
 * 多线程的问题是避免了，但也造成了整体性能的下降，
 * 每次使用单例对象，都需要锁判断，降低了整体性能
 */
public class lanhan {
	private static lanhan instance;
	private lanhan(){}
	public static synchronized lanhan getInstance(){    //得到实例的函数
		/*
		 * getInstance()方法中添加了synchronized关键字，
		 * 使其变成一个同步方法，目的是为了在多线程环境下保证单例对象唯一。
		 */
		if (instance==null) {
			instance = new lanhan();
		}
		return instance;
	}

}
