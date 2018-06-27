package Problem26;
import util.ComplexListNode;
/*
 * 输入一个复杂链表,返回结果为复制后复杂链表的head。
 * 先复制链表的next节点，将复制后的节点接在原节点后，然后复制其它的节点，最后取偶数位置的节点（复制后的节点）
 * 将新复制的node放在旧node的后面，以免两次遍历增加复杂度（在旧链表里面插入p.next.next等于旧链表里面的p.next）
 */
public class CloneComplexList {

	public static void main(String[] args) {
        ComplexListNode A = new ComplexListNode(0);		//初始化过程中，可以同时赋值
        ComplexListNode B = new ComplexListNode(1);
        ComplexListNode C = new ComplexListNode(2);
        ComplexListNode D = new ComplexListNode(3);
        ComplexListNode E = new ComplexListNode(4);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;

        A.random = C; // 2
        B.random = E; // 4
        D.random = B; // 1
        ComplexListNode newHead = clone(A);

        while (null != newHead) {
            System.out.println("value域:" + newHead.value + ", random域:" + newHead.random);
            newHead = newHead.next;
        }
	}
	

    
    public static ComplexListNode clone(ComplexListNode pHead) {////都是基于原链表进行操作
        if (pHead == null) return null;

        //插入新node
        ComplexListNode curr = pHead;
        while (curr != null) {
        	ComplexListNode node = new ComplexListNode(curr.value);
            node.next = curr.next;				//相当于插入操作，可以理解为node和curr指向的node是一样的
            curr.next = node;//将新复制的node放在旧node的后面，以免两次遍历增加复杂度
//          clonedNode=p;					//不能直接赋值node
            curr = curr.next.next;				//下一次遍历为隔一个的node(相当于插入一个node)
        }									//curr.next.next等于旧链表里面的curr.next

        //复制random
        curr = pHead;
        while (curr != null) {
        	ComplexListNode next = curr.next;//将下一位赋值
            if (curr.random != null)
                next.random = curr.random.next;//正确的，将random下一位赋值给新node
            curr = next.next;
        }

        //拆链表
        curr = pHead;
        ComplexListNode tmp;
        ComplexListNode result = curr.next;
        while (curr != null) {
            tmp = curr.next;
            curr.next = tmp.next;
            if (tmp.next != null) {
                tmp.next = tmp.next.next;				//隔一个的意思
            }
            curr = curr.next;

        }
        return result;
    }
}
