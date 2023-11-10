package Backtracking;

public class Recurssion {
    public static void main(String[] args) {
            boolean[][] r = {
                    {true,true,true},
                    {true,true,true},
                    {true,true,true}
            };
            search("",r,0,0);
    }
    static void search(String p,boolean[][] maze,int r,int c){
        if (r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return;
        }

        maze[r][c] = false;
        if (r < maze[0].length-1 ){
            search(p+'D',maze,r+1,c);
        }

        if (c < maze.length-1 ){
            search(p+'R',maze,r,c+1);
        }

        if (r > 0 ){
            search(p+'U',maze,r-1,c);
        }

        if (c > 0 ){
            search(p+'L',maze,r,c-1);
        }
        maze[r][c] = true;
    }
}
