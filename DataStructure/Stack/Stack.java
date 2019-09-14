package Stack;

public class Stack<T> {
	private T[] arr;
	private int point = 0;//栈顶指针
	//容量达到最大容量的百分比之后，进行扩容或缩小
	private int EXPANSION_PROBABILITY = 80;//不能大于100，大于100会导致数组无法扩容
	private int REDUCTION_PROBABILITY = 50;//不能大于REDUCTION_SIZE，否则会导致当前的栈内元素个数多于缩小后的数组大小，引起越界异常
	//扩大或缩小成当前最大容量的百分比
	private int EXPANSION_SIZE = 150;
	private int REDUCTION_SIZE = 70;
	private double MAX_PROBABILITY = 100;//类型为double是为了计算的时候不需要再转换类型

	public Stack(int size) {
		arr = (T[])new Object[size];
	}

	public void push(T value) {
		if (size() > (length() - 1)) {
			System.out.println("数组已满，EXPANSION_PROBABILITY不能大于100");
			return;
		}
		arr[point++] = value;
		//数组需要扩容的阈值
		double expansion = length() * (EXPANSION_PROBABILITY / MAX_PROBABILITY);
		if (size() >= expansion) {
			int size = (int) (length() * (EXPANSION_SIZE / MAX_PROBABILITY));
			resize(size);
		}
	}

	public T pull() {
		if (size() == 0) {
			System.out.println("栈内没有元素，不能执行PULL操作");
			return null;
		}
		T value = arr[--point];
		//数组需要缩小的阈值
		double reduction = length() * (REDUCTION_PROBABILITY / MAX_PROBABILITY);
		if (size() < reduction) {
			int size = (int) (length() * (REDUCTION_SIZE / MAX_PROBABILITY));
			resize(size);
		}
		return value;
	}

	/**
	 * @return 栈内当前元素的个数
	 */
	public int size() {
		return point;
	}

	/**
	 * @return 栈的实际大小
	 */
	public int length() {
		return arr.length;
	}

	public String toString() {
		StringBuilder str1 = new StringBuilder();
		str1.append('[');
		for (int i = 0; i < point; i++) {
			if (i != (point - 1)) {
				str1.append(arr[i]).append('、');
			} else {
				str1.append(arr[i]);
			}
		}
		str1.append(']');
		return str1.toString();
	}

	/**
	 * 调整数组大小
	 *
	 * @param size 调整后数组的大小
	 */
	private void resize(int size) {
		if (point > size) {
			System.out.println("调整数组大小失败，REDUCTION_SIZE不能小于REDUCTION_PROBABILITY");
			return;
		}
		T[] tempArr = (T[])new Object[size];
		for (int i = 0; i < point; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
	}
}
