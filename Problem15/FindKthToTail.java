package Problem15;
import util.ListNode;
/*
 * 输入一个链表，输出该链表中倒数第 k 个结点(需要一次遍历，时间复杂度为O(n))
 * 定义一快一慢两个指针，快指针走K步，然后慢指针开始走，快指针到尾时，慢指针就找到了倒数第K个节点
 * 注意鲁棒性
 */
public class FindKthToTail {
	public static void main(String[] args) throws Exception {
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
		ListNode node=findKToTail(a, 3);
		System.out.println(node.value);
	}
	
    public static ListNode findKToTail(ListNode head,int k) throws Exception {    
        if(head==null||k<=0) {    //空链表情况
            throw new Exception("空指针。。。。");    
        }    
        ListNode BehindNode=head;    //定义两个指针
        ListNode AheadNode=head;    
        for(int i=1; i<k; i++) {    		//只循环一次，时间复杂度为O(n)
            if(AheadNode.next!=null) {    //注意鲁棒性
            	AheadNode=AheadNode.next;    
            } else {    
                return null;   
            }    
        }    

        while(AheadNode.next!=null) {    //两个指针一同向后移动,直到链表末尾
        	BehindNode=BehindNode.next;    
        	AheadNode=AheadNode.next;    
        }    
        return BehindNode;
    }   

}
