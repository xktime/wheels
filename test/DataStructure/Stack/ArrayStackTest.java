package DataStructure.Stack;

public class ArrayStackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStackImpl<Integer>(4);
		System.out.println("=============入栈===================");
		//入栈操作
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println("栈的元素个数为：" + stack.size());
		System.out.println("=============出栈===================");
		//出栈操作
		for (int i = 0; i < 11; i++) {
			stack.pop();
		}
		System.out.println(stack);
		System.out.println("栈的元素个数为：" + stack.size());
		System.out.println("=============入栈===================");
		//测试空栈之后是否还能正常扩容
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println("栈的元素个数为：" + stack.size());
	}
}
