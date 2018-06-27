package Problem30;
import java.util.*;
/*
 * 输入n个整数，找出其中最小的K个数。
 * 最大堆法O(nlgk)，堆heap为特殊二叉树，最大堆为根结点值最大
 * 不需要改变数组，适用于海量数据
 */
public class GetLeastNumbersWithHeap {

	public static void main(String[] args) {
		int[] array = { 4, 5, 1, 6, 2, 7, 3};
		getLeastNumbers(array, 4);

	}

	public static void getLeastNumbers(int[] a, int k) {
		if (null == a || k <= 0 || k > a.length) {
			return;
		}
		//根据输入数组前k个数建立最大堆,从k+1个数开始与根节点比较
		//大于根节点，舍去
		//小于，取代根节点，重排最大堆
		int[] kArr = Arrays.copyOfRange(a, 0, k);			//截取数组前k个值
		buildMaxHeap(kArr);								//重建前k值的最大堆
		for (int i = k; i < a.length; i++) {		//从k位置开始
			if (a[i] < kArr[0]) {	//k之后每个数与最大堆根结点对比，若小于根结点则取代跟结点，并重新排最大堆
				kArr[0] = a[i];
				adjustHeap(kArr, 0);
			}
		}
		for (int i :kArr) {			//输出最大堆
			System.out.print(i+"\t");
		}
	}
	
	/**
	 * 建堆，，重新建立最大堆
	 */
	private static void buildMaxHeap(int[] a) {			//建立数组a的一个最大堆
		for (int i = a.length>>1; i >= 0; i--) {		//从中间位置开始递减
			adjustHeap(a, i);
		}
	}
	
	private static void adjustHeap(int[] a, int parent) {        //保证parent位为最大值
		int left = 2 * parent + 1;			//将数组按奇偶分成二叉树的左右子树
		int right = 2 * parent + 2;
		int largest = parent;						//将数组每个数设置为最大值
		if (left < a.length && a[left] > a[largest]) {			//left大于最大值
			largest = left;								//保证将最大值赋值largest
		}
		if (right < a.length && a[right] > a[largest]) {		//right大于最大值
			largest = right;
		}
		if (largest != parent) {				//若循环临值不等于最大值，则将临值与最大值互换，保证parent为最大值
			int temp = a[parent];
			a[parent] = a[largest];
			a[largest] = temp;
			adjustHeap(a, largest);				//递归
		}
	}
}
