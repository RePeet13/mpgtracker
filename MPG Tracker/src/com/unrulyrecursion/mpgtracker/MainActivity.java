package com.unrulyrecursion.mpgtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	public final static String CAR_NAME = "com.unrulyrecursion.mpgtracker.carname";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public void onResume() {
    	// TODO call async task to get database here (and in the detail activity)
    	// this will kick it off, and cache the db for faster reads later
    }
    
    /* Called when user clicks Fill Up on home screen */
    public void newFillUp(View view) {
    	Intent intent = new Intent(this, AddFillUpActivity.class);
    	TextView textView = (TextView) findViewById(R.id.current_car);
    	String carName = textView.getText().toString();
    	intent.putExtra(CAR_NAME, carName);
    	startActivity(intent);
    	
    }
    
    public void newCar(View view) {
    	Intent intent = new Intent(this, NewCarActivity.class);
    	EditText editText = (EditText) findViewById(R.id.new_car);
    	String carName = editText.getText().toString();
    	intent.putExtra(CAR_NAME, carName);
    	startActivity(intent);
    }
    
}
