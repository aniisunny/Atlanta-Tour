package com.example.atlantatour;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MercedesBenzStadium extends AppCompatActivity {

    private Intent intent;
    private String phoneNumber = "+1-470-341-5000";
    private String url = "https://mercedesbenzstadium.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chops_lobster_bar);

        final ChopsLobsterBarData data = new ChopsLobsterBarData(R.drawable.benzstadium,
                "Mercedes Benz Stadium", "1 AMB Drive Northwest, Atlanta, GA",
                "Everyone loves Atlanta Falcons, High profile fans, like Samuel Jackson.",
                "Mercedes-Benz Stadium is the currently under-construction new stadium" +
                        " of NFL team Atlanta Falcons and new MLS franchise Atlanta United FC. " +
                        "First suggestions for the construction of a new stadium for the Atlanta" +
                        " Falcons were made in 2010, which became concrete plans in 2012. In the " +
                        "next years funding was arranged and designs were finalised, resulting in" +
                        " the start of construction in May 2014. The stadium is scheduled to be" +
                        " completed in 2017, which is also the first season that Atlanta United" +
                        " will play in the MLS. Mercedes-Benz Stadium will have a seating capacity" +
                        " of 71,000 for NFL games, of which 7,500 club seats and 190 suites." +
                        " Capacity can be increased to up to 81,000 for other events, while " +
                        "capacity for MLS games will be reduced to just over 32,000 seats. " +
                        "The stadium will be adjusted for soccer matches through additional " +
                        "retractable seating closer to the pitch and curtains that close " +
                        "off the upper tiers.\n\nThe stadium will have a retractable roof " +
                        "that consists of triangular panels that open and close like a photo" +
                        " camera. It will be equipped with the latest technology including a" +
                        " 360 degree HD video halo board built into the roof. It has been " +
                        "designed by HOK Architects.\n\nThe stadium will be built on a site" +
                        " just south of the Georgia Dome, the present home of the Atlanta" +
                        " Falcons, which lies just west of downtown Atlanta.\n\nMercedes-Benz" +
                        " Stadium will come at a cost of US$ 1.4 billion, part publicly part privately financed.");

        ImageView imageView = (ImageView) findViewById(R.id.Image);
        imageView.setImageResource(data.getImageResourceId());

        TextView name = (TextView) findViewById(R.id.Name);
        name.setText(data.getName());

        TextView address = (TextView) findViewById(R.id.Address);
        address.setText(data.getAddress());

        TextView celebrity = (TextView) findViewById(R.id.Celebrity);
        celebrity.setText(data.getCelebrityName());

        TextView about = (TextView) findViewById(R.id.About);
        about.setText(data.getAbout());

        final TextView info = (TextView) findViewById(R.id.Info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().equals("View More Info")) {
                    String text = "View Less Info<br><br><font color=#FFFFFF>" +
                            "(404) 341-5000<br>mercedesbenzstadium.com<\font>";
                    info.setText(Html.fromHtml(text));
                }
                else
                    info.setText("View More Info");
            }
        });

        ImageView call = (ImageView) findViewById(R.id.Call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if(intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(MercedesBenzStadium.this, "Call Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView web = (ImageView) findViewById(R.id.Web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(url);
                intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(MercedesBenzStadium.this, "Web Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView map = (ImageView) findViewById(R.id.Map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:33.755449, -84.400854");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(location);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(MercedesBenzStadium.this, "Map Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView share = (ImageView) findViewById(R.id.Share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mercedes Benz Stadium");
                intent.putExtra(Intent.EXTRA_TEXT, data.getName() + "\n" + data.getAddress() + "\n" + phoneNumber + "\n" + url);
                startActivity(Intent.createChooser(intent, "Share"));
                Toast.makeText(MercedesBenzStadium.this, "Share Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        final ImageView save = (ImageView) findViewById(R.id.Save);
        final TextView textView = (TextView) findViewById(R.id.Saved);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().equals("Save")) {
                    save.setImageResource(R.drawable.saved);
                    textView.setText("Saved");
                    Toast.makeText(MercedesBenzStadium.this,
                            "Chops Lobster Bar was Added to Favourite!", Toast.LENGTH_SHORT).show();
                }
                else {
                    save.setImageResource(R.drawable.baseline_favorite_border_black_24dp);
                    textView.setText("Save");
                    Toast.makeText(MercedesBenzStadium.this,
                            "Chops Lobster was removed from Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
