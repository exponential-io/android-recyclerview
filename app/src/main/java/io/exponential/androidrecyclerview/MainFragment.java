package io.exponential.androidrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        // Get a reference to the RecyclerView element in the Fragment's layout
        carsRecyclerView = (RecyclerView) view.findViewById(R.id.cars);

        // Get the cars dataset
        List<Car> carsDataset = getCarsDataset();

        // Set the adapter
        carAdapter = new CarAdapter(carsDataset);
        carsRecyclerView.setAdapter(carAdapter);

        // Set the layout manager
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
