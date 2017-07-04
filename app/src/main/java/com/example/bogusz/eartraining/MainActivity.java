package com.example.bogusz.eartraining;




import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private float xDpi;
    private float yDpi;


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
        for(int i = 0; i<6; i++) {

                    View view = ikonaFragments[i].getView();
                    view.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    TextView textView = view.findViewById(R.id.tekstIkona);
                                    textView.setText("x = " + xDpi + "  y = " + yDpi);
                                }
                            });

        }

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



}
