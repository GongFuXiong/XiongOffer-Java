package Problem2;
/**
 * Created by owen on 2017/6/13.
 */
public class MultiThreadSingleton {
    /**
     * 多线程模式下线程安全的单例模式
     * 和Double_CheckLock是一样的
     */
    private MultiThreadSingleton(){}		//私有构造函数
    public static volatile MultiThreadSingleton instance;		//初试化对象
    public static  MultiThreadSingleton getINSATCNE() {
        if (instance == null)
            synchronized (MultiThreadSingleton.class) {
                if (instance == null)
                	instance = new MultiThreadSingleton();
            }
        return instance;

    }

}
