package Questions_previous_Test;

import java.util.ArrayList;

public class Walk2 {
	public static void main(String[] args) {
		
		int arr[]= {2,8,3,3,4,9,7,11,9,9};
		System.out.println(solve(arr));
	}
	
	private static int solve(int []arr) {
		// TODO Auto-generated method stub
		ArrayList<Integer>al = new ArrayList<Integer>();
		int N=arr.length;
		
		for(int i=0;i<N;i++) {
			al.add(arr[i]);			
		}
		
		int count=1;
		int max=al.get(N-1);
		System.out.println("max:"+max);
		for(int i=N-1;i>0;i--) {
			if(max==al.get(i-1)) {
				continue;
			}
			if(max > al.get(i-1)) {
				count++;
				max=al.get(i-1);
				System.out.println("max:"+max);
			}
			if(max < al.get(i-1)) {
				continue;
			}
		}
		return count;
	}	
}
