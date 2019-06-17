package Questions_previous_Test;

import java.util.Arrays;
import java.util.Scanner;

public class Development_of_Self_driving_Algorithm {
	static int H;//Height
	static int W;//Width
	static char matrix[][] = new char[500][500];//map
	
	public void input_data()  {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();  
		W = sc.nextInt();  
		for (int i = 0; i < H; i++) {
			matrix[i] = sc.next().toCharArray();
		}
	}

	public static void main(String[] args){
		Development_of_Self_driving_Algorithm m = new Development_of_Self_driving_Algorithm();
		m.input_data();
		
		int[][] visited = new int[H][W];
		
		int min_dist = findShortestPath_3(matrix,visited, 0, 0, H-1, W-1,Integer.MAX_VALUE, 0);

		if(min_dist != Integer.MAX_VALUE) {
			System.out.println(min_dist);
		}
		else {
			System.out.println("-1");
		}
	}

	public static int findShortestPath(char mat[][], int visited[][],
			int i, int j, int x, int y, int min_dist, int dist) {
		
		if(!isValid(i,j)) {
			return 0;
		}
		if(!isSafe(mat, visited, i , j)) {
			return 0;
		}
		
		if (i == x && j == y) {
			return Integer.min(dist, min_dist);
		}
				
		visited[i][j] = 1;

		int Row_Nbr[]= {1,0,-1,0};
		int Col_Nbr[]= {0,1,0,-1};
		
		for(int kk=0;kk<4;kk++) {
			min_dist = findShortestPath(mat, visited, i+Row_Nbr[kk] , j+Col_Nbr[kk], x, y, min_dist, dist + 1);
		}
		
		visited[i][j] = 0;

		return min_dist;
	}

	private static boolean isSafe(char mat[][], int visited[][], int x, int y) {
		return !(mat[x][y] == 'X' || visited[x][y] != 0);
	}
	
	private static boolean isValid(int x, int y) {
		return (x < H && y < W && x >= 0 && y >= 0);
	}
	
	
	public static int findShortestPath_2(char mat[][], int visited[][],
			int i, int j, int x, int y, int min_dist, int dist) {
		
		if (i == x && j == y) {
			return Integer.min(dist, min_dist);
		}
		
		if(!(x < H && y < W && x >= 0 && y >= 0)) {
			return  Integer.min(dist-1, min_dist);
		}
		
		if((mat[x][y] == 'X' || visited[x][y] != 0)) {
			Integer.min(dist-1, min_dist);
		}
					
		visited[i][j] = 1;
		
		if (isValid(i + 1, j) && isSafe(mat, visited, i + 1, j)) {
			min_dist = findShortestPath_2(mat, visited, i + 1, j, x, y, min_dist, dist + 1);
		}

		if (isValid(i, j + 1) && isSafe(mat, visited, i, j + 1)) {
			min_dist = findShortestPath_2(mat, visited, i, j + 1, x, y,min_dist, dist + 1);
		}

		if (isValid(i - 1, j) && isSafe(mat, visited, i - 1, j)) {
			min_dist = findShortestPath_2(mat, visited, i - 1, j, x, y, min_dist, dist + 1);
		}

		if (isValid(i, j - 1) && isSafe(mat, visited, i, j - 1)) {
			min_dist = findShortestPath_2(mat, visited, i, j - 1, x, y, min_dist, dist + 1);
		}
				
		visited[i][j] = 0;

		return min_dist;
	}
	
	public static int findShortestPath_3(char mat[][], int visited[][],
		int i, int j, int x, int y, int min_dist, int dist) {
		
		if (i == x && j == y) {
			return Integer.min(dist, min_dist);
		}
			
		visited[i][j] = 1;
		
        int Row_Nbr[]= {1,0,-1,0};
		int Col_Nbr[]= {0,1,0,-1};
		
		for(int kk=0;kk<4;kk++) {
            if (isValid(i+Row_Nbr[kk], j+Col_Nbr[kk]) && isSafe(mat, visited, i+Row_Nbr[kk], j+Col_Nbr[kk])) {
                min_dist = Integer.min(min_dist,findShortestPath(mat, visited, i+Row_Nbr[kk] , j+Col_Nbr[kk], x, y, min_dist, dist + 1));
            }
		}
               
		visited[i][j] = 0;

		return min_dist;
	}

}
