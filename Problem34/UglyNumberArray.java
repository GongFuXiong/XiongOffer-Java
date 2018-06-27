package Problem34;
/*
 * 创建一个数组储存丑数，以避免每个数字计算的消耗
 */
public class UglyNumberArray {

	public static void main(String[] args) {
        System.out.println(new UglyNumberArray().getUglyNumber(11));

	}
	
	public int getUglyNumber(int n) {
		if (n <= 0) {
			return 0;
		}

		int[] uglyArr = new int[n];		//创建数组
		uglyArr[0] = 1;
		int m2 = 0, m3 = 0, m5 = 0;

		for (int i = 1; i < uglyArr.length; i++) {
			int min = Min(uglyArr[m2] * 2, uglyArr[m3] * 3, uglyArr[m5] * 5);//乘以因子之后的最小值
            uglyArr[i] = min;			//连续赋值数组

			while (uglyArr[m2] * 2 <= min) {	//有点难理解，将给m2,m3,m5乘数因子提高到min值处
				m2++;
			}
			while (uglyArr[m3] * 3 <= min) {
				m3++;
			}
			while (uglyArr[m5] * 5 <= min) {
				m5++;
			}
		}
        return uglyArr[n - 1];
	}

	private int Min(int number1, int number2, int number3) {	//返回最小值
		int min = (number1 < number2) ? number1 : number2;
		return min < number3 ? min : number3;
	}
}
