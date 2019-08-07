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

public class PhillipsArena extends AppCompatActivity {

    private Intent intent;
    private String phoneNumber = "+1-404-878-3000";
    private String url = "https://www.statefarmarena.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chops_lobster_bar);

        final ChopsLobsterBarData data = new ChopsLobsterBarData(R.drawable.arena,
                "Phillips Arena", "1 State Farm Dr, Atlanta, GA",
                "Home of the beloved Atlanta Hawks! You're bound to see a " +
                        "celebrity like Zac Brown, Killer Mike and Topgolf.",
                "Home to the NBA’s Atlanta Hawks Basketball Club, State Farm Arena" +
                        " opened its doors in October 2018 following the 2nd largest " +
                        "renovation in NBA history. Inspired by the fans, State Farm Arena" +
                        " is a next-generation venue focused on experience, service and " +
                        "entertainment. With the NBA’s third-largest center-hung scoreboard" +
                        " and an immersive video experience, fan-friendly food pricing and" +
                        " premium restaurant options, Topgolf Swing Suites and " +
                        "celebrity-inspired spaces accessible to every fan, the downtown" +
                        " Atlanta arena stakes its claim as the city’s best sports and live" +
                        " entertainment venue. Consistently ranked among the top 10 concert" +
                        " and event venues in the world by Pollstar, State Farm Arena hosts" +
                        " approximately 200 events and nearly 2 million guests annually.\n\n" +
                        "The mission of State Farm is to help people manage the risks of" +
                        " everyday life, recover from the unexpected, and realize their " +
                        "dreams. State Farm and its affiliates are the largest providers" +
                        " of auto and home insurance in the United States.");

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
                            "(404) 878-3000<br>www.statefarmarena.com<\font>";
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
                Toast.makeText(PhillipsArena.this, "Call Button Clicked",
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
                Toast.makeText(PhillipsArena.this, "Web Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView map = (ImageView) findViewById(R.id.Map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:33.757292, -84.396325");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(location);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(PhillipsArena.this, "Map Button Clicked",
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
                intent.putExtra(Intent.EXTRA_SUBJECT, "Phillips Arena");
                intent.putExtra(Intent.EXTRA_TEXT, data.getName() + "\n" + data.getAddress() + "\n" + phoneNumber + "\n" + url);
                startActivity(Intent.createChooser(intent, "Share"));
                Toast.makeText(PhillipsArena.this, "Share Button Clicked",
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
                    Toast.makeText(PhillipsArena.this,
                            "Chops Lobster Bar was Added to Favourite!", Toast.LENGTH_SHORT).show();
                }
                else {
                    save.setImageResource(R.drawable.baseline_favorite_border_black_24dp);
                    textView.setText("Save");
                    Toast.makeText(PhillipsArena.this,
                            "Chops Lobster was removed from Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
