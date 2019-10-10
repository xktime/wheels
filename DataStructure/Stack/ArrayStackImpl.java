package Stack;

import Funciton.ArrayDynamicEx;

public class ArrayStackImpl<T> extends ArrayDynamicEx implements Stack<T> {
	private T[] array;
	private int topPoint = 0;//栈顶指针
	//容量达到最大容量的百分比之后，进行扩容或缩小
	private int EXPANSION_PROBABILITY = 80;//不能大于100，大于100会导致数组无法扩容
	private int REDUCTION_PROBABILITY = 50;//不能大于REDUCTION_SIZE，否则会导致当前的栈内元素个数多于缩小后的数组大小，引起越界异常
	//扩大或缩小成当前最大容量的百分比
	private int EXPANSION_SIZE = 150;
	private int REDUCTION_SIZE = 70;
	private double MAX_PROBABILITY = 100;//类型为double是为了计算的时候不需要再转换类型

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
		//数组需要扩容的阈值
		double expansion = array.length * (EXPANSION_PROBABILITY / MAX_PROBABILITY);
		if (size() >= expansion) {
			double size = array.length * (EXPANSION_SIZE / MAX_PROBABILITY);
			array = (T[]) resize(array, topPoint, size);
		}
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			System.out.println("空栈不能执行pop操作");
			return null;
		}
		T element = array[--topPoint];
		//数组需要缩小的阈值
		double reduction = array.length * (REDUCTION_PROBABILITY / MAX_PROBABILITY);
		if (size() < reduction) {
			double size = array.length * (REDUCTION_SIZE / MAX_PROBABILITY);
			if (topPoint > size) {
				System.out.println("调整数组大小失败，REDUCTION_SIZE不能小于REDUCTION_PROBABILITY");
				return null;
			}
			array = (T[]) resize(array, topPoint, size);
		}
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
