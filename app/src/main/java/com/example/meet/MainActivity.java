package com.example.meet;

import android.content.res.AssetFileDescriptor;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;

import com.example.framework.base.BaseUIActivity;
import com.example.framework.manager.MediaPlayerManager;

public class MainActivity extends BaseUIActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final MediaPlayerManager mediaPlayerManager = new MediaPlayerManager();
        mediaPlayerManager.setOnProgressListener(new MediaPlayerManager.OnMusicProgressListener() {
            @Override
            public void onProgress(int progress, int pos) {

            }
        });

    }
}
