package Problem30;
/*
 * 输入n个整数，找出其中最小的K个数。
 * 基于partition的O(n)解法，，partition函数的定义
 * 需要修改数组
 */
public class GetLeastNumbersWithPartition {

	public static void main(String[] args) {
		int[] array = { 4, 5, 1, 6, 2, 7, 3};
		getLeastNumbers(array, 4);

	}
	
    public static void getLeastNumbers(int[] array, int num) {
        if (null == array || array.length <= 0 || num <= 0 || num > array.length) {
            return;								//特殊情况
        }

        int low = 0;
        int high = array.length - 1;
        int index = partition(array, low, high, num);	//返回排序好的数组的low位下标

        while (index != num - 1) {
            if (index > num - 1) {
                high = index - 1;					//假如返回下标较大，则依次相减
                index = partition(array, low, high, num);
            } else {
                low = index + 1;					//假如返回下标较小，则依次相加
                index = partition(array, low, high, num);
            }
        }

        for (int i = 0; i < num; i++) {			//index==num下标时
            System.out.print(array[i]+"\t");		//中间加一个制表符
        }
    }
/*
 * partition函数将整个数组分成左边全部小于基准值的，和右边全部大于基准值的。
 */
    private static int partition(int[] a, int low, int high, int k) {

        int temp = a[k - 1];			//num位和第一位互换。。必要的，因为k值需要随着改变，而且数组改变
        a[k - 1] = a[low];
        a[low] = temp;

        int pivot = a[low];			//默认以第一个值为基准值

        while (low < high) {
            while (low < high && a[high] >= pivot) {//从后半部分向前扫描
                high--;						//假如符合要求，扫描下一个
            }
            a[low] = a[high];	//base 赋值给 当前 heigh 位,base 挪到(互换)到了这里,heigh位右边的都比base大
            while (low < high && a[low] <= pivot) {//从前半部分向后扫描
                low++;						//假如符合要求，扫描下一个
            }
            a[high] = a[low];		//扫描完毕，或者不符合要求，则将不符合的较大值赋值high，并填补低位空缺
        }
        a[low] = pivot;				//填补之前赋值之后的低位空缺。必要的步骤，因为数组要改变

        return low;					//返回base值
    }
}
