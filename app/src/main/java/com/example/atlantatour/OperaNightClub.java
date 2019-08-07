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

public class OperaNightClub extends AppCompatActivity {

    private Intent intent;
    private String phoneNumber = "+1-404-881-8801";
    private String url = "https://www.atlantaopera.org/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chops_lobster_bar);

        final ChopsLobsterBarData data = new ChopsLobsterBarData(R.drawable.opera,
                "Opera Night Club", "Opera Atlanta", "The club has" +
                " been a place for celebrity sightings such as Clint Eastwood.",
                "Opera Nightclub was a nightclub located in Midtown Atlanta, " +
                        "Georgia, United States. It was Atlanta's most popular and " +
                        "successful nightclub in terms of revenue and attendance and has " +
                        "also been featured in Nightclub & Bar's Top 50 Clubs in the " +
                        "United States for 2015.");

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
                            "(404) 881-8801<br>www.atlantaopera.org<\font>";
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
                Toast.makeText(OperaNightClub.this, "Call Button Clicked",
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
                Toast.makeText(OperaNightClub.this, "Web Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView map = (ImageView) findViewById(R.id.Map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:33.748998, -84.387983");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(location);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(OperaNightClub.this, "Map Button Clicked",
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
                intent.putExtra(Intent.EXTRA_SUBJECT, "Opera Night Club");
                intent.putExtra(Intent.EXTRA_TEXT, data.getName() + "\n" + data.getAddress() + "\n" + phoneNumber + "\n" + url);
                startActivity(Intent.createChooser(intent, "Share"));
                Toast.makeText(OperaNightClub.this, "Share Button Clicked",
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
                    Toast.makeText(OperaNightClub.this,
                            "Chops Lobster Bar was Added to Favourite!", Toast.LENGTH_SHORT).show();
                }
                else {
                    save.setImageResource(R.drawable.baseline_favorite_border_black_24dp);
                    textView.setText("Save");
                    Toast.makeText(OperaNightClub.this,
                            "Chops Lobster was removed from Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
