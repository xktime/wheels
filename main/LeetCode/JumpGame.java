package LeetCode;

/**
 * 55.
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class JumpGame {
	public static void main(String[] args) {
		int[] nums = {2, 0, 0, 1, 4};
		System.out.println(new JumpGame().canJump(nums));
	}

	/**
	 * 动态规划实现，还有种方法，查找判定是否可以跳过元素为0的点就可以了
	 */
	private boolean canJump(int[] nums) {
		boolean[] f = new boolean[nums.length];
		f[0] = true;
		for (int i = 1; i < nums.length; i++) {
			f[i] = false;
			for (int j = 0; j < i; j++) {
				if (f[j] && j + nums[j] >= i) {
					f[i] = true;
					break;
				}
			}
		}
		return f[nums.length - 1];
	}
}
