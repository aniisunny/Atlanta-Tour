package com.example.atlantatour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DiningFragment extends Fragment {

    private Intent intent;

    public DiningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_dining, container, false);

        final ArrayList<AtlantaData> data = new ArrayList<>();
        data.add(new AtlantaData(R.drawable.chobslobsterbar, "Chops Lobster Bar",
                "Visit Chops Lobster Bar & you might see Larry David, Russel Crowe, " +
                        "Justin Bieber, Bily Bob Thornton, Vin Diesel, Dennis Quaid, Kate Bosworth or Ryan Gosling!"));
        data.add(new AtlantaData(R.drawable.park75, "Park 75",
                "Located inside the Four Seasons Hotel, Park 75 is favorite spot for " +
                        "celebs and industry insiders to discuss business over cocktails. With " +
                        "a discreet staff, celebs can enjoy a low-key yet sophisticated night in " +
                        "Midtown, especially if they’re already guests at the luxurious hotel."));
        data.add(new AtlantaData(R.drawable.porncecitymarket, "Ponce City Market",
                "Not exactly an after-hours spot, but Ponce City Market’s Central " +
                        "Food Hall does stay open late and is located right alongside the " +
                        "Atlanta BeltLine’s Eastside Trail, making it a prime hot spot for " +
                        "celebs to check out a unique Atlanta vibe. Deciding where to eat from " +
                        "among the two dozen eateries inside PCM’s Central Food Hall is one " +
                        "of life’s delicious pleasures, and actor Owen Wilson can certainly " +
                        "sympathize. He frequented PCM while in town filming the movie “Bastards” " +
                        "with Atlanta-native Ed Helms; that Holeman & Finch burger in particular made an impression."));
        data.add(new AtlantaData(R.drawable.southcitykitchen, "South City Kitchen",
                "At South City Kitchen, you might run into Kanye West, Kim Kardashian, " +
                        "Charles Barkley, Ben Affleck, Wanda Sykes, Melissa McCarthy and " +
                        "Tom Hanks have all been spotted at the restaurant."));

        DataAdapter dataAdapter = new DataAdapter(getActivity(), data);
        ListView listView = (ListView) rootView.findViewById(R.id.List);
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    intent = new Intent(getActivity(), ChopsLobsterBar.class);
                    startActivity(intent);
                }
                else if(position == 1) {
                    intent = new Intent(getActivity(), Park75.class);
                    startActivity(intent);
                }
                else if(position == 2) {
                    intent = new Intent(getActivity(), PonceCityMarket.class);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(getActivity(), SouthCityKitchen.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
