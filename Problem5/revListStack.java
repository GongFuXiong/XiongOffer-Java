package Problem5;
import java.util.ArrayList;
import java.util.Stack;
import util.ListNode;

/*
 * 从尾到头打印链表每个节点的值
 * 利用栈后进先出,第一个函数和第二个函数是一样的
 */
public class revListStack {
    public void reversing(ListNode headNode){
        if (headNode==null) return;
        Stack<Integer> stack = new Stack<>();		//<>代表泛型，且栈里的每个元素都是int类型的
        ListNode node=headNode;
        while (node!=null){				//注意不是node.next!=null
            stack.push(node.value);		//将链表值一个个压进栈中
            node=node.next;			//将链表节点指向下一个
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());		//输出栈内容
        }
    }
    
    public void tatalprint(ListNode headNode) {
    	{
    		ArrayList<Integer> list = new ArrayList<>();	//定义一个ArrayList类型
    		if (headNode == null)
    		return ;
    		Stack<Integer> stack = new Stack<>();
    		while (headNode != null) {
    		stack.push(headNode.value);
    		headNode = headNode.next;
    		} 
    		while (!stack.isEmpty()) {
    		list.add(stack.pop());
    		} 
    		 System.out.println(list);
    		}
	}
    
}





