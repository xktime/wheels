package LeetCode;

import Util.Collection.List.ArrayListImpl;
import Util.Collection.List.List;

/**
 * 89.
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 */
public class GrayCode {
	public static void main(String[] args) {
		System.out.println(new GrayCode().grayCode(3));
	}

	private List<Integer> grayCode(int n) {
		List<Integer> arr = new ArrayListImpl<>();
		for (int i = 0; i < 1 << n; ++i)
			arr.add(i ^ i >> 1);
		return arr;
	}
}
