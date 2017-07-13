package com.example.bogusz.eartraining;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;


public class InterwalyCwiczenie extends AppCompatActivity {

    //GUI
    ProgressBar progressBarInterwaly;
    IkonaFragment ikonaFragmentInterwaly;
    Button  buttonPlay;

    //logic
    private MediaPlayer plikMuzyczny;           // klasa do otwierania muzyki
    private boolean status_gry = false;
    private Timer timerSync;
    long delaySync;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interwaly_cwiczenie);

        // Gui init
        progressBarInterwaly = (ProgressBar) findViewById(R.id.progressBarInterwaly);
        ikonaFragmentInterwaly = (IkonaFragment) getFragmentManager().findFragmentById(R.id.ikonaFragmentInterwaly);
        buttonPlay = (Button) findViewById(R.id.buttonPlay);

        //logic value

        timerSync = new Timer();

        musicFilesInit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setUpView();
        setUpButtonPlay();
        syncTimerSetUp();
    }

    @Override
    public void finish() {
        endAction();
        super.finish();

    }


    private void musicFilesInit(){
        plikMuzyczny = MediaPlayer.create(this, R.raw.pianino);
        plikMuzyczny.setLooping(false);
    }
    private void setUpView(){
        ikonaFragmentInterwaly.zmianaObrazu(R.drawable.interwaly);
        String podpisIkony = getResources().getStringArray(R.array.podpisyIkon)[0];

        ikonaFragmentInterwaly.zmianaNapisu(podpisIkony);
    }

    private void setUpButtonPlay(){
        buttonPlay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playMusic();
                        setPasek();
                    }
                }
        );

    }

    private void playMusic(){
        if(!status_gry) {

            plikMuzyczny.start();
            buttonPlay.setText("STOP");
            status_gry =true;
        }else{

            plikMuzyczny.pause();
            buttonPlay.setText("PLAY");
            status_gry =false;
        }
    }

    private void setPasek() {

        int dlugoscPaska = plikMuzyczny.getDuration();      // get length of file
        int curentOdt = plikMuzyczny.getCurrentPosition();

        progressBarInterwaly.setMax(dlugoscPaska);
        progressBarInterwaly.setProgress(curentOdt);

    }

    private void syncTimerSetUp(){

        delaySync = 100;        // in miliseconds

        timerSync.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setPasek();
                    }
                });
            }
        }, 0, delaySync);


    }

    private void endAction(){
        // ending all of actions initialized in this activity
        plikMuzyczny.stop();
        plikMuzyczny = null;
        timerSync.cancel();
    }
}
