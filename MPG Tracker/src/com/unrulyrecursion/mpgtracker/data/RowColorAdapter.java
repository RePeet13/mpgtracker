package com.unrulyrecursion.mpgtracker.data;

import java.util.List;

import com.unrulyrecursion.mpgtracker.R; // TODO is this import inappropriate?
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowColorAdapter extends ArrayAdapter<String> {

	private static final int TYPE_COUNT = 10; // TODO Take out if different method for passing colors is developed
	private static final int TYPE_COLOR_GRAY = 0;
	private static final int TYPE_COLOR_DEEP_RED = 1;
	private static final int TYPE_COLOR_RED = 2;
	private static final int TYPE_COLOR_WHITE = 3;
	private static final int TYPE_COLOR_GREEN = 4;
	
	private final Context context;
	private final Car[] objects;
	
	public RowColorAdapter(Context context, Car[] objects) {
		super(context, R.layout.car_list_entry);
		this.context = context;
		this.objects = objects;
	}
	
	@Override
	public int getViewTypeCount() {
	    return TYPE_COUNT;
	}
	
	@Override
	public int getItemViewType(int position) {

	    Car item = objects[position]; // TODO Change to lookup?

	    return (item.getColor().compareToIgnoreCase("deep_red") == 0) ? TYPE_COLOR_DEEP_RED : TYPE_COLOR_GRAY;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.car_list_entry, parent, false);
		TextView nameTextView = (TextView) rowView.findViewById(R.id.list_entry_car_name);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.list_entry_car_image); // TODO can implement for car image perhaps
		TextView detailsTextView = (TextView) rowView.findViewById(R.id.list_entry_car_details);
		
		Car car = objects[position];
		
		nameTextView.setText(car.getCarName());
		
		int i = car.getYear() % 100;
		detailsTextView.setText("'" + Integer.toString(i) + " " + car.getMake() + " " + car.getModel());
		
		switch (getItemViewType(position)) {
		case TYPE_COLOR_DEEP_RED:
//			row.setBackgroundResource(R.drawable.button_red);
		}
		return(rowView);
	}
	
}