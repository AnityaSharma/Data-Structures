package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathwithMaximumGold1219 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,6,0},
                {5,8,7},
                {0,9,0},
        };
        System.out.println(Max(grid));

    }

    static int Max(int[][] grid){
        List<Integer> ls = gold(grid,0,0);
        int max = -1;
        for (int a : ls) {
            if (a>max){
                max = a;
            }
        }
        return max;
    }
    static List<Integer> gold(int[][] matrix,int row,int col){
        List<Integer> ls = new ArrayList<>();

        //BaseCondition
        if (row == matrix.length){
            return ls;
        }

        //ChangingRows
        if (col == matrix[row].length){
            ls.addAll(gold(matrix,row +1 ,0));
            return ls;
        }
        if (matrix[row][col] != 0){
            boolean [][] boolmatrix = new boolean[matrix.length][matrix[row].length];
            boolmatrix[row][col] = true;
            ls.addAll(helper(matrix,row,col,matrix[row][col],boolmatrix));
            boolmatrix[row][col] = false;
        }
        ls.addAll((gold(matrix,row,col+1)));
        return ls;
    }
    static List<Integer> helper(int[][] matrix, int row , int col , int boss, boolean[][] boolmatrix){
        List<Integer> list = new ArrayList<>();

        //going down
        if (row < matrix.length-1 && !(boolmatrix[row+1][col]) && matrix[row+1][col] != 0){
                boolmatrix[row+1][col] = true;
                list.addAll(helper(matrix,row +1,col,boss+matrix[row+1][col],boolmatrix));
                boolmatrix[row+1][col] = false;
        }

        //going right
        if (col < matrix[row].length-1 && !(boolmatrix[row][col+1]) && matrix[row][col+1] != 0){
            boolmatrix[row][col+1] = true;
            list.addAll(helper(matrix,row,col+1,boss+matrix[row][col+1],boolmatrix));
            boolmatrix[row][col+1] = false;
        }

        //going up
        if (row > 0 && !(boolmatrix[row-1][col]) && matrix[row-1][col] != 0){
            boolmatrix[row-1][col] = true;
            list.addAll(helper(matrix,row-1,col,boss+matrix[row-1][col],boolmatrix));
            boolmatrix[row-1][col] = false;
        }

        //going left
        if (col > 0 && !(boolmatrix[row][col-1]) && matrix[row][col-1] != 0){
            boolmatrix[row][col-1] = true;
            list.addAll(helper(matrix,row,col-1,boss+matrix[row][col-1],boolmatrix));
            boolmatrix[row][col-1] = false;
        }
        list.add(boss);
        return list;
    }
}
