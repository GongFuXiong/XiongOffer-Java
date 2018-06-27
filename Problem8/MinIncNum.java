package Problem8;

/*
 * 利用二分查找法实现递增数组寻找最小值
 * 利用二分法，找到中间的数，然后和最左边的值进行比较，若大于最左边的数，则最左边从mid开始，
 * 若小于最右边值，则最右边从mid开始。若左中右三值相等，则取mid前后值中较小的数。
 * 并不能解决特殊输入数组（当right、left和mid三值相等时，无法判断）
 */
public class MinIncNum {
	public int minNum(int[] array) {
		if (array==null|| array.length==0) {
			return 0;
		}
		int left=0;					//定义左中右指针，左指针指向数组下标0处
		int right = array.length-1;//右指针指向最右边
		int mid =0;
		
		while (array[left]>=array[right]) {	//左指针大于右指针
			if (right-left<=1) {
				mid =right;
				break;					//必须加上break，跳出while循环
			}
			mid=(left+right)/2;
			
			if (array[left]==array[right]&&array[mid]==array[right]) {	//right、left和mid三值相等
				if (array[left+1]!=array[right-1]) {		//移一位之后判断是否相等
					mid=array[left+1]<array[right-1] ? left+1:right-1;//mid为移动之后的较小值
				}else {
					left++;
					right--;//相等则继续移动
				}
			}
			else {						//若right、left和mid三值不相等，则判断左右从mid开始
				if (array[left]<=array[mid]) {	//判断left是否大于mid
					left=mid;
				}else if(array[mid]<=array[right]) {
					right=mid;			//将right指针移到mid 
					}
				}
			}
		return array[mid];
	}
}
