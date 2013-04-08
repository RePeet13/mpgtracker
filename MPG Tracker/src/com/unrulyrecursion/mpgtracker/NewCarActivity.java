package com.unrulyrecursion.mpgtracker;

import com.unrulyrecursion.mpgtracker.data.Car;
import com.unrulyrecursion.mpgtracker.data.Garage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class NewCarActivity extends Activity {

	private Garage garage;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_car);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_new_car, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onResume() { // TODO should restore values in edittexts if
								// theyre there
		super.onResume();

	}

	@Override
	public void onPause() { // TODO should save values in edittexts if theyre
							// there
		super.onPause();

	}

	public void createCar(View view) {
		Log.d("New Car Activity", "Making new car");

		EditText tmp;
		tmp = (EditText) findViewById(R.id.new_car_name);
		String carName = tmp.getText().toString();
		Log.d("New Car Activity", "Car Name: " + tmp.getText().toString());

		tmp = (EditText) findViewById(R.id.new_car_color);
		String color = tmp.getText().toString();
		Log.d("New Car Activity", "Car Color: " + tmp.getText().toString());

		tmp = (EditText) findViewById(R.id.new_car_year);
		int year = Integer.parseInt(tmp.getText().toString());
		Log.d("New Car Activity", "Car Year: " + Integer.parseInt(tmp.getText().toString()));

		tmp = (EditText) findViewById(R.id.new_car_make);
		String make = tmp.getText().toString();
		Log.d("New Car Activity", "Car Make: " + tmp.getText().toString());

		tmp = (EditText) findViewById(R.id.new_car_model);
		String model = tmp.getText().toString();
		Log.d("New Car Activity", "Car Model: " + tmp.getText().toString());

		tmp = (EditText) findViewById(R.id.new_car_mileage);
		int mileage = Integer.parseInt(tmp.getText().toString());
		Log.d("New Car Activity", "Car Mileage: " + Integer.parseInt(tmp.getText().toString()));

		Car car = new Car(carName, color, make, model, year, mileage);

		if (car.getCarName() == null) {
			garage.addCar(car);
		}
		else {
			// TODO error message / you done messed up
			Log.w("New Car Activity", "Car object was null, seek help");
		}

		Intent intent = new Intent(this, CarListActivity.class);
		startActivity(intent);
	}

}
