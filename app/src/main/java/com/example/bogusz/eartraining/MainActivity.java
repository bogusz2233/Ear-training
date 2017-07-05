package com.example.bogusz.eartraining;




import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private float xDpi;
    private float yDpi;
    private static int klikniete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        xDpi = dm.xdpi;
        yDpi = dm.ydpi;


        ImageView glowneLogo =(ImageView) findViewById(R.id.imageView2);

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
        View[] views ={
                ikonaFragments[0].getView(),
                ikonaFragments[1].getView(),
                ikonaFragments[2].getView(),
                ikonaFragments[3].getView(),
                ikonaFragments[4].getView(),
                ikonaFragments[5].getView(),
        };

        views[0].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ChooseScreen.class);
                        ActivityOptionsCompat activityOptionsCompat =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.fragment_1),"myFragment");
                        startActivity(intent, activityOptionsCompat.toBundle());

                        setKlikniete(0);
                    }
                }
        );

        views[1].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ChooseScreen.class);
                        ActivityOptionsCompat activityOptionsCompat =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.fragment_2),"myFragment");
                        startActivity(intent, activityOptionsCompat.toBundle());
                        setKlikniete(1);
                    }
                }
        );

        views[2].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ChooseScreen.class);
                        ActivityOptionsCompat activityOptionsCompat =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.fragment_3),"myFragment");
                        startActivity(intent, activityOptionsCompat.toBundle());

                        setKlikniete(2);
                    }
                }
        );

        views[3].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ChooseScreen.class);


                        ActivityOptionsCompat activityOptionsCompat =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.fragment_4),"myFragment");
                        startActivity(intent, activityOptionsCompat.toBundle());

                        setKlikniete(3);
                    }
                }
        );

        views[4].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ChooseScreen.class);
                        ActivityOptionsCompat activityOptionsCompat =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.fragment_5),"myFragment");
                        startActivity(intent, activityOptionsCompat.toBundle());

                        setKlikniete(4);
                    }
                }
        );

        views[5].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ChooseScreen.class);
                        ActivityOptionsCompat activityOptionsCompat =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.fragment_6),"myFragment");
                        startActivity(intent, activityOptionsCompat.toBundle());
                        setKlikniete(5);
                    }
                }
        );

    }


    private void setUpFragmentow(IkonaFragment[] ikonaFragments){
        for(int i = 0; i<6; i++){
            View view = ikonaFragments[i].getView();
            TextView textView = ikonaFragments[i].getView().findViewById(R.id.tekstIkona);



            switch (i){
                case 0:
                    ikonaFragments[i].zmianaObrazu(R.drawable.interwaly);
                    ikonaFragments[i].zmianaNapisu(R.string.interwaly);
                    break;

                case 1:
                    ikonaFragments[i].zmianaObrazu(R.drawable.trojdzwieki);
                    ikonaFragments[i].zmianaNapisu(R.string.trojDzwieki);
                    break;

                case 2:
                    ikonaFragments[i].zmianaObrazu(R.drawable.akordy);
                    ikonaFragments[i].zmianaNapisu(R.string.akordy);
                    break;

                case 3:
                    ikonaFragments[i].zmianaObrazu(R.drawable.rytmiczne);
                    ikonaFragments[i].zmianaNapisu(R.string.dyktandaRytmiczne);
                    break;

                case 4:
                    ikonaFragments[i].zmianaObrazu(R.drawable.melodyczne);
                    ikonaFragments[i].zmianaNapisu(R.string.dyktandaMelodyczne);
                    break;

                case 5:
                    ikonaFragments[i].zmianaObrazu(R.drawable.solfez);
                    ikonaFragments[i].zmianaNapisu(R.string.solfez);
                    break;
            }
        }

    }

    public static int getKlikniete() {
        return klikniete;
    }

    private static void setKlikniete(int klikniete) {
        MainActivity.klikniete = klikniete;
    }
}
