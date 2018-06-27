package Problem48;
/*
 * 不能被继承的类（除了利用final关键字）
 */
public class FinalClass {
    public static FinalClass getInstance() {//通过定义public的静态函数来创建和释放类的实例
        return new FinalClass();
    }

    private FinalClass() {		//私有化构造函数
    }
}
