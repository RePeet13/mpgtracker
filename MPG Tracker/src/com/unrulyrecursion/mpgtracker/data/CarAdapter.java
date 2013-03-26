package com.unrulyrecursion.mpgtracker.data;

import java.util.List;

import com.unrulyrecursion.mpgtracker.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CarAdapter extends ArrayAdapter<Car> {

	private static final int TYPE_COUNT = 10;
	private static final int TYPE_COLOR_GRAY = 0;
	private static final int TYPE_COLOR_DEEP_RED = 1;
	private static final int TYPE_COLOR_RED = 2;
	private static final int TYPE_COLOR_WHITE = 3;
	private static final int TYPE_COLOR_GREEN = 4;
	
	
	public CarAdapter(Context context, int resource, int textViewResourceId,
			List<Car> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getViewTypeCount() {
	    return TYPE_COUNT;
	}
	
	@Override
	public int getItemViewType(int position) {

	    Car item = getItem(position);

	    return (item.getColor().compareToIgnoreCase("deep_red") == 0) ? TYPE_COLOR_DEEP_RED : TYPE_COLOR_GRAY;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = super.getView(position, convertView, parent);
		switch (getItemViewType(position)) {
		case TYPE_COLOR_DEEP_RED:
//			row.setBackgroundResource(R.drawable.button_red); //TODO Figure out buttons
		}
		return(row);
	}

}