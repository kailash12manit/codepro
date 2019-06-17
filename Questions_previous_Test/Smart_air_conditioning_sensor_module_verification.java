package Questions_previous_Test;

import java.util.Scanner;

public class Main {
	int N;				//	Number of commands
	int exit_flag = 0; 	// Variable 1 indicating the Power OFF standby state is in the Power OFF standby state
	int previous=0;
	 
	Scanner s = new Scanner(System.in);
	// Functions that return incoming commands
	int Get_Command()
	{
		return s.nextInt();
	}
	
	void inputData() {
			N = s.nextInt();
	}
	
	void solve() {
		int data =0;
		

		for(int i=0; i<N; i++)
		{
			data = Get_Command();			
			if(data !=6 ){
				exit_flag = 0;			 
			}
			if(data==6 && previous==5){
				System.out.println("Power OFF");
				break;
			}
			switch(data) 
			{   
				default:
					System.out.println("Unknown Error");
					System.out.println("Error Code " + data);
					break;
				case 9:
					System.out.println("Error Code " + data);
					break;
				case 4:	
					System.out.println("Sensing Mode Init");
					System.out.println("Temp. Sensing Mode ON");
					System.out.println("Humidity Sensing Mode ON");
					System.out.println("Air Sensing Mode ON");
					break;
					
				case 3:	
					System.out.println("Sensing Mode Init");
					System.out.println("Humidity Sensing Mode ON");
					System.out.println("Air Sensing Mode ON");
				break;
				case 2:	
					System.out.println("Sensing Mode Init");
					System.out.println("Air Sensing Mode ON");
					break;
				case 5:
					System.out.println("Wait Power OFF");
					exit_flag = 1;
					break;
				case 6:
					if(exit_flag ==1)
					{
						System.out.println("Power OFF");
					}
					else
					{
						System.out.println("No Operation");							
					}
					break;
				case 1:
					System.out.println("Power ON");
					break;					
				
			}
			previous=data;
		}
		System.out.println("Finish");
		s.close();
	}

	public static void main(String[] args) {
		Main m = new Main();

		m.inputData();				//	Input function
		m.solve();					//	Output answer
	}
}
