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

public class Park75 extends AppCompatActivity {

    private Intent intent;
    private String phoneNumber = "+1-404-253-3840";
    private String url = "https://www.fourseasons.com/atlanta/dining/restaurants/park_75/?seo=google_local_atl2_amer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chops_lobster_bar);

        final ChopsLobsterBarData data = new ChopsLobsterBarData(R.drawable.park75,
                "Park 75", "75 14th St NE, Atlanta, GA",
                "Located inside the Four Seasons Hotel, Park 75 is favorite spot " +
                        "for celebs and industry insiders to discuss business over cocktails. " +
                        "With a discreet staff, celebs can enjoy a low-key yet sophisticated " +
                        "night in Midtown, especially if they’re already guests at the " +
                        "luxurious hotel.", "Park 75 is located inside Four Seasons " +
                "Hotel Atlanta in Midtown at 75 14th Street. This Forbes Travel Four-Star " +
                "Atlanta restaurant overlooking the lobby’s dramatic three-story atrium " +
                "includes a lounge and terrace. From Sunday brunch to dessert and everything" +
                " in between, executive chef Robert Gerstenecker puts his modern twist on " +
                "classic dishes, using seasonal ingredients from Atlanta and around the globe." +
                " Although the menu is ever changing, the chef is always playful with " +
                "combinations. If you’re feeling daring, book the chef’s table in the kitchen " +
                "for an unforgettable multicourse extravaganza that really showcases some " +
                "of these special ingredients.");

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
                            "(404) 253-3840<br>www.fourseasons.com/atlanta/dining/" +
                            "restaurants/park_75/?seo=google_local_atl2_amer<\font>";
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
                Toast.makeText(Park75.this, "Call Button Clicked",
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
                Toast.makeText(Park75.this, "Web Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView map = (ImageView) findViewById(R.id.Map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:33.786308, -84.385344");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(location);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(Park75.this, "Map Button Clicked",
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
                intent.putExtra(Intent.EXTRA_SUBJECT, "Park ");
                intent.putExtra(Intent.EXTRA_TEXT, data.getName() + "\n" + data.getAddress() + "\n" + phoneNumber + "\n" + url);
                startActivity(Intent.createChooser(intent, "Share"));
                Toast.makeText(Park75.this, "Share Button Clicked",
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
                    Toast.makeText(Park75.this,
                            "Chops Lobster Bar was Added to Favourite!", Toast.LENGTH_SHORT).show();
                }
                else {
                    save.setImageResource(R.drawable.baseline_favorite_border_black_24dp);
                    textView.setText("Save");
                    Toast.makeText(Park75.this,
                            "Chops Lobster was removed from Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
