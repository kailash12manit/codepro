package Questions_previous_Test;
import java.util.Scanner;


public class Optimization_of_Battery_Performance_of_Robot_Cleaner {
		int N; 				
		double M; 		
		int S[]; 			
		double T[];		
		int L[]; 			
		double P[];		

		public void inputData() {
			Scanner s = new Scanner(System.in);
			N = s.nextInt();
			M = s.nextDouble();
			S = new int [N+1];
			L = new int [N+1];
			T = new double [N+1];
			P = new double [N+1];
			for(int i=1;i<=N;i++){
				S[i] = s.nextInt();
				T[i] = s.nextDouble();
			}
			s.close();
		}

		public int CalABS(int a){
			if (a > 0) return a;
			return -a;
		}
		
		public double solve() {
			double Remain;		
			
			for (int i = 1; i <= N; i++) {
				L[i] = (int)(S[i] * T[i] + 0.5);
			}

			for (int i = 1; i <= N; i++) {
				P[i] = L[i] * (CalABS(S[i] - S[i - 1]) + 1) / 2.0;
			}

			Remain = M;
			for (int i = 1; i <= N; i++) {
				Remain -= P[i];
			}
			return Remain;
		}

		public static void main(String[] args) {
			Optimization_of_Battery_Performance_of_Robot_Cleaner m = new Optimization_of_Battery_Performance_of_Robot_Cleaner();

			m.inputData();				

			System.out.printf("%.1f\n", m.solve());	
		}
	}