/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t=  sc.nextInt();
		for(int i=0; i<t;i++){
		    long n = sc.nextLong();
		    long arr[] = new long[n];
		    for(int j=0;j<n;j++)
		        arr[j]=sc.nextLong();
		    long count = (n*(n-1))/2;
		    
		    
		    System.out.println(count);
		    
		}
	}
}
