package Algorithms;

public class Fibonacci {

    public int byRecursive(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法传入值");
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return byRecursive(n - 1) + byRecursive(n - 2);
    }

    public int byCircle(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法传入值");
        }
        int num = 1;
        int lastNum = 1;
        for (int i = 2; i < n; i++) {
            int temp = num;
            num = num + lastNum;
            lastNum = temp;
        }
        return num;
    }
}
