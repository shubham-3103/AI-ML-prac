import java.util.*;
public class nqueens {

    static void print(int [][] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean iscorrect(int[][] arr, int row, int column){
        for(int i=0;i<column;i++){
            if(arr[row][i]==1)
                return false;
        }
        for(int i=row, j=column;i>=0&&j>=0; i--, j--){
            if(arr[i][j]==1)
                return false;
        }
        for(int i=row, j=column; j>=0&&i<arr.length-1; i++,j--){
            if(arr[i][j]==1)
                return false;
        }
        return true;
    }
    static boolean logic(int[][]arr,int row){
        if(row>=arr.length-1) return true;
        for(int column=0;column<arr.length-1;column++){
            if(iscorrect(arr, column, row)){
                arr[column][row]=1;
                if(logic(arr, row+1)==true)
                    return true;
                arr[column][row]=0;
            }
        }
        return false;
    }
    static boolean solvearr(int n){
        int [][] arr = new int[n][n];
        Arrays.fill(arr,0);
        if(logic(arr, 0)==false){
            
            System.out.print("No solution");
            return false;
        }
        print(arr);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t;i++){
            int n = sc.nextInt();
            solvearr(n);
        }
    }
}
