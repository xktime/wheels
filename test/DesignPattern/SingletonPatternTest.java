package DesignPattern;

import DesignPattern.SingletonPattern.SingletonPatternImpl;

public class SingletonPatternTest {
    public static void main(String[] args) {
        //获取对象实例
        SingletonPatternImpl impl1 = SingletonPatternImpl.getMe();
        SingletonPatternImpl impl2 = SingletonPatternImpl.getMe();
        //判断是否为同一个对象
        System.out.println(impl1 == impl2);
    }
}
