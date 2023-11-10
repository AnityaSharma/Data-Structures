package Leetcode;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                sarr[i][j] = '.';
            }
        }
        sudoku(board,0,0,sarr);
        for (char[] carr: sarr) {
            for (char elm:carr) {
               if (elm == '.'){
                   return ;
               }
            }
        }
        return ;
    }
    static char[][] sarr = new char[9][9];
    static void sudoku(char[][] board, int row, int col,char[][] sarr){
        // BaseCondition
        if (row == board.length-1 && col == board[row].length){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    sarr[i][j] = board[i][j];
                }
            }
            return;
        }
        if (col==board[row].length){
            sudoku(board,row+1,0,sarr);

        }
        if (col == board.length ){
            sudoku(board,row+1,0,sarr);
            return;
        }
        if (board[row][col] == '.'){
            for (int num = 1; num <= 10 ; num++) {
                if (num == 10){
                    return;
                }
                if (isValid(board,row,col,num)){
                    board[row][col] = (char) (num + '0');
                    sudoku(board,row,col+1,sarr);
                    board[row][col] = '.';
                }
            }
        }else {
            sudoku(board,row,col+1,sarr);
        }
    }
    static boolean isValid(char[][] board,int row , int col, int num){
        //checking horizontally
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == (char) (num + '0')){
                return false;
            }
        }
//         checking vertically
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == (char) (num + '0')){
                return false;
            }
        }

        int rStart = row - (row % 3);
        int cStart = col - (col % 3);
        for (int i = rStart; i < rStart+3; i++) {
            for (int j = cStart; j < cStart+3 ; j++) {
                if(board[i][j] == (char) (num + '0')){
                    return false;
                }
            }
        }
        return true;
    }

}
