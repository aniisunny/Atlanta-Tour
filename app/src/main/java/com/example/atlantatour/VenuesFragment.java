package com.example.atlantatour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class VenuesFragment extends Fragment {

    private Intent intent;

    public VenuesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_dining, container, false);

        ArrayList<AtlantaData> data = new ArrayList<>();
        data.add(new AtlantaData(R.drawable.foxtheatre, "Fox Theatre",
                "The fox Theatre is where everyone goes to see the hottest plays," +
                        "concerts, speeches."));
        data.add(new AtlantaData(R.drawable.benzstadium, "Mercedes Benz Stadium",
                "Everyone loves Atlanta Falcons, High profile fans, like Samuel Jackson."));
        data.add(new AtlantaData(R.drawable.arena, "Phillips Arena",
                "Home of the beloved Atlanta Hawks! You're bound to see a celebrity like " +
                        "Zac Brown, Killer Mike and Topgolf."));
        data.add(new AtlantaData(R.drawable.suntrustpark, "Sun Trust Park",
                "The Atlanta Braves have a new home at Sun Trust Park! In addition " +
                        "to the famous for Susan Johnson, Brian Jordan and Lisa Levine."));

        DataAdapter adapter = new DataAdapter(getActivity(), data);
        ListView listView = (ListView) rootView.findViewById(R.id.List);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    intent = new Intent(getActivity(), FoxTheatre.class);
                    startActivity(intent);
                }
                else if(position == 1) {
                    intent = new Intent(getActivity(), MercedesBenzStadium.class);
                    startActivity(intent);
                }
                else if(position == 2) {
                    intent = new Intent(getActivity(), PhillipsArena.class);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(getActivity(), SunTrustPark.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
