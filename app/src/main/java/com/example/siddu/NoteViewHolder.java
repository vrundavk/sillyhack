package com.example.siddu;


import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    View nview;
    TextView textTitle, textTime;
    ImageView personPicture;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        nview=itemView;
textTime=nview.findViewById(R.id.note_title);
        textTitle=nview.findViewById(R.id.note_time);
        personPicture=nview.findViewById(R.id.user_profile_image);
    }
    public void setNoteTitle(String title){
        textTitle.setText(title);

    }
    public void setnoteTitle(String time){
        textTime.setText(time);

    }
    public void setnotePicture(String image){
        personPicture.setImageURI(Uri.parse(image));
    }
}

