package DynamicPrograming;

public class MinimumPAthSum {

    public static void main(String[] args) {
        int[][]grid={
                {8,1,6},
                {4,4,16},
                {2,7,20},
                {20,7,20}
        };
        int n=grid.length;
        int m=grid[0].length;
        System.out.println( rec(n-1,m-1,grid));
    }
    public static int rec(int row,int col,int [][]grid){
        if(row==0&&col==0)return grid[row][col];

        if(row<0||col<0)return Integer.MAX_VALUE;

        int up=grid[row][col]+rec(row-1,col,grid);
        int left=grid[row][col]+rec(row,col-1,grid);

        return Math.min(up,left);
    }
}
