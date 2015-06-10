package io.exponential.androidrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    private Callbacks callbacks;

    private RecyclerView carsRecyclerView;
    private CarAdapter carAdapter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private static List<Car> getCarsDataset() {
        List<Car> cars = new ArrayList<>();

        String[] makes = {"Ford", "GM", "BMW", "Toyota", "Honda", "Mercedes"};
        String[] models = {"F150", "Corvette", "M8", "Camry", "Accord", "S65"};

        for (int i = 0; i < makes.length && i < models.length; i++) {
            Car car = new Car(makes[i], models[i]);
            cars.add(car);
        }

        return cars;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Read how final is used to allow access to context within the anonymous inner class below.
        // ref: http://en.wikipedia.org/wiki/Final_%28Java%29 (read the Final and inner classes
        // section)
        final Context context = getActivity();

        // Get a reference to the RecyclerView element in the Fragment's layout
        carsRecyclerView = (RecyclerView) view.findViewById(R.id.cars);

        // Get the cars dataset
        final List<Car> carsDataset = getCarsDataset();

        // Set the adapter
        carAdapter = new CarAdapter(carsDataset);
        carsRecyclerView.setAdapter(carAdapter);

        // Set the layout manager
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        // RecyclerView event handlers

        // ref: http://developer.android.com/reference/android/view/GestureDetector.SimpleOnGestureListener.html
        final GestureDetector gestureDetector = new GestureDetector(context,
            new GestureDetector.SimpleOnGestureListener() {

                /**
                 * Return true to notify Android that we have handled the single tap event.
                 *
                 * @param e The up motion.
                 * @return Return true to indicate that we have handled this event.
                 */
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            }
        );

        carsRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View childView = rv.findChildViewUnder(e.getX(), e.getY());

                // gestureDetector.onTouchEvent(e) will return true if the gestureDetector has
                // consumed the event. When creating the instance of gestureDetector above, we only
                // set an event handler for onSingleTapUp, but not onLongPress. Therefore,
                // gestureDetector.onTouchEvent(e) below will return false during a long press.
                if (childView != null && gestureDetector.onTouchEvent(e)) {
                    String message = "Clicked: " + carsDataset.get(rv.getChildPosition(childView)).getMake();

                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

                    return true;
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                // empty
            }

        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callbacks = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Callbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public interface Callbacks {
        public void setHomePage(String name);
    }

}
