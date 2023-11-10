package Sorting;

import java.util.Arrays;
import static Sorting.Bubble.swap;

public class Cyclic {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(Arrays.toString(cyclic(arr)));

    }
    static int[] cyclic(int[] arr){
        int i = 0;
        while(i<arr.length){
            if (i == arr[i]-1){
                i++;
            }else {
                swap(arr,i,arr[i]-1);
            }
        }
        return arr;
    }
}
