import java.util.Scanner;
class magicsquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of row/column of square magic square:");
        int size = sc.nextInt();
        int arr [][] = new int[size][size];
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                arr[i][j]=0;
            }
        }
        int num = 1;
        int row=0;
        int column = (int) Math.floor(size/2);
        arr[row][column]=num;

        while(num<size*size){
            num = num + 1;
            row = row - 1;
            column = column + 1;
            if(row==-1)
                row=size-1;
            if(column==size)
                column=0;

            if(arr[row][column]==0){
            arr[row][column] = num;
            }
            else{
                // column = column;
                row = row + 1;
                if(column==size)
                    column=0;
                arr[row][column] = num;
            }
        }

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
