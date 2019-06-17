package Questions_previous_Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
3
041
253
620
*/
public class Road_construction {
	static int H;
	static int W;
	static char matrix[][] = new char[500][500];//map
	
	public void input_data()  {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();  
		W=H;
		for (int i = 0; i <H; i++) {
			matrix[i] = sc.next().toCharArray();
		}
	}
	public static void main(String[] args) {
		Road_construction m = new Road_construction();
		m.input_data();
		int visited[][]= new int[H][H];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				visited[i][j]=0;
			}
		}
		
		int min_dist = findShortestPath(visited, 0, 0, H-1, W-1,Integer.MAX_VALUE, 0);

		if(min_dist != Integer.MAX_VALUE) {
			System.out.println(min_dist);
		}
		else {
			System.out.println("-1");
		}
	}	
	
	//Method returns minimum step to reach target position  
	public static int findShortestPath(int visited[][],int i, int j, int x, int y, int min_dist, int dist) {
	
		if (i == x && j == y) {
			return Integer.min(dist, min_dist);
		}
		
		if(!(x < H && y < W && x >= 0 && y >= 0)) {
			return  Integer.min(dist-1, min_dist);
		}
		
		if((visited[x][y] != 0)) {
			Integer.min(dist-1, min_dist);
		}
					
		visited[i][j] = 1;
		
		if (isValid(i + 1, j) && isSafe( visited, i + 1, j)) {
			min_dist = findShortestPath(visited, i + 1, j, x, y, min_dist, dist + (matrix[i][j]-'0'));
		}

		if (isValid(i, j + 1) && isSafe(visited, i, j + 1)) {
			min_dist = findShortestPath(visited, i, j + 1, x, y,min_dist, dist + (matrix[i][j]-'0'));
		}

		if (isValid(i - 1, j) && isSafe(visited, i - 1, j)) {
			min_dist = findShortestPath(visited, i - 1, j, x, y, min_dist, dist + (matrix[i][j]-'0'));
		}

		if (isValid(i, j - 1) && isSafe(visited, i, j - 1)) {
			min_dist = findShortestPath(visited, i, j - 1, x, y, min_dist, dist + (matrix[i][j]-'0'));
		}
				
		visited[i][j] = 0;

		return min_dist;
		
	} 
	
	private static boolean isSafe(int visited[][], int x, int y) {
		return !(visited[x][y] != 0);
	}
	
	private static boolean isValid(int x, int y) {
		return (x < H && y < W && x >= 0 && y >= 0);
	}
}