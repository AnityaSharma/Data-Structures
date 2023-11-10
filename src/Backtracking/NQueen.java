package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        List<List<String>> ans = new ArrayList<>();
        nQueens(board,0,ans);
        System.out.println(ans);

    }
    static void nQueens(boolean[][] board, int r, List<List<String>> ans){
        if(r>= board.length){
            List<String> list = new ArrayList<>();
            for (boolean[] arr:board) {
                StringBuilder sb = new StringBuilder();
                for (boolean b:arr) {
                    if (b){
                        sb.append("Q");
                    }
                    if (!b){
                        sb.append(".");
                    }
                }
                String s = sb.toString();
                list.add(s);
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < board[0].length ; col++) {
            board[r][col] = true;
            if (isSafe(board,r,col)){
                nQueens(board,r+1,ans);
            }
            board[r][col] = false;
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
            int r1 = r;
            int c1 = c;
            if (board[--r1][--c1]){
                return false;
            }
        }
        int minRight = Math.min(board[r].length-c-1,r);
        for (int i = 0; i < minRight ; i++) {
            int r1 = r;
            int c1 = c;
            if (board[--r1][++c1]){
                return false;
            }
        }
        return true;
    }

}
