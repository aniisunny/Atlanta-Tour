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

public class NightLifeFragment extends Fragment {

    private Intent intent;

    public NightLifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dining, container, false);

        ArrayList<AtlantaData> data = new ArrayList<>();
        data.add(new AtlantaData(R.drawable.clermont, "Clermont Lounge",
                "Anthony Bourdain, Robert De Niro, Morgan Freeman, Lady Gaga, " +
                        "Jennifer Lawrence and pretty much every celebrity who visits Atlanta, " +
                        "but not Mumford & Sons since they got kicked out of there last year."));
        data.add(new AtlantaData(R.drawable.compound, "Compound",
                "At compound, you might see singers like Chris Brown, 2Chainz, " +
                        "Lil Baby, Fabolous, Trey Songz, and Yo Gotti."));
        data.add(new AtlantaData(R.drawable.opera, "Opera Night Club",
                "The club has been a place for celebrity sightings such as Clint Eastwood."));
        data.add(new AtlantaData(R.drawable.petals, "Puff & Petals",
                "Celebrity sightings here include various cast members from " +
                        "several VH1 reality series."));
        data.add(new AtlantaData(R.drawable.stk, "STK Atlanta",
                "Vince Vaughn, Denzel Washington, Selena Gomez, Zac Efron, " +
                        "Jessica Alba, Chris Evans, Scarlett Johansson, Owen Wilson, " +
                        "Charles Barkley, John Mellencamp, Meg Ryan, Kevin Bacon, Kurt " +
                        "Russell, Dakota Fanning, Keri Hilson"));

        DataAdapter adapter = new DataAdapter(getActivity(), data);
        ListView listView = (ListView) rootView.findViewById(R.id.List);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    intent = new Intent(getActivity(), ClermontLounge.class);
                    startActivity(intent);
                }
                else if(position == 1) {
                    intent = new Intent(getActivity(), Compound.class);
                    startActivity(intent);
                }
                else if(position == 2) {
                    intent = new Intent(getActivity(), OperaNightClub.class);
                    startActivity(intent);
                }
                else if(position == 3) {
                    intent = new Intent(getActivity(), PuffPetals.class);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(getActivity(), STK.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
