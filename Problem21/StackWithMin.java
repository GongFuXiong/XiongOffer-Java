package Problem21;
import java.util.Stack;
/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 * 定义两个栈，一个存放入的值。辅助栈另一个存最小值。
 */
public class StackWithMin {			//此为定义的新的栈类型

	public Stack<Integer> dataStack = new Stack<>();//定义两个stack类型
	public Stack<Integer> minStack = new Stack<>();
	
	public  void push(Integer item) {
		dataStack.push(item);
		if (minStack.size() == 0 || item <= minStack.peek()) {//返回栈顶的值,但不删除栈顶的值
			minStack.push(item);//若minStack栈值较大，则压入item栈内
		} else {
			minStack.push(minStack.peek());//minStack栈值较小，重复将栈压入，保证栈内空间一样
		}
	}

	public Integer pop() {
		minStack.pop();
		return dataStack.pop();//保证两个栈空间一样
	}
	
	public Integer min() {
		return minStack.peek();
	}

}
