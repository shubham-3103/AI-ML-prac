package ML;
class sol{

    static int remainder = 0;
    static int quotient = 0;

    static void hcf(int dividend, int divisor, int remainder){
        
        if(remainder==0 || divisor<0)
            System.out.println(divisor); 
        hcf(divisor, dividend-divisor, dividend%divisor);
    }

    public static void main(String[] args) {
        // int [] arr = {20,2,3,1,4,4,2};
        
        // for (int i = 1; i<=Math.pow(2, i); i *= 2) {
        //     int start = i-1;
        //     for(int j = start; j < start + i; j++) {
        //         System.out.print(arr[j]+" ");
        //     }
        //     System.out.println();
        // }

        int dividend = 320;
        int divisor = 132;
        hcf(dividend, divisor, dividend%divisor);

    }
}