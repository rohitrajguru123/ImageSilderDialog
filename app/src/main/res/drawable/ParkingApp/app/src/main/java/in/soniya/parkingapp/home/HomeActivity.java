package in.soniya.parkingapp.home;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import in.soniya.parkingapp.R;
import in.soniya.parkingapp.login.LoginandregisterActivity;

public class HomeActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth mAuth;

    private View headerView;
    ImageView tracker,parking_list, imageView5, imageView6, imageView3,bluetooth,feedback,parking_status,p_manual,Location_Area,parking1,parking2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        tracker = (ImageView) findViewById(R.id.tracker);
        tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(HomeActivity.this, userdetail.class);
                startActivity(streamIntent);
            }
        });

        p_manual = (ImageView) findViewById(R.id.p_manual);
        p_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(HomeActivity.this, parking_manual.class);
                startActivity(streamIntent);
            }
        });

        parking1 = (ImageView) findViewById(R.id.parking1);
        parking1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(HomeActivity.this, booking.class);
                startActivity(streamIntent);
            }
        });

        parking2 = (ImageView) findViewById(R.id.parking2);
        parking2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(HomeActivity.this, Detail_page.class);
                startActivity(streamIntent);
            }
        });





        Location_Area = (ImageView) findViewById(R.id.Location_Area);
        Location_Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(HomeActivity.this, location_area.class);
                startActivity(streamIntent);
            }
        });



        feedback = (ImageView) findViewById(R.id.feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("example@gmail.com") + "?subject=" +
                        Uri.encode("your email id ") + "&body=" + Uri.encode("");

                Uri uri = Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });

        parking_status = (ImageView) findViewById(R.id.parking_status);
        parking_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent streamIntent = new Intent(HomeActivity.this, parking_status_page.class);
                startActivity(streamIntent);
            }
        });


        // setup UI
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinatorLayout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        TextView drawerUsername = headerView.findViewById(R.id.drawer_name);
        TextView drawerAccount = headerView.findViewById(R.id.drawer_email);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.About_us) {


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(String.format("%1$s", getString(R.string.about1)));
            builder.setMessage ( getResources().getText(R.string.about_text));
            builder.setPositiveButton("OK", null);
            builder.setIcon(R.mipmap.ic_launcher);
            AlertDialog welcomeAlert = builder.create();
            welcomeAlert.show();
            ((TextView) welcomeAlert.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());




        } else if (id == R.id.Location) {
            Intent intent = new Intent("android.intent.action.VIEW",
                    Uri.parse("https://www.google.com/maps/place/%E0%A4%AE%E0%A4%BE%E0%A4%A4%E0%A5%8B%E0%A4%B6%E0%A5%8D%E0%A4%B0%E0%A5%80+%E0%A4%A8%E0%A4%BF%E0%A4%B5%E0%A4%BE%E0%A4%B8/@19.4696639,75.1861696,359m/data=!3m1!1e3!4m5!3m4!1s0x3bdb6f379c9e63d9:0x8174669d5d0576e0!8m2!3d19.4699268!4d75.1864455!5m1!1e2"));
            startActivity(intent);


        } else if (id == R.id.nav_support_contact) {
            Intent paymentIntent = new Intent(HomeActivity.this, test.class);
            startActivity(paymentIntent);

        } else if (id == R.id.help_line_Number) {

            if(Build.VERSION.SDK_INT<23){
                Intent in=new Intent(Intent.ACTION_CALL, Uri.parse("tel:+91" + "8999743930"));

                try{
                    startActivity(in);
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(), "yourActivity is not founded", Toast.LENGTH_SHORT).show();
                }

            }else{
                int REQUEST_CODE_ASK_PERMISSIONS = 123;

                int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.CALL_PHONE);
                if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[] {Manifest.permission.CALL_PHONE},
                            REQUEST_CODE_ASK_PERMISSIONS);

                }

                Intent in=new Intent(Intent.ACTION_CALL, Uri.parse("tel:+91" + "8999743930"));

                try{
                    startActivity(in);
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), "Permissions required", Toast.LENGTH_SHORT).show();
                }

            }

            return true;



        } else if (id == R.id.nav_share) {

            Intent shareintent = new Intent();
            shareintent.setAction(Intent.ACTION_SEND);
            shareintent.putExtra(Intent.EXTRA_TEXT, "your application link");
            shareintent.setType("text/plain");
            startActivity(Intent.createChooser(shareintent, " Share Parking App"));

        } else if (id == R.id.nav_logout)
            mAuth.signOut();
        if (mAuth.getCurrentUser() == null) {
            startActivity(new Intent(getApplicationContext(), LoginandregisterActivity.class));
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;



    }
}
