package com.unrulyrecursion.mpgtracker.data;

import android.provider.BaseColumns;

public class DBContract {

//	Android Training website for Databases:
//	http://developer.android.com/training/basics/data-storage/databases.html
	
	// Empty constructor discourages attempting to instantiate the class
	private DBContract() {}
	
	/*
	 * Database Schema
	 * 
	 * Columns arranged in decreasing order of importance.
	 * Tables that use global columns have them also, but commented.
	 */
	
	// Global Column names
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME_CAR_NAME = "carname";
	public static final String COLUMN_NAME_DATE = "date";
	public static final String COLUMN_NAME_TOTAL_MILEAGE = "totalmileage";
	
	/**
	 * Contains information on all cars in the system (one row per car). Keyed 
	 * by Car Name.
	 * @author Taylor
	 */
	public static abstract class Cars implements BaseColumns {
		public static final String TABLE_NAME = "cars";
//		public static final String COLUMN_ID = "_id";
//		public static final String COLUMN_NAME_CAR_NAME = "carname"; //primary key
		public static final String COLUMN_NAME_COLOR = "color";
		public static final String COLUMN_NAME_MAKE = "make";
		public static final String COLUMN_NAME_MODEL = "model";
		public static final String COLUMN_NAME_YEAR = "year";
//		public static final String COLUMN_NAME_TOTAL_MILEAGE = "totalmileage";
		public static final String[] COLUMNS = {COLUMN_ID,
			COLUMN_NAME_CAR_NAME, COLUMN_NAME_COLOR, COLUMN_NAME_MAKE, 
			COLUMN_NAME_MODEL, COLUMN_NAME_YEAR, COLUMN_NAME_TOTAL_MILEAGE};
}
	
	/**
	 * Contains information of all fillups that have been recorded. Keyed by 
	 * a unique id, and Car Name.
	 * @author Taylor
	 */
	public static abstract class Fillups implements BaseColumns {
		public static final String TABLE_NAME = "fillups";
//		public static final String COLUMN_ID = "_id";
//		public static final String COLUMN_NAME_CAR_NAME = "carname";
//		public static final String COLUMN_NAME_DATE = "date";
//		public static final String COLUMN_NAME_TOTAL_MILEAGE = "totalmileage";
		public static final String COLUMN_NAME_TRIP_MILEAGE = "tripmileage";
		public static final String COLUMN_NAME_GALLONS_IN = "gallonsin";
		public static final String COLUMN_NAME_PRICE_PER_GALLON = "pricepergallon";
		public static final String[] COLUMNS = {COLUMN_ID,
			COLUMN_NAME_CAR_NAME, COLUMN_NAME_DATE, COLUMN_NAME_TOTAL_MILEAGE, 
			COLUMN_NAME_TRIP_MILEAGE, COLUMN_NAME_GALLONS_IN, 
			COLUMN_NAME_PRICE_PER_GALLON};
	}
	
	
	/* Unimplemented sections of DB

	// Used in future implementation with Oil Change Tracking
	public static abstract class OilChange implements BaseColumns {
		public static final String TABLE_NAME = "OIL_CHANGES";
//	public static final String COLUMN_ID = "_id";
		public static final String COLUMN_NAME_CAR_NAME = "carname";
		public static final String COLUMN_NAME_DATE = "date";
		public static final String COLUMN_NAME_TOTAL_MILEAGE = "totalmileage";
		public static final String COLUMN_NAME_MILES_ON_LAST_OIL = "milesonlastoil";
		public static final String COLUMN_NAME_OIL_USED = "oilused";
		public static final String COLUMN_NAME_OIL_PRICE = "oilprice";
		public static final String COLUMN_NAME_FILTER_USED = "filterused";
		public static final String COLUMN_NAME_FILTER_PRICE = "filterprice";
	}
	
	// Used in future implementation with Notifications to check maintenance items
	public static abstract class DefaultCheckTimes implements BaseColumns {
//	public static final String COLUMN_ID = "_id";
		public static final String TABLE_NAME = "defaultchecktimes";
		public static final String COLUMN_NAME_CAR_NAME = "carname"; // generic
		public static final String COLUMN_NAME_CHANGE_OIL = "changeoil"; // 5000 miles
		public static final String COLUMN_NAME_CHANGE_WIPERS = "changewipers"; // 6 months
		public static final String COLUMN_NAME_CHECK_WIPER_FLUID = "checkwiperfluid"; // 3 months
		public static final String COLUMN_NAME_CHECK_TIRES = "checktires"; // 10,000 miles
	}
	
	*/
}
