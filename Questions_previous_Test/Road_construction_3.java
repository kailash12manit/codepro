package Questions_previous_Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Road_construction_3 {
	int N;
	char originalmap[][];
	static int map[][];
	
	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map= new int [N][N];
		originalmap=new char [N][N];
		
		for (int i = 0; i < N; i++) {
			originalmap[i] = sc.next().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=originalmap[i][j]-'0';
			}
		}
	}	
	
	class cell { 
	    int x, y; 
	    int distance; 
	    public cell(int x, int y, int distance) { 
	        this.x=x;
	        this.y=y;
	        this.distance=distance;
	    }
	}
	
	public static void main(String[] args) {
		long ans = -1;
		Road_construction_3 m = new Road_construction_3();
		m.inputData();
		ans = m.shortest(map);
		System.out.println(ans);		
	}	
	
	public int shortest(int grid[][]) {
		int dist[][]=new int [N][N];
		for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N;j++) {
	            dist[i][j] = Integer.MAX_VALUE;
	        }
		}
  	    int dx[] = {-1, 0, 1, 0}; 
	    int dy[] = {0, 1, 0, -1}; 
	       
	    Queue<cell> st = new LinkedList<cell>();
	    
	    st.add(new cell(0,0,0));
	    dist[0][0] = grid[0][0]; 
	    
	    while (!st.isEmpty()) {
	    	cell curr = st.remove();  	
	    	for (int i = 0; i < 4; i++) { 
	             int x = curr.x + dx[i]; 
	             int y = curr.y + dy[i]; 
	   
	             if (!isInsideGrid(x, y)) {
	                 continue; 
	             }
	             if (dist[x][y] > dist[curr.x][curr.y] + grid[x][y]) { 
	                 cell prev = new cell(x, y, dist[x][y]);
			 if (dist[x][y] != Integer.MAX_VALUE) {
	                	st.remove(prev); 
	                 }	                 
	                 dist[x][y] = dist[curr.x][curr.y] + grid[x][y]; 
	                 st.add(prev); 
	             } 
	         } 
	    }
	    return dist[N-1][N-1];
	}
	
	public boolean isInsideGrid(int i,int j) {
		return (i < N && j < N && i >= 0 && j >= 0);
	}
}
