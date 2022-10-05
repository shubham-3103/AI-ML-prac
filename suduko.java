public class suduko{
    static int N =9;
    static boolean solve(int [][] matrix,int row, int column){
        
            if(row==N-1 && column==N)
                return true;
            if(column==N){
                row++;
                column = 0;;
            }
            if (matrix[row][column] != 0)
                return solve(matrix, row, column + 1);
            for(int num = 1; num<10; num++){
                if (isSafe(matrix, row, column, num)) {
                    matrix[row][column] = num;
                    if (solve(matrix, row, column + 1))
                        return true;
                }
                matrix[row][column] = 0;
            }
            return false;
        }
    
        static boolean isSafe(int[][] matrix, int row, int column,
                              int num)
        {
            for (int x = 0; x <= 8; x++)
                if (matrix[row][x] == num)
                    return false;
            for (int x = 0; x <= 8; x++)
                if (matrix[x][column] == num)
                    return false;
            int startRow = row - row % 3;
            int startCol = column - column % 3;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (matrix[i + startRow][j + startCol] == num)
                        return false;
     
            return true;
        }
    public static void main(String[] args) {
        int matrix[][] = { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        if (solve(matrix, 0, 0))
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        else
            System.out.println("No Solution exists");
    }
    
}