package Algorithms.Search;

import Util.Collection.List.List;
import Util.Funciton.Collections;

/**
 * 二分查找
 */
public class BinarySearch implements Search {
    private Comparable c;

    /**
     * @param c 所要查找的元素
     * @return 已排序数组返回所要查找元素的下标（如果是未排序数组，返回的是该数组排序之后元素所在下标）
     */
    public int search(List<? extends Comparable> list, Comparable c) {
        this.c = c;
        Collections.sort(list);
        if (list == null || c == null || list.isEmpty()) {
            throw new IllegalArgumentException("参数错误");
        }
        return binarySearch(list, 0, list.size() - 1);
    }

    private int binarySearch(List<? extends Comparable> list, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (list == null || list.isEmpty() || mid >= list.size()) {
            throw new IllegalArgumentException("参数错误");
        }
        if (c.compareTo(list.get(mid)) < 0) {
            return binarySearch(list, low, mid - 1);
        } else if (c.compareTo(list.get(mid)) > 0) {
            return binarySearch(list, mid + 1, high);
        } else if (c.compareTo(list.get(mid)) == 0) {
            return mid;
        } else {
            return -1;
        }
    }
}
