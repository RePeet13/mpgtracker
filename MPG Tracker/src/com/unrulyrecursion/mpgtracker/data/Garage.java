package com.unrulyrecursion.mpgtracker.data;

import java.util.ArrayList;
import java.util.List;

import com.unrulyrecursion.mpgtracker.test.CarTestData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.unrulyrecursion.mpgtracker.data.DBContract;

/**
 * This class will act as a singleton for interacting with 
 * the database, as well as holding the database's reference.
 * 
 * @author Taylor
 *
 */
public class Garage {
	
	private SQLiteDatabase db;
	private MPGTrackerDBHelper dbh;
	private List<Car> carList;
	private Car[] carArray;
	public Boolean ready, arrayClean, listClean;

	public Garage(Context context) {
		
		ready = false;
		arrayClean = false; // TODO implement this later in the app as well
		listClean = false; // TODO implement this later in the app as well
		
		carList = new ArrayList<Car>();
		
		dbh = new MPGTrackerDBHelper(context);
		open();
		
		/* For Testing, Try this */
		//TODO Take out this section
		Log.d("Garage", "Adding initial data");
		CarTestData carTestData = new CarTestData();
		List<Car> carTestList = carTestData.carTestList;
		
		int i = carTestList.size();
		carArray = new Car[i];
		i = 0;
		
		for(Car car : carTestList) {
			carList.add(car);
			carArray[i] = car;
			Log.d("Garage - Test List", "i: " + i);
			i++;
			/* Add to database */
			addCar(car);
		}
		
		close();
		
		Log.d("Garage", "Finishing up constructor");
		ready = true;
	}
	
	public void open() throws SQLException {
		Log.d("Garage", "Opening Database");
		db = dbh.getWritableDatabase();
	}
	
	public void close() {
		Log.d("Garage", "Closing Database");
		db.close();
	}
	
	public void addCar(Car car) { //TODO add return value based on success
		//TODO check against current carlist to see if its already in it, later regen carArray
		
		ContentValues cv = new ContentValues();
		Log.d("Garage - Add Car", "Adding Car: " + car.getCarName());
		cv.put(DBContract.COLUMN_NAME_CAR_NAME, car.getCarName());
		
//		Log.i("Garage", "Car ID: " + car.getId()); // for updateCar (no Id yet)
//		cv.put(DBContract.COLUMN_ID, car.getId());
		
		Log.i("Garage - Add Car", "Car Color: " + car.getColor());
		cv.put(DBContract.Cars.COLUMN_NAME_COLOR, car.getColor());
		
		Log.i("Garage - Add Car", "Car Make: " + car.getMake());
		cv.put(DBContract.Cars.COLUMN_NAME_MAKE, car.getMake());
		
		Log.i("Garage - Add Car", "Car Model: " + car.getModel());
		cv.put(DBContract.Cars.COLUMN_NAME_MODEL, car.getModel());
		
		Log.i("Garage - Add Car", "Car Year: " + car.getYear());
		cv.put(DBContract.Cars.COLUMN_NAME_YEAR, car.getYear());
		
		long carId;
		carId = dbh.addCar(db, cv);
		Log.i("Garage - Add Car", "Car ID: " + carId);
		car.setId(carId);
	}
	

	public void updateCar(Car car) { //TODO add return value based on success
		//TODO error checking for duplicates?
		
		ContentValues cv = new ContentValues();
		Log.d("Garage", "Updating Car: " + car.getCarName());
		cv.put(DBContract.COLUMN_NAME_CAR_NAME, car.getCarName());
		
		Log.i("Garage", "Car ID: " + car.getId());
		cv.put(DBContract.COLUMN_ID, car.getId());
		
		Log.i("Garage", "Car Color: " + car.getColor());
		cv.put(DBContract.Cars.COLUMN_NAME_COLOR, car.getColor());
		
		Log.i("Garage", "Car Make: " + car.getMake());
		cv.put(DBContract.Cars.COLUMN_NAME_MAKE, car.getMake());
		
		Log.i("Garage", "Car Model: " + car.getModel());
		cv.put(DBContract.Cars.COLUMN_NAME_MODEL, car.getModel());
		
		Log.i("Garage", "Car Year: " + car.getYear());
		cv.put(DBContract.Cars.COLUMN_NAME_YEAR, car.getYear());
		
		// TODO Could add dialog that says updated or something
		int rows = dbh.updateCar(db, cv);
		Log.i("Garage", "Rows Affected: " + rows);
	}
	
	public List<Car> getAllCars() {
		Log.d("Garage", "Getting all Cars");
		Cursor cursor = dbh.getAllCars(db);
		
		List<Car> cars = new ArrayList<Car>();
		
		while (!cursor.isAfterLast()) {
		      Car car = cursorToCar(cursor);
		      cars.add(car);
		      cursor.moveToNext();
		}
		
		// Can't forget this!
		cursor.close();
		return cars;
	}
	
	public Car getCar(Long id) {
		Log.d("Garage", "Getting a car: " + Long.toString(id));
		
		Cursor cursor = dbh.getACar(db, id);
		Car car = cursorToCar(cursor);
		
		// Can't forget this!
		cursor.close();
		return car;
	}
	
	public Car cursorToCar(Cursor cursor) {
		Log.d("Garage", "Cursor to Car");

		long carId = cursor.getLong(0);
		Log.i("Garage", "Car ID: " + carId);
		
		String carName = cursor.getString(1);
		Log.i("Garage", "Car Name: " + carName);
		
		String color = cursor.getString(2);
		Log.i("Garage", "Car Color: " + color);
		
		String make = cursor.getString(3);
		Log.i("Garage", "Car Make: " + make);
		
		String model = cursor.getString(4);
		Log.i("Garage", "Car Model: " + model);

		int year = cursor.getInt(5);
		Log.i("Garage", "Car Year: " + year);
		
		long totalMileage = cursor.getLong(6);
		Log.i("Garage", "Car Mileage: " + totalMileage);
		
		Car car = new Car(carId, carName, color, make, model, year, totalMileage);
		Log.i("Garage", "Car Made");
		
		return car;
	}
	
	public Car[] getCarArray() {
		// TODO dirty checking based on whether stuff has been written to the database or not
		Log.i("Garage", "getCarArray");
		if (arrayClean) {
			return carArray;
		}
		
		// TODO implement this
		return carArray;
	}
	
	public List<Car> getCarList() {
		// TODO dirty checking based on whether stuff has been written to the database or not
		Log.i("Garage", "getCarList");
		if (listClean) {
			return carList;
		}
		return getAllCars(); // TODO not a good way to do this...
	}
}
