package Problem21;

public class test21 {

	public static void main(String[] args) {
		StackWithMin  stack =new StackWithMin(); //StackWithMin为定义新的栈类型
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());

	}

}
