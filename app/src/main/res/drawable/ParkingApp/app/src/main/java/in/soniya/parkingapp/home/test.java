package in.soniya.parkingapp.home;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.view.View;

import android.widget.ImageView;



import in.soniya.parkingapp.R;


public class test extends AppCompatActivity {



    ImageView telegram, instagram, inquiry, faq, share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        share = (ImageView) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "your app link";
                String shareSUb = "You Subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSUb);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share Using"));


            }

        });



        telegram = findViewById(R.id.telegram);
        instagram = findViewById(R.id.instagram);

        faq = findViewById(R.id.faq);

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://t.me/learncodewithrk");


            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://instagram.com/sanket_j6533?igshid=ZDdkNTZiNTM=");


            }
        });




        inquiry = (ImageView) findViewById(R.id.inquiry);
        inquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("example@gmail") + "?subject=" +
                        Uri.encode("Support ") + "&body=" + Uri.encode("");

                Uri uri = Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.google.com/maps/place/%E0%A4%AE%E0%A4%BE%E0%A4%A4%E0%A5%8B%E0%A4%B6%E0%A5%8D%E0%A4%B0%E0%A5%80+%E0%A4%A8%E0%A4%BF%E0%A4%B5%E0%A4%BE%E0%A4%B8/@19.4696639,75.1861696,359m/data=!3m1!1e3!4m5!3m4!1s0x3bdb6f379c9e63d9:0x8174669d5d0576e0!8m2!3d19.4699268!4d75.1864455!5m1!1e2https://goo.gl/maps/aK2kGa769QdtmhUK6");


            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));


    }
}


