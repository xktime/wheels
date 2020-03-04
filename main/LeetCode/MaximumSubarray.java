package LeetCode;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    /**
     * 思路：
     *      只要子列或者元素是大于0的那么对结果有增益
     *      否则抛弃掉
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int subArraySum = 0;
        for (int num : nums) {
            if (subArraySum > 0) {
                subArraySum += num;
            } else {
                subArraySum = num;
            }
            maxSum = Math.max(maxSum, subArraySum);
        }
        return maxSum;
    }
}
