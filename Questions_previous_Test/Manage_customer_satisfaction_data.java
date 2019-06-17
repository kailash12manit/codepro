package Questions_previous_Test;
import java.util.Scanner;

public class Manage_customer_satisfaction_data {
	
	int M;		// Number of repeated recognition 
	char[] S;	// Survey string
	
	void inputData() {

		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		S = (sc.next() + "\0").toCharArray();	
		
		sc.close();
	}

	void Solve() {
		int i=1;			// Indicate any character in the string S
		int len;		// Length of string S
		char r_char=S[0];	// Repeated Characters
		int r_cnt = 1;		// Number of repetitions
		String ans=""+r_char;
		len=S.length;
		
		while(i<len-1) {
			
			if(S[i]!=r_char) {
				if(r_cnt>=M) {
						// print short
					ans+=""+S[i]+"("+r_cnt+")";
					r_cnt=0;
				}
				else {
						// print long
					while(r_cnt-->=1) {
						ans+=""+S[i];
					}	
					r_cnt=0;
				}
				r_char=S[i];
				i++;
			}
			else{
				r_cnt++;
				i++;
			}	
			System.out.println("ans:"+ans);
		}
		
		System.out.println(ans);
		
		
		// Code implementation and output of results
		
	}

	public static void main(String[] args) {
		Manage_customer_satisfaction_data m = new Manage_customer_satisfaction_data();
		
		m.inputData();		//	Input function
		m.Solve();			//	Problem solution 
	}
}

