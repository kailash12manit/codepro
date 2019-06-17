package Questions_previous_Test;
import java.util.Scanner;
public class researcher_health_promotion_project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("k");
		researcher_health_promotion_project m = new researcher_health_promotion_project();
		m.inputData();				//	Input function
		int sol = m.solve();			//	Problem solving
		System.out.println(sol);	//	Answer output
    }
	
	int N;		//	# of stairs
	int[] P;	//	P[i]: score earned when stepping on stair i
	int[] total;

	public int solve() {
		total = new int [N+1];
		total[0]=0;
		total[1]=P[0];
		total[2]=P[1]+P[0];
				
		for(int i=3;i<=N;i++) {
			total[i]=total[i-2]+P[i-1];
			if( total[i] < (total[i-3]+P[i-2]+ P[i-1]) ) {
				total[i] = (total[i-3]+P[i-2]+ P[i-1]);				
			}			
			System.out.println(total[i]);
		}		
		
		return total[N];
	}
	
	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();			// # of stairs
		P = new int [N+1];		

		for(int i=0 ; i<N ; i++){
			P[i] = sc.nextInt();	//	Score for each stair
		}
	}	
}