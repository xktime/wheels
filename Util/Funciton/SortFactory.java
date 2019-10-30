package Funciton;

import Sort.*;

/**
 * 排序算法工厂
 */
public class SortFactory {

    public Sort createSort(String sortName) {
        if (sortName == null) {
            return null;
        }
        switch (sortName) {
            case "BubbleSort":
                return new BubbleSort();
            case "InsertSort":
                return new InsertSort();
            case "MergeSort":
                return new MergeSort();
            case "SelectionsSort":
                return new SelectionsSort();
        }
        return null;
    }
}
