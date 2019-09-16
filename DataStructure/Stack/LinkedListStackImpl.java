package Stack;


public class LinkedListStackImpl<T> implements Stack {
	private class Node {
		Node next;
		T element;
	}

	private Node top;//栈顶元素
	private int size = 0;

	@Override
	public void push(Object element) {
		Node newTop = new Node();
		newTop.element = (T) element;
		newTop.next = top;
		top = newTop;
		size++;
	}

	@Override
	public Object pop() {
		if (size == 0) {
			System.out.println("空栈不能执行pop操作");
			return null;
		}
		size--;
		T element = top.element;
		top = top.next;
		return element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		//按出栈顺序打印，暂时先这样测试用；等之后写了反转字符串之后再来从新实现入栈顺序打印
		StringBuilder str1 = new StringBuilder();
		if (isEmpty()) {
			return str1.append('[').append(']').toString();
		}
		Node tempTop = top;
		str1.append('[');
		while (tempTop.next != null) {
			str1.append(tempTop.element).append('、');
			tempTop = tempTop.next;
		}
		if (tempTop.next == null) {
			str1.append(tempTop.element);
		}
		str1.append(']');
		return str1.toString();
	}
}
