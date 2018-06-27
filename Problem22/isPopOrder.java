package Problem22;
import java.util.Stack;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 用栈来压入弹出元素，相等则出栈
 * 以辅助栈是否全部弹出为符合依据
 */
public class isPopOrder {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 4, 3, 5, 2, 1 };

		System.out.println(IsPopOrder(array1, array2));
	}

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (null == pushA || null == popA || pushA.length <= 0 || popA.length <= 0 || pushA.length != popA.length) {
            return false;			//特殊情况
        }

        Stack<Integer> stack = new Stack<>();	//新建一个辅助栈
        int popIndex = 0;					//指向popA的下一个弹出数据
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);		//循环压入pushA值
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {//判断栈顶是否等于pop弹出序列值
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();			//以辅助栈是否全部弹出为符合依据
    }
}
