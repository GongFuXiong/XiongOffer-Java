package Problem34;
/*
 * 丑数是只包含因子2、3和5的数，求从小到大的第N个丑数
 * 直观方法，每个数都需要计算，消耗大
 */
public class UglyNumber {

	public static void main(String[] args) {
		System.out.println(getUglyNumber(2));

	}
	
	public static int getUglyNumber(int index) {
		if (index <= 0) {
			return 0;
		}
		int number = 0;		//丑数
		int count = 0;
		while (count < index) {			//判断计算每一个数
			number++;
			if (isUgly(number)) {
				count++;
			}
		}
		return number;
	}
	
	private static boolean isUgly(int number) {
		while (number % 2 == 0) {		//number如果能被235整除，则处于235
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		
		return (1 == number) ? true : false;
	}
}
