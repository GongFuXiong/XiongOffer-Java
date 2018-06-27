package Sort;
import java.util.Arrays;
/*
 * 归并排序:归并排序采用的是递归来实现，属于“分而治之”，将目标数组从中间一分为二，之后分别对这两个数组进行排序，
 * 排序完毕之后再将排好序的两个数组“归并”到一起，归并排序最重要的也就是这个“归并”的过程，
 * 归并排序的效率是比较高的，设数列长为N，将数列分开成小数列一共要logN步，
 * 每步都是一个合并有序数列的过程，时间复杂度可以记为O(N)，故一共为O(N*logN)
 */
public class MergeSort {
	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        new MergeSort().sort(a, 0, 7);
        System.out.println(Arrays.toString(a));

	}
		//递归
    private void sort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) { 
            sort(array, low, mid);// 左边递归，分区域处理
            sort(array, mid + 1, high);   // 右边
            // 左右归并
            merge(array, low, mid, high);	//已经改变数组内部结构
        }
    }
    	//合并
    private void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];		//归并的数组空间
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;		//新数组指针
        
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {			//只需比较前后大块的值即可
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 把左边剩余的数移入数组、、、、。。。。。左右边不需要重新排序，递归之后底层已经排序好了
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 把新数组中的数覆盖array数组
        for (int k2 = 0; k2 < temp.length; k2++) {
        	array[k2 + low] = temp[k2];
        }
    }
}
