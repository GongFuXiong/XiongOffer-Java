package Sort;
import java.util.Arrays;
/*
 * 冒泡排序，一次比较两个元素，如果它们的顺序错误就把它们交换过来。平均时间复杂度：O(n2)，稳定
 */
public class BubbleSort {
	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));

	}
	
	public static void bubbleSort(int[] arr){
		   int temp;//临时变量
		   boolean flag;//是否交换的标志
		   for(int i=0; i<arr.length-1; i++){   //表示趟数，一共arr.length-1次。若有6个数，则只需要进行5次

		       flag = false;
		       for(int j=0; j<arr.length-1-i; j++){//注意arr.length-1-i要减i，因为最后的已经排好了
//双循环
		           if(arr[j] > arr[j+1]){// 相邻元素两两对比,挑出最大的放在最后面
		               temp = arr[j];		//交换
		               arr[j] = arr[j+1];
		               arr[j+1] = temp;
		               flag = true;
		           }
		       }
		       if(!flag) break;//若没有交换，则意味着不是此轮最大值，则没必要再判断，跳出
		   }
		}
}
