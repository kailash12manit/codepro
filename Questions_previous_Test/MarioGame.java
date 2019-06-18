package Questions_previous_Test;
import java.util.Scanner;

public class MarioGame {
	int N;//Number of mushrooms	
	int arr[] = new int[150000 + 10];//Mushroom value
	public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
	}
	public static void main(String[] args){
		MarioGame m = new MarioGame();
		int ans = -1;
		m.inputData();				//	Input function
		ans=m.solve();
		System.out.println(ans);	//	Output answer
	}
	private int solve() {
		// TODO Auto-generated method stub
		int sum=0;
		int increase=1;
		for(int i=0;i<N;i++){
			if(increase==1) {
				if(arr[i]<arr[i+1]){
					continue;
				}
				else{
					increase=0;
					System.out.println(arr[i]);
					sum+=arr[i];
				}
			}
			else if(increase==0){
				if(arr[i]>arr[i+1]){
					continue;
				}
				else{
					increase=1;
					System.out.println(arr[i]);
					sum-=arr[i];
				}
			}
		}
		return sum;
	}
}