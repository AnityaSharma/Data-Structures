package Leetcode;

import java.util.Arrays;

public class Permutations46 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] demo = new int[0];
        permute(demo,arr);
    }
    static void permute(int[] p,int[] up) {

        //BaseCondition
        if (up.length == 0){
            System.out.println(Arrays.toString(p));
            return;
        }

        for (int i = 0; i <= p.length; i++) {
            int[] larr = new int[up.length-1];
            for (int j = 0; j < larr.length; j++) {
                larr[j] = up[j+1];
            }
            permute(helper(up[0],i,p),larr);
        }
    }

    static int[] helper(int el, int index,int [] p){
        int[] harr = new int[p.length+1];
        //
        for (int i = 0; i < harr.length-1 ; i++) {
            harr[i] = p[i];
        }

        for (int i = harr.length - 1; i > index ; i--) {
            harr[i] = harr[i-1];
        }
        harr[index] = el;
        return harr;
    }
}
