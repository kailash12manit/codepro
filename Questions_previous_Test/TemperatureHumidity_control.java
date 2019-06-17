package Questions_previous_Test;

import java.util.Scanner;

public class TemperatureHumidity_control {

	int N;

	// Temperature range variable
	int min_temp;
	int max_temp;

	// Humidity range variable
	int min_humidity;
	int max_humidity;

	// Temperature/humidity change
	int []Temperature_diff;
	int []Humidity_diff;

	// Temperature/humidity range excess flag
	boolean flag_control_temp=false;
	boolean flag_control_humidity=false;
	
	// Initial temperature/humidity value
	static final int INIT_TEMPERATURE = 20;
	static final int INIT_HUMIDITY = 50;
	
	int cur_temp;	// Current temperature
	int cur_humidity;	// Current humidity value
	
	boolean Check_Temp_and_Control(int diff)
	{
		cur_temp += diff;
	
		if ((cur_temp > max_temp) || (cur_temp < min_temp))	// If out of range
		{
			flag_control_temp = true;
            cur_temp=INIT_TEMPERATURE;
            //System.out.println("cur_temp:"+cur_temp);
			return true;
		}
		//System.out.println("cur_temp:"+cur_temp);
		return false;
	}
	
	boolean Check_Humidity_and_Control(int diff)
	{
		cur_humidity += diff;
	
		if ((cur_humidity > max_humidity) || (cur_humidity < min_humidity))		// If out of range
		{
			flag_control_humidity = true;
            cur_humidity = INIT_HUMIDITY;
           // System.out.println("cur_humidity:"+cur_humidity);
			return true;
		}
		//System.out.println("cur_humidity:"+cur_humidity);
		return false;
	}
	
	void Reset_Flag()
	{
		//  flag initialization
		if (flag_control_humidity) flag_control_humidity = false;
		if (flag_control_temp) flag_control_temp = false;
	}
	

	void Control_Temp_and_Humidity()
	{
		int i;
	
		for (i = 1; i <= N; i++)
		{   
			boolean ret_temp;
			boolean ret_hudity;
			ret_temp=Check_Temp_and_Control(Temperature_diff[i]);
			ret_hudity=Check_Humidity_and_Control(Humidity_diff[i]);
			
			// Temperature/humidity range check and control
			if (ret_temp || ret_hudity) {
				
                if (flag_control_temp && flag_control_humidity) {
					System.out.println(3);
				}
				else if (flag_control_temp) {
					System.out.println(1);
				}
				else if (flag_control_humidity){
					System.out.println(2);
				}
	
				Reset_Flag();
		    }
			else System.out.println(0);
		}
	}

	void Input_Data()
	{
		int i;
		
		Scanner sc = new Scanner(System.in);
		
		// Total operation time, humidity/temperature range inputs
		N = sc.nextInt();
		min_temp = sc.nextInt(); 
		max_temp = sc.nextInt();
		min_humidity = sc.nextInt();
		max_humidity = sc.nextInt();
	
		Temperature_diff = new int[N+1];
		Humidity_diff = new int[N+1];
		
		// Temperature change input
		for (i = 1; i <= N; i++)
		{
			Temperature_diff[i] = sc.nextInt();
		}
		
		// Humidity change input
		for (i = 1; i <= N; i++)
		{
			Humidity_diff[i] = sc.nextInt();
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		TemperatureHumidity_control m = new TemperatureHumidity_control();
		
		m.cur_temp = INIT_TEMPERATURE;
		m.cur_humidity = INIT_HUMIDITY;
		
		m.Input_Data(); // Input data

		m.Control_Temp_and_Humidity(); // Temperature/humidity control function
	}
}
