package Funciton;

/**
 * 动态扩展或缩小的数组继承类
 *
 */
public abstract class ArrayDynamicEx {
	/**
	 * 调整数组大小
	 *
	 * @param array
	 * @param size        队尾指针。因为数组之后的元素没有删除，需要确定数组的实际大小
	 * @param resizedSize 需要将数组调整到的大小
	 * @return
	 */
	protected Object[] resize(Object[] array, int size, double resizedSize) {
		//缩小时向上取整是因为向下取整可能导致容量被resize为0
		//扩容时向上取整是因为如果如果实际容量为1之后.会一直为1,增加元素之后不会再继续扩容
		Object[] tempArr = new Object[ceil(resizedSize)];
		for (int i = 0; i < size; i++) {
			tempArr[i] = array[i];
		}
		return tempArr;
	}

	/**
	 * 向上取整
	 *
	 * @param value
	 * @return
	 */
	private int ceil(double value) {
		return (int) value + 1;
	}
}
