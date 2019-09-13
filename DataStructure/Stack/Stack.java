package Stack;

public class Stack {
	private final static Object lock_object = new Object();//加锁用的对象
	private static Stack stack;
	private int[] arr;
	private int point = 0;//栈顶指针
	private int INITIAL_VALUE = 4;//初始容量大小
	//容量达到最大容量的百分比之后，进行扩容或缩小
	private int EXPANSION_PROBABILITY = 80;//不能大于100，大于100会导致数组无法扩容
	private int REDUCTION_PROBABILITY = 50;//不能大于REDUCTION_SIZE，否则会导致当前的栈内元素个数多于缩小后的数组大小，引起越界异常
	//扩大或缩小成当前最大容量的百分比
	private int EXPANSION_SIZE = 150;
	private int REDUCTION_SIZE = 70;
	private double MAX_PROBABILITY = 100;//类型为double是为了计算的时候不需要再转换类型

	private Stack() {
		arr = new int[INITIAL_VALUE];
	}

	//单例，使用单例是方便以后用来测试多线程
	public static Stack getMe() {
		if (stack == null) {
			synchronized (lock_object) {
				if (stack == null) {
					stack = new Stack();
				}
			}
		}
		return stack;
	}

	public void push(int value) {
		if (size() > (length() - 1)) {
			System.out.println("数组已满，EXPANSION_PROBABILITY不能大于100");
			return;
		}
		arr[point++] = value;
		//数组需要扩容的阈值
		double expansion = length() * (EXPANSION_PROBABILITY / MAX_PROBABILITY);
		if (size() >= expansion) {
			int size = (int) (length() * (EXPANSION_SIZE / MAX_PROBABILITY));
			autoAdjustedSize(size);
		}
	}

	public void pull() {
		if (size() == 0) {
			System.out.println("栈内没有元素，不能执行PULL操作");
			return;
		}
		--point;
		//数组需要缩小的阈值
		double reduction = length() * (REDUCTION_PROBABILITY / MAX_PROBABILITY);
		if (size() < reduction) {
			int size = (int) (length() * (REDUCTION_SIZE / MAX_PROBABILITY));
			autoAdjustedSize(size);
		}
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
	private void autoAdjustedSize(int size) {
		if (point > size) {
			System.out.println("调整数组大小失败，REDUCTION_SIZE不能小于REDUCTION_PROBABILITY");
			return;
		}
		int[] tempArr = new int[size];
		for (int i = 0; i < point; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
	}
}
