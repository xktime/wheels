package DataStructure.Stack;

import Stack.ArrayStackImpl;

public class ArrayStackTest {
	public static void main(String[] args) {
		ArrayStackImpl<Integer> stack = new ArrayStackImpl(4);
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			System.out.println("栈的元素个数为：" + stack.size() + ";栈的实际大小为：" + stack.length());
		}
		System.out.println(stack);
		for (int i = 0; i < 8; i++) {
			System.out.println(stack.pop() + "被pull了");
			System.out.println("栈的元素个数为：" + stack.size() + ";栈的实际大小为：" + stack.length());
		}
		System.out.println(stack);
	}
}
