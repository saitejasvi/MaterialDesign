package com.example.bharti.materialdesign;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

public class MusicService extends Service {
    public MusicService() {
    }

    MediaPlayer mediaPlayer;
    Boolean flag = false;
    int length;

    @Override
    public IBinder onBind(Intent intent) {


                return null;}
    @Override
    public void onCreate(){
        super.onCreate();
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.sia);
            mediaPlayer.start();
        }


    }
 @Override
    public int onStartCommand(Intent intent, int flag1, int stdID){

     if (flag == true) {
         mediaPlayer.pause();
         length = mediaPlayer.getCurrentPosition();
         try {
             mediaPlayer.prepare();
         } catch (IllegalStateException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         mediaPlayer.seekTo(0);
         flag = false;
     } else if (flag == false) {
         mediaPlayer.seekTo(length);
         mediaPlayer.start();
         flag = true;
     }

      return Service.START_NOT_STICKY;
    }
    @Override
    public void onDestroy(){
        mediaPlayer.stop();    }
}
