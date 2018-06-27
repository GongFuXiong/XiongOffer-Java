package Problem5;

import util.ListNode;

public class test {

	public static void main(String[] args) {
		/*
		 * 定义一个链表的结构
		 */
        ListNode node1=new ListNode();    //定义一个链表的类型
        ListNode node2=new ListNode();    
        ListNode node3=new ListNode();    
        node1.value=1;    				//为链表赋值
        node2.value=2;    
        node3.value=3;    
        node1.next=node2;    
        node2.next=node3;    
//        revListRecur test=new revListRecur();    
//        test.revlistRecur(node1); 
        revListStack test1= new revListStack();
//        test1.tatalprint(node1);
        test1.reversing(node1);
	}

}
