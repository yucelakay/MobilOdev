package com.example.animasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class fragman extends AppCompatActivity {

VideoView videoView;
MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragman);
        videoView=findViewById(R.id.vvw);
        mediaController=new MediaController(fragman.this);
        String Filmlinq= getIntent().getExtras().getString("link");
        Uri kaynak = Uri.parse(Filmlinq);
        videoView.setVideoURI(kaynak);
        videoView.start();
        videoView.setMediaController(mediaController);
    }
}