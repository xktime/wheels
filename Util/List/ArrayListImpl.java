package List;

import Funciton.ArrayDynamicEx;

public class ArrayListImpl<T> extends ArrayDynamicEx implements List {
	private T[] array;
	private int rear = 0;//队尾指针
	//容量达到最大容量的百分比之后，进行扩容或缩小
	private int EXPANSION_PROBABILITY = 80;//不能大于100，大于100会导致数组无法扩容
	private int REDUCTION_PROBABILITY = 50;//不能大于REDUCTION_SIZE，否则会导致当前的栈内元素个数多于缩小后的数组大小，引起越界异常
	//扩大或缩小成当前最大容量的百分比
	private int EXPANSION_SIZE = 150;
	private int REDUCTION_SIZE = 70;
	private double MAX_PROBABILITY = 100;//类型为double是为了计算的时候不需要再转换类型

	public ArrayListImpl(int size) {
		array = (T[]) new Object[size];
	}

	@Override
	public boolean add(Object e) {
		return false;
	}

	@Override
	public boolean remove(Object e) {
		return false;
	}

	@Override
	public void sort() {

	}

	@Override
	public void clear() {

	}

	@Override
	public Object get(int index) {
		return null;
	}

	@Override
	public int indexOf(Object e) {
		return 0;
	}

	@Override
	public boolean contains(Object e) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
