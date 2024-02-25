package app;

/**
 * The Car class represents a simple model for a car, including properties such as year, make, model, odometer,
 * and engine liters. It provides constructors, getter and setter methods for each property.
 */
public class Car {
	
	private int year;
	private String make;
	private String model;
	private int odometer; 
	private double engineLiters;
	

    /**
     * Default constructor for the Car class.
     */
	public Car() {
		
		year = 0;
		make = "";
		model = ""; 
		odometer = 0;
		engineLiters = 0; 
	}
	
	
	  /**
     * Parameterized constructor for the Car class.
     *
     * @param year         The year of the car.
     * @param make         The make of the car.
     * @param model        The model of the car.
     * @param odometer     The odometer reading of the car.
     * @param engineLiters The engine liters of the car.
     */
	public Car(int year, String make, String model, int odometer, double engineLiters) {
		
		super(); 
		this.year = year; 
		this.make = make; 
		this.model = model; 
		this.odometer = odometer; 
		this.engineLiters = engineLiters; 
	}
	
	
	public static void main(String[] args) {
	

	}

    // Getter and setter methods for each property

    /**
     * Getter for the year property.
     *
     * @return The year of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter for the year property.
     *
     * @param year The year of the car to set.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter for the make property.
     *
     * @return The make of the car.
     */
    public String getMake() {
        return make;
    }

    /**
     * Setter for the make property.
     *
     * @param make The make of the car to set.
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Getter for the model property.
     *
     * @return The model of the car.
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter for the model property.
     *
     * @param model The model of the car to set.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter for the odometer property.
     *
     * @return The odometer reading of the car.
     */
    public int getOdometer() {
        return odometer;
    }

    /**
     * Setter for the odometer property.
     *
     * @param odometer The odometer reading of the car to set.
     */
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    /**
     * Getter for the engineLiters property.
     *
     * @return The engine liters of the car.
     */
    public double getEngineLiters() {
        return engineLiters;
    }

    /**
     * Setter for the engineLiters property.
     *
     * @param engineLiters The engine liters of the car to set.
     */
    public void setEngineLiters(double engineLiters) {
        this.engineLiters = engineLiters;
    }
}
