package Algorithms;

import Util.Collection.List.ArrayListImpl;
import Util.Collection.List.List;

/**
 * n皇后问题
 */
public class NQueen {
    private int n = 8;
    private int count = 0;
    private int[] chessBoard;
    private List<String> answer = new ArrayListImpl<>();

    //默认为8皇后
    public NQueen() {
        chessBoard = new int[n];
        nQueen(0);
    }

    public NQueen(int n) {
        this.n = n;
        chessBoard = new int[n];
        nQueen(0);
    }

    private void nQueen(int row) {
        if (row == n) {
            //找到一个解
            count++;
            putAnswer(answer, chessBoard);
            return;
        } else {
            for (int j = 0; j < n; j++) {
                chessBoard[row] = j;//把j放入row行
                boolean flag = true;
                for (int k = 0; k < row; k++) {
                    //判断左右对角线
                    if (chessBoard[row] == chessBoard[k]
                            || row - chessBoard[row] == k - chessBoard[k]
                            || row + chessBoard[row] == k + chessBoard[k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    nQueen(row + 1);
                }
            }
        }
    }

    //获取八皇后解的数量
    public int getCount() {
        return count;
    }

    //打印解
    public void printAnswer() {
        if (answer == null || answer.isEmpty()) {
            return;
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.println("第" + (i + 1) + "个解为：" + answer.get(i));
        }
    }

    /**
     * @param l   解所要放入的容器
     * @param arr 解
     */
    private void putAnswer(List<String> l, int[] arr) {
        if (l == null || arr == null) {
            return;
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            //+1是因为存放棋盘值从0开始
            s.append(arr[i] + 1).append(" ");
        }
        l.add(s.toString());
    }
}
