package Sort;
import java.util.Arrays;
/*
 * 插入排序:现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 平均时间复杂度：O(n2),稳定
 */
public class InsertionSort {
	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        insertSort(a);
        System.out.println(Arrays.toString(a));

	}
	
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {	//从第二位开始，固定一个位置往后推
            int current = array[i];
            int j;
            for (j = i - 1; j >= 0 && current < array[j]; j--) {//比较固定值之前的值
                array[j + 1] = array[j];	//不断根据新进来的current调整顺序，前n个值已经排好序
            }
            
            array[j + 1] = current;	//必要，关键。。。将新来的值插入到排好序的位置
        }
    }
}
