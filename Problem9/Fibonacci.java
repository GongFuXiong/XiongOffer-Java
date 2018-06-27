package Problem9;
/*
 * 递归时间复杂度为O(n2)
 * 循环时间复杂度为O(n)
 */
public class Fibonacci {

	public static void main(String[] args) {
		long a=fibRec(8);		//必须要先定义a的类型
        long after1 = System.currentTimeMillis();		//获得当前时间戳
		System.out.println(a+" "+after1);			//输出两个变量
		long b=fibloop(9);
		System.out.println(b);
	}
	
	public static long fibRec(int n) {			//利用递归计算,类型为long,必须static才能调用
		if (n<=0) return 0;
		if (n==1) return 1;
		return fibRec(n-1)+fibRec(n-2);
	}
	
    public static long fibloop(int n){	//利用循环计算
        if (n==0) return 0;
        if (n==1) return 1;
        int fibOne=1;
        int temp=0;			//为一个增加值，为变量
        int fibN=0;
        for (int i=2;i<=n;i++){
            fibN=fibOne+temp;		//为结果值
            temp=fibOne;			//变量变化值
            fibOne=fibN;			//初始值
        }
        return fibN;
    }
}
