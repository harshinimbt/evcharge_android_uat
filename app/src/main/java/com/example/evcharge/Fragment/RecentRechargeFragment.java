package com.example.evcharge.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Adapter.RecentRechargeAdapter;
import com.example.evcharge.Adapter.SpinnerDaysAdapter;
import com.example.evcharge.Model.RecentRecharge;
import com.example.evcharge.Model.SpinnerItem;
import com.example.evcharge.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class RecentRechargeFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    View view;
    ImageButton ibBack;
    RecyclerView rvRecentRecharge;
    ArrayList<SpinnerItem> spinnerItems;
    SpinnerDaysAdapter daysAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recent_recharges, container, false);
        ibBack = view.findViewById(R.id.ibBack);
        ibBack.setOnClickListener(this);
        rvRecentRecharge = view.findViewById(R.id.rvRecentRecharge);
        ArrayList<RecentRecharge> recentRecharge = new ArrayList<>();
        recentRecharge.add(new RecentRecharge("March 3, 2024 at 5:54 PM", "Brigade Gardenia JP Nagar", "#3, 17th Main, 5th Block, Koramangala", "120"));
        recentRecharge.add(new RecentRecharge("Feb 20, 2024 at 3:54 PM", "Kubera TVS", "#3, 17th Main, 5th Block, Koramangala", "240"));
        RecentRechargeAdapter recentRechargeAdapter = new RecentRechargeAdapter(getActivity(), recentRecharge);
        rvRecentRecharge.hasFixedSize();
        rvRecentRecharge.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecentRecharge.setAdapter(recentRechargeAdapter);
        Spinner spinner = view.findViewById(R.id.SpinDays);
        spinner.setOnItemSelectedListener(this);
        List<String> days = new ArrayList<String>();
        days.add("Last 7 days");
        days.add("Last 15 days");
        days.add("Last 30 days");
        days.add("Custom");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, days);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

//        initList();
//        daysAdapter = new SpinnerDaysAdapter(getContext(), spinnerItems);
//        spinner.setAdapter(daysAdapter);
//        spinner.setOnItemSelectedListener(
//                new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> parent,
//                                               View view, int position, long id)
//                    {
//                        SpinnerItem clickedItem = (SpinnerItem)parent.getItemAtPosition(position);
//                        String name = clickedItem.getDays();
//                    }
//                    @Override
//                    public void onNothingSelected(AdapterView<?> parent)
//                    {
//                    }
//                });
        return view;
    }

    private void initList() {
        spinnerItems  = new ArrayList<>();
        spinnerItems.add(new SpinnerItem("Last 7 days"));
        spinnerItems.add(new SpinnerItem("Last 15 days"));
        spinnerItems.add(new SpinnerItem("Last 30 days"));
        spinnerItems.add(new SpinnerItem("Custom"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DashboardFragment()).commit();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
