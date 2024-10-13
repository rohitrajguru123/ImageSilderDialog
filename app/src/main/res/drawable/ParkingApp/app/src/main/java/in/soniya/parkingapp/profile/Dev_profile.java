package in.soniya.parkingapp.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.soniya.parkingapp.R;

public class Dev_profile extends AppCompatActivity {
    TextView phone_profile,Location;
    Button call,what_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_profile);

        phone_profile = (TextView) findViewById(R.id.phone_profile);
        phone_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+91 9599695872"));
                startActivity(callIntent);

            }
        });
        call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+91 9599695872"));
                startActivity(callIntent);

            }
        });

        what_call = findViewById(R.id.what_call);
        Location = findViewById(R.id.Location);

        what_call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://api.whatsapp.com/send/?phone=919599695872&text&app_absent=0");


            }
        });

        Location.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://goo.gl/maps/fHLoFSHs5PEzW4H1A");


            }
        });











    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}