package LeetCode;

import Util.Collection.List.ArrayListImpl;
import Util.Collection.List.List;

/**
 * 260.
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.print(new SingleNumber().singleNumber(nums));
    }

    private int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayListImpl<>();
        for (int i : nums) {
            if (!list.contains(i)) {
                list.add(i);
            } else {
                list.remove(new Integer(i));
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
