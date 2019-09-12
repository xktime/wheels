package Stack;

public class Stack {
	private final static Object lock_object = new Object();//加锁用的对象
	private static Stack stack;
	private int[] arr;
	private int point = 0;//栈顶指针
	private int INITIAL_VALUE = 4;//初始容量大小
	//容量达到最大容量的百分比之后，进行扩容或缩小
	private int EXPANSION_PROBABILITY = 80;
	private int REDUCTION_PROBABILITY = 50;
	//扩大或缩小当前最大容量的百分比
	private int EXPANSION_SIZE = 150;
	private int REDUCTION_SIZE = 70;
	private int MAX_PROBABILITY = 100;

	private Stack(){
		arr = new int[INITIAL_VALUE];
	}

	//单例，使用单例是方便以后用来测试多线程
	public static Stack getMe(){
		if (stack == null) {
			synchronized (lock_object) {
				if (stack == null) {
					stack = new Stack();
				}
			}
		}
		return stack;
	}

	public void push (int value) {
		arr[point++] = value;
		int expasion = (int)(arr.length * ((double) EXPANSION_PROBABILITY/MAX_PROBABILITY));
		if (point >= expasion) {
			int size = (int)(arr.length * ((double) EXPANSION_SIZE/MAX_PROBABILITY));
			autoAdjustedSize(size);
		}
	}

	public void pull() {
		int reduction = (int)(arr.length * ((double) REDUCTION_PROBABILITY/MAX_PROBABILITY));
		if (--point < reduction) {
			int size = (int)(arr.length * ((double) REDUCTION_SIZE/MAX_PROBABILITY));
			autoAdjustedSize(size);
		}
	}

	public String toString() {
		StringBuilder str1 = new StringBuilder();
		str1.append('[');
		for (int i = 0; i < point; i++) {
			if (i != point-1) {
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
