package Problem7;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 * 用两个栈实现队列 
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

public class MyQueue<T> {			//泛型需要在类中表示<T>
	private Stack<T> stack1=new Stack<>();
	private Stack<T> stack2=new Stack<>();

	private Queue<Integer> q1 = new LinkedList<>();		//定义两个队列，LinkedList为双向链表
	private Queue<Integer> q2 = new LinkedList<>();
	public void appendTail(T t){
		stack1.push(t);				//再尾部插入，直接在stack1中插入就行
	}
	
	public T deleteHead() throws Exception{
		if (stack2.isEmpty()) {					//判断stack2是否为空
			while (!stack1.isEmpty()) {		//并且stack1非空，将stack1内容压进stack2中
				stack2.push(stack1.pop());
			}
		}
        if (stack2.isEmpty()) throw new Exception();
		return stack2.pop();				//最后将stack2中的栈顶输出
	}
}
