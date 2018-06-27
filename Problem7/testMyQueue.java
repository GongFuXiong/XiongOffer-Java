package Problem7;


public class testMyQueue {

	public static void main(String[] args) throws Exception {
		MyQueue testQueue=new MyQueue<>();
		testQueue.appendTail(1);
		testQueue.appendTail(2);
		testQueue.appendTail(3);
		Object delHead = testQueue.deleteHead();			//必须在变量前加Object修饰
		System.out.println(delHead);
	}

}
