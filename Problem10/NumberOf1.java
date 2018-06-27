package Problem10;

import com.sun.org.apache.regexp.internal.recompile;

/*
 *输入一个整数，输出该数二进制表示中的１的个数
 */
public class NumberOf1 {
	public static void main(String[] args) {
		int a= numberOf1(171);
		System.out.println(a);
		int b=flagMove(171);
		System.out.println(b);
		
		int n=0x80000000<<1;		//int为32位，左移一位得0，byte为-128~127，不能定义128
		System.out.println(n);
		int m=10>>1;			//右移一位与除以2为等价
		System.out.println(m);
	}
/*
 * 把一个整数减去１再和原整数与，就会把整数最右边一个１变成０
 */
	public static int numberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;			//多少次操作就会多少次
			n = (n-1) & n;		//只要有0就会变为0
		}
		return count;
	}
	/*
	 * 利用1不断左移进行判断
	 */
	public static int flagMove(int n) {
		int count=0;
		int flag=1;
		while (flag!=0) {
			if ((n&flag)!=0) {
				count++;
			}
			flag=flag<<1;
		}
		return count;
	}
}
