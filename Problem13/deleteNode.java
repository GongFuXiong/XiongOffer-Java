package Problem13;
import util.ListNode;
/*
 * 给定单向链表的头指针和一个节点，定义一个函数在O(1)时间删除该节点
 * 将要删除节点的下一个节点的值赋给要删除的节点，然后指向下下一个节点
 * 操作被删除node的下一个node
 * 一定要分多种特殊情况
 */
public class deleteNode {
	public static void main(String[] args) {
		ListNode a = new ListNode();
		ListNode b = new ListNode();
		ListNode c = new ListNode();
		ListNode d = new ListNode();
		a.next = b;
		b.next = c;
		c.next = d;
		a.value = 1;
		b.value = 2;
		c.value = 3;
		d.value = 4;
		deletenode(a, a);
		while (a != null) {	//循环输出node的值
			System.out.println(a.value);
			a = a.next;
		}
	}
	
    public static void deletenode(ListNode headNode,ListNode deleteNode) {    
        if(deleteNode==null||headNode==null) {    //链表中为空
            return;    //返回主函数，不执行剩余函数
        }    
        if(headNode.next==null) { //链表中只有一个结点..注意为headNode.next==null
            headNode=null;    

        } else {    
            if(deleteNode.next==null) { //删除结点为尾结点    
                ListNode pointNode=headNode;    
                while(pointNode.next.next!=null) {    
                    pointNode=pointNode.next;    
                }    
                pointNode.next=null;    		//前一个node指向null，就相当于删除
            } else {    
                deleteNode.value=deleteNode.next.value;    //将下一个node值赋予被删除的node
                deleteNode.next=deleteNode.next.next;    //将下一个node指向赋予被删除的node
            }    
        }    
    } 

}
