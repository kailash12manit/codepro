package Questions_previous_Test;

import java.util.Scanner;

class Data{
	int startDate; // Start date
	int endDate; // End date
	
	Data(int startDate,int endDate){
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
}

public class To_Assign_Projects_to_a_New_Developer {
	
	int N; // Number of projects
	Data[] project_info; // Project Infomation
	int sol;
	boolean[] date_chk;
	
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		
		// Input of number of projects
		N = sc.nextInt();
		project_info = new Data[N];
		date_chk= new boolean[301];
		// Input of project information
		for(int i=0;i<N;i++){
			int st = sc.nextInt();
			int et = sc.nextInt();
			project_info[i] =  new Data(st,et);
		}
		
		sc.close();
	}
	
	public static void main(String []argv) {
		To_Assign_Projects_to_a_New_Developer m=new To_Assign_Projects_to_a_New_Developer();
		m.inputData();		// Calling of input function
		m.sol=m.solve(0,0);
		System.out.println(m.sol); // Output of result
	}

	private int solve(int n, int count) {
		// TODO Auto-generated method stub
		int max=count,res;
		if(n>=N) {
			return max;
		}
		for(int i=n;i<N;i++){
			if(checkDate(project_info[i].startDate,project_info[i].endDate)) {
				setcheckDate(project_info[i].startDate,project_info[i].endDate);
				res=solve(i+1,count+1);
				if(max<res) {
					max=res;
				}
				ResetcheckDate(project_info[i].startDate,project_info[i].endDate);
			}
		}
		return max;
	}

	private void ResetcheckDate(int startDate, int endDate) {
		// TODO Auto-generated method stub
		for(int i=startDate;i<=endDate;i++) {
			date_chk[i]=false;
		}
	}

	private void setcheckDate(int startDate, int endDate) {
		// TODO Auto-generated method stub
		for(int i=startDate;i<=endDate;i++) {
			date_chk[i]=true ;
		}
	}

	private boolean checkDate(int startDate, int endDate) {
		// TODO Auto-generated method stub
		for(int i=startDate;i<=endDate;i++) {
			if(date_chk[i]==true) {
				return false;
			}
		}
		return true;
	}
}