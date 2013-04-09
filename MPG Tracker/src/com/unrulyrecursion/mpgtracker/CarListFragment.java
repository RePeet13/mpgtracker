package com.unrulyrecursion.mpgtracker;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.unrulyrecursion.mpgtracker.data.Car;
import com.unrulyrecursion.mpgtracker.data.Garage;
import com.unrulyrecursion.mpgtracker.data.RowColorAdapter;

/**
 * A list fragment representing a list of Cars. This fragment also supports
 * tablet devices by allowing list items to be given an 'activated' state upon
 * selection. This helps indicate which item is currently being viewed in a
 * {@link CarDetailFragment}.
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class CarListFragment extends ListFragment {

	private Garage garage;
	private List<Car> cars;
	private RowColorAdapter adapter;
	private ListView mListView;
	private Car mCurrentCar;

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * activated item position. Only used on tablets.
	 */
	private static final String STATE_ACTIVATED_POSITION = "activated_position";

	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */
	private Callbacks mCallbacks = sDummyCallbacks;

	/**
	 * The current activated item position. Only used on tablets.
	 */
	private int mActivatedPosition = ListView.INVALID_POSITION;

	/**
	 * A callback interface that all activities containing this fragment must
	 * implement. This mechanism allows activities to be notified of item
	 * selections.
	 */
	public interface Callbacks {
		/**
		 * Callback for when an item has been selected.
		 */
		public void onItemSelected(String id);
	}

	/**
	 * A dummy implementation of the {@link Callbacks} interface that does
	 * nothing. Used only when this fragment is not attached to an activity.
	 */
	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(String id) {
		}
	};

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public CarListFragment() {
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

    	Log.d("CarList Fragment", "OnCreateView");
    	
        View v = inflater.inflate(R.layout.fragment_car_list, container, false);
    	
    	/* Chain to build listener for buttons */
    	v.findViewById(R.id.create_new_car).setOnClickListener(
    			new OnClickListener() {
    				
    				@Override
    				public void onClick(View v) {
    					newCar();
    				}
    			});
    	
    	v.findViewById(R.id.delete_all_cars).setOnClickListener(
    			new OnClickListener() {
    				
    				@Override
    				public void onClick(View v) {
    					deleteAll();
    				}
    			});
    	
    	mListView = (ListView) v.findViewById(android.R.id.list);
    	mListView.setAdapter(adapter);
    	mListView.setOnItemClickListener(new OnItemClickListener() { //Might need (taken from gitmad code)

            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                    int position, long id) {
//                mCurrentCar = adapter.select(position);
            }
        });
    	return v;
    }

	@Override
	public void onResume() {
		super.onResume();
		Log.d("Car List Fragment", "OnResume");
		
		garage = new Garage(this.getActivity());
		cars = garage.getCarList();
		
		for (Car car : cars) {
			Log.d("Car List Fragment", "OnResume Found: " + car.getCarName());
		}
		
		adapter = new RowColorAdapter(this.getActivity(), cars);
		mListView.setAdapter(adapter);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Restore the previously serialized activated item position.
		if (savedInstanceState != null
				&& savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
			setActivatedPosition(savedInstanceState
					.getInt(STATE_ACTIVATED_POSITION));
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// Activities containing this fragment must implement its callbacks.
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException(
					"Activity must implement fragment's callbacks.");
		}

		mCallbacks = (Callbacks) activity;
		
	}

	@Override
	public void onDetach() {
		super.onDetach();

		// Reset the active callbacks interface to the dummy implementation.
		mCallbacks = sDummyCallbacks;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);

		// Notify the active callbacks interface (the activity, if the
		// fragment is attached to one) that an item has been selected.
		// mCallbacks.onItemSelected(DummyContent.ITEMS.get(position).id);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mActivatedPosition != ListView.INVALID_POSITION) {
			// Serialize and persist the activated item position.
			outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
		}
	}

	/**
	 * Turns on activate-on-click mode. When this mode is on, list items will be
	 * given the 'activated' state when touched.
	 */
	public void setActivateOnItemClick(boolean activateOnItemClick) {
		// When setting CHOICE_MODE_SINGLE, ListView will automatically
		// give items the 'activated' state when touched.
		getListView().setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
						: ListView.CHOICE_MODE_NONE);
	}

	private void setActivatedPosition(int position) {
		if (position == ListView.INVALID_POSITION) {
			getListView().setItemChecked(mActivatedPosition, false);
		} else {
			getListView().setItemChecked(position, true);
		}

		mActivatedPosition = position;
	}
	
    public void newCar() {
    	Log.d("Car List Fragment", "Entered newCar method");
    	Intent intent = new Intent(this.getActivity(), NewCarActivity.class);
    	startActivity(intent);
    }
    
    public void deleteAll() {
    	Log.d("Car List Fragment", "Entered deleteAll method");

    	// TODO pop up a dialog to confirm
    	// call delete all on dbhandler, reget list notify changed?
    }
}
