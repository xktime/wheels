package DataStructure;
import Stack.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack(4);
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			System.out.println("栈的元素个数为：" + stack.size() + ";栈的实际大小为：" + stack.length());
		}
		System.out.println(stack);
		for (int i = 0; i <8; i++) {
			System.out.println(stack.pull() + "被pull了");
			System.out.println("栈的元素个数为：" + stack.size() + ";栈的实际大小为：" + stack.length());
		}
		System.out.println(stack);
	}
}
