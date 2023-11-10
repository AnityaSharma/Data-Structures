package Backtracking;

public class NQueens2 {
    public static void main(String[] args) {
        int x = 4;
        boolean[][] board = new boolean[x][x];
        int count = search(board,0);
        System.out.println(count);
    }
    static int search(boolean[][] board, int row){
        if (row == board.length){
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            board[row][col] = true;
            if (isSafe(board,row,col)){
                count = count + search(board,row+1);
            }
            board[row][col] = false;
        }
        return count;
    }
    static boolean isSafe(boolean[][] board,int row,int col){

        for (int i = 0; i < row ; i++)
            if (board[i][col]) return false;


        int minLeft = Math.min(row,col);
        for (int i = 1; i <= minLeft ; i++) {
            if (board[row-i][col-i]) return false;
        }


        int minright = Math.min(row,board.length-col-1);
        for (int i = 1; i <= minright ; i++) {
            if (board[row-i][col+i])return false;
        }
        return true;
    }
}
//    static boolean isSafe(boolean[][] board,int r ,int c){
//        for (int i = 0; i < r ; i++) {
//            if (board[i][c]){
//                return false;
//            }
//        }
//
//        int minLeft = Math.min(r,c);
//        for (int i = 1; i <= minLeft ; i++) {
//            if (board[r-i][c-i]){
//                return false;
//            }
//        }
//        int minRight = Math.min(board.length-c-1,r);
//        for (int i = 1; i <= minRight ; i++) {
//            if (board[r-i][c+i]){
//                return false;
//            }
//        }
//        return true;
//    }
