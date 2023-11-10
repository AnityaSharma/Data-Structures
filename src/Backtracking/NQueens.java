package Backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nQueens(board,0);

    }
    static void test(boolean[][] board){
        for (boolean[] b:board) {
            StringBuilder sd = new StringBuilder();
            for (boolean a:b) {
                if (a){
                    sd.append("Q");
                }else {
                    sd.append(".");
                }
            }
            System.out.println(sd.toString());
        }

    }

    static boolean isSafe(boolean[][] board,int r ,int c){
        for (int i = r-1; i >= 0 ; i--) {
            if (board[i][c]){
                return false;
            }
        }

        int minLeft = Math.min(r,c);
        for (int i = 0; i < minLeft ; i++) {
            if (board[r-i][c-i]){
                return false;
            }
        }
        int minRight = Math.min(board[0].length-c-1,r);
        for (int i = 0; i < minRight ; i++) {
            if (board[r-i][c+i]){
                return false;
            }
        }
        return true;
    }
    static void nQueens(boolean[][] board , int r){
        if (r >= board.length){
            test(board);
            System.out.println();
            return;
        }
        for (int col = 0; col < board[0].length ; col++) {

            if (isSafe(board,r,col)){
                board[r][col] = true;
                  nQueens(board,r+1);
                board[r][col] = false;
            }

        }
    }
}
