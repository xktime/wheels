package Tree;

public class BinarySearchTreeImpl implements Tree {
    class Node {
        Node lChild;//左孩子
        Node rChild;//右孩子
        int size;//以该节点为根节点的总结点数
        int value;//该节点的值
    }

    private Node root;

    @Override
    public void put(int value) {
        root = put(root, value);
    }

    @Override
    public boolean remove(int value) {
        if (!contain(value)) {
            //不包含元素直接返回
            return false;
        }
        Node parentNode = findParentNode(root, value);//被删除节点的父节点
        Node node = find(parentNode, value);//被删除的节点
        //如果被删除节点之后没有节点，直接删除
        if (node.lChild == null && node.rChild == null) {
            if (parentNode.lChild == node) {
                parentNode.lChild = null;
            } else if (parentNode.rChild == node) {
                parentNode.rChild = null;
            }
            return true;
        }
        //如果被删除节点只有一个孩子，那么直接将该孩子节点放到被删除节点的位置
        if (node.lChild == null) {
            if (parentNode.lChild == node) {
                parentNode.lChild = node.rChild;
            } else if (parentNode.rChild == node) {
                parentNode.rChild = node.rChild;
            }
            return true;
        } else if (node.rChild == null) {
            if (parentNode.lChild == node) {
                parentNode.lChild = node.lChild;
            } else if (parentNode.rChild == node) {
                parentNode.rChild = node.lChild;
            }
            return true;
        }
        //如果被删除节点有两个孩子
        if (parentNode.lChild == node) {
            Node priorNode = findPriorNode(node);
            remove(priorNode.value);
            parentNode.lChild = priorNode;
            priorNode.lChild = node.lChild;
            priorNode.rChild = node.rChild;
        } else if (parentNode.rChild == node) {
            Node priorNode = findPriorNode(node);
            remove(priorNode.value);
            parentNode.rChild = priorNode;
            priorNode.lChild = node.lChild;
            priorNode.rChild = node.rChild;
        }
        return true;
    }

    @Override
    public boolean contain(int value) {
        return find(root, value) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public void DLR() {
        StringBuilder str = new StringBuilder();
        DLR(root, str);
        formatString(str, "先序遍历：");
        System.out.println(str.toString());
    }

    @Override
    public void LDR() {
        StringBuilder str = new StringBuilder();
        LDR(root, str);
        formatString(str, "中序遍历：");
        System.out.println(str.toString());
    }

    @Override
    public void LRD() {
        StringBuilder str = new StringBuilder();
        LRD(root, str);
        formatString(str, "后序遍历：");
        System.out.println(str.toString());
    }

    /**
     * 递归插入元素
     */
    private Node put(Node node, int value) {
        if (node == null) {
            //终结条件，返回被插入节点
            Node newNode = new Node();
            newNode.size = 1;
            newNode.value = value;
            return newNode;
        }
        //判断插入到左节点还是右节点
        if (value > node.value) {
            node.rChild = put(node.rChild, value);
        } else if (value < node.value) {
            node.lChild = put(node.lChild, value);
        }
        //最后加的1是节点自己
        node.size = size(node.rChild) + size(node.lChild) + 1;
        return node;
    }

    /**
     * 递归查找元素
     */
    private Node find(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value == node.value) {
            return node;
        }
        if (value > node.value) {
            node = find(node.rChild, value);
        } else {
            node = find(node.lChild, value);
        }
        return node;
    }

    /**
     * 递归查找元素的双亲节点
     */
    private Node findParentNode(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.lChild.value == value || node.rChild.value == value) {
            return node;
        }
        if (value > node.value) {
            node = findParentNode(node.rChild, value);
        } else {
            node = findParentNode(node.lChild, value);
        }
        return node;
    }

    /**
     * 递归查找元素的前趋节点
     */
    private Node findPriorNode(Node node) {
        if (node == null) {
            return null;
        }
        //节点的前驱节点是小于节点的最大节点，即左孩子节点的最右节点
        Node priorNode = node.lChild;
        while (priorNode.rChild != null) {
            priorNode = priorNode.rChild;
        }
        return priorNode;
    }

    /**
     * 先序遍历
     */
    private void DLR(Node node, StringBuilder str) {
        if (node == null) {
            return;
        }
        str.append(node.value).append('、');
        DLR(node.lChild, str);
        DLR(node.rChild, str);
    }

    /**
     * 中序遍历
     */
    private void LDR(Node node, StringBuilder str) {
        if (node == null) {
            return;
        }
        LDR(node.lChild, str);
        str.append(node.value).append('、');
        LDR(node.rChild, str);
    }

    /**
     * 后序遍历
     */
    private void LRD(Node node, StringBuilder str) {
        if (node == null) {
            return;
        }
        LRD(node.lChild, str);
        LRD(node.rChild, str);
        str.append(node.value).append('、');
    }

    /**
     * 对打印的字符串格式化
     *
     * @param s 在字符前插入字符
     */
    private void formatString(StringBuilder str, String s) {
        int index = str.lastIndexOf("、");
        //删除最后一个顿号
        str.delete(index, index + 1);
        str.insert(0, '[').append(']');
        str.insert(0, s);
    }

    /**
     * 获取总节点数
     *
     * @return 以参数节点为根节点的总结点数
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }
}
