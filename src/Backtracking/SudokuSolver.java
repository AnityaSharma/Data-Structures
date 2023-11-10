package Backtracking;

import java.util.Arrays;

public class SudokuSolver {
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
        sudokuS(board,0,0);
    }
    static void sudokuS(char[][] sud, int row , int col){
        if (row == sud.length - 1 && col == sud.length ){
            for (char[] arr: sud) {
                for ( char el: arr) {
                    System.out.print(el);
                }
                System.out.println();
            }
            return;
        }
        if (col == sud.length ){
            sudokuS(sud,row+1,0);
            return;
        }
        if (sud[row][col] == '.'){
            for (int num = 1; num <= 10 ; num++) {
                if (num == 10){
                    return;
                }
                if (isSafe(sud,row,col,num)){
                    sud[row][col] = (char) (num + '0');
                    sudokuS(sud,row,col+1);
                    sud[row][col] = '.';
                }
            }
        }else {
            sudokuS(sud,row,col+1);
        }
    }

    static boolean isSafe(char[][] sud,int row , int col, int num){
        //searching vertically
        for (int i = 0; i < sud.length; i++) {
            if (sud[i][col] == (char) (num + '0')){
                return false;
            }
        }

        //checking horizontally
        for (int i = 0; i < sud.length; i++) {
            if (sud[row][i] == (char) (num + '0')){
                return false;
            }
        }

        //checking in the small matrix

        int rStart = validR(row);
        int cStart = validC(col);
        for (int i = rStart ; i < rStart+3 ; i++) {
            for (int j = cStart ; j < cStart+3 ; j++) {
                if (sud[i][j] == (char) (num + '0') ){
                    return false;
                }
            }
        }
        return true;
    }
    static int validR(int row){
        if (row >=0 && row <3){
            return 0;
        }
        if (row >=3 && row <6){
            return 3;
        }
        return 6;
    }

    static int validC(int col){
        if (col >=0 && col <3){
            return 0;
        }
        if (col >=3 && col <6){
            return 3;
        }
        return 6;
    }
}
