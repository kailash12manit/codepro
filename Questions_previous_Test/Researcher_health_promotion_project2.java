package Questions_previous_Test;

import java.util.Scanner;

public class Researcher_health_promotion_project2 {
	int N;				//	# of stairs
	int[] P;				//	P[i]: score earned when stepping on stair i

	public int solve() {
		int sol=0;

		//	TODO : Write your codes.
		int arr[]= new int[N+1];
		arr[0]=0;
		arr[1]=P[0];
		arr[2]=P[1]+P[0];
		
		for(int i=3;i<=N;i++) {
			arr[i]=P[i-1]+arr[i-2];
			if(arr[i]<arr[i-3]+P[i-2]+P[i-1]) {
				arr[i]= ( arr[i-3]+P[i-2]+P[i-1]);
			}		
		}
		
		for(int kk:arr) {
			System.out.print(kk+" ");
		}
		System.out.println();
		sol=arr[N];
		
		return sol;
	}

	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();			// # of stairs
		P = new int [N+1];		

		for(int i=0 ; i<N ; i++){
			P[i] = sc.nextInt();	//	Score for each stair
		}
	}

	public static void main(String[] args){
		Researcher_health_promotion_project2 m = new Researcher_health_promotion_project2();

		m.inputData();				//	Input function
		int sol = m.solve();			//	Problem solving
		System.out.println(sol);	//	Answer output
	}
}
