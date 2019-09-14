package Stack;

public class ArrayStackImpl<T> implements Stack {
	private T[] array;
	private int point = 0;//栈顶指针
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
	public void push(Object element) {
		if (size() > (length() - 1)) {
			System.out.println("数组已满，EXPANSION_PROBABILITY不能大于100");
			return;
		}
		array[point++] = (T) element;
		//数组需要扩容的阈值
		double expansion = length() * (EXPANSION_PROBABILITY / MAX_PROBABILITY);
		if (size() >= expansion) {
			int size = (int) (length() * (EXPANSION_SIZE / MAX_PROBABILITY));
			resize(size);
		}
	}

	@Override
	public T pop() {
		if (size() == 0) {
			System.out.println("空栈不能执行pop操作");
			return null;
		}
		T element = array[--point];
		//数组需要缩小的阈值
		double reduction = length() * (REDUCTION_PROBABILITY / MAX_PROBABILITY);
		if (size() < reduction) {
			int size = (int) (length() * (REDUCTION_SIZE / MAX_PROBABILITY));
			resize(size);
		}
		return element;
	}

	/**
	 * @return 栈内当前元素的个数
	 */
	@Override
	public int size() {
		return point;
	}

	/**
	 * @return 栈的实际大小
	 */
	public int length() {
		return array.length;
	}

	@Override
	public String toString() {
		StringBuilder str1 = new StringBuilder();
		str1.append('[');
		for (int i = 0; i < point; i++) {
			if (i != (point - 1)) {
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
		T[] tempArr = (T[]) new Object[size];
		for (int i = 0; i < point; i++) {
			tempArr[i] = array[i];
		}
		array = tempArr;
	}
}
