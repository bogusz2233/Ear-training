package com.example.bogusz.eartraining;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IkonaFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadPhoto();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private void loadPhoto() {


            IkonaFragment[] fragment_obj = {
                    (IkonaFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_1),
                    (IkonaFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_2),
                    (IkonaFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_3),
                    (IkonaFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_4),
                    (IkonaFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_5),
                    (IkonaFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_6),

            };

            for(int i= 0; i<6; i++) {
                ImageView imageView = (ImageView) fragment_obj[i].getView().findViewById(R.id.imageView);
                TextView textView = (TextView) fragment_obj[i].getView().findViewById(R.id.tekstIkona);

                switch (i){
                    case 0:
                        imageView.setImageResource(R.drawable.interwaly);
                        textView.setText(R.string.interwaly);
                        break;
                    case 1:
                    imageView.setImageResource(R.drawable.trojdzwieki);
                    textView.setText(R.string.trojDzwieki);
                    break;


                    case 2:
                        imageView.setImageResource(R.drawable.akordy);
                        textView.setText(R.string.akordy);
                        break;


                    case 3:
                        imageView.setImageResource(R.drawable.rytmiczne);
                        textView.setText(R.string.dyktandaRytmiczne);
                        break;


                    case 4:
                        imageView.setImageResource(R.drawable.melodyczne);
                        textView.setText(R.string.dyktandaMelodyjne);
                        break;


                    case 5:
                        imageView.setImageResource(R.drawable.solfez);
                        textView.setText(R.string.solfez);
                        break;

                }

            }


    }


}
