package Algorithms.Enums;

public enum SortType {
    BUBBLE_SORT("BubbleSort"),
    INSERT_SORT("InsertSort"),
    MERGE_SORT("MergeSort"),
    SELECTIONS_SORT("SelectionsSort"),
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
