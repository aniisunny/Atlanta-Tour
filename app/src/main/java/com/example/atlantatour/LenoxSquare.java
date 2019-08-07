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

public class LenoxSquare extends AppCompatActivity {

    private Intent intent;
    private String phoneNumber = "+1-404-233-6767";
    private String url = "https://www.simon.com/mall/lenox-square";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chops_lobster_bar);

        final ChopsLobsterBarData data = new ChopsLobsterBarData(R.drawable.lenoxsquare,
                "Lenox Square", "3393 Peachtree Rd NE, Atlanta, GA",
                "A-listers are as drawn to those designer boutiques as us mere " +
                        "mortals, so don’t be surprised if you catch a glimpse of a " +
                        "movie star or musician buried under bundles of shopping bags.",
                "An impressive two-story glass facade welcomes shoppers to three " +
                        "full-service restaurants: The Cheesecake Factory, Zinburger Wine " +
                        "& Burger Bar, and True Food Kitchen. This dramatic entrance " +
                        "showcases the iconic property’s street side presence, including " +
                        "a glass covered porte-cochere and valet amenities for easy access." +
                        " The property boasts Bloomingdale's, Neiman Marcus and Macy's and" +
                        " features nearly 250 specialty stores like FENDI, Burberry, Cartier," +
                        " David Yurman, Louis Vuitton, Diane von Furstenberg, and Vineyard Vines.\n\n" +
                        "In addition to our front-side restaurants, you'll find dining " +
                        "experiences throughout our property that fit every taste. Enjoy a" +
                        " casual meal at  ATL Taco, California Pizza Kitchen, Corner Bakery," +
                        " or even Cousins Maine Lobster.  If you're looking for a quick bite," +
                        " there's a wide selection of specialty food shops located on the " +
                        "lower level in the Lenox Fashion Cafe.  Make sure you stop by Da " +
                        "Vinci Doughnuts to celebrate your successful day of shopping!\n\n" +
                        "Our staff cordially invites you to make Lenox Square a part of your" +
                        " next legendary shopping experience.  We’re conveniently located at " +
                        "the intersection of Peachtree Road and Lenox Road, just across " +
                        "from our sister center Phipps Plaza.");

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
                            "(404) 233-6767<br>www.simon.com/mall/lenox-square<\font>";
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
                Toast.makeText(LenoxSquare.this, "Call Button Clicked",
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
                Toast.makeText(LenoxSquare.this, "Web Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView map = (ImageView) findViewById(R.id.Map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:33.846294, -84.362142");
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(location);
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                Toast.makeText(LenoxSquare.this, "Map Button Clicked",
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
                intent.putExtra(Intent.EXTRA_SUBJECT, "Lenox Square");
                intent.putExtra(Intent.EXTRA_TEXT, data.getName() + "\n" + data.getAddress() + "\n" + phoneNumber + "\n" + url);
                startActivity(Intent.createChooser(intent, "Share"));
                Toast.makeText(LenoxSquare.this, "Share Button Clicked",
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
                    Toast.makeText(LenoxSquare.this,
                            "Chops Lobster Bar was Added to Favourite!", Toast.LENGTH_SHORT).show();
                }
                else {
                    save.setImageResource(R.drawable.baseline_favorite_border_black_24dp);
                    textView.setText("Save");
                    Toast.makeText(LenoxSquare.this,
                            "Chops Lobster was removed from Favorite!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
