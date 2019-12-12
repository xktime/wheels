package LeetCode;

/**
 * 55.
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGame().canJump(nums));
    }

    /**
     * 使用的递归实现，效率很低，其实只需要查找判定是否可以跳过元素为0的点就可以了
     */
    private int count = 0;

    private boolean canJump(int[] nums) {
        jump(nums, 0);
        return count > 0;
    }

    private void jump(int[] nums, int index) {
        //如果有一个解就不再判断接下来的
        if (count > 0) {
            return;
        }
        if (index == nums.length - 1) {
            count++;
        }
        if (index >= nums.length) {
            return;
        }
        int num = nums[index];
        for (int i = index + 1; i <= index + num && i < nums.length; i++) {
            jump(nums, i);
        }
    }
}
