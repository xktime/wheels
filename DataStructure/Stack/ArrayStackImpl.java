package Stack;

import Funciton.ArrayDynamic;

public class ArrayStackImpl<T> extends ArrayDynamic implements Stack<T> {
	private T[] array;
	private int topPoint = 0;//栈顶指针

	public ArrayStackImpl(int size) {
		array = (T[]) new Object[size];
	}

	@Override
	public void push(T element) {
		if (size() > (array.length - 1)) {
			System.out.println("数组已满，EXPANSION_PROBABILITY不能大于100");
			return;
		}
		array[topPoint++] = element;
		array = (T[]) expationCapacity(array, size());
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			System.out.println("空栈不能执行pop操作");
			return null;
		}
		T element = array[--topPoint];
		array = (T[]) trimCapacity(array, size());
		return element;
	}

	/**
	 * @return 栈内当前元素的个数
	 */
	@Override
	public int size() {
		return topPoint;
	}

	@Override
	public String toString() {
		//按入栈顺序打印
		StringBuilder str1 = new StringBuilder();
		str1.append('[');
		for (int i = 0; i < topPoint; i++) {
			if (i != (topPoint - 1)) {
				str1.append(array[i]).append('、');
			} else {
				str1.append(array[i]);
			}
		}
		str1.append(']');
		return str1.toString();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

}
