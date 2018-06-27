package Problem8;
/*
 * 利用二分查找法和顺序查找实现递增数组寻找最小值
 * 
 */
public class RotateArray {
	public Integer min(int[] array) {
        if (array==null|| array.length<1) {
            return null;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {//左指针大于右指针
            if (right-left <= 1) {
                mid = right;
                break;
            }
            mid = (left+right) / 2;
            if (array[left]==array[right]&&array[mid]==array[right]) {
                return getMinInOrder(array, left, right);	//当right、left和mid三值相等，调用顺序查找函数
            }
            if (array[left]<=array[mid]) {
            	left=mid;
            } else if (array[mid]<=array[right]) {
                right = mid;
            }
        }

        return array[mid];
    }

    /**
     * 当low, mid, high相等时我们无法判断a[mid]属于哪个递增子数组时
     * 只能进行顺序查找
     */
    private int getMinInOrder(int[] array, int left, int right) {
        int min = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < min) {
            	min = array[i];
            }
        }

        return min;		//输出最小值
    }
}
