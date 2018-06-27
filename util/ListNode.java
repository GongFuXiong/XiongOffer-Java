package util;

/*
 * 单向的链表定义,指针域和数据域必须是public
 */
public final class ListNode {
	public ListNode next;	//指针域
	public int value;		//数据域
	
	public ListNode(int value){		//定义构造函数
		this.value=value;
	}

	public ListNode() {		//定义无参构造函数
		this(0);
	}
}
