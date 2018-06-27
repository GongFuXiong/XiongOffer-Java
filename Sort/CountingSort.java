package Sort;
import java.util.Arrays;
/*
 * 计数排序:计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * 时间复杂度是O(n+k)，空间复杂度也是O(n+k)，其排序速度快于任何比较排序算法。..稳定
 */
public class CountingSort {
	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        int[] newArr=countSort(a);
        System.out.println(Arrays.toString(newArr));
        
//        int[] outArr=countSort2(a);
//        System.out.println(Arrays.toString(outArr));
        
//        int[] tmp =new int[10];
//        Arrays.fill(tmp, 1);
//        System.out.println(tmp[1]);
        
	}
	
	public static int[] countSort(int[] arr){
	    int max = 0;
	    int min = 0;
	    //找出数组中的最大最小值
	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);
	        min = Math.min(min, arr[i]);
	    }
	    int[] helpArr = new int[max - min + 1];//定义一个间隔数值个位的辅助数组
	    
	    //找出每个数字出现的次数
	    for(int i = 0; i < arr.length; i++){
	        int gapNum = arr[i] - min;
	        helpArr[gapNum]++;
	    }
	    
	    //计算每个数字应该在排序后数组中应该处于的位置
	    for(int i = 1; i < helpArr.length; i++){
	    	helpArr[i] = helpArr[i-1] + helpArr[i];
	    }
	    
	    //根据helpArr数组进行排序
	    int newArr[] = new int[arr.length];		//从新定义一个数组存储结果
	    for(int i = 0; i < arr.length; i++){	
	        int post = --helpArr[arr[i] - min];//每一个坑位仅此一个数。。post按照排序后数组所处的位置下标
	        newArr[post] = arr[i];
	    }
	    return newArr;
	}
	
//	public static int[] countSort2(int[] arr){	//自己写的，比较简略
//	    int max = 0;
//	    for(int i = 0; i < arr.length; i++){//找出数组中的最大最小值
//	        max = Math.max(max, arr[i]);
//	    }
//	    int[] tmp =new int[max+1];
//	    int[] outArr=new int[arr.length];
//	    
//	    for (int i = 0; i < outArr.length; i++) {
//			tmp[arr[i]]=arr[i];
//		}
//	    int index = 0;
//	    for (int i = 0; i <= max; i++) {
//			if (tmp[i]!=0) {
//				outArr[index++]=tmp[i];
//			}
//		}
//	    return outArr;
//	}
}
