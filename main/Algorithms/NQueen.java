package Algorithms;

/**
 * n皇后问题
 */
public class NQueen {
    private int n = 8;
    public int count = 0;
    private int[] chessBoard;

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
            count++;
            return;
        } else {
            for (int j = 0; j < n; j++) {
                chessBoard[row] = j;//把j放入row行
                boolean flag = true;
                for (int k = 0; k < row; k++) {
                    //判断左右对角线
                    if (chessBoard[row] == chessBoard[k]
                            || row - chessBoard[row] ==  k - chessBoard[k]
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
}
