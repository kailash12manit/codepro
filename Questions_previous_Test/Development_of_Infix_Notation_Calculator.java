package Questions_previous_Test;

import java.util.Scanner;

public class Development_of_Infix_Notation_Calculator {

	public static final int MAX=50000;
	public static final int MOD=10000;
	
	int N;
	int stack[];
	int sp = 0;
	int a[];
	char op[];
	
	public Development_of_Infix_Notation_Calculator() {
		stack = new int[MAX];
		a = new int[MAX];
		op = new char[MAX];
	}
	
int push(int d) {
		//System.out.println("push"+d);
		if (sp >= MAX) return -1;
        sp=sp+1;
       	stack[sp] = d;
        return d;
	}
	
	int pop() {
       
		// ToDo : Complete Pop() function
		// Pop function returns data
		// If the stack is empty, return -1
        if (sp<0) {
            return -1;	
        }
        else{
            int temp= stack[sp];
            sp=sp-1;
           // System.out.println("pop:"+temp);
            return temp;
        }        
	}
	
	void inputData() {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		a[0] = s.nextInt();
		for (int i = 1; i < N; i++) {
			op[i] = s.next().charAt(0);
			a[i] = s.nextInt();
		}
		s.close();
	}
	
	int multiply(int a, int b) {
		return (a * b) % MOD;
	}
	
	long solve() {
		long sol = 0;
		push(a[0]);
		for (int i = 1; i < N; i++) {
			switch (op[i]) {
			case '*':
				push(multiply(pop(), a[i]));
				break;
			case '+':
				push(a[i]);
				break;
			}
			//System.out.println("I: "+i);
		}
		while(sp>=0){
          sol=(sol+pop())% MOD;   // for large input
          //System.out.println("sol:"+sol);
        }		
		return sol;
	}
	
	public static void main(String[] args) {
		Development_of_Infix_Notation_Calculator m = new Development_of_Infix_Notation_Calculator();
		m.inputData();
		System.out.println(m.solve());
	}
}
