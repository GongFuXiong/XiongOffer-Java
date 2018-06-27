package Problem33;
import java.util.*;

/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 关键就是制定排序规则。或使用比较和快排的思想，将前面的数和最后的数比较，若小则放到最前面
 */
public class PrintMinNumber {

	public static void main(String[] args) {
//		int[] a = { 3, 32 ,321};
		int[] a = { 3, 533333 , 1444444, 4, 2};
		System.out.println(sortArray(a));
		
		String sring1="fffgh";
		String sring2="ga";
		System.out.println(sring1.compareTo(sring2));
	}
	
	public static String sortArray(int[] array) {

		Integer[] targetArr = new Integer[array.length];//定义一个新数组，并复制，Comparator接口必须使用integer
		for (int i = 0; i < array.length; i++) {
			targetArr[i] = array[i];
		}

		Arrays.sort(targetArr, new Comparator<Integer>() {	//改变sort规则
			@Override			//这个用于重写Comparator接口父类方法用的
			public int compare(Integer o1, Integer o2) {		//重新定义sort排序规则
				String s1 = String.valueOf(o1) + String.valueOf(o2);		//定义两个元素的正反元素和
				String s2 = String.valueOf(o2) + String.valueOf(o1);

				return s1.compareTo(s2);//返回s1-s2的数值差,根据return为一个与0的比较值，来重新排序targetArr
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int val : targetArr) {		//转换数组类型为string类型
			sb.append(val);
		}
		return sb.toString();			//可直接打印string
	}
}
