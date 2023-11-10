package DynamicPrograming;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class NinjaTraining {
    public static void main(String[] args) {
        int [][] test={
                {2,1,3},
                {3,4,6},
                {10,1,6},
                {8,3,7}
        };
        int n=test.length;
        System.out.println(ninjaTraining(n,test));
    }
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp= new int[n][4];

        dp[0][0]=max(points[0][1],points[0][2]);
        dp[0][1]=max(points[0][0],points[0][2]);
        dp[0][2]=max(points[0][0],points[0][1]);
        dp[0][3]=max(points[0][0],max(points[0][1],points[0][2]));

        for(int day=1;day<n;day++){
            for(int last=0;last<4;last++){
                dp[day][last]=0;

                for(int task=0;task<3;task++){
                    if(task!=last){
                        int point=points[day][task]+dp[day-1][task];
                        dp[day][last]=max(dp[day][last],point);
                    }

                }
            }
        }

        return dp[n-1][3];
    }

    public static int dp(int[][] grid,int day,int last,int [][]memo){
        if(day==0){
            int max=0;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    max=Math.max(max,grid[day][i]);
                }
            }
            memo[day][last]=max;
            return max;
        }
        if(memo[day][last]!=-1)return memo[day][last];
        int max=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int points=grid[day][i]+dp(grid,day-1,i,memo);
                max=Math.max(max,points);
            }
        }
        memo[day][last]=max;
        return max;
    }

}
