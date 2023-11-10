package Arrays;

import java.util.HashMap;

public class Sum2 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mapp=new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int num=nums[i];
            int moreNeeded=target-num;
            if (mapp.containsKey(moreNeeded)){
                return new int[]{mapp.get(moreNeeded),i};
            }
            mapp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
