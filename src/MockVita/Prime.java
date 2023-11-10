package MockVita;

import java.util.Arrays;
import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        long l= 10000000000L;
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] array=input.split(" ");
        int []arr=new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i]=Integer.parseInt(array[i]);
        }
        Arrays.sort(arr);

        for(long i=1L;i<=l;i++) {
            boolean b = true;
            if (i == arr[0]) continue;
            for (int j = 2; j <= (i / 2) && b; j++) {
                long divisor = i / j;
                if (divisor == 0) b = false;
            }
            if (b) {
                long prime = i;
                boolean bool = true;
                for (int k = 1; k < array.length && bool; k++) {
                    long remainder = prime % arr[k];
                    if (remainder != arr[0]) bool = false;
                }
                if (bool) {
                    System.out.print(i);
                    return;
                }
            }
        }
        System.out.println("None");


    }
}




//    public static void prime(int[]arr,long l){
//        for(int i=1;i<l;i++){
//            boolean b=true;
//            if(i==arr[0])continue;
//            for(int j=2;j<=(i/2)&&b;j++){
//                long divisor=i/j;
//                if(divisor==0)b=false;
//            }
//            if(b){
//                long prime=i;
//                boolean bool=true;
//                for (int k = 1; k < array.length&&bool; k++) {
//                    long remainder=prime%arr[k];
//                    if(remainder!=arr[0])bool=false;
//                }
//                if(bool){
//                    System.out.print(i);
//                    return;
//                }
//            }
//        }
//    }

