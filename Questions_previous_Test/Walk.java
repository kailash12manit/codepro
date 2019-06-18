package Questions_previous_Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Walk {

	int N;//Number of employees
	int T;//Walking Time (in minutes)
	int P[] = new int[100000 + 10];//Starting location of emplyees
	int S[] = new int[100000 + 10];//Walking speed of emplyees (per minute)

	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
			S[i] = sc.nextInt();
		}
	}

	public static void main(String[] args){
		Walk m = new Walk();
		int ans = -1;
		m.inputData();				//	Input function
		ans=m.solve();
		System.out.println(ans);	//	Output right answer
	}

	private int solve() {
		// TODO Auto-generated method stub
		ArrayList<Integer>al = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			al.add(P[i]+S[i]*T);			
		}
		
		int count=1;
		int max=al.get(N-1);
		for(int i=N-1;i>0;i--) {
			if(max==al.get(i-1)) {
				continue;
			}
			if(max > al.get(i-1)) {
				count++;
				max=al.get(i-1);
			}
			if(max < al.get(i-1)) {
				continue;
			}
		}
		return count;
	}	
}
