package Problem40;
import java.util.Arrays;

/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 利用异或：两个相同值异或为0，任何数异或0为它本身
 */
public class FindNumsAppearOnce {
	public static void main(String[] args) {
		int[] array = { 4, 6, 1, 1, 1, 1 };
		System.out.println(Arrays.toString(new FindNumsAppearOnce().find(array)));
		
		int a=3^1;
		System.out.println(a);
	}
	
	public int[] find(int[] array) {
		if (null == array || array.length <= 1) {
			return null;
		}
		int number = 0;
		for (int i : array) {	//以此异或所有元素，得到最后两个不相同元素的异或结果、、两个相同数异或为0
			number ^= i;
		}
		int index = findFirstBitIs1(number);//index为异或结果之后右边第一个1值的位数
		
		int number1 = 0, number2 = 0;		//定义两个子数组
        // 划分两组
		for (int ele : array) {	//按照index为是否为1，分为两组，分别在两组中元素异或
			if (isBit1(ele, index)) {//判断每个元素第i位是否为1
				number1 ^= ele;		//在含1位中异或组内所有值，抵消完其他成对数，余下则为单个数
			} else {
				number2 ^= ele;		//另一个数index不为1，在别处为1
			}
		}
        return new int[] {number1, number2};//将两个数放在一个数组中
	}
	
	// 找出number的二进制中最右边是1的位数
	private int findFirstBitIs1(int number) {
		int indexBit = 0;
		while ((number & 1) == 0) {
			number >>= 1;
			indexBit++;
		}
		return indexBit;
	}
	
	// 判断number的二进制表示中从右边起的第index位是不是1
	private boolean isBit1(int number, int indexBit) {
		number >>= indexBit;
		
		return (number & 1) == 1;
	}
}
