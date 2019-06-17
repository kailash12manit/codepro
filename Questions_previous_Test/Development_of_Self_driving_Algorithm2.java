package Questions_previous_Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Development_of_Self_driving_Algorithm2 {
	static int H;//Height
	static int W;//Width
	static char matrix[][] = new char[500][500];//map
	
	static class cell  {  
		int x, y;  
		int dis;  
		public cell(int x, int y, int dis) { 
			this.x = x; 
			this.y = y; 
			this.dis = dis; 
		}
	}
	static boolean isInside_Valid(int x, int y)  {  
		if ( (x >= 0 && x < H && y >= 0 && y < W) && (matrix[x][y]=='.')) {  
			return true;  
		}
		return false;  
	}
	
	
	public void input_data()  {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();  
		W = sc.nextInt();  
		for (int i = 0; i <H; i++) {
			matrix[i] = sc.next().toCharArray();
		}
	}
	public static void main(String[] args) {
		Development_of_Self_driving_Algorithm2 m = new Development_of_Self_driving_Algorithm2();
		m.input_data();
		
		int knightPos[]= {0,0};
		int targetPos[]= {H-1,W-1};
		
		int min_dist = minStepToReachTarget(knightPos,targetPos);

		if(min_dist != Integer.MAX_VALUE) {
			System.out.println(min_dist);
		}
		else {
			System.out.println("-1");
		}
	}
	
	//Method returns minimum step to reach target position  
	static int minStepToReachTarget(int knightPos[], int targetPos[])  {  
		
		int dx[] = {1,0,-1,0};  
		int dy[] = {0,1,0,-1};
		
		Queue<cell> q = new LinkedList<cell>();  

		q.add(new cell(knightPos[0], knightPos[1], 0));  

		int x, y;  
		boolean visit[][] = new boolean[H][W];  

		for (int i = 0; i < H; i++)  
			for (int j = 0; j < W; j++)  
				visit[i][j] = false;  

		visit[knightPos[0]][knightPos[1]] = true;  

		while (!q.isEmpty()) {  
			cell t = q.remove();  			

			if (t.x == targetPos[0] && t.y == targetPos[1])  
				return t.dis;  

			for (int i = 0; i < 4; i++) {  
				x = t.x + dx[i];  
				y = t.y + dy[i];  

				if (isInside_Valid(x, y) && !visit[x][y]) {  
					visit[x][y] = true;  
					q.add(new cell(x, y, t.dis + 1));  
				}  
			}  
		}  
		return Integer.MAX_VALUE; 
	} 
}
