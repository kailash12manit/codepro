package Questions_previous_Test;

import java.util.Scanner;

public class Factory_operation {
		int N;//Day
		int S;//Storage cost
		int C[] = new int [50010];//Price
		int Y[] = new int [50010];//Capacity

		public void inputData()  {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			S = sc.nextInt();
			for (int i = 0; i < N; i++) {
				C[i] = sc.nextInt();
				Y[i] = sc.nextInt();
			}
		}

		public static void main(String[] args){
			Factory_operation m = new Factory_operation();
			long ans = 0;

			m.inputData();				// Input function

			// TODO : Write your codes.
			ans= m.cal_amount_2();
			System.out.println(ans);	// Answer output
		}

		private long cal_amount() { // 70%
			// TODO Auto-generated method stub
			long res=C[0]*Y[0];
			
			for(int i=1;i<N;i++) {
				long aa=C[i]*Y[i];
				long bb=C[i-1]*Y[i]+ S*Y[i];
				
				if(aa > bb) {
					res+=bb;
				}
				else {
					res+=aa;
				}			
			}
			return res;
		}
		
		private long cal_amount_2() {  // 100% 
			// TODO Auto-generated method stub
			int i;
			long sum, price;
			price=C[0];
			sum=price*Y[0];
			for(i=1;i<N;i++) {
				if( price+S < C[i]) {
					price= price+S;
				}
				else {
					price=C[i];
				}
				sum=sum+price*Y[i];
			}
			return sum;	
		}		
}

/*

4 5
88 200
89 400
97 300
91 500

*/