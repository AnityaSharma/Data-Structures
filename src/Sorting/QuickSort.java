package Sorting;

import java.util.Arrays;

import static Sorting.Bubble.swap;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int l, int h){
        if (l>=h){
            return;
        }
        int s = l;
        int e = h;
        int pivot = arr[h];

        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }
            if (s<=e){
                swap(arr,s,e);
                s++;e--;
            }
        }
        quickSort(arr,l,e);
        quickSort(arr,s,h);
    }
}
