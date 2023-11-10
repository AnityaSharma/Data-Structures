package Sorting;

import java.util.Arrays;
import static Sorting.Bubble.swap;
public class Selection {

    static int[] selectionmin(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            int min = arr.length-1;
            for (int j = i; j < arr.length ; j++) {
                if (arr[min]>arr[j]){
                    min = j;
                }
            }
            swap(arr,min,i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(selectionmin(arr)));
    }
    static int[] selectionmax(int[] arr){
        for (int j = arr.length-1; j > 0 ; j--) {
            int max = 0;
            for (int i = 0; i <= j; i++) {
                if (arr[max]<arr[i]){
                    max = i;
                }
            }
            swap(arr,j,max);
        }
        return arr;
    }
}
