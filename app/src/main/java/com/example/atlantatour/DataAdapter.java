package com.example.atlantatour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends ArrayAdapter<AtlantaData> {

    public DataAdapter(Context context, ArrayList<AtlantaData> data) {
        super(context, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if(listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.framelayout_fragment, parent, false);
        }

        AtlantaData atlantaData = getItem(position);

        ImageView imageView = (ImageView) listView.findViewById(R.id.ImageView);
        imageView.setImageResource(atlantaData.getImageResourceId());

        TextView heading = (TextView) listView.findViewById(R.id.Heading);
        heading.setText(atlantaData.getHeading());

        TextView description = (TextView) listView.findViewById(R.id.Description);
        description.setText(atlantaData.getDescription());

        return listView;
    }
}
