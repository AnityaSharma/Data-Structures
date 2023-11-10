package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> Optimised(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if (i==0 || ( (i>0)&& (nums[i]!=nums[i-1]))){

                int lo=i+1,hi=nums.length-1,sum=0-nums[i];
                while(lo<hi){
                    if (nums[lo]+nums[hi]==sum){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[lo]);
                        temp.add(nums[hi]);
                        res.add(temp);

                        while(lo<hi&&nums[lo]==nums[lo+1])lo++;
                        while(lo<hi&&nums[hi]==nums[hi-1])hi--;
                        lo++;hi--;
                    } else if (sum>nums[lo]+nums[hi]) {
                        lo++;
                    }else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }





    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> myList = new ArrayList<List<Integer>>();
        int n= Integer.MAX_VALUE;
        for (int i:nums) {

        }
        int ns = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> innerList = new ArrayList<Integer>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        if (!myList.contains(innerList)){
                            myList.add(innerList);
                        }
                    }
                }
            }
        }
        return myList;
    }




}