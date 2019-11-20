package Algorithms;

public class NQueenTest {
    public static void main(String[] args) {
        NQueen nQueen = new NQueen(8);
        System.out.println(nQueen.getCount());
        nQueen.printAnswer();
    }
}
