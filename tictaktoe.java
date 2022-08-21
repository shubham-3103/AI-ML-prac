import java.util.Scanner;

public class tictaktoe {
    static String [] arr = new String[9];
    static int symbol = 0;
    static void logic(int value, int count){
        
        if(arr[value]=="X" || arr[value]=="O"){
            System.out.println("User already place his sign on it, please try again");
            symbol--;
        }
        else{
            if(count%2==0){
                arr[value]="X";
            }
            else{
                arr[value]="O";
            }
        }
        
        System.out.println("| "+arr[0]+" | "+arr[1]+" | "+arr[2]+" |");
        System.out.println("|---|---|---|");
        System.out.println("| "+arr[3]+" | "+arr[4]+" | "+arr[5]+" |");
        System.out.println("|---|---|---|");
        System.out.println("| "+arr[6]+" | "+arr[7]+" | "+arr[8]+" |");
        System.out.println();
        if(count==8){
            System.out.println("done");
        }
    }
    static boolean flag = true;
    static boolean traverse(){
        int flagcount = 0;
        for(int i=0;i<9;i++){
            if(arr[i]=="X" || arr[i]=="O")
                // flag = false;
                flagcount++;
                if(flagcount==9){
                    flag = false;
                    break;}
            // else if(arr[i]!="X" || arr[i]!="O")
            //     flag = true;
            //     break;
        }
        return flag;
    }
    static void winner(){
        for(int i = 0;i<3;i++){
            if(arr[0+i]=="X" && arr[3+i]=="X" && arr[6+i]=="X" || arr[0+i]=="O" && arr[3+i]=="O" && arr[6+i]=="O"){
                System.out.println(arr[0+i]+" is WINNER");
                flag = false;
                break;
            }
        }
        for(int i = 0;i<7;i+=3){
            if(arr[0+i]=="X" && arr[1+i]=="X" && arr[2+i]=="X" || arr[0+i]=="O" && arr[1+i]=="O" && arr[2+i]=="O"){
                System.out.println(arr[0+i]+" is WINNER");
                flag = false;
                break;
            }
        }
        if(arr[0]=="X" && arr[4]=="X" && arr[8]=="X" || arr[0]=="O" && arr[4]=="O" && arr[8]=="O"){
            System.out.println(arr[0]+" is WINNER");
            flag = false;
        }
        if(arr[2]=="X" && arr[4]=="X" && arr[6]=="X" || arr[2]=="O" && arr[4]=="O" && arr[6]=="O"){
            System.out.println(arr[2]+" is WINNER");
            flag = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++){
            arr[i]= String.valueOf(i) ;
        }
        System.out.println("| "+arr[0]+" | "+arr[1]+" | "+arr[2]+" |");
        System.out.println("|---|---|---|");
        System.out.println("| "+arr[3]+" | "+arr[4]+" | "+arr[5]+" |");
        System.out.println("|---|---|---|");
        System.out.println("| "+arr[6]+" | "+arr[7]+" | "+arr[8]+" |");
         
        while(traverse()){
            if(symbol%2==0){
                System.out.print("Enter the number you want to place X in it: ");
            }else{
                System.out.print("Enter the number you want to place O in it: ");
            }
            logic(sc.nextInt(),symbol);
            symbol++;
            winner();
        }
    }
}
