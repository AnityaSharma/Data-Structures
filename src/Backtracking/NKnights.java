package Backtracking;

public class NKnights {
    public static void main(String[] args) {
        int x = 4;
        boolean[][] board = new boolean[x][x];
        search(board,0,0,x);
    }
    static boolean isSafe(boolean[][] board ,int row , int col){
        if (isValid(board,row-1,col-2)){
            if (board[row-1][col-2]){
                return false;
            }
        }
        if (isValid(board,row-1,col+2)){
            if (board[row-1][col+2]){
                return false;
            }
        }
        if (isValid(board,row-2,col-1)){
            if (board[row-2][col-1]){
                return false;
            }
        }
        if (isValid(board,row-2,col+1)){
            if (board[row-2][col+1]){
                return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean[][] board, int row, int col){
        if (row>=0 && row< board.length && col >= 0 && col < board.length){
            return true;
        }
        return false;
    }
    static void search(boolean[][] board ,int row , int col, int knights){
        if (row == board.length-1 && col == board.length){
            return;
        }
        if (knights == 0){
            printThe(board);
            return;
        }
        if (col == board.length){
                search(board,row+1,0,knights);
                return;
        }

        if (isSafe(board,row,col)){
            board[row][col] = true;
            search(board,row,col+1,knights-1);
            board[row][col] = false;
        }
        search(board, row, col+1, knights);
    }
    static void printThe(boolean[][] board){
        for (boolean[] arr:board) {
            for (boolean element:arr) {
                if (element){
                    System.out.print("K");
                }else System.out.print("O");
            }
            System.out.println();
        }
        System.out.println();
    }
}
