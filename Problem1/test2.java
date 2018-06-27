package Problem1;

import util.ComplexListNode;
/*
 * 输入一个复杂链表,返回结果为复制后复杂链表的head。
 * 先复制链表的next节点，将复制后的节点接在原节点后，然后复制其它的节点，最后取偶数位置的节点（复制后的节点）
 * 将新复制的node放在旧node的后面，以免两次遍历增加复杂度
 */
public class test2 {


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

        
        ComplexListNode p = A;
        ComplexListNode cloned;
        int a=9>>1;
        int b=9/2;
        System.out.println(a);
        System.out.println(b);
        
    }

}

	

