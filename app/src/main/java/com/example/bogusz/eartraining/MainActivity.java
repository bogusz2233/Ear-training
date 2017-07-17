package com.example.bogusz.eartraining;


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

}
