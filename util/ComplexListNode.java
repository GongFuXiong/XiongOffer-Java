package util;

public class ComplexListNode {
	public int value=0;
	
	public ComplexListNode next = null;
	
	public ComplexListNode random = null;//随机指向一个node
	
    public ComplexListNode() {
        this(0);
    }

    public ComplexListNode(int value) {
        this.value = value;
    }


}
