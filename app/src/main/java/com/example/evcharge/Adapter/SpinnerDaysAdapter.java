package com.example.evcharge.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.evcharge.Fragment.RecentRechargeFragment;
import com.example.evcharge.Model.SpinnerItem;
import com.example.evcharge.R;

import java.util.ArrayList;

public class SpinnerDaysAdapter implements SpinnerAdapter {
    Context context;
    ArrayList<SpinnerItem> spinnerItems;
    public SpinnerDaysAdapter(Context context, ArrayList<SpinnerItem> spinnerItems) {
        this.context = context;
        this.spinnerItems = spinnerItems;
    }

    @Override
    public View getDropDownView(int position, @Nullable
    View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Integer getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, @Nullable
    View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_spinner, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.tvText);
//        SpinnerItem spinnerItem = getItem(position);

//        if (spinnerItem != null) {
//            textViewName.setText(spinnerItem.getDays());
//        }
        return convertView;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
