package DataStructure.LinkedList;

import LinkedList.SinglyLinkedListImpl;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedListImpl<Integer> linkedList = new SinglyLinkedListImpl<Integer>();
        System.out.println("===============添加元素=================");
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println(linkedList);
        System.out.println("===============插入元素=================");
        System.out.println("在第5个位置插入元素11，在第100个位置插入元素12");
        linkedList.insert(11,5);
        linkedList.insert(12,100);
        System.out.println(linkedList);
        System.out.println("===============删除元素=================");
        System.out.println("先删除第5个元素，再删除第100个元素");
        linkedList.remove(5);
        linkedList.remove(100);
        System.out.println(linkedList);
        System.out.println("===============查找元素=================");
        System.out.println(linkedList);
        System.out.println("链表的第五个元素是：" + linkedList.get(5));
        System.out.println("元素2在链表的第" + linkedList.find(2) + "位");
        System.out.println("元素100在链表的第" + linkedList.find(100) + "位");
    }
}
