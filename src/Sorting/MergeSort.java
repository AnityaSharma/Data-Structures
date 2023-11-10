package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {100,60,40,50,10,45,20,70,-1};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    public static int[] mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] first = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] second = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(first,second);
    }
    public static int[] merge(int[] arr1, int[] arr2){
        int[] arr = new int[arr1.length+arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<arr1.length && j<arr2.length){
            if (arr1[i] < arr2[j]){
                arr[k] = arr1[i];
                i++;
            }else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i<arr1.length){
            arr[k] = arr1[i];
            i++;k++;
        }
        while(j<arr2.length){
            arr[k] = arr2[j];
            j++;k++;
        }
        return arr;
    }
}
