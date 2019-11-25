package Util.Collection.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedListImpl<Integer>();
        System.out.println("=============添加元素===================");
        linkedList.addAll(0,1,2,3,4,5,6,7,8,9);
        System.out.println(linkedList);
        System.out.println("LinkedList的元素个数为：" + linkedList.size());
        System.out.println("=============删除元素===================");
        //测试删除头元素
        linkedList.remove(0);
        System.out.println("删除元素为：" + 0);
        System.out.println(linkedList);
        System.out.println("LinkedList的元素个数为：" + linkedList.size());
        System.out.println("-------------------------------------");
        //测试删除中间元素
        linkedList.remove(8);
        System.out.println("删除元素为：" + 8);
        System.out.println(linkedList);
        System.out.println("LinkedList的元素个数为：" + linkedList.size());
        System.out.println("-------------------------------------");
        //测试删除尾元素
        linkedList.remove(9);
        System.out.println("删除元素为：" + 9);
        System.out.println(linkedList);
        System.out.println("LinkedList的元素个数为：" + linkedList.size());
        System.out.println("=============清除所有元素===================");
        linkedList.clear();
        System.out.println(linkedList);
        System.out.println("LinkedList的元素个数为：" + linkedList.size());
        System.out.println("=============添加元素===================");
        for (int i = 9; i > 0; i--) {
            linkedList.add(i);
        }
        System.out.println(linkedList);
        System.out.println("LinkedList的元素个数为：" + linkedList.size());
        System.out.println("=============查找元素===================");
        for (int i = 8; i < 11; i++) {
            System.out.println("LinkedList是否包含元素 "+ i +"：" + linkedList.contains(i));
            System.out.println("元素:"+ i +" 在LinkedList下标:" + linkedList.indexOf(i) + "处");
            System.out.println("LinkedList的下标：" + i + "处是元素：" + linkedList.get(i));
            System.out.println("-------------------------------------");
        }
        System.out.println("=============测试Iterator，使用foreach遍历===================");
        for (Object i : linkedList) {
            System.out.print(i + " ");
        }
    }
}
