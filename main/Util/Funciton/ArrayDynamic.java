package Util.Funciton;

/**
 * 动态扩展或缩小的数组继承类
 */
public abstract class ArrayDynamic<T> {
    //容量达到最大容量的百分比之后，进行扩容或缩小
    private static final int EXPANSION_PROBABILITY = 75;//不能大于100，大于100会导致数组无法扩容
    private static final int REDUCTION_PROBABILITY = 50;//不能大于REDUCTION_SIZE，否则会导致当前的栈内元素个数多于缩小后的数组大小，引起越界异常
    //扩大或缩小成当前最大容量的百分比
    private static final int EXPANSION_SIZE = 150;
    private static final int REDUCTION_SIZE = 70;
    private static final double MAX_PROBABILITY = 100;//类型为double是为了计算的时候不需要再转换类型

    /**
     * 扩大容量
     *
     * @param array 需要修改大小的数组
     * @param size  数组的元素个数
     */
    protected T[] expandCapacity(T[] array, int size) {
        //数组需要扩容的阈值
        double expansion = array.length * (EXPANSION_PROBABILITY / MAX_PROBABILITY);
        //是否需要扩容
        if (size >= expansion) {
            double resizedSize = array.length * (EXPANSION_SIZE / MAX_PROBABILITY);
            array = resize(array, size, resizedSize);
        }
        return array;
    }

    /**
     * 缩小容量
     *
     * @param array 需要修改大小的数组
     * @param size  数组的元素个数
     */
    protected T[] trimCapacity(T[] array, int size) {
        //数组需要缩小的阈值
        double reduction = array.length * (REDUCTION_PROBABILITY / MAX_PROBABILITY);
        //是否需要缩小容量
        if (size < reduction) {
            double resizedSize = array.length * (REDUCTION_SIZE / MAX_PROBABILITY);
            if (size > resizedSize) {
                System.out.println("调整数组大小失败，REDUCTION_SIZE不能小于REDUCTION_PROBABILITY");
                return array;
            }
            array = resize(array, size, resizedSize);
        }
        return array;
    }

    /**
     * 调整数组大小
     *
     * @param array       需要调整大小的数组
     * @param size        数组的元素个数。因为数组之后的元素没有删除，需要确定数组的元素个数
     * @param resizedSize 需要将数组调整到的大小
     * @return 调整之后的数组
     */
    protected T[] resize(T[] array, int size, double resizedSize) {
        //缩小时向上取整是因为向下取整可能导致容量被resize为0
        //扩容时向上取整是因为如果如果实际容量为1之后.会一直为1,增加元素之后不会再继续扩容
        T[] tempArr = (T[]) new Object[ceil(resizedSize)];
        for (int i = 0; i < size; i++) {
            tempArr[i] = array[i];
        }
        return tempArr;
    }

    /**
     * 向上取整
     */
    protected int ceil(double value) {
        return (int) value + 1;
    }
}
