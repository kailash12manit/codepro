package Questions_previous_Test;

import java.util.Scanner;

public class Euclidean_algorithm {
	// Functions to create
	public static int GCD(int m, int n)	{
		    if(n==0) {
		    	return m;
		    }
		    return GCD(n,m%n);
		   			
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			// Input part
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			// Substitute a large number to the variable m
			if (m < n)
			{
				int temp = m; m = n; n = temp;
			}

			int sol = GCD(m,n);

			System.out.println(sol);

		}

}
