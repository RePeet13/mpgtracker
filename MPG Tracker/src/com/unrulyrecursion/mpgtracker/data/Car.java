package com.unrulyrecursion.mpgtracker.data;

import java.util.LinkedHashMap;


public class Car {

	private String carName;
	private String make;
	private String model;
	private String color;
	private final static String defColor = "DEEP_RED";
	private int id;
	private int year;
	
	public Car(int id, String carName, String color, String make, String model, int year) {

		this.id = id; // TODO This should receive some special attention (if its -1, or null, etc)
		
		this.carName = carName;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;

	}
	
	public Car(String carName, String color, String make, String model, int year) {
		this(-1, carName, color, make, model, year);
	}
	
	public Car(String carName, String color) {
		this(carName, color, "none", "none", -1);
	}
	
	public Car(String carName) {
		this(carName, defColor);
	}

	
	/* Getters and Setters */
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	/* Consider keeping these
	public LinkedHashMap<String, String> getProps() {
		return props;
	}

	public void setProps(LinkedHashMap<String, String> props) {
		this.props = props;
	}
	*/

}
