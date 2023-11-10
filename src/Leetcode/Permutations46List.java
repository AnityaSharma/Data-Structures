package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations46List {
    public static void main(String[] args) {

        int[] arr = {1,2,3};
        int[] demo = new int[0];
        List<List<Integer>> ans = permute(demo,arr);
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> temp : ans ) {
                if (!list.contains(temp)){
                    list.add(temp);
                }
        }
    }
    static List<List<Integer>> permute(int[] p,int[] up) {

        List<List<Integer>> list = new ArrayList<>();
        //BaseCondition
        if (up.length == 0){
            ArrayList<Integer> al = new ArrayList<>(p.length);
            for (int i = 0; i < p.length; i++) {
                al.add(i,p[i]);
            }
            list.add(al);
            return list;
        }

        for (int i = 0; i <= p.length; i++) {
            int[] larr = new int[up.length-1];
            for (int j = 0; j < larr.length; j++) {
                larr[j] = up[j+1];
            }
            list.addAll(permute(helper(up[0],i,p),larr));
        }
        return list;
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
