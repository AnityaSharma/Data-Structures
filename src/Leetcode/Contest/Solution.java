package Leetcode.Contest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int [][]grid={{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int [] arr={20,10,9,7,4,3,5};
        long ans =maximumScoreAfterOperations(grid,arr);
        System.out.println(ans);
    }
    private static class Pair{
        int node;
        int value;
        Pair(int node,int value){
            this.node=node;
            this.value=value;
        }
    }
    public static long maximumScoreAfterOperations(int[][] edges, int[] values) {
            int n=values.length;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int []vis =new int[n];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)vis[i]=-1;
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(0,values[0]));
        while(!que.isEmpty()){
            Pair pair=que.remove();
            int node=pair.node;
            int value=pair.value;
            vis[node]=0;

            ArrayList<Integer> ls= graph.get(node);
            if(ls.size()==1){
                list.add(value);
                continue;
            }

            for(int p: ls){
                int nd=p;
                if(vis[nd]==-1){
                    que.add(new Pair(nd,value+values[nd]));
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i:list){
            if(i>max)max=i;
        }
        return max;
    }
}
