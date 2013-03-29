package com.unrulyrecursion.mpgtracker;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

class RowColorAdapter extends ArrayAdapter<String> {

	private static final int type_count = 10;
	private static final int type_color_red = 1;
	private static final int type_color_silver = 0;
	
	public RowColorAdapter(Context context, int resource,
			int textViewResourceId, List<String> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getViewTypeCount() {
	    return type_count;
	}
	
	@Override
	public int getItemViewType(int position) {

	    String item = getItem(position);

	    return (item.compareToIgnoreCase("red") == 0) ? type_color_red : type_color_silver;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = super.getView(position, convertView, parent);
		switch (getItemViewType(position)) {
		case type_color_red:
//			row.setBackgroundResource(R.drawable.button_red);
		}
		return(row);
	}
	
}