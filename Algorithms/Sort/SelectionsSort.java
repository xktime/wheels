package Sort;

import Funciton.Collections;
import List.List;

/**
 * 选择排序
 */
public class SelectionsSort implements Sort {
	@Override
	public void sort(List<? extends Comparable> list) {
		for (int j = 0; j < list.size() - 1; j++) {
			int minIndex = j;//最小元素的下标
			for (int k = minIndex + 1; k < list.size(); k++) {
				if (list.get(k).compareTo(list.get(minIndex)) < 0) {
					minIndex = k; //记下目前找到的最小值所在的下标
				}
			}
			Collections.swap(list, j, minIndex);
		}
	}
}
