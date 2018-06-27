package Problem37;
import util.ListNode;
/*
 * 输入两个链表，找出它们的第一个公共结点。
 * way1 蛮力时间O(m*n)
 * way2 利用栈时间O(m+n) 空间O(m+n)
 * way3 时间O(m+n)
 */
public class FindFirstCommonNode {

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(6);
        ListNode a5 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(5);
        b1.next = b2;
        b2.next = a4;

        System.out.println(new FindFirstCommonNode().find(a1, b1).value);
	}
	
    public ListNode find(ListNode root1, ListNode root2) {
        int len1 = getLength(root1);		//链表长度，以便同步到达尾端
        int len2 = getLength(root2);
        ListNode LongList = null;			//定义两个链表
        ListNode ShortList = null;
        int dif = 0;			//长度差
        if (len1 > len2) {
        	LongList = root1;
        	ShortList = root2;
            dif = len1 - len2;
        } else {
        	LongList = root2;
        	ShortList = root1;
            dif = len2 - len1;
        }
        for (int i = 0; i < dif; i++) {			//长链表先遍历
        	LongList = LongList.next;
        }
        while (LongList != null && ShortList != null && LongList != ShortList) {//同时遍历，直到相同
        	LongList =LongList.next;
        	ShortList = ShortList.next;
        }
        return LongList;
    }

    private int getLength(ListNode root) {	//计算链表长度
        int res = 0;
        if (null == root) return res;
        
        ListNode p = root;
        while (p != null) {
            p = p.next;
            res++;
        }
        return res;
    }
}
