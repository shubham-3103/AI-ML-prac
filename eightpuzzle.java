import java.util.HashMap;

class eightpuzzle{

	static void print(int [][] initialarr){
		for(int i=0;i<3;i++){
			for(int j = 0; j<3;j++){
				System.out.print(initialarr[i][j]+" ");
			}
			System.out.println();
		}
	}


	public static void main (String[] args) throws java.lang.Exception
	{
		//1 up
		//2 down
		//3 left
		//4 right
		int [][] initialarr = {
			{1,2,3},
			{4,7,0},
			{6,5,8}
		};
		int [][] finalarr = {
			{1,2,3},
			{4,5,6},
			{7,8,0}
		};

		int depth = 0;
		HashMap <Integer,Integer> map = new HashMap<>();
		int misplaced = 0;
		int firstpos, secondpos;
		for(int i=0;i<initialarr[0].length;i++){
			for(int j=0;j<finalarr[0].length;j++){
				if(initialarr[i][j]!=finalarr[i][j])  //misplaced tiles
					misplaced++;
			}
		}
		for(int i=0;i<initialarr[0].length;i++){
			for(int j=0;j<finalarr[0].length;j++){
				if(initialarr[i][j]==0){
					firstpos=i;
					secondpos=j;
				}
			}
		}
	}
}
