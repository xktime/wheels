package DataStructure.Stack;

import Stack.LinkedListStack;

public class LinkedListStackTest {
	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println("栈的大小为：" + stack.size());
		for (int i = 0; i < 8; i++) {
			stack.pop();
		}
		System.out.println(stack);
		System.out.println("栈的大小为：" + stack.size());
	}
}
