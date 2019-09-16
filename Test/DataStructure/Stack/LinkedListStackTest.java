package DataStructure.Stack;

import Stack.LinkedListStackImpl;

public class LinkedListStackTest {
	public static void main(String[] args) {
		LinkedListStackImpl<Integer> stack = new LinkedListStackImpl();
		System.out.println("=============入栈===================");
		//入栈操作
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println("栈的大小为：" + stack.size());
		System.out.println("=============出栈===================");
		//出栈操作以及空栈之后处理是否正常
		for (int i = 0; i < 11; i++) {
			stack.pop();
		}
		System.out.println(stack);
		System.out.println("栈的大小为：" + stack.size());
	}
}
