package Problem17;
import util.ListNode;

/*
 * 输入两个递增的链表，合并这两个链表并使新链表仍然是递增的
 * 递归与求解，小数放在前面
 */
public class MergeList {
	public static void main(String[] args) {
		ListNode a1 = new ListNode();		//链表1
		ListNode a2 = new ListNode();
		a1.next = a2;
		a1.value = 1;
		a2.value = 5;

		ListNode b1 = new ListNode();		//链表2
		ListNode b2 = new ListNode();
		ListNode b3 = new ListNode();
		b1.next = b2;
		b2.next = b3;
		b1.value = 2;
		b2.value = 3;
		b3.value = 7;
		ListNode node=mergeList(a1, b1);
		while (node != null) {				//循环输出链表
			System.out.println(node.value);
			node = node.next;
		}
	}
	
    public static ListNode mergeList(ListNode head1,ListNode head2) {    
        if(head1==null) {    				//考虑特殊情况
            return head2;    
        } else if(head2==null) {    
            return head1;    
        }    
        ListNode mergeHead=null;    		//初始化新链表
        if(head1.value<head2.value) {    
            mergeHead=head1;    		//值较小者，赋值到新链表节点
            mergeHead.next=mergeList(head1.next,head2);    //利用递归求解
        } else {    
            mergeHead=head2;    
            mergeHead.next=mergeList(head1, head2.next);    
        }    
        return mergeHead;    
    }   

}
