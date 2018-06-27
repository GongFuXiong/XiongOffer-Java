package Problem16;
import util.ListNode;

public class ReverseList {
/*
 * 输入一个链表，反转链表后，输出链表的所有元素（反转即为改变链表的next值）
 * 定义两个指针，反向输出
 */
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
		ListNode node=reverseList(a);
		
		while (node != null) {		//循环输出链表
			System.out.println(node.value);
			node = node.next;
		}
	}

    public static ListNode reverseList(ListNode head) {    //链表输入都为头结点
        if(head==null) {    //空链表情况
            return null;    
        }    
        if(head.next==null) {    
            return head;    
        }    
        ListNode newNode = null;	//构造新的链表
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) {
                cur.next = newNode;
                return cur;
            }
            ListNode next = cur.next;	//作用第四条语句，next为继续下一次循环的中间变量
            cur.next = newNode;			//把新的结点赋给下一位
            newNode = cur;				//得到新的结点,改变链表next值即为反转链表
            cur = next;			//继续下一次循环
        }

        return newNode;

    }  
}
