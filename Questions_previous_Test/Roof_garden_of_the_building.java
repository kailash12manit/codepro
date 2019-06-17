package Questions_previous_Test;

import java.util.Scanner;

public class Roof_garden_of_the_building {

	static int N;//Number of buildings
	static int H[] = new int [80010];//Height of buildings

	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			H[i] = sc.nextInt();
		}
	}

	public static void main(String[] args){
		Roof_garden_of_the_building m = new Roof_garden_of_the_building();
		long ans = 0;

		m.inputData();				//	Input function

		//	Write the code
		for(int i=0;i<N-1;i++){
			 int temp=H[i];
			 for(int j=i+1;j<N;j++){
				  if(H[j]<H[i]){
						ans++;
					}else{
						break;
					}
			 }
			//System.out.println(ans);
		}			
		System.out.println(ans);	//	Output right answer
	}
}
