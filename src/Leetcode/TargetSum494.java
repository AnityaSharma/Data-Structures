package Leetcode;

public class TargetSum494 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int p =0;
        int target = 3;
        System.out.println(targetSum(p,arr,target));

    }
    static int targetSum(int p,int[] up,int target){
        int count =0;
        //baseCondition
        if(up.length==0){
            if (p == target){
                return 1;
            }
            return 0;
        }
        int[] narr = new int[up.length-1];
        System.arraycopy(up,1,narr,0,narr.length);
        count= count + targetSum(p + up[0],narr,target);

        int neg = up[0] * -1;
        count =count + targetSum( p+ neg,narr,target);
        return count;
    }
}
