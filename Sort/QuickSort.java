package Sort;
import java.util.Arrays;
/*
 * 快速排序：O(N*logN)
 * 本质就是,找一个基位(枢轴,分水岭,作用是左边的都比它小,右边的都比它大
 */
public class QuickSort {

	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        new QuickSort().quickSort(a, 0, 7);
        System.out.println(Arrays.toString(a));

	}
	
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int division = partition(arr, low, high);//已经分好的base，左边的都比这个位置小,右边的都大
            quickSort(arr, low, division - 1);	//再次分为左右两部分，，递归
            quickSort(arr, division + 1, high);
        }
    }

    // 分水岭,基位,左边的都比这个位置小,右边的都大
    private int partition(int[] arr, int low, int heigh) {
        int base = arr[low]; //用子表的第一个记录做枢轴(分水岭)记录
        
        while (low < heigh) {  //从表的两端交替向中间扫描
            while (low < heigh && arr[heigh] >= base) {		//遍历后半部分
                heigh--;		//heigh定位到右边的都比base大
            }
            swap(arr, heigh, low);//base 赋值给 当前 heigh 位,base 挪到(互换)到了这里,heigh位右边的都比base大
            
            while (low < heigh && arr[low] <= base) {		//遍历前半部分，
                low++;
            }
            swap(arr, heigh, low);// 遇到左边比base值大的了,换位置
        }
        //现在 low = heigh;
        return low;
    }

    private void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
