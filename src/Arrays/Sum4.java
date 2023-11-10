package Arrays;
import java.lang.Integer;
import java.io.PrintStream;
import java.util.*;

public class Sum4 {
    public static void main(String[] args) {
        int[] test = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> res= fourSum(test,-294967296);
        System.out.println(res);

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1;j<n;j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int k=j+1,l=n-1;
                while(l>k){
                    long sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum==target){
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(temp);
                        k++;l--;
                    }else if(sum<target)k++;
                    else l--;
                    while(l>k&&l!=n-1&&nums[l]==nums[l+1])l--;
                    while(l>k&&k!=j+1&&nums[k]==nums[k-1])k++;
                }
            }
        }
        return ans;
    }
}
