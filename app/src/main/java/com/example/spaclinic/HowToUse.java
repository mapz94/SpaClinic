package com.example.spaclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class HowToUse extends AppCompatActivity {

    private VideoView vv;
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);

        goBackButton = findViewById(R.id.goback);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vv.stopPlayback();
                Intent i = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(i);
            }
        });

        vv = (VideoView) findViewById(R.id.videoView);
        vv.setVideoURI(Uri.parse("rtsp://v6.cache4.c.youtube.com/CigLENy73wIaHwmh5W2TKCuN2RMYDSANFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp"));

        MediaController mediaController = new MediaController(this);
        vv.setMediaController(mediaController);
        mediaController.setAnchorView(vv);

        vv.setMediaController(new MediaController(this));
        vv.requestFocus();
        vv.start();

    }

}