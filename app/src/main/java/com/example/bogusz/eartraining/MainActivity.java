package com.example.bogusz.eartraining;


import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.TransitionRes;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionListenerAdapter;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {


    private static int klikniete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ustawienia fragmentów
        IkonaFragment[] ikonaFragments = {
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_1),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_2),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_3),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_4),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_5),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_6)

        };

        setUpFragmentow(ikonaFragments);
        setOnClickFragmentow(ikonaFragments);
    }


    private void setOnClickFragmentow(IkonaFragment[] ikonaFragments){
        // ustala w jaki sposób zachowa się aplikacja po wcisnieciu danego fragmentu

       for(int i =0; i <ikonaFragments.length; i++){
           View view = ikonaFragments[i].getView();
           view.setOnClickListener(ustawKlikniecie(i));
       }

    }


    private void setUpFragmentow(IkonaFragment[] ikonaFragments){

        String[] podpisyIkon = getResources().getStringArray(R.array.podpisyIkon);

        for(int i =0; i<ikonaFragments.length; i++){
            ikonaFragments[i].zmianaNapisu(podpisyIkon[i]);

            switch (i){
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

    }

    private View.OnClickListener  ustawKlikniecie(final int numerPrzycisku){
        View.OnClickListener  view= (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseScreen.class);
                ActivityOptionsCompat activityOptionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.fragment_6),"myFragment");
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
