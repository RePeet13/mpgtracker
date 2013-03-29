package com.unrulyrecursion.mpgtracker.data;

import java.util.List;//TODO Remove this when done testing
import com.unrulyrecursion.mpgtracker.test.CarTestData;//TODO Remove this when done testing

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MPGTrackerDBHelper extends SQLiteOpenHelper {
	
	/*
	 * If db schema changes, increment the database version
	 */
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "mpgtracker.db";
	
	/*
	 * Database helper variables
	 */
	
	private static final String COMMA_SEP = ",";
	private static final String PRIMARY_KEY_TEXT = "_id integer primary key autoincrement";
	
	// Type Vars
	private static final String TEXT_TYPE = " TEXT";
	private static final String INT_TYPE = " INTEGER";
	
	// Table Create Statements
	private static final String SQL_CREATE_TABLE_CARS = //TODO Test this. Logcat Debug Level
			"CREATE TABLE " + DBContract.Cars.TABLE_NAME + " (" 
			+ PRIMARY_KEY_TEXT + COMMA_SEP + 
			DBContract.COLUMN_NAME_CAR_NAME + TEXT_TYPE + COMMA_SEP + 
			DBContract.Cars.COLUMN_NAME_COLOR + TEXT_TYPE + COMMA_SEP + 
			DBContract.COLUMN_NAME_TOTAL_MILEAGE + INT_TYPE + COMMA_SEP + 
			DBContract.Cars.COLUMN_NAME_MAKE + TEXT_TYPE + COMMA_SEP + 
			DBContract.Cars.COLUMN_NAME_MODEL + TEXT_TYPE + COMMA_SEP + 
			DBContract.Cars.COLUMN_NAME_YEAR + INT_TYPE + " )";
	
	private static final String SQL_CREATE_TABLE_FILLUPS = //TODO Test this. Logcat Debug Level
			"CREATE TABLE " + DBContract.Fillups.TABLE_NAME + " (" + 
			PRIMARY_KEY_TEXT + COMMA_SEP + 
			DBContract.COLUMN_NAME_CAR_NAME + TEXT_TYPE + COMMA_SEP + 
			DBContract.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP + 
			DBContract.COLUMN_NAME_TOTAL_MILEAGE + INT_TYPE + COMMA_SEP + 
			DBContract.Fillups.COLUMN_NAME_TRIP_MILEAGE + INT_TYPE + COMMA_SEP + 
			DBContract.Fillups.COLUMN_NAME_GALLONS_IN + TEXT_TYPE + COMMA_SEP + 
			DBContract.Fillups.COLUMN_NAME_PRICE_PER_GALLON + TEXT_TYPE + " )";
	
	
	public MPGTrackerDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v("MPGTrackerDBHelper", "Creating SQLite Database");
		Log.d("MPGTrackerDBHelper", "Creating Cars Table");
		Log.i("MPGTrackerDBHelper", "SQL-" + SQL_CREATE_TABLE_CARS);
		db.execSQL(SQL_CREATE_TABLE_CARS);
		
		Log.d("MPGTrackerDBHelper", "Creating Fillups Table");
		Log.i("MPGTrackerDBHelper", "SQL-" + SQL_CREATE_TABLE_FILLUPS);
		db.execSQL(SQL_CREATE_TABLE_FILLUPS);
		
		
		/* For Testing, Try this */
		//TODO Take out this section
		CarTestData carTestData = new CarTestData();
		List<Car> carTestList = carTestData.carTestList;
		
		for(Car car : carTestList) {
			addCar(car);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.v("MPGTrackerDBHelper", "Upgrading SQLite Database");
		// TODO Auto-generated method stub
		
	}
	
	public void addCar(Car car) { //TODO add return value based on success
		//TODO error checking for duplicates
		
		
	}

}
