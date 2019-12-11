package Algorithms.Search;

import Util.Collection.List.List;

public class CommonSearch implements Search {
    @Override
    public int search(List list, Object c) {
        if (list == null || c == null || list.isEmpty()) {
            throw new IllegalArgumentException("参数错误");
        }
        for (int i = 0; i < list.size(); i++) {
            if (c.equals(list.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
