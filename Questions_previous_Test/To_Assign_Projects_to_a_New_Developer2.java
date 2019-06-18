package Questions_previous_Test;

import java.util.Scanner;
import java.util.*;
import java.lang.*;

class Data implements Comparable<Data>{
	int startDate; // Start date
	int endDate; // End date

	Data(int startDate,int endDate){
		this.startDate = startDate;
		this.endDate = endDate;
	}	
	public int compareTo(Data d){
		return this.endDate-d.endDate;
	}	
}
public class To_Assign_Projects_to_a_New_Developer2 {
	int n; // Number of projects
	Data[] project_info; // Project Infomation

	public void inputData() {
		Scanner sc = new Scanner(System.in);		
		// Input of number of projects
		n = sc.nextInt();
		project_info = new Data[n];
		// Input of project information
		for(int i=0;i<n;i++){
			int st = sc.nextInt();
			int et = sc.nextInt();
			project_info[i] =  new Data(st,et);
		}		
		sc.close();
	}

	public static void main(String []argv) {
		int sol=0;	
		To_Assign_Projects_to_a_New_Developer2 m=new To_Assign_Projects_to_a_New_Developer2();
		m.inputData();
		sol=m.solve();
		System.out.println(sol); // Output of result
	}
	public int solve() {
		int count=1;
		Arrays.sort(project_info);		
		/*
		for(int i=0;i<n;i++){
			System.out.println(project_info[i].startDate +" "+project_info[i].endDate);
		}
		*/		
		int endtime=project_info[0].endDate;
		for(int i=1;i<n;i++){
			if(	project_info[i].startDate >endtime){
				count++;
				endtime=project_info[i].endDate;
			}
		}
		return count;
	}
}


