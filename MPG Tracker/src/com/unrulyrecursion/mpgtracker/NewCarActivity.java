package com.unrulyrecursion.mpgtracker;

import com.unrulyrecursion.mpgtracker.data.Garage;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
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
    public void onResume() { // TODO should restore values in edittexts if theyre there
    	super.onResume();
    	garage = new Garage(this);
    	
    }
    
    @Override
    public void onPause() { // TODO should save values in edittexts if theyre there
    	super.onResume();
    	
    }
    
    public void createCar() {
    	Car car = new Car(
    			(EditText) findViewById(R.id.new_car_name), 
    			(EditText) findViewById(R.id.new_car_color), 
    			(EditText) findViewById(R.id.new_car_year), 
    			(EditText) findViewById(R.id.new_car_make), 
    			(EditText) findViewById(R.id.new_car_model),
    			(EditText) findViewById(R.id.new_car_mileage) );
    	garage.addCar(car);
    }

}
