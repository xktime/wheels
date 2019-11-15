package Algorithms.Enums;

public enum SortType {
    BUBBLE_SORT("冒泡排序"),
    INSERT_SORT("插入排序"),
    MERGE_SORT("归并排序"),
    SELECTIONS_SORT("选择排序"),
    QUICK_SORT("快速排序"),
    QUICK_3_WAY_SORT("3向切分快速排序"),
    ;

    private String sortName;

    SortType(String sortName) {
        this.sortName = sortName;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
