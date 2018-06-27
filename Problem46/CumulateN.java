package Problem46;
/*
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
 * 巧用递归（返回值类型为Boolean）
 */
public class CumulateN {
	public static void main(String[] args) {
		System.out.println(new CumulateN().sumSolution(100));
		System.out.println(new CumulateN().sumSolution2(100));
		System.out.println(new CumulateN().sumSolution3(100));
	}
	
    public static int sumSolution(int n) {
        int sum = 0;
        boolean b = (n > 0) && ((sum += sumSolution(n - 1)+n) > 0);//用&&做截断
        return sum;
    }
    
    public static int sumSolution2(int n) {		//递归
        if (n==1)	return 1;
        int sum ;
        sum= sumSolution2(n-1)+n;
        return sum;
    }
    
    public static int sumSolution3(int n) {//和上面一模一样
        if (n==1) return 1;
        return sumSolution3(n-1)+n;
    }
}
