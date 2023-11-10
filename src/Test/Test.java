package Test;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        long a=3;
        long ans=sumFirstN(a);
        System.out.println(ans);
    }
    public static long sumFirstN(long n) {
        long ans=0;
        sol(ans,n);
        return ans;
    }
    public static void sol(long ans,long i){
        if(i==0)return;
        sol(ans,i-1);
        ans+=i;
    }
}
