package Util.List;

import List.ArrayListImpl;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayListImpl<Integer> arrayList = new ArrayListImpl<Integer>();
        System.out.println("=============添加元素===================");
        arrayList.addAll(0,1,2,3,4,5,6,7,8,9);
        System.out.println(arrayList);
        System.out.println("ArrayList的元素个数为：" + arrayList.size());
        System.out.println("=============删除元素===================");
        for (int i = 0; i < 4; i++) {
            arrayList.remove(i);
            System.out.println("删除元素为：" + i);
            System.out.println(arrayList);
        }
        System.out.println("ArrayList的元素个数为：" + arrayList.size());
        System.out.println("=============清除所有元素===================");
        arrayList.clear();
        System.out.println("ArrayList的元素个数为：" + arrayList.size());
        System.out.println("=============添加元素===================");
        //测试是否还能正常扩容
        for (int i = 9; i > 0; i--) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        System.out.println("ArrayList的元素个数为：" + arrayList.size());
        System.out.println("=============查找元素===================");
        for (int i = 8; i < 11; i++) {
            System.out.println("ArrayList是否包含元素 "+ i +"：" + arrayList.contains(i));
            System.out.println("元素:"+ i +" 在ArrayList的下标：" + arrayList.indexOf(i) + "处");
            System.out.println("ArrayList的下标：" + i + "处是元素：" + arrayList.get(i));
            System.out.println("-------------------------------------");
        }
    }
}
