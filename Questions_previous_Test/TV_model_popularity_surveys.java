package Questions_previous_Test;

import java.util.Scanner;

public class TV_model_popularity_surveys {
	int N, M;
	int[] TV;    // Sold TV model
	int[] sold;  // Sales q’ty(quantity)
	int[] score; // Popularity
	int[] freq;
	
	void inputData() {
		int i;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		freq=new int[M];
		
		TV = new int[100000 + 10];
		sold = new int[100000 + 10];
		score = new int[100000 + 10];
		
		for(i = 0; i < N; i++) {
			TV[i] = sc.nextInt();
		}
		
		sc.close();
	}
	
	int Solve() {
		cal_freq();
		int i, max;
		
		// Count the sales q’ty of each model
		for (i = 0; i < N; i++) {
			sold[TV[i]]++;
		}

		// Improve the popularity based on the existing method (popularity = sales q’ty)
		for (i = 1; i <= M; i++) {
			score[i] = sold[i]*freq[i-1];
		}
		
		// Find the model number with the highest popularity.
		max = 1;
		for (i = 2; i <= M; i++) {
			if(score[i] > score[max]) max = i;
		}
		
		return max;
	}
	
	private void cal_freq() {
		// TODO Auto-generated method stub
		int i=0;
		for (i = 0; i < N-1; i++) {
			int len=1;
			for(int j=i+1;j<N;j++) {
				if(TV[i]==TV[j]) {
					len++;
				}else {
					break;
				}
			}
			if(len> freq[TV[i]-1]) {
				freq[TV[i]-1]=len;
			}
		}
		/*
		for(int kk:freq) {
			System.out.print(kk+" ");
		}
		System.out.println();
		*/
	}

	public static void main(String[] args) {
		TV_model_popularity_surveys m = new TV_model_popularity_surveys();
		
		m.inputData();					//	Input function
		int sol = m.Solve();			//	Problem solving
		
		System.out.println(sol);		//	Answer output

	}
}