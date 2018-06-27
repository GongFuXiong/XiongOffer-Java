package Sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * 桶排序是计数排序的升级版..桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 分为n个大小相同的子区间， 上一个区间里的元素都比下一个区间里的元素小，然后对所有区间里的元素排序，最后顺序输出所有区间里的元素
 */
public class BucketSort {
	public static void main(String[] args) {
        int [] a = {1,100,234,44,3,2,4,5};
        bucketSort(a);
//        System.out.println(Arrays.toString(a));
	}
	public static void bucketSort(int[] arr){
	    int max = 0;
	    int min = 0;
	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);//自我比较
	        min = Math.min(min, arr[i]);
	    }
	    
	    int bucketNum = (max - min) / arr.length + 1;//桶数
	    ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);//定义保存的数组链表
	    for(int i = 0; i < bucketNum; i++){				//必要步骤，，，必须在数组链表里面再次初始化
	        bucketArr.add(new ArrayList<Integer>());
	    }
	    
	    //将每个元素放入桶
	    for(int i = 0; i < arr.length; i++){
	        int num = (arr[i] - min) / (arr.length);//根据距离放入桶中
	        bucketArr.get(num).add(arr[i]);	//第num桶中放入第n元素，桶根据num已经排好序，但是里面的元素没有排序
	    }
	    
	    //对每个桶进行排序
	    for(int i = 0; i < bucketArr.size(); i++){
	        Collections.sort(bucketArr.get(i));//是用来对List类型进行排序
	    } 
	    System.out.println(bucketArr.toString());//输出bucketArr，而不是原始数组
	    System.out.println(Arrays.toString(arr));//输出bucketArr，而不是原始数组
	}
}
