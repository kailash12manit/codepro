package Questions_previous_Test;

import java.util.Scanner;

public class NewProductLaunchEvent {
	int []a;				//	An array that stores the numbers on the back of the card
	int N;					//	Number of Cards
	int M;					//	New Product Capacity

	public int solve() {
		int sol=0;
		//	Correct the error in the code below
		for (int i = 0; i < N - 3; i++){
			for (int j = i + 1; j < N - 2; j++){
				for (int k = j + 1; k < N - 1; k++){
					for (int l = k + 1; l < N ; l++){
						if (a[i] + a[j] + a[k] + a[l] == M) {
                            sol++;
                        }
					}
				}
			}
		}
		return sol;
	}

	public void inputData()  {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();			//	Number of Cards	
		M = sc.nextInt();			//	New Product Capacity
		a = new int [N+1];		

		for(int i=0 ; i<N ; i++){
			a[i] = sc.nextInt();		//	Score on the back of the card
		}
	}

	public static void main(String[] args){
		NewProductLaunchEvent m = new NewProductLaunchEvent();

		m.inputData();					//	Input function
		int sol = m.solve();			//	Problem solution 
		System.out.println(sol);	//	Output right answer
	}
}