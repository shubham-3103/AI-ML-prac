import java.util.Scanner;
public class knighttour {
    static void print(int [][] chess){
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void knighttour(int [][] chess, int row, int column, int move){
        if(row<0 || column<0 || row>=chess.length || column>=chess.length || chess[row][column]>0){
            return;
        }else if(move==chess.length*chess.length){
            chess[row][column]=move;
            print(chess);
            // chess[row][column]=0;
            return;
        }

        chess[row][column]=move;
        knighttour(chess, row-2, column+1, move+1);
        knighttour(chess, row-2, column-1, move+1);
        knighttour(chess, row-1, column+2, move+1);
        knighttour(chess, row-1, column-2, move+1);
        knighttour(chess, row+1, column+2, move+1);
        knighttour(chess, row+1, column-2, move+1);
        knighttour(chess, row+2, column+1, move+1);
        knighttour(chess, row+2, column-1, move+1);
        chess[row][column]=0;

    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int r = 2;
        int c = 1;
        int [][] chess = new int[n][n];
        knighttour(chess, r, c, 0);
        print(chess);

        
    }
}
