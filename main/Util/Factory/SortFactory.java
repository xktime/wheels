package Util.Factory;

import Algorithms.Enums.SortType;
import Algorithms.Sort.*;

/**
 * 排序算法工厂
 */
public class SortFactory<T extends Comparable<? super T>> {

    public Sort<T> createSort(SortType sortType) {
        switch (sortType) {
            case BUBBLE_SORT:
                return new BubbleSort<>();
            case INSERT_SORT:
                return new InsertSort<>();
            case MERGE_SORT:
                return new MergeSort<>();
            case SELECTIONS_SORT:
                return new SelectionsSort<>();
            case QUICK_SORT:
                return new QuickSort<>();
            case QUICK_3_WAY_SORT:
                return new Quick3WaySort<>();
        }
        return null;
    }
}
