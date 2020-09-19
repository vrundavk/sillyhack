package com.example.siddu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddu.Model.Notes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class StartActivity extends AppCompatActivity {
private TextView displayNote,displayTitle;
private ImageView displayPic,backit;
private String noteId="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
noteId=getIntent().getStringExtra("pid");

        displayNote=(TextView)findViewById(R.id.bye);
                displayTitle=findViewById(R.id.hi);
                        displayPic=findViewById(R.id.displayPicture);
                        backit=(ImageView)findViewById(R.id.back);
getNotes(noteId);
                        backit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(StartActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
    }

    private void getNotes(String noteId) {
        DatabaseReference productsRef= FirebaseDatabase.getInstance().getReference().child("Notes");
productsRef.child(noteId).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()){
            Notes notes=dataSnapshot.getValue(Notes.class);
            displayNote.setText(notes.getNote());
            displayTitle.setText(notes.getNotetitle());

            Picasso.get().load(notes.getImage()).into(displayPic);
    }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
    }
}
