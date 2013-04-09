package com.unrulyrecursion.mpgtracker.data;

import java.util.LinkedHashMap;

import android.util.Log;


public class Car {

	private String carName;
	private String make;
	private String model;
	private String color;
	private final static String defColor = "DEEP_RED";
	private long id;
	private int totalMileage;
	private int year;
	
	public Car(long id, String carName, String color, String make, String model, int year, int totalMileage) {

		Log.i("Car", "Entering Car Constructor");
		
		if (id != -1) {
			this.id = id;
		}
		
		this.carName = carName;
		this.color = color;
		this.make = make;
		this.model = model;
		this.year = year;
		this.totalMileage = totalMileage;
		
		Log.d("Car", "Made car: " + toString());

	}
	
	public Car(String carName, String color, String make, String model, int year, int totalMileage) {
		this(-1, carName, color, make, model, year, totalMileage);
	}
	
	public Car(String carName, String color, String make, String model, int year) {
		this(carName, color, make, model, year, 0);
	}
	
	public Car(String carName, String color) {
		this(carName, color, "none", "none", -1);
	}
	
	public Car(String carName) {
		this(carName, defColor);
	}
	
	/* Overrides for important methods (toString() and equals()) */
	
	@Override
	public boolean equals(Object other) {
		Car outside;
		try {
			outside = (Car) other;
		}
		catch (Exception e) {
			Log.w("Car - Equals", "Tried to cast object passed in to Car - Failed");
			return false;
		}
		
		/* Check everything but color, which doesn't matter */
		
		if (carName.compareToIgnoreCase(outside.getCarName()) < 0) {
			Log.i("Car - Equals", "Car Names do not match");
			return false;
		}
		
		if (make.compareToIgnoreCase(outside.getMake()) < 0) {
			Log.i("Car - Equals", "Car Make does not match");
			return false;
		}
		
		if (model.compareToIgnoreCase(outside.getModel()) < 0) {
			Log.i("Car - Equals", "Car Model does not match");
			return false;
		}
		
		if (year != outside.getYear()) {
			Log.i("Car - Equals", "Car Year does not match");
			return false;
		}
		
		if (id != outside.getId()) {
			Log.i("Car - Equals", "Car ID does not match");
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append(carName);
		out.append(": (id - " + id + ") ");
		out.append(Integer.toString(year) + " " + make + " " + model + " (color: " + color + ")" + " Total Mileage: " + totalMileage);
		return out.toString();
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

	public long getId() {
		return id;
	}

	public boolean setId(long id) {
		if (this.id < 0) {
			this.id = id;
			return true;
		} else {
			Log.d("Car", carName + ": Attempted to set id when already set"); // TODO consider another method to allow setting set id's
			return false;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTotalMileage() {
		return totalMileage;
	}

	public void setTotalMileage(int totalMileage) {
		this.totalMileage = totalMileage;
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
