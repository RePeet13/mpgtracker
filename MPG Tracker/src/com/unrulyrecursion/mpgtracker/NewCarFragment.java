package com.unrulyrecursion.mpgtracker;

import com.unrulyrecursion.mpgtracker.data.Car;
import com.unrulyrecursion.mpgtracker.data.Garage;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Use the
 * {@link NewCarFragment#newInstance} factory method to create an instance of
 * this fragment.
 * 
 */
public class NewCarFragment extends Fragment {

	private Garage garage;
	private Bundle saved;

	public NewCarFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_new_car, container, false);

		if (savedInstanceState != null && savedInstanceState.containsKey("savedValues")) {
			saved = savedInstanceState.getBundle("savedValues");

			restoreSaved(v);

		}
		saved = new Bundle();
		
		v.findViewById(R.id.create_car).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Log.d("New Car Activity", "Making new car");

						EditText tmp;
						tmp = (EditText) v.findViewById(R.id.new_car_name);
						String carName = tmp.getText().toString();
						Log.d("New Car Activity", "Car Name: "
								+ tmp.getText().toString());

						tmp = (EditText) v.findViewById(R.id.new_car_color);
						String color = tmp.getText().toString();
						Log.d("New Car Activity", "Car Color: "
								+ tmp.getText().toString());

						tmp = (EditText) v.findViewById(R.id.new_car_year);
						int year = Integer.parseInt(tmp.getText().toString());
						Log.d("New Car Activity",
								"Car Year: "
										+ Integer.parseInt(tmp.getText()
												.toString()));

						tmp = (EditText) v.findViewById(R.id.new_car_make);
						String make = tmp.getText().toString();
						Log.d("New Car Activity", "Car Make: "
								+ tmp.getText().toString());

						tmp = (EditText) v.findViewById(R.id.new_car_model);
						String model = tmp.getText().toString();
						Log.d("New Car Activity", "Car Model: "
								+ tmp.getText().toString());

						tmp = (EditText) v.findViewById(R.id.new_car_mileage);
						int mileage = Integer
								.parseInt(tmp.getText().toString());
						Log.d("New Car Activity",
								"Car Mileage: "
										+ Integer.parseInt(tmp.getText()
												.toString()));

						Car car = new Car(carName, color, make, model, year,
								mileage);

						if (car.getCarName() != null) {
							garage.addCar(car);
						} else {
							// TODO error message / you done messed up - toast?
							Log.w("New Car Fragment",
									"Car object was null, seek help");
						}

						goToList();
					}
				});

		/* If a field loses focus, save information */
		v.findViewById(R.id.new_car_name).setOnFocusChangeListener(
				new OnFocusChangeListener() {

					@Override
					public void onFocusChange(View arg0, boolean arg1) {
						if (!arg1) {
							Log.d("New Car Fragment", "Car Name Lost Focus");
							saved.putString("carName", ((EditText) arg0)
									.getText().toString());
						}
					}

				});
		v.findViewById(R.id.new_car_color).setOnFocusChangeListener(
				new OnFocusChangeListener() {

					@Override
					public void onFocusChange(View arg0, boolean arg1) {
						if (!arg1) {
							Log.d("New Car Fragment", "Car Color Lost Focus");
							saved.putString("color", ((EditText) arg0)
									.getText().toString());
						}
					}

				});
		v.findViewById(R.id.new_car_year).setOnFocusChangeListener(
				new OnFocusChangeListener() {

					@Override
					public void onFocusChange(View arg0, boolean arg1) {
						if (!arg1) {
							Log.d("New Car Fragment", "Car Year Lost Focus");
							saved.putInt("year", Integer
									.parseInt(((EditText) arg0).getText()
											.toString()));
						}
					}

				});
		v.findViewById(R.id.new_car_make).setOnFocusChangeListener(
				new OnFocusChangeListener() {

					@Override
					public void onFocusChange(View arg0, boolean arg1) {
						if (!arg1) {
							Log.d("New Car Fragment", "Car Make Lost Focus");
							saved.putString("make", ((EditText) arg0).getText()
									.toString());
						}
					}

				});
		v.findViewById(R.id.new_car_model).setOnFocusChangeListener(
				new OnFocusChangeListener() {

					@Override
					public void onFocusChange(View arg0, boolean arg1) {
						if (!arg1) {
							Log.d("New Car Fragment", "Car Model Lost Focus");
							saved.putString("model", ((EditText) arg0)
									.getText().toString());
						}
					}

				});
		v.findViewById(R.id.new_car_mileage).setOnFocusChangeListener(
				new OnFocusChangeListener() {

					@Override
					public void onFocusChange(View arg0, boolean arg1) {
						if (!arg1) {
							Log.d("New Car Fragment", "Car Mileage Lost Focus");
							saved.putInt("mileage", Integer
									.parseInt(((EditText) arg0).getText()
											.toString()));
						}
					}

				});

		return v;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		garage = new Garage(this.getActivity());
//		restoreSaved(this); // TODO pass view in here to enable restoring saved state
	}
	
	private void restoreSaved(View v) {
		if (!saved.isEmpty()) {
			((EditText) v.findViewById(R.id.new_car_name)).setText(saved
					.getString("carName", ""));
			((EditText) v.findViewById(R.id.new_car_year)).setText(saved
					.getInt("year", 0));
			((EditText) v.findViewById(R.id.new_car_make)).setText(saved
					.getString("make", ""));
			((EditText) v.findViewById(R.id.new_car_model)).setText(saved
					.getString("model", ""));
			((EditText) v.findViewById(R.id.new_car_mileage)).setText(saved
					.getInt("mileage", 0));
			((EditText) v.findViewById(R.id.new_car_color)).setText(saved
					.getString("color", ""));
		}
	}
	
	

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		/* Put any saved values into bundle */
		outState.putBundle("savedValues", saved);
	}

	private void goToList() {
		Intent intent = new Intent(this.getActivity(), CarListActivity.class);
		startActivity(intent);
	}
}
