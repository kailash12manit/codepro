package Questions_previous_Test;

public class EarlyFireSuppressionSystemTest {

	public static void main(String[] args) {
		System.out.println("EarlyFireSuppressionSystemTest");
	}
}
/*
import dcs.ControlSystem;
import dcs.FireSensor;
import dcs.Position;
import dcs.TestUtils;
// The test target is implemented as shown annotation below. 
// If necessary, write the test input and test code in the LedTest class, referring to the annotation below. 
// NOTE: The code under test is already included in the build, do not use and release the following annotations.
/**
 * Position.java
 * (y, x) Data structure representing location information 
 *
public class Position {
	public Position(int y, int x) { // NOTE: Be aware that it is in (y,x) order
		...
	}
	public int x = 0;
	public int y = 0;
	... (Appropriate equals are implemented)
}
...
/**
 * FireSensor.java
 *  Fire detection sensor interface
 *
public interface FireSensor {
	**
	 * Returns the position value of the sensor that detected the current fire
	 * @return Position type coordinates.
	 *
	Position getSensorPosition();
}
...
*/

/**
 * ControlSystem.java
 * Drone control system (test target)
 * 
public class ControlSystem {
	...
	private FireSensor sensor;
	public ControlSystem(FireSensor sensor) {
		this.sensor = sensor;
		...
		// Initialize Drone position
	}
	
	/**
	 * A function to obtain the position of the fire and to calculate the position with the current drone to select the closest dron (Test target)
	 * Save the position of the selected drones for the next position calculation. (Assuming that the selected drones move to the corresponding coordinates)
	 * @return The number of the drones closest to where the fire occurred. 1 or 2
	 *
	public int selectDrone() {
		Position dpos1 = drone[0].getPosition();
		Position dpos2 = drone[1].getPosition();
		Position issued = sensor.getSensorPosition();
		
		int dx = issued.x - currentDrone1.x;
		int dy = issued.y - currentDrone1.y;
		int dist1 = (dx * dx) + (dy * dy);
		dx = issued.x - currentDrone2.x;
		dy = issued.y - currentDrone2.y;
		int dist2 = (dx * dx) + (dy * dy);
		
		...
		// Save position of selected drones
		...
		
		return (dist2>=dist1) ? 1 : 2;
	}
}
*/
/*
class test_class implements FireSensor{
		Position pos;
		test_class(int x,int y){
			pos=new Position(x,y);
		}
		
		public Position getSensorPosition() {
			// TODO Auto-generated method stub
			return pos;
		}	
	}
public class DroneControlSystemTest {
	
	// Problem 1.	
	// Format of answer array - When the fire detection sensor number is detected in the given order, the number of the drones to be dispatched is described in order
	// For example, if the drones are dispatched in the order of 1, 1, 2, 2, 1, record as {1, 1, 2, 2, 1}
	public int[] expectedResult_1_1 = {2,2,2,1,1};  //TODO: Problem (1-1) Sensor detection in order of 1, 2, 5, 3, 7
	public int[] expectedResult_1_2 = {1,2,2,1,1};  //TODO: Problem (1-2) Sensor detection in order of 7, 6, 5, 4, 3
	
	// Problem 2.
	// Design TC for each problem
	// ormat of TC array : Describe the number of fire sensors that should be detected in order for the drones to visit the site in the given order
	// Sensors must be detected in 1, 2, 3, 4 and 5 in order for Drone to visit the site in 2, 2, 1, 2, and 2 so write {1, 2, 3, 4, 5} 
	public int[] testInput_example = {1, 2, 3, 4, 5};
	
	public int[] testInput_2_1 = {7,3,4,2,1}; //TODO: Problem (2-1) 1, 1, 1, 1, 1 => When only 1 drone is dispatched
	public int[] testInput_2_2 = {5,6,4,2,1 }; //TODO: Problem (2-2) 2, 2, 2, 2, 2 => When only 2 drone is dispatched
	public int[] testInput_2_3 = {7,3,6,5,2}; //TODO: Problem (2-3) 1, 1, 2, 2, 1 => When only 1, 2 drone are dispatched simultaneously
	public int[] testInput_2_4 = {3,5,1,7,2}; //TODO: Problem (2-4) 1, 2, 2, 1, 2 => When only 1, 2 drone are dispatched simultaneously
	
	//  Problem 3. Write test code
	
	public void test_3_1() {
		// TODO: Item 3-1. 
		// A test code to reproduce the situation in which the fire position is detected in the order of sensors 1, 7, 2, 3, 5
		
		test_class obj = new test_class(1,10);		
		
		ControlSystem dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
		obj = new test_class(8,2);
		dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
		obj = new test_class(2,6);
		dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
		obj = new test_class(4,1);
		dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
		obj = new test_class(6,10);
		dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
	}
	public void test_3_2() {
		// TODO: Item 3-2. 
		// A test code to reproduce the situation in which the fire position is detected in the order of sensors 3, 1, 4, 6, 2
		test_class obj = new test_class(4,1);		
		ControlSystem dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
		obj = new test_class(1,10);
		dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
		obj = new test_class(5,5);
		dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
		obj = new test_class(7,8);
		dcs = new ControlSystem(obj);
		dcs.selectDrone();
		
		obj = new test_class(2,6);
		dcs = new ControlSystem(obj);
		dcs.selectDrone();	
		
	}
	
	
	// If you have code you want to execute for reference, you can write and use it in main () below.
	// The code of the main function is not related to marking
	public static void main(String[] args) {
		DroneControlSystemTest test = new DroneControlSystemTest();
		TestUtils.printTestResult("example", test.testInput_example);
		TestUtils.printTestResult("2-1", test.testInput_2_1);
		TestUtils.printTestResult("2-2", test.testInput_2_2);
		TestUtils.printTestResult("2-3", test.testInput_2_3);
		TestUtils.printTestResult("2-4", test.testInput_2_4);
	}
*/
