package MockVita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Mockvita2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <=n ; i++) {
            String input=br.readLine();
            String[] array=input.split(" ");
            ArrayList<Integer> ls=graph.get(i);
            for (int j=0;j<array.length;j++){
                ls.add(Integer.parseInt(array[j]));
            }
        }
        String input=br.readLine();
        String[] arr=input.split(" ");
        int start=Integer.parseInt(arr[0]);
        int end=Integer.parseInt(arr[1]);


        int vis[]=new int[n+1];
        for (int i = 0; i <=n ; i++) {
            vis[i]=-1;
        }
        if(!dfs(start,end,graph,vis,0)){
            System.out.print(-1);
        }

    }

    public static boolean dfs(int node,int end,ArrayList<ArrayList<Integer>> graph,int[] vis,int dis){
        vis[node]=0;
        if(node==end){
            System.out.print(dis);
            return true;
        }
        for(int i:graph.get(node)){
            if (vis[i]!=0){
                if(dfs(i,end,graph,vis,dis+1)){
                    return true;
                }
            }
        }
        return false;
    }
}
