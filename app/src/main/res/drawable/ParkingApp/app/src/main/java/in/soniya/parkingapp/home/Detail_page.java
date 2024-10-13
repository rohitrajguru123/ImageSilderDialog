package in.soniya.parkingapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

import in.soniya.parkingapp.R;

public class Detail_page extends AppCompatActivity {
    TextView Slot_id,vehicle_id,Time,Phone_No;
    Button pay_now,qrcode;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        Slot_id = findViewById(R.id.Slot_id);
        vehicle_id = findViewById(R.id.vehicle_id);
        Time = findViewById(R.id.Time);
        Phone_No = findViewById(R.id.Phone_No);

        pay_now = findViewById(R.id.pay_now);
        qrcode = findViewById(R.id.qrcode);
        db = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();

        DocumentReference contactListener = db.collection("Book").document("Contacts");
        contactListener.addSnapshotListener(new EventListener<DocumentSnapshot>() {





            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                assert documentSnapshot != null;

                Slot_id.setText(documentSnapshot.getString("Slot"));
                vehicle_id.setText(documentSnapshot.getString("Vehicle"));
                Time.setText(documentSnapshot.getString("Time"));
                Phone_No.setText(documentSnapshot.getString("Phone"));

            }
        });


        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qrAct = new Intent(Detail_page.this,QrActivity.class);
                startActivity(qrAct);
                finish();
            }
        });


        pay_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay_now = new Intent(Detail_page.this,payment_page.class);
                startActivity(pay_now);
                finish();
            }
        });


    }
}