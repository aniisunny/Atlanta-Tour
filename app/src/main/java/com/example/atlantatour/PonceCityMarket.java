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

public class PonceCityMarket extends AppCompatActivity {

    private Intent intent;
    private String phoneNumber = "+1-404-900-7900";
    private String url = "https://poncecitymarket.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chops_lobster_bar);

        final ChopsLobsterBarData data = new ChopsLobsterBarData(R.drawable.porncecitymarket,
                "Ponce City Market", "675 Ponce de Leon Ave. NE",
                "Not exactly an after-hours spot, but Ponce City Market’s Central" +
                        " Food Hall does stay open late and is located right alongside the " +
                        "Atlanta BeltLine’s Eastside Trail, making it a prime hot spot for " +
                        "celebs to check out a unique Atlanta vibe. Deciding where to eat from" +
                        " among the two dozen eateries inside PCM’s Central Food Hall is one " +
                        "of life’s delicious pleasures, and actor Owen Wilson can certainly " +
                        "sympathize. He frequented PCM while in town filming the movie " +
                        "“Bastards with Atlanta-native Ed Helms; that Holeman & Finch burger" +
                        " in particular made an impression.", "At the heart of Ponce " +
                "City Market is the marketplace itself, a flexible space to gather, eat and " +
                "shop. In the Central Food Hall, artisan chefs and local purveyors fill an " +
                "authentic market with the design, food, and flavors of Atlanta. From morning" +
                " coffee to lunchtime shopping and date-night dinners, the Central Food Hall" +
                " is a daily gathering place and culinary destination, year-round.\n\n" +
                "Retail shops and offices add to the life, color, and culture of Ponce City" +
                " Market and surrounding neighborhoods. Residents of the Flats apartments in" +
                " the upper floors of the east and west wings are just a few steps or an " +
                "elevator ride from workplaces, shopping, the Central Food Hall, and direct" +
                " access to the BeltLine. Atlanta neighborhoods of Virginia-Highland, " +
                "Poncey-Highland, and Midtown are all within easy walking or pedaling distance.");

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
                            "(404) 900-7900<br>poncecitymarket.com<\font>";
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
                Toast.makeText(PonceCityMarket.this, "Call Button Clicked",
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
                Toast.makeText(PonceCityMarket.this, "Web Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView map = (ImageView) findViewById(R.id.Map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:33.772793, -84.365860");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(location);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(PonceCityMarket.this, "Map Button Clicked",
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
                intent.putExtra(Intent.EXTRA_SUBJECT, "Ponce City Market");
                intent.putExtra(Intent.EXTRA_TEXT, data.getName() + "\n" + data.getAddress() + "\n" + phoneNumber + "\n" + url);
                startActivity(Intent.createChooser(intent, "Share"));
                Toast.makeText(PonceCityMarket.this, "Share Button Clicked",
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
                    Toast.makeText(PonceCityMarket.this,
                            "Chops Lobster Bar was Added to Favourite!", Toast.LENGTH_SHORT).show();
                }
                else {
                    save.setImageResource(R.drawable.baseline_favorite_border_black_24dp);
                    textView.setText("Save");
                    Toast.makeText(PonceCityMarket.this,
                            "Chops Lobster was removed from Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
