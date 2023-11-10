package CodeForces;

import java.util.*;

public class TowerOfHanoi {
    static class DS{
        int value;
        boolean flag;
        DS(int value,boolean flag){
            this.value=value;
            this.flag=flag;
        }
    }

    public static void check(int[]array,Ans bo){
        boolean b=true;
        int add=array[0]+array[1];
        for(int i=1;i<array.length-1;i++){
            int temp=array[i]+array[i+1];
            if(add!=temp){
                b=false;
                break;
            }
        }
        if(b){
            bo.b=true;
//            System.out.print("Yes");
        }
    }

    public static void rec(int i,int []array,DS[] ds,int n,Ans bo){
        array[n]=ds[i].value;
        ds[i].flag=true;
        if(n==array.length-1){
            check(array,bo);
            ds[i].flag=false;
            return;
        }
        for(int a=0;a<array.length;a++){
            if(!ds[a].flag && !bo.b){
                rec(a,array,ds,n+1,bo);
            }
        }
        ds[i].flag=false;

    }
    static class Ans{
        boolean b;
        Ans(boolean b){
            this.b=b;
        }
    }
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            t--;
            int n=sc.nextInt();
            int []array=new int[n];
            DS[] ds=new DS[n];
            for(int i=0;i<n;i++){
                ds[i]=new DS(sc.nextInt(),false);
            }
            //creating all permutations
            boolean ans=false;

            Ans bo=new Ans(ans);
            for(int i=0;i<n && !bo.b;i++){
                rec(i,array,ds,0,bo);
            }
            if(bo.b)System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
