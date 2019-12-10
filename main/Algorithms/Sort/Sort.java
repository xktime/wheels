package Algorithms.Sort;

import Util.Collection.List.List;

public interface Sort<T extends Comparable<? super T>> {
    void sort(List<T> list);
}
