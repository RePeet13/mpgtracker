package com.unrulyrecursion.mpgtracker.data;

import android.os.AsyncTask;
import java.util.List;

public class DatabaseOpenTask extends AsyncTask<String, Integer, List<Car>> {

	// TODO overwrite on progress thing
	
	@Override
	protected List<Car> doInBackground(String... params) {
		// TODO Auto-generated method stub
		// TODO Get writable database
		// TODO handle if there are no cars
		// TODO Get and make cars from them
		// TODO progress is cars made/total cars
		// TODO returns arraylist of cars in carlist
		return null;
	}

}
