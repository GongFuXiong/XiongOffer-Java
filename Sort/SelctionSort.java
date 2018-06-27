package Sort;
import java.util.Arrays;
/*
 * 选择排序,，，直接将最小值放在最前面
 * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
 * O(n2)的时间复杂度,不稳定：a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面
 */
public class SelctionSort {

	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        int[] b=selectSort(a);
        System.out.println(Arrays.toString(b));

	}
	
	public static int[] selectSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int miniPost = i;
//双循环
            for (int m = i + 1; m < arr.length; m++) {
                if (arr[m] < arr[miniPost]) {// 寻找最小的数
                    miniPost = m;			// 将最小数的索引保存
                }
            }

            int temp;		//将最小值直接放入最前面
            temp = arr[i];
            arr[i] = arr[miniPost];
            arr[miniPost] = temp;

        }
        return arr;
    }
}
