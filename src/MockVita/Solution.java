
import java.util.*;
public class Solution {
    static class Pair{
        int val;
        char c;
        Pair(int val,char c){
            this.val=val;
            this.c=c;
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String [][] board=new String[10][10];
        // for(int i=0;i<10;i++){
        //     for(int j=0;j<10;j++){
        //         board[i][j]=sc.next();
        //     }
        // }

        for(int i=0;i<10;i++){
            String temp=sc.nextLine();
            board[i]=temp.split(" ");
        }

        String die_input=sc.nextLine();
        String[] inputArr=die_input.split(" ");

        int[] dieInput=new int[inputArr.length];
        for(int i=0;i<dieInput.length;i++){
            dieInput[i]=Integer.parseInt(inputArr[i]);
        }
        // for(int i=0;i<10;i++){
        //     for(int j=0;j<10;j++){
        //         System.out.print(board[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println(Arrays.toString(dieInput));

        HashMap<Integer,Pair> map=new HashMap<>();
        int snake=0;
        int ladder=0;
        board[0][0]="100";
        board[9][0]="1";

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                char c = board[i][j].charAt(0);
                if(c=='S'||c=='L'){
                    String s=new String(board[i][j]);
                    int len=s.length();

                    int toGo=0;
                    if(s.equals("S(Start)")){

                    }else if(s.equals("L(End)")){
                        toGo=100;
                    }else{
                        // if(len)
                        switch (len){
                            case 4:
                                toGo=(int)s.charAt(len-2)-'0';
//                                System.out.println(toGo);
                                break;
                            case 5:
                                int t=(int)s.charAt(len-2)-'0';
                                toGo=(int)s.charAt(len-3)-'0';
                                toGo*=10;
                                toGo+=t;
                                break;
                            case 6:
                                toGo=100;
                                break;
                        }
                    }
                    int currentPos=0;
                    if(j>0&&j<9){
                        int left=Integer.parseInt(board[i][j-1]);
                        int right=Integer.parseInt(board[i][j+1]);
                        if(right<left){
                            currentPos=right+1;
                        }else{
                            currentPos=left+1;
                        }
                    }
                    if(j==0){
                        int left=Integer.parseInt(board[i][j+1]);
                        int right=Integer.parseInt(board[i][j+2]);
                        if(left<right){
                            currentPos=left-1;
                        }else{
                            currentPos=left+1;
                        }
                    }
                    if(j==9){
                        int left=Integer.parseInt(board[i][j-2]);
                        int right=Integer.parseInt(board[i][j-1]);
                        if(left<right){
                            currentPos=right+1;
                        }else{
                            currentPos=right-1;
                        }
                    }
                    if(c=='S'){
                        map.put(currentPos,new Pair(toGo,'S'));
                    }else{
                        map.put(currentPos,new Pair(toGo,'L'));
                    }

                }
            }
        }
        int player=0;
        for(int i=0;i<dieInput.length;i++){
            int currentDicePosition=dieInput[i];
            player+=currentDicePosition;
             if(player==100){
                 System.out.print("Possible"+" "+snake+" "+ladder);
                 return;
             }
            if(map.containsKey(player)){
                Pair jump=map.get(player);
                int change=jump.val;
                char incOrDec=jump.c;
                if(incOrDec=='S'){
                    snake++;
                }
                else {
                    ladder++;
                }
                player=change;
            }
            if(player==100){
                System.out.print("Possible"+" "+snake+" "+ladder);
                return;
            }
        }
        System.out.print("Not Possible"+" "+snake+" "+ladder+" "+player);
    }
}