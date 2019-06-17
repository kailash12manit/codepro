package Questions_previous_Test;

import java.util.Scanner;

public class Fine_Dust_Measurement_System {

		public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int[][] a = new int[N][N]; // Matrix to store the fine dust change of each day (row) and each hour (column)

		// Section to input the fine dust change for each of N hours and N days
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = s.nextInt();
			}
		}

		s.close();

		int maxRow=0;	// Variable to store the day (row) of the largest sum of fine dust changes
		int minCol=0;	// Variable to store the hour (column) of the smallest sum of fine dust changes
		long sum=0;		// Variable to store the sum of fine dust changes
		long minSum=999999999;	// Variable to store the smallest sum of fine dust changes

		// Section to calculate which time slot (column) has the smallest sum of fine dust changes
		for (int j = 0; j < N; j++) {
            sum=0;
			// Calculate the sum of fine dust changes of jth hour (column) during N days
			for (int i = 0; i < N; i++) {
				sum += a[i][j];
			}

			// Section to calculate the time slot (column) that has the smallest sum of fine dust change of each time slot (column)
			if (sum < minSum) {
				minSum = sum;
				minCol = j;
			}
		}
        sum=0;
		long maxSum=-999999999;	// Variable to store the largest sum of fine dust changes

		// Section to calculate which day (row) has the largest sum of fine dust changes
		for (int i = 0; i < N; i++) {
            sum=0;
			// Calculate the sum of fine dust changes for N hours on the ith day (row)
			for (int j = 0; j < N; j++){
				sum += a[i][j];
			}

			// Section to obtain the day (row) that has the largest sum of fine dust changes on each day (row)
			if (sum > maxSum) {
				maxSum = sum;
				maxRow = i;
			}
		}

		System.out.println((maxRow+1) + " " + (minCol+1));
	}
}