package com.example.siddu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddu.Model.Notes;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity

{

private TextView myNOtetext;
private ImageView addNewNoteMain;
private RecyclerView mNOtesList;
    private DatabaseReference ProductsRef;
private GridLayoutManager gridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Notes");
        mNOtesList=findViewById(R.id.main_notes_list);
        gridLayoutManager=new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);

        mNOtesList.setHasFixedSize(true);
mNOtesList.setLayoutManager(gridLayoutManager);
        myNOtetext=(TextView)findViewById(R.id.textMyNotes);
        addNewNoteMain=(ImageView)findViewById(R.id.imageAddNoteMain);
        addNewNoteMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NewNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Notes> options = new FirebaseRecyclerOptions.Builder<Notes>()
                .setQuery(ProductsRef,Notes.class)
                .build();
        FirebaseRecyclerAdapter<Notes,NoteViewHolder>adapter=new FirebaseRecyclerAdapter<Notes, NoteViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int i, @NonNull final Notes notes) {
noteViewHolder.textTitle.setText(notes.getNotetitle());
noteViewHolder.textTime.setText(notes.getTime());
                Picasso.get().load(notes.getImage()).into(noteViewHolder.personPicture);
noteViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Intent intent=new Intent(MainActivity.this,StartActivity.class);
intent.putExtra("pid",notes.getPid());
startActivity(intent);
    }
});

            }

            @NonNull
            @Override
            public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_note_layout, parent, false);
                NoteViewHolder noteViewHolder = new NoteViewHolder(view);
                return noteViewHolder;
            }
        };
mNOtesList.setAdapter(adapter);
adapter.startListening();
    }



    }

