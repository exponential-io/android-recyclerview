package io.exponential.androidrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> cars = Collections.emptyList();

    public CarAdapter(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View carView = LayoutInflater.from(parent.getContext()).inflate(R.layout.car, parent, false);

        CarViewHolder carViewHolder = new CarViewHolder(carView);

        return carViewHolder;
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        Car car = cars.get(position);

        holder.makeTextView.setText(car.getMake());
        holder.modelTextView.setText(car.getModel());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        private TextView makeTextView;
        private TextView modelTextView;

        public CarViewHolder(View itemView) {
            super(itemView);
            makeTextView = (TextView) itemView.findViewById(R.id.make);
            modelTextView = (TextView) itemView.findViewById(R.id.model);
        }
    }

}
