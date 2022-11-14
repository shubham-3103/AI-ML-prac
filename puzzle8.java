import java.io.*;
import java.util.*;

public class puzzle8
{
	public static int N = 3;
	public static class Node
	{
		Node parent;
		int mat[][] = new int[N][N];
		int x, y;
		int misplace;
		int manhatan;
	}
	
	public static void print(int mat[][]){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println("");
		}
	}
	// new node
	public static Node newNode(int mat[][], int x, int y,
							int newX, int newY, int manhatan,
							Node parent){
		Node node = new Node();
		node.parent = parent;
		
		node.mat = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				node.mat[i][j] = mat[i][j];
			}
		}
		//moving tile
		int temp = node.mat[x][y];
		node.mat[x][y] = node.mat[newX][newY];
		node.mat[newX][newY]=temp;
		
		node.misplace = Integer.MAX_VALUE; // no. of misplaced tile
		node.manhatan = manhatan; // no. of moves
		
		node.x = newX;// position of new blank tile
		node.y = newY;
		
		return node;
	}
	
	public static int row[] = { 1, 0, -1, 0 }; // b t l r
	public static int col[] = { 0, -1, 0, 1 };
	
	//number of misplaced tile
	public static int misplacedtiles(int initialMat[][], int finalMat[][])
	{
		int count = 0;
		for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			if (initialMat[i][j]!=0 && initialMat[i][j] != finalMat[i][j])
			count++;
		return count;
	}
	// is matrix correct
	public static int iscorrect(int x, int y)
	{
		return (x >= 0 && x < N && y >= 0 && y < N)?1:0;
	}
	//print from root to ans
	public static void printPath(Node root){
		if(root == null){
			return;
		}
		printPath(root.parent);
		print(root.mat);
		System.out.println("");
	}
	
	static class comp implements Comparator<Node>{
		@Override
		public int compare(Node lhs, Node rhs){
			return (lhs.misplace + lhs.manhatan) > (rhs.misplace+rhs.manhatan)?1:-1;
		}
	}
	public static void solve(int initialMat[][], int x,
							int y, int finalMat[][])
	{
	
		PriorityQueue<Node> pq = new PriorityQueue<>(new comp());
		
		Node root = newNode(initialMat, x, y, x, y, 0, null);
		root.misplace = misplacedtiles(initialMat,finalMat);
		
		pq.add(root);
		
		while(!pq.isEmpty())
		{
			Node min = pq.peek();
			pq.poll();
			if(min.misplace == 0){
				printPath(min);
				return;
			}
			for (int i = 0; i < 4; i++)
			{
				if (iscorrect(min.x + row[i], min.y + col[i])>0)
				{
					Node child = newNode(min.mat, min.x, min.y, min.x + row[i],min.y + col[i], min.manhatan + 1, min);
					child.misplace = misplacedtiles(child.mat, finalMat);
					pq.add(child);
				}
			}
		}
	}
	
	public static void main (String[] args)
	{
	
		int initialMat[][] =
		{
			{1, 2, 3},
			{5, 6, 0},
			{7, 8, 4}
		};
	
		int finalMat[][] =
		{
			{1, 2, 3},
			{5, 8, 6},
			{0, 7, 4}
		};
	
		int x = 1, y = 2;
	
		solve(initialMat, x, y, finalMat);
	}
}

