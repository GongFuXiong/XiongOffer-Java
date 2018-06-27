package Problem29;
import java.util.Arrays;
import java.util.Stack;
/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 采用栈修改了数组的顺序，采用对等消耗不需要改变数组顺序。。。时间复杂度都为O(n)
 */
public class CheckMoreThanHalfNum {

	public static void main(String[] args) {
        int[] a = {1,2,3,2,2,2,5,4,2,3};
        int[] b = { 1, 3, 2, 3,4,5,3};
        System.out.println(MoreThanHalfNum_Solution(b));
        System.out.println(MoreThanHalfNum_Solution2(b));

	}
    /**
     * 采用栈的方式，先排序，如果数相同则进栈，否则清空栈。
     */
    public static Integer MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);				//排序按从小到大的顺序
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < array.length; i++) {		//每一个数都会测试进栈
            if (stack.size() == 0 || stack.peek() == array[i]) {
                stack.push(array[i]);
                if (stack.size() >= array.length >> 1)	//假如stack内存大于array长度的一半
                    return stack.peek();		//一个函数只能一个return，return这个之后，后面的return无效
            } else stack.clear();		//每一个不达到标准的都会清零(因为是按照顺序排列，所以可以这样)
        }
        return 0;
    }
    
    /**
     * 采取消耗的策略。出现超过一半次数的数和其余的数消耗，最后剩下的必定为这个数
     */
    public static int MoreThanHalfNum_Solution2(int[] array) {
        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i]!=num){			//不断消耗不一样的数字
                if (count==0){			//如果消耗完之前的，赋值新的num，并count值加一
                    num=array[i];		//赋值新的num
                    count++;
                }else count--;			//如果后面值不相等，则count自减一
            }else count++;
        }
        
        if (count<=1){
            int time=0;
            for (int i = 0; i <array.length ; i++) {		//计算array中num相等的个数
                if (num==array[i]) time++;
            }
            if (time>=array.length>>1){				//验证结果是否有效，对无效输入做出处理
                return num;
            }else return 0;
        }
        return num;				//返回该数值
    }
}
