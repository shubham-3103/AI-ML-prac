/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class eightpuzzle
{   static int count = 0;

    static int minimum(int a, int b){
        if(a%3==0 || b%3==0)
		    return count;
		else{
		    if(a>b)
		        a=Math.abs(a-b);
		    else if(b>a)
		        b=Math.abs(a-b);
		    count++;
            minimum(a, b);
	    }
	    return count;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    count=0;
		    System.out.println(minimum(a,b));
		}
	}
}
