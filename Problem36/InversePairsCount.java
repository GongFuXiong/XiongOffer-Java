package Problem36;
/*
 * 输入一个数组,求出这个数组中的逆序对的总数P
 * 本质是归并排序，在比较时加入全局变量count进行记录逆序对的个数
 * 采用辅助数组，时间复杂度为O(nlogn)
 */
public class InversePairsCount {

	public static void main(String[] args) {
        int[] a = new int[] {7, 5, 6, 4};
        System.out.println(new InversePairsCount().getInversePairs(a));
        
//        int[] copy = a.clone();
//        int[] copy2=a;
//        System.out.println(copy[3]);
//        System.out.println(copy2[3]);
	}
	
    public int getInversePairs(int[] array) {
        if (null == array || array.length < 2) {
            return 0;
        }
        int[] copy = array.clone();		//clone方法，赋值一个全新的数组，地址不一样，copy为辅助数组
        return mergeSort(array, copy, 0, array.length - 1);
    }

    private int mergeSort(int[] data, int[] copy, int start, int end) {//此为大名鼎鼎的归并排序
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int len = (end - start) / 2;		
        int leftCount = mergeSort(copy, data, start, start + len);//开始到中间，left递归。。data和copy互换
        int rightCount = mergeSort(copy, data, start + len + 1, end);	//中间到末尾，right递归

        int leftIndex = start + len;//原数组左指针，初始化在中间
        int rightIndex = end;//原数组有指针，初始化在末尾
        int copyPoint = end;//辅助数组指针
        int count = 0;
        // 把较小的数先移到新数组中
        while (leftIndex >= start && rightIndex >= start + len + 1) {
            if (data[leftIndex] > data[rightIndex]) {		//若left大于right
                copy[copyPoint--] = data[leftIndex--];		//赋值到辅助数组中，再自减
                count += rightIndex - start -len;			//只有left大时才可以计算
            } else {
                copy[copyPoint--] = data[rightIndex--];
            }
        }
        
     // 把左边剩余的数移入数组。。。。左右边不需要重新排序，递归之后底层已经排序好了
        for (; leftIndex >= start; leftIndex--) {
            copy[copyPoint--] = data[leftIndex];
        }
        for (; rightIndex >= start + len + 1; rightIndex--) {
            copy[copyPoint--] = data[rightIndex];
        }

        return leftCount + rightCount + count;
    }
}
