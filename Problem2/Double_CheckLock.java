package Problem2;

public class Double_CheckLock {
	private static Double_CheckLock instance;
	private Double_CheckLock(){}
	public static Double_CheckLock getInstance(){
		/*
		 * 两层判空，第一层是为了避免不必要的同步
		 * 第二层是为了在null的情况下创建实例
		 * 同时调用getInstance()方法不进行同步锁，效率高。 
		 * 只会前几次获取单例对象的时候会进行锁判断，一旦单例对象创建完成，锁的任务也就完成了
		 */
		if (instance==null) {
			synchronized (Double_CheckLock.class) {   //在第二次判断前加了锁
				if (instance==null) {
					instance=new Double_CheckLock();
				}
			}
		}
		return instance;
	}

}
