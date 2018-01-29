package com.example.bogusz.eartraining;

<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.bogusz.eartraining.database.DatabaseHelper;
import com.example.bogusz.eartraining.fragments.Icon;
import com.example.bogusz.eartraining.interwaly.Interwaly;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jm.music.data.Note;
import jm.util.Write;

import static com.example.bogusz.eartraining.Constants.NAME_IMAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Icon> iconList = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    private String midNameFile;

    //Database fields
    private DatabaseHelper myDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (getResources().getConfiguration().orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_landscape);
                break;
        }
        fragmentsInit();
        addingDB(this);

        Log.d("lukasz", "onCreate");

    }

    @Override
    protected void onStart() {
        Log.d("lukasz", "onStart");
        super.onStart();
        fragmentSetting();
    }

    @Override
    protected void onRestart() {
        Log.d("lukasz", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("lukasz", "onResume");
        super.onResume();
    }

    private void fragmentsInit() {
        Log.d("lukasz", "fragmentsInit");
        // getting connecting to fragment on the layout
        iconList.add((Icon) getSupportFragmentManager().findFragmentById(R.id.fragment1));
        iconList.add((Icon) getSupportFragmentManager().findFragmentById(R.id.fragment2));
        iconList.add((Icon) getSupportFragmentManager().findFragmentById(R.id.fragment3));
        iconList.add((Icon) getSupportFragmentManager().findFragmentById(R.id.fragment4));
        iconList.add((Icon) getSupportFragmentManager().findFragmentById(R.id.fragment5));
        iconList.add((Icon) getSupportFragmentManager().findFragmentById(R.id.fragment6));
    }

    private void fragmentSetting() {
        Log.d("lukasz", "fragmentSetting");

        String[] texts = getResources().getStringArray(R.array.iconName);

        for (int i = 0; i < iconList.size(); i++) {
            iconList.get(i).changeText(texts[i]);
        }

        //setting image
        iconList.get(0).changeImage(R.drawable.interwaly);
        iconList.get(1).changeImage(R.drawable.trojdzwieki);
        iconList.get(2).changeImage(R.drawable.akordy);
        iconList.get(3).changeImage(R.drawable.rytmiczne);
        iconList.get(4).changeImage(R.drawable.melodyczne);
        iconList.get(5).changeImage(R.drawable.solfez);


        for (int i = 0; i < iconList.size(); i++) {
            iconList.get(i).getView().setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fragment1) {
            Intent intent = new Intent(MainActivity.this, Interwaly.class);
            //date to send to other window
            intent.putExtra(NAME_IMAGE,R.drawable.interwaly);
            startActivity(intent);
        } else if (view.getId() == R.id.fragment2) {

            //creating mid file to play
            midNameFile = getApplication().getCacheDir().getPath() + "/file.mid";
            Write.midi(new Note(), midNameFile);

            //getting reference to created file and next playing them
            Uri uri = Uri.parse(midNameFile);
            mediaPlayer = MediaPlayer.create(this, uri);
            mediaPlayer.start();
        }
    }

    private boolean copyDatabase(Context context) {

        try {
            InputStream inputStream= context.getAssets().open(DatabaseHelper.DB_NAME);
            String outFileName = DatabaseHelper.DB_LOCATION + DatabaseHelper.DB_NAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    void addingDB(Context context){
        //if on the device doesn't exist database, db is copying

        // asking to database
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DB_NAME);
        if(myDBHelper == null){ myDBHelper = new DatabaseHelper(context);}

        if(database.exists() == false){

            myDBHelper.getReadableDatabase();

            if(copyDatabase(context)) {
                Toast.makeText(context, "Copy database succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
=======

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    //logic value
    private static int klikniete;
    private String[] podpisyIkon;
    private String tagLog = "logAplikacji";

    //GUI - MainActivity
    private IkonaFragment[] ikonaFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(tagLog, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial fragments
        ikonaFragments = new IkonaFragment[]{
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_1),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_2),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_3),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_4),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_5),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_6)

        };
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.i(tagLog, "onStart");
        setUpFragmentow();
        setOnClickFragmentow();
    }

    private void setOnClickFragmentow() {

        Log.i(tagLog, "setOnClickFragmentow");
        // ustala w jaki sposób zachowa się aplikacja po wcisnieciu danego fragmentu

        for (int i = 0; i < ikonaFragments.length; i++) {
            View view = ikonaFragments[i].getView();
            view.setOnClickListener(ustawKlikniecie(i));
        }

        Log.i(tagLog, "before setup fragments");

    }


    private void setUpFragmentow() {

        Log.i(tagLog, "setUpFragmentow");

        // download from res value of string
        podpisyIkon = getResources().getStringArray(R.array.podpisyIkon);


        Log.i(tagLog, "before setup podpisyIkon");

        // setUp image of fragments
        for (int i = 0; i < ikonaFragments.length; i++) {

            Log.i(tagLog, "pętla for iteracja: " + i);

            ikonaFragments[i].zmianaNapisu(podpisyIkon[i]);

            Log.i(tagLog, "after zmianNapisu");

            switch (i) {
                case 0:
                    ikonaFragments[i].zmianaObrazu(R.drawable.interwaly);
                    break;

                case 1:
                    ikonaFragments[i].zmianaObrazu(R.drawable.trojdzwieki);
                    break;

                case 2:
                    ikonaFragments[i].zmianaObrazu(R.drawable.akordy);
                    break;

                case 3:
                    ikonaFragments[i].zmianaObrazu(R.drawable.rytmiczne);
                    break;

                case 4:
                    ikonaFragments[i].zmianaObrazu(R.drawable.melodyczne);
                    break;

                case 5:
                    ikonaFragments[i].zmianaObrazu(R.drawable.solfez);
                    break;
            }
        }

        Log.i(tagLog, "before setup ikony fragments");

    }

    private View.OnClickListener ustawKlikniecie(final int numerPrzycisku) {
        View.OnClickListener view = (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseScreen.class);
                ActivityOptionsCompat activityOptionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, ikonaFragments[numerPrzycisku].getView(), "myFragment");
                startActivity(intent, activityOptionsCompat.toBundle());
                setKlikniete(numerPrzycisku);
            }
        });
        return view;
    }


    public static int getKlikniete() {
        return klikniete;
    }

    private void setKlikniete(int klikniete) {
        MainActivity.klikniete = klikniete;
    }

>>>>>>> bd1924a8b3c7fd341e514602fb7d22e54048ad12
}
