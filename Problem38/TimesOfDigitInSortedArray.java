package Problem38;
import java.util.*;
/*
 * 遍历判断时间复杂度为O(n)
 * 统计一个数字在排序数组中出现的次数
 * 利用二分查找+递归思想，进行寻找。当目标值与中间值相等时进行判断，时间复杂度为O(logn)
 * 左右部分均递归，在中间时计算count
 */
public class TimesOfDigitInSortedArray {
	public static void main(String[] args) {
		int[] array= {1,2,3,3,3,3,4,5};    
        System.out.println(new TimesOfDigitInSortedArray().getNumberOfK(array, 3)); 

	}
	
	public int getNumberOfK(int[] array, int k) {
		int count = 0;
		if (null == array || array.length <= 0) {
			return 0;
		}
		if (array.length == 1) {
			if (array[0] == k) {
				return 1;
			} else {
				return 0;
			}
		}
		 
		if (k < array[array.length/2]) {
			count += getNumberOfK(Arrays.copyOfRange(array, 0, array.length/2), k);//递归左半部分
		} else if (k > array[array.length/2]) {
			count += getNumberOfK(Arrays.copyOfRange(array, array.length/2, array.length), k);//递归右半部分
		} else {
			count += getCount(array, array.length/2);	//处在中间时，计算count结果
		}
		
		return count;
	}
	
	private int getCount(int[] a, int index) {
		int k = a[index];
		int count = 0;
		
		for (int i = index; i < a.length; i++) {	//从中间向左遍历
			if (a[i] == k) {
				count++;
			} else {
				break;		//因为是排序的
			}
		}
		for (int i = index - 1; i >= 0; i--) {	//从中间向右遍历
			if (a[i] == k) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}
