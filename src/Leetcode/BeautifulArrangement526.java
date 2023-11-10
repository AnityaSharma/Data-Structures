package Leetcode;
public class BeautifulArrangement526 {
    static boolean isValid(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i]%(i+1) == 0 || (i+1) % arr[i] == 0)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int n = 5;
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = i+1;
        }
        permute(new int[0],arr);
    }
    static int permute(int[] p,int[] up) {
        int count = 0;
        //BaseCondition
        if (up.length == 0){
            if (isValid(p)) {
                return 1;
            }
            return 0;
        }

        for (int i = 0; i <= p.length; i++) {
            int[] larr = new int[up.length-1];
            for (int j = 0; j < larr.length; j++) {
                larr[j] = up[j+1];
            }
            count = count + permute(helper(up[0],i,p),larr);
        }
        return count;
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
