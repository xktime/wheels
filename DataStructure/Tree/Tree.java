package Tree;

public interface Tree {

    void put(int value);//添加元素

    boolean remove(int value);//删除元素,返回是否删除成功

    boolean contain(int value);//是否包含元素

    boolean isEmpty();//树是否为空

    int size();//树节点的个数

    void DLR();//先序遍历

    void LDR();//中序遍历

    void LRD();//后序遍历
}
