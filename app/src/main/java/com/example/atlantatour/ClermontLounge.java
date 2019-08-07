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

public class ClermontLounge extends AppCompatActivity {

    private Intent intent;
    private String phoneNumber = "+1-404-874-4783";
    private String url = "https://www.clermontlounge.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chops_lobster_bar);

        final ChopsLobsterBarData data = new ChopsLobsterBarData(R.drawable.clermont,
                "Clermont Lounge", "789 Ponce De Leon Ave NE, Atlanta, GA",
                "Anthony Bourdain, Robert De Niro, Morgan Freeman, Lady Gaga, " +
                        "Jennifer Lawrence and pretty much every celebrity who visits Atlanta, " +
                        "but not Mumford & Sons since they got kicked out of there last year.",
                "The Clermont Lounge® is Atlanta's oldest strip club. Although the " +
                        "basement space began life in 1955 as an upscale supper club, it was" +
                        " reborn as the Clermont Lounge in 1965 and has become an Atlanta " +
                        "landmark.\n\nLocated in the basement of the Clermont Motor Hotel on" +
                        " Ponce De Leon, the Clermont Lounge offers great entertainment," +
                        " generous drinks and much, much more.\n\nWe have been featured on" +
                        " the Travel Channel's \"The Layover\", Real Housewives of Atlanta," +
                        " Comedy Central and many more. The Clermont Lounge has received" +
                        " numerous awards for our unique atmosphere and service. Many " +
                        "celebrities frequent the Clermont Lounge such as Bill Murray, " +
                        "Robert De Niro, P!nk, Carey Hart, Kid Rock, Woody Harrelson, " +
                        "Morgan Freeman and many more.\n\nCome find out what draws people" +
                        " to the Clermont Lounge. You never know who you may bump into.");

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
                String text = "View Less Info<br><br><font color = #FFFFFF>" +
                        "(404) 874-4783<br>www.clermontlounge.net</font";
                if(info.getText().equals("View More Info"))
                    info.setText(Html.fromHtml(text));
                else
                    info.setText("View More Info");
            }
        });

        ImageView call =(ImageView) findViewById(R.id.Call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if(intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(ClermontLounge.this, "Call Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView web = (ImageView) findViewById(R.id.Web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                if(intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(ClermontLounge.this, "Web Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView map = (ImageView) findViewById(R.id.Map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:33.773580, -84.361392");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(location);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(ClermontLounge.this, "Map Button Clicked",
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
                intent.putExtra(Intent.EXTRA_SUBJECT,"Clermont Lounge");
                intent.putExtra(Intent.EXTRA_TEXT, data.getName() + "\n" + data.getAddress() + "\n" + phoneNumber + "\n" + url);
                startActivity(Intent.createChooser(intent, "Share"));
                Toast.makeText(ClermontLounge.this, "Share Button Clicked",
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
                    Toast.makeText(ClermontLounge.this,
                            "Chops Lobster Bar was Added to Favourite!", Toast.LENGTH_SHORT).show();
                }
                else {
                    save.setImageResource(R.drawable.baseline_favorite_border_black_24dp);
                    textView.setText("Save");
                    Toast.makeText(ClermontLounge.this,
                            "Chops Lobster was removed from Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
