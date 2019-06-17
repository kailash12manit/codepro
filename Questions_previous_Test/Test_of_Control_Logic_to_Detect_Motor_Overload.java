package Questions_previous_Test;


interface CurrentSensor {
	int getCurrentLoad();
}

class Motor {

	private CurrentSensor sensor;
	private int count = 0;

	public Motor(CurrentSensor sensor) {
		this.sensor = sensor;
	}

	public boolean detectOverload() {
		int load = sensor.getCurrentLoad();

		if (load > 2000)
			count += 5;
		else if (load > 1800)
			count += 3;
		else if (load > 1500)
			count += 2;
		else
			count = 0;

		return (count > 10) ? true : false;
	}
}

class test_class implements CurrentSensor{

	int load;	
	@Override
	public int getCurrentLoad() {
		// TODO Auto-generated method stub
		return load;
	}	
	
}


public class Test_of_Control_Logic_to_Detect_Motor_Overload {

	public static void main(String[] args) {
		
	}
	
	
	public int[][] testParameters = {
			{ 1600, 2010, 1900, 1501, },
			// TODO: Items 1-1, 1-2, 1-3. Add a test input.
			{ 500, 2100, 1600, 0, 1850, 1900, 1950 },
	    { 500, 2100, 1600, 0, 1900, 1600, 2100 },
			{ 500, 2100, 1600, 0, 1900, 1900, 2100 }
	};
	/*/
	 
	 	{ 1600, 2010, 1900, 1501, },
			{ 1600,2100,600,1820,1890,1900},
			{ 2100,600,1600,1900,1650,1850},	
			{ 1650,600,2150,1850,1950},
			
	 */

	    
	    
	
	public void test_2_1() {
		// TODO: Item 2-1. 
		// Write the code that reproduces the case of detecting the current loads in the sequence of 1900, 1600, 0, and 2100.
				
		test_class obj=new test_class();
		Motor m = new Motor(obj);
		obj.load=1900;
		m.detectOverload();
		
		obj.load=1600;
		m.detectOverload();
		
		obj.load=0;
		m.detectOverload();
		
		obj.load=2100;
		m.detectOverload();
		
		
		/*
		Motor motor = new Motor(fakeSensor);
        fakeLoad = 1900;
		motor.detectOverload();
		
		fakeLoad = 1600;
		motor.detectOverload();
		
		fakeLoad = 0;
		motor.detectOverload();
		
		fakeLoad = 2100;
		motor.detectOverload();
		*/
	}

	public void test_2_2() {
		// TODO: Item 2-2.
		// Write the code that reproduces the case of detecting the current loads in the sequence of 0, 1900, 1600, 2100, and 1600.

		test_class obj=new test_class();
		Motor m = new Motor(obj);
		obj.load=0;
		m.detectOverload();
		
		obj.load=1900;
		m.detectOverload();
		
		obj.load=1600;
		m.detectOverload();
		
		obj.load=2100;
		m.detectOverload();
		
		
		obj.load=1600;
		m.detectOverload();
		
	}
	
}
