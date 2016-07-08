package com.gaojunhui.day7_2video;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.VideoView;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.bt_play)
    Button btPlay;
    @InjectView(R.id.surfaceView)
    MyVideoSurface surfaceView;
    VideoView videoView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
    MediaPlayer player;
    @OnClick(R.id.bt_play)
    public void onClick() {
        player=new MediaPlayer();
        player.reset();
        player.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                return false;
            }
        });
        try {
            player.setDataSource(getApplicationContext(), Uri.parse("http://flv2.bn.netease.com/videolib3/1607/01/tUvhJ4911/HD/tUvhJ4911-mobile.mp4"));
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDisplay(surfaceView.getHolder());
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                          surfaceView.setmVideoWidthHeight(player.getVideoWidth(),player.getVideoHeight());
                        }
                    },5000);
                }
            });
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
