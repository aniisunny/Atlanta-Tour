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

public class ShoppingFragment extends Fragment {

    private Intent intent;

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dining, container, false);

        final ArrayList<AtlantaData> data = new ArrayList<>();
        data.add(new AtlantaData(R.drawable.lenoxsquare, "Lenox Square",
                "A-listers are as drawn to those designer boutiques as us mere " +
                        "mortals, so don’t be surprised if you catch a glimpse of a " +
                        "movie star or musician buried under bundles of shopping bags."));
        data.add(new AtlantaData(R.drawable.phippsplaza, "Phipps Plaza",
                "You are likely to set atleast one celebrity when shopping " +
                        "at Phipps's Plaza in Atlanta."));
        data.add(new AtlantaData(R.drawable.shopsbuckhead, "The Shops Buckhead Atlanta",
                "The shops Buckhead Atlanta is known affectionately as the " +
                        "“Rodeo Drive of Buckhead,” the Shops Buckhead Atlanta is bursting " +
                        "with taste: fashion, jewelry, shoes, eyewear -- and has quickly " +
                        "become a new beacon of style in Atlanta. Of course it will attract " +
                        "celebrities as well. And a little birdie told us that there are " +
                        "a few who live in the high rises there, too."));

        DataAdapter adapter = new DataAdapter(getActivity(), data);
        ListView listView = (ListView) rootView.findViewById(R.id.List);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    intent = new Intent(getActivity(), LenoxSquare.class);
                    startActivity(intent);
                }
                else if(position == 1) {
                    intent = new Intent(getActivity(), PhippsPlaza.class);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(getActivity(), TheShopsBuckhead.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
