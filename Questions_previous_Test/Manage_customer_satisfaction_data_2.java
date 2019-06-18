package Questions_previous_Test;

import java.util.Scanner;

public class Manage_customer_satisfaction_data_2 {

	int M;		// Number of repeated recognition 
	char[] S;	// Survey string
	
	void inputData() {

		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		S = (sc.next() + "\0").toCharArray();	
		
		sc.close();
	}

	void Solve() {
		int i=0;			// Indicate any character in the string S
		int len=S.length;		// Length of string S
		char r_char;	// Repeated Characters
		int r_cnt=1;		// Number of repetitions
		for(i=0;i<len-1;i++){
            if(S[i]==S[i+1]){
                r_cnt++;
            }
            else{
                System.out.print(S[i]);
                if(r_cnt>=M){
					System.out.print("("+r_cnt+")");
				}
				else{
                    while(r_cnt-->1){
					 System.out.print(S[i]);
					}
				}
		        r_cnt=1;                
            }    
		}	
		
	}
	public static void main(String[] args) {
		Manage_customer_satisfaction_data_2 m = new Manage_customer_satisfaction_data_2();
		
		m.inputData();		//	Input function
		m.Solve();			//	Problem solution 
	}
}

