package DataStructure;
import Stack.Stack;

public class StackTest {
	public static void main(String[] args) {
		Stack stack = Stack.getMe();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		for (int i = 0; i <8; i++) {
			stack.pull();
		}
		System.out.println(stack);
	}
}
