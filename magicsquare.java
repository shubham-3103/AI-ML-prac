public class magicsquare {
    public static void main(String[] args) {
        int size = 3;
        int arr [][] = new int[size][size];
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                arr[i][j]=0;
            }
        }
        int num = 1;
        int row=0;
        int column = 1;
        arr[row][column]=num;

        while(num<3*3){
            num = num + 1;
            row = row - 1;
            column = column + 1;
            if(row==-1)
                row=2;
            if(column==3)
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


        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
