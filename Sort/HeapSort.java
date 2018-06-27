package Sort;
import java.util.Arrays;
/*
 * 堆排序:堆积是一个近似完全二叉树的结构，并同时满足最大堆的性质：即子结点的键值总是小于它的父节点。
 * 难理解
 * 
 * 本质就是先构造一个大顶堆,parent比children大,root节点就是最大的节点
 * 把最大的节点(root)与尾节点(最后一个节点,比较小)位置互换
 * 剩下最后的尾节点,现在最大,其余的,从第一个元素开始到尾节点前一位,构造大顶堆递归
 * 由于每次重新恢复堆的时间复杂度为O(logN)，共N - 1次重新恢复堆操作，
 * 再加上前面建立堆时N / 2次向下调整，每次调整时间复杂度也为O(logN)。二次操作时间相加还是O(N * logN)。
 */
public class HeapSort {
	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        new HeapSort().sort(a);
        System.out.println(Arrays.toString(a));

	}
	
    public static void sort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            buildHeap(array, len - 1 - i);// 建堆,，，，从后向前依次
            swap(array, 0, len - 1 - i);// 交换堆顶元素和最后一个元素
        }
    }
    
    public static void buildHeap(int[] a, int lastIndex) { // 建堆
        // 从最后一个节点的父节点(即正中间位置)开始，递减遍历
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            
            while (i * 2 + 1 <= lastIndex) {// 当前节点存在子节点
                int left = i * 2 + 1;		// 左节点下标值
                int right = i * 2 + 2;		// 右结点下标值
                int biggerIndex = left; // 默认左节点为最大值      
                
                if (left < lastIndex) {// 存在右结点
                    if (a[right] > a[left]) {  // 右结点的值比左节点大
                        biggerIndex = right;
                    }
                }
                
                if (a[i] < a[biggerIndex]) {	//当前节点i的值比孩子节点的最大值小，交换
                    swap(a, i, biggerIndex);
                    i = biggerIndex;		// 把最大值下标赋给当前节点，进入下一次while循环判断
                } else {
                    break;
                }
            }
        }
    }
    
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
