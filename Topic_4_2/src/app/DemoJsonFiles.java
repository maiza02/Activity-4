package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The DemoJsonFiles class demonstrates the use of JSON serialization and deserialization to save and read Car objects
 * from a file. It includes methods for saving Car objects to a file and reading Car objects from a file.
 */
public class DemoJsonFiles {

	
	/**
     * The main method of the DemoJsonFiles class.
     *
     * @param args The command-line arguments passed to the program.
     * @throws IOException If an I/O error occurs while reading or writing the file.
     */
	public static void main(String[] args) throws IOException{
		
		// Create some Cars using an array 
		// Discussion: why is a list better to use then an array?
		Car[] cars = new Car[5]; 
		cars[0] = new Car(2018, "Ford", "Mustang", 0, 1.5d); 
		cars[1] = new Car(2018, "Chevy", "Blazer", 1000, 1.5d); 
		cars[2] = new Car(2019, "Toyota", "Camery", 2000, 1.5d); 
		cars[3] = new Car(2018, "Toyota", "Avalon", 90000, 2.5d); 
		cars[4] = new Car(2010, "GMC", "Silverado", 10000, 3.5d);
		
		for (int x = 0; x < 4; ++x) {
		    // Write Car to a file as JSON 
		    saveToFile("out.json", cars[x], true); 
		}
		
		// Read the Cars from the file and print out 
		ArrayList<Car>carsList = readFromFile("out.json"); 
		for(Car car : carsList) {
			
			String text = Integer.toString(car.getYear()) + "," + car.getMake() + "," + car.getModel() + "," + Integer.toString(car.getOdometer()) + "," + Double.toString(car.getEngineLiters());
			System.out.println(text); 
		}	
	}
	
	
	 /**
     * Saves a Car object to a file as JSON.
     *
     * @param filename The name of the file to save to.
     * @param car      The Car object to save.
     * @param append   True to append to the file, false to overwrite.
     * @throws IOException If an I/O error occurs while reading or writing the file.
     */
	private static void saveToFile(String filename, Car car, boolean append) {
		
		PrintWriter pw; 
		try { 
		   
			// Create a file File to write 
			// Discussion: How and why would a BufferedWriter improve this code?
			File file = new File(filename); 
			FileWriter fw = new FileWriter(file, append); 
			pw = new PrintWriter(fw); 
			
			// Write Car as JSON
			ObjectMapper objectMapper = new ObjectMapper(); 
			String json = objectMapper.writeValueAsString(car); 
			pw.println(json); 
			
			// Cleanup 
			// Discussion: what is wrong with this code?
			pw.close(); 
		}
		catch (IOException e) {
			
			// Print exception 
			// Discussion what is wrong with this code? 
			e.printStackTrace(); 
		}
		
	}
	
	 /**
     * Reads Car objects from a file and returns them as a list.
     *
     * @param filename The name of the file to read from.
     * @return The list of Car objects read from the file.
     */
	private static ArrayList<Car> readFromFile(String filename) {
		
		ArrayList<Car> cars = new ArrayList<Car>(); 
		try {
			
			// Open the file File to read 
			// Discussion: How and why would a bufferedReader improve this code? 
			File file = new File(filename); 
			Scanner s = new Scanner(file); 
			
			// Create list of Cars by reading JSON file 
			while(s.hasNext()) {
				
				// Read a string of JSON and convert to a Car 
				String json = s.nextLine(); 
				ObjectMapper objectMapper = new ObjectMapper(); 
				Car car = objectMapper.readValue(json, Car.class);
				cars.add(car); 
			}
			// Cleanup 
			// Discussion: what is wrong with this code?
			s.close(); 
		}
		catch (IOException e) {
			
			//Print exception 
			// Discussion: what is wrong with this code?
			e.printStackTrace(); 
		}
		// Return the list of Cars
		return cars; 
		
	}

}
