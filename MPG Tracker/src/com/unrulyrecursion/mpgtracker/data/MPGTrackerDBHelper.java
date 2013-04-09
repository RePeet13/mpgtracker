package com.unrulyrecursion.mpgtracker.data;

import java.util.List;//TODO Remove this when done testing
import com.unrulyrecursion.mpgtracker.test.CarTestData;//TODO Remove this when done testing

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MPGTrackerDBHelper extends SQLiteOpenHelper {
	
	/*
	 * If db schema changes, increment the database version
	 * before doing that though, make sure to implement onUpgrade()
	 */
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "mpgtracker.db";
	
	/*
	 * Database helper variables
	 */
	private static final String PRIMARY_KEY_TEXT = " integer primary key autoincrement";
	private static final String COMMA_SEP = ", ";
	private static final String NOT_NULL = " NOT NULL";
	
	// Type Vars
	private static final String TEXT_TYPE = " TEXT";
	private static final String INT_TYPE = " INTEGER";
	
	// Table Array
	private static final String[] TABLE_NAMES = {DBContract.Cars.TABLE_NAME, DBContract.Fillups.TABLE_NAME};
	
	// Table Create Statements
	private static final String SQL_CREATE_TABLE_CARS = 
			"CREATE TABLE " + DBContract.Cars.TABLE_NAME + " (" + 
			DBContract.COLUMN_ID + PRIMARY_KEY_TEXT + COMMA_SEP + 
			DBContract.COLUMN_NAME_CAR_NAME + TEXT_TYPE + NOT_NULL + COMMA_SEP + 
			DBContract.Cars.COLUMN_NAME_COLOR + TEXT_TYPE + NOT_NULL + COMMA_SEP + 
			DBContract.COLUMN_NAME_TOTAL_MILEAGE + INT_TYPE + COMMA_SEP + 
			DBContract.Cars.COLUMN_NAME_MAKE + TEXT_TYPE + COMMA_SEP + 
			DBContract.Cars.COLUMN_NAME_MODEL + TEXT_TYPE + COMMA_SEP + 
			DBContract.Cars.COLUMN_NAME_YEAR + INT_TYPE + ")";
	
	private static final String SQL_CREATE_TABLE_FILLUPS = 
			"CREATE TABLE " + DBContract.Fillups.TABLE_NAME + " (" + 
			DBContract.COLUMN_ID + PRIMARY_KEY_TEXT + COMMA_SEP + 
			DBContract.COLUMN_NAME_CAR_NAME + TEXT_TYPE + NOT_NULL + COMMA_SEP + 
			DBContract.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP + 
			DBContract.COLUMN_NAME_TOTAL_MILEAGE + INT_TYPE + COMMA_SEP + 
			DBContract.Fillups.COLUMN_NAME_TRIP_MILEAGE + INT_TYPE + COMMA_SEP + 
			DBContract.Fillups.COLUMN_NAME_GALLONS_IN + TEXT_TYPE + COMMA_SEP + 
			DBContract.Fillups.COLUMN_NAME_PRICE_PER_GALLON + TEXT_TYPE + ")";
	
	// Drop Tables Statement - Update this if adding new Tables
	public static final String SQL_DROP_TABLES = "DROP TABLE IF EXISTS ";
	
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
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.v("MPGTrackerDBHelper", "Upgrading SQLite Database");
		// implement this before updating version number
		
	}
	
	public long addCar(SQLiteDatabase db, ContentValues car) { //TODO add return value based on success
		//TODO error checking for duplicates?
//		Log.d("MPGTrackerDBHelper", "Adding Car: " + car.getCarName()); // Fix for pulling from contentvalues
//		Log.i("MPGTrackerDBHelper", "Car ID: " + car.getId());
//		Log.i("MPGTrackerDBHelper", "Car Color: " + car.getColor());
//		Log.i("MPGTrackerDBHelper", "Car Make: " + car.getMake());
//		Log.i("MPGTrackerDBHelper", "Car Model: " + car.getModel());
//		Log.i("MPGTrackerDBHelper", "Car Year: " + car.getYear());

		long insertID = db.insert(DBContract.Cars.TABLE_NAME, null, car);
		
		return insertID;
	}

	public int updateCar(SQLiteDatabase db, ContentValues cv) {
		Log.d("MPGTrackerDBHelper", "Updating Car: " + cv.getAsString(DBContract.COLUMN_NAME_CAR_NAME));
		
		// Update based on ID
		String selection = "id LIKE ?";
		String[] selArgs = {cv.getAsString(DBContract.COLUMN_ID)};
		
		int rows = db.update(DBContract.Cars.TABLE_NAME, cv, selection, selArgs);
		
		return rows;
	}
	
	public Cursor getAllCars(SQLiteDatabase db) {
		Cursor cursor = db.rawQuery("SELECT * FROM " + DBContract.Cars.TABLE_NAME, null);
		return cursor;
	}
	
	public Cursor getACar(SQLiteDatabase db, long ID) {
		Cursor cursor = db.query(DBContract.Cars.TABLE_NAME,
		        DBContract.Cars.COLUMNS, "id = " + ID, null,
		        null, null, null);
		    cursor.moveToFirst();
		return cursor;
	}
	
	public void startFresh(SQLiteDatabase db) {
		Log.d("MPGTrackerDBHelper", "Entered startFresh");
		for (String sql : TABLE_NAMES) {
			Log.d("MPGTrackerDBHelper - startFresh", "Dropping Table: " + sql);
			db.execSQL(SQL_DROP_TABLES + sql);
		}
		
		onCreate(db);
	}
	
}
