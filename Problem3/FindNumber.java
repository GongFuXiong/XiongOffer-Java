package Problem3;
/*
 * 判断数组中是否含指定数字
 * 从从数组右上角或者左下角选择数字复杂度较低
 * 不能从左上角或者右下角
 */
public class FindNumber {
	public static boolean findNumber(int[][] array, int number){ //定义函数，boolean类型，输入为一个数组和指定数字
		if (array==null) {		//判断是否为空数组
			return false;
		}
		int column = array[0].length-1;		//定义行列值
		int row=0;
		while (row<array.length&&column>=0) {  //循环判断，从数组右上角选择数字复杂度较低
			if (array[row][column]==number) {
				return true;
			}
			if (array[row][column]>number) {	//不相等，指定值较小则列减，较大则行增
				column--;
			}
			else {
				row++;
			}
		}
		return false;
	}
}
