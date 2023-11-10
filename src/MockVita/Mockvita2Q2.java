//package MockVita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mockvita2Q2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        String[] arr=input.split(" ");
        int n=Integer.parseInt(arr[0]);
        int m=Integer.parseInt(arr[1]);
        char[][] matrix= new char[n][m];
        int points=0;
        for (int i = 0; i < n; i++) {
            String row=br.readLine();
            for (int j = 0; j < m; j++) {
                char c=row.charAt(j);
                matrix[i][j]=c;
                if(c=='C')++points;
            }
        }
        int calories=0;
        for (int i = 0; i < m; i++) {
            int index=-1;
            for (int j = 0; j <n; j++) {
                if (matrix[j][i]=='C'){
                    index=j;
                    break;
                }
            }
            if(index!=-1){
                calories+=(n-index-1)*2;
            }
        }
        for (int i = 0; i < m; i++) {
            if(matrix[n-1][i]!='H')continue;
            int index=n-1;
            for (int j =n-2 ; j >=0 ; j--) {
                if(matrix[j][i]!='H'){
                    break;
                }
                index--;
            }
            calories+=(n-index)*2;
        }
        System.out.print(points+" "+calories);
    }
}
