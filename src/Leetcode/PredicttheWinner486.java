package Leetcode;
public class PredicttheWinner486 {
    public static void main(String[] args) {
        int[] nums = {1,5,2};
        System.out.println(isTrue(0,nums,0,1));

    }
    static boolean isTrue(int p1, int[] arr , int p2 ,int step ){
        if (arr.length == 0){
            if (p1 >= p2){
                return true;
            }
        }
        if (step%2 != 0){
            int[] arrD = new int[arr.length-1];
            for (int i = 0; i < arrD.length; i++) {
                arrD[i] = arr[i+1];
            }
            if (isTrue(p1+arr[0],arrD,p2,step+1)){
                return true;
            }
            for (int i = 0; i < arrD.length; i++) {
                arrD[i] = arr[i+1];
            }
            if (isTrue(p1+ arr[arr.length-1],arrD,p2,step+1)){
                return true;
            }
        }else {
            int[] arrD = new int[arr.length - 1];
            for (int i = 0; i < arrD.length; i++) {
                arrD[i] = arr[i + 1];
            }
            if (isTrue(p1, arrD, p2 + arr[0], step + 1)) {
                return true;
            }
            for (int i = 0; i < arrD.length; i++) {
                arrD[i] = arr[i+1];
            }
            if (isTrue(p1, arrD, p2 + arr[arr.length - 1], step + 1)) {
                return true;
            }
        }
        return false;
    }
}
