package Problem5;

import util.ListNode;
/*
 * 利用链表结构的递归方法		从尾到头打印链表每个节点的值
 * （重点理解递归）
 */
public class revListRecur {
	public static void revlistRecur(ListNode headNode) {
		if (headNode!=null) {
			System.out.println("fffff----"+headNode.value);
			
			if (headNode.next!=null) {
				System.out.println("rrrrr" + headNode.value + "次");
				
				revlistRecur(headNode.next);//输入为下一个节点，执行完之后返回以上语句执行
												//递归本质上为栈结构，会继续执行内存余下部分
				System.out.println("执行第" + headNode.value + "次");
				}
			
		System.out.println(headNode.value);
		}
	}
	
	
    public void reversing(ListNode root){
        if (root==null) return;
        reversing(root.next);
        System.out.println(root.value);
    }
}
