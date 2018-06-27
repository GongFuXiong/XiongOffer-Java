package Sort;
import java.util.Arrays;
/*
 * 基数排序:按照位排序
 * 是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
 * 基数排序基于分别排序，分别收集，所以是稳定的。需要O(n)的时间复杂度
 * 循环时，先从前到后，再从后到前，则不会出现赋值错误的情况（注意）
 */
public class RadixSort {
	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        new RadixSort().radixSort(a,10);
        System.out.println(Arrays.toString(a));

	}
	
    public static void radixSort(int[] array, int radix) {  
        int[] tmp = new int[array.length];  // 缓存数组
        int[] buckets = new int[radix];   // buckets数组定义了0-9个桶  ，指数字最高位数
        int length=array.length;
        int rate=1;			//与基数radix配合使用，得到数据的各个位数值
        
        for (int i = 0; i < 3; i++) {  //3位数字的最大位数
            Arrays.fill(buckets, 0);  // 必要的。。。重置count数组，开始统计下一个关键字  
            System.arraycopy(array, 0, tmp, 0, array.length);//将array中的元素完全复制到tmp数组中,和Arrays.copyOf方法一样
            
            // 计算每个待排序数据的子关键字  
            for (int j = 0; j < length; j++) {  
                int subKey = (tmp[j] / rate) % radix;  //subKey为0~9的位数
                buckets[subKey]++;  //相应位置值加一，计算每个箱子的数字个数
            }  
  
            for (int j = 1; j < radix; j++) {  //计算每个数字应该在排序后数组中应该处于的位置
                buckets[j] = buckets[j] + buckets[j - 1];  //此处目的为按顺序排列所有元素buckets的数值
            }  

            // 按子关键字对指定的数据进行排序  buckets数值已经按照顺序排列了
            for (int m = length - 1; m >= 0; m--) {  
                int subKey = (tmp[m] / rate) % radix;  ////subKey为tmp[m]的位数值
                //由于之前按从前到后的顺序放进桶中的，所有赋值从后到前，则不会出现赋值错误情况
                array[--buckets[subKey]] = tmp[m];  //重点理解，赋值完之后，在该捅上减去一个个数
            }  
            rate *= radix;  //得到十位的位数值
        }  
  
    } 
}
