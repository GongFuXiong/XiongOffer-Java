package util;

public class Stack {
    private int maxSize;// 栈的大小
    private int top;
    private char[] arr;

    public Stack(int size) {
        maxSize = size;
        top = -1;
        arr = new char[maxSize];
    }

    public void push(char value) { // 压入数据

        arr[++top] = value;
    }

    public char pop() { // 弹出数据

        return arr[top--];
    }

    public char peek() { // 访问栈顶元素

        return arr[top];
    }

    public boolean isFull() { // 栈是否满了

        return maxSize - 1 == top;
    }

    public boolean isEmpty() { // 栈是否为空

        return top == -1;
    }
}
