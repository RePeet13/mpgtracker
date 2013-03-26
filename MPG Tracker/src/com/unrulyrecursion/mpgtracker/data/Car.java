package com.unrulyrecursion.mpgtracker.data;

import java.util.LinkedHashMap;


public class Car {

	private String carName;
	private String make;
	private String model;
	private String color;
	private int id;
	private int year;
	private LinkedHashMap<String, String> props;
	
	public Car(String carName, int id, String make, String model, int year, String color) {
		
		this.carName = carName;
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		
		props = new LinkedHashMap<String, String>();
		props.put("name", new String(carName));
		props.put("id", new String(Integer.toString(id)));
		props.put("make", new String(make));
		props.put("model", new String(model));
		props.put("year", new String(Integer.toString(year)));
		props.put("color", new String(color));
	}
	
	public Car(String carName, String id, String color) {
		props = new LinkedHashMap<String, String>();
		props.put("name", new String(carName));
		props.put("id", new String(id));
		props.put("color", new String(color));
	}
	
	public Car(String carName, String id) {
		props = new LinkedHashMap<String, String>();
		props.put("name", new String(carName));
		props.put("id", new String(id));
	}


	
	public LinkedHashMap<String, String> getProps() {
		return props;
	}

	public void setProps(LinkedHashMap<String, String> props) {
		this.props = props;
	}

	public String getCarName() {
		return props.get("name");
	}

	public void setCarName(String carName) {
		props.put("name", new String(carName));
	}
	
	public String getColor() {
		return props.get("color");
	}

	public void setColor(String color) {
		// TODO check color against allowed colors?
		props.put("color", new String(color));
	}

	public String getId() {
		return props.get("id");
	}
	
	public String getMake() {
		return props.get("make");
	}

	public void setMake(String make) {
		props.put("make", new String(make));
	}

	public String getModel() {
		return props.get("model");
	}

	public void setModel(String model) {
		props.put("model", new String(model));
	}

	public String getYear() {
		return props.get("year");
	}

	public void setYear(int year) {
		props.put("year", new String(Integer.toString(year)));
	}
}
