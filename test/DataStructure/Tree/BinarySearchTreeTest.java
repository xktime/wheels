package DataStructure.Tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        Tree tree = new BinarySearchTreeImpl();
        tree.put(6);
        tree.put(3);
        tree.put(5);
        tree.put(8);
        tree.put(7);
        tree.put(9);
        tree.put(4);
        tree.put(2);
        tree.put(10);
        tree.put(11);
        tree.DLR();
        tree.LDR();
        tree.LRD();
        System.out.println("二叉树总共有" + tree.size() + "个节点");
        System.out.println("移除元素8");
        tree.remove(8);
        tree.DLR();
        tree.LDR();
        tree.LRD();
    }
}
