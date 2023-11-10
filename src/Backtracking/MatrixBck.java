package Backtracking;

import java.util.Arrays;

public class MatrixBck {
    public static void main(String[] args) {
        boolean[][] r = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] arr = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        search("",r,0,0,1,arr);

    }
    static void search(String p,boolean[][] maze,int r,int c,int count,int[][] arr){
        if (r == maze.length-1 && c == maze[0].length-1){
            arr[r][c] = count;
            for(int[] ints:arr){
                System.out.println(Arrays.toString(ints));
            }
            System.out.println(p);
            System.out.println();
            arr[r][c] = 0;
            return;
                                                                                                                                                                                                                                                                                                                       }
        if (!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        arr[r][c] = count;
//        count++;
        if (r < maze[0].length-1 ){
            search(p+'D',maze,r+1,c,count+1,arr);
        }

        if (c < maze.length-1 ){
            search(p+'R',maze,r,c+1,count+1,arr);
        }

        if (r > 0 ){
            search(p+'U',maze,r-1,c,count+1,arr);
        }

        if (c > 0 ){
            search(p+'L',maze,r,c-1,count+1,arr);
        }
//        count--;
        maze[r][c] = true;
        arr[r][c] = 0;
    }
}
