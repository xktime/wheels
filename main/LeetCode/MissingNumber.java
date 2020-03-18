package LeetCode;

/**
 * 268.
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 *
 */
public class MissingNumber {
    /**
     * 思路：
     *      将temp[nums[i]] 的值置为-1
     *      temp[i]不为-1的i即为解
     */
    public int missingNumber(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] = -1;
        }
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] != -1) {
                return i;
            }
        }
        return -1;
    }
}
