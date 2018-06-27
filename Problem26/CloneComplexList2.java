package Problem26;
import util.ComplexListNode;
/*
 * 比较简单的方法,时间复杂度较高
 */
public class CloneComplexList2 {
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
	
	private static ComplexListNode clone(ComplexListNode PHead) {
		if (PHead==null) {
			return null;
		}
		ComplexListNode CopyHead=new ComplexListNode(PHead.value);		//将旧值赋予新node
//		ComplexListNode CopyHead=PHead;		//直接把跟结点赋值不得行
		ComplexListNode temp =CopyHead;		//需要设置一个临时变量，，不然最后输出的是value4
		
		while (PHead.next!=null) {
			temp.next=new ComplexListNode(PHead.next.value);		//将下一个值赋予临时变量下一位
			if (PHead.random!=null) {
				temp.random=new ComplexListNode(PHead.random.value);
			}
			PHead=PHead.next;
			temp=temp.next;
		}
		return CopyHead;
	}

}
