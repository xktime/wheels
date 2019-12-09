package Algorithms;

public class FibonacciTest {
    public static void main(String[] args) {
        System.out.println("=============递归===================");
        for (int i = 1; i < 10; i++) {
            System.out.println("第" + i + "位Fibonacci数为：" + new Fibonacci().byRecursive(i));
        }
        System.out.println("=============循环===================");
        for (int i = 1; i < 10; i++) {
            System.out.println("第" + i + "位Fibonacci数为：" + new Fibonacci().byCircle(i));
        }
    }
}
