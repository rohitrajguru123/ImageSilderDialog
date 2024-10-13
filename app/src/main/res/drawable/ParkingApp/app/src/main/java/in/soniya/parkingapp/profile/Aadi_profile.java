package in.soniya.parkingapp.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.soniya.parkingapp.R;

public class Aadi_profile extends AppCompatActivity {
    TextView phone_profile,Location;
    Button call,what_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadi_profile);

        phone_profile = (TextView) findViewById(R.id.phone_profile);
        phone_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+91 8999743930"));
                startActivity(callIntent);

            }
        });
        call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+91 8999743930"));
                startActivity(callIntent);

            }
        });

        what_call = findViewById(R.id.what_call);
        Location = findViewById(R.id.Location);

        what_call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://web.whatsapp.com/");


            }
        });

        Location.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.google.com/maps/place/%E0%A4%AE%E0%A4%BE%E0%A4%A4%E0%A5%8B%E0%A4%B6%E0%A5%8D%E0%A4%B0%E0%A5%80+%E0%A4%A8%E0%A4%BF%E0%A4%B5%E0%A4%BE%E0%A4%B8/@19.4696639,75.1861696,359m/data=!3m1!1e3!4m5!3m4!1s0x3bdb6f379c9e63d9:0x8174669d5d0576e0!8m2!3d19.4699268!4d75.1864455!5m1!1e2");


            }
        });











    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}