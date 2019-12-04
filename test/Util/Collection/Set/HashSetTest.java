package Util.Collection.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSetImpl<>();
        System.out.println("=============添加元素===================");
        for (int i = 0; i < 10; i++) {
            hashSet.add(i);
        }
        System.out.println(hashSet);
        System.out.println("=============覆盖元素===================");
        for (int i = 5; i < 14; i++) {
            hashSet.add(i);
        }
        System.out.println(hashSet);
        System.out.println("=============删除元素===================");
        for (int i = 5; i < 14; i++) {
            hashSet.remove(i);
        }
        System.out.println(hashSet);
    }
}
