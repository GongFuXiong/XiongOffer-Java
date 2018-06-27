package Problem41;
import java.util.Arrays;
/*
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S
 * 定义两个指针，分别从前面和后面进行遍历
 * 双指针两端向中间扫描O(n)
 */
public class FindNumbersWithSum {

	public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(Arrays.toString(new FindNumbersWithSum().find(a, 15)));

	}
	
    public int[] find(int[] a, int num) {
        if (null == a || a.length <= 0) {
            return null;
        }

        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            int curSum = a[low] + a[high];
            if (curSum == num) {
                return new int[] {a[low], a[high]};		//返回一个新数组
            } else {
                if (curSum > num) {			//偏大，则指针前移
                    high--;
                } else {
                    low ++;
                }
            }
        }

        return null;
    }
}
