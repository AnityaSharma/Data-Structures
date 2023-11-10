package Sorting;

import java.util.Arrays;

import static Sorting.Bubble.swap;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {2,1};
        System.out.println(Arrays.toString(insertion(arr)));
    }

//    static int[] insertion(int[] arr){
//        for (int i = 0; i <= arr.length-2 ; i++) {
//            for (int j = i+1;j > 0; j--) {
//                if (arr[j]>arr[j-1]){
//                    swap(arr,j,j-1);
//                }else {
//                    break;
//                }
//            }
//        }
//        return  arr;
//    }
    static int[] insertion(int[] arr){
        for (int i = 0; i <= arr.length-2; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }

    return arr;
    }


}
