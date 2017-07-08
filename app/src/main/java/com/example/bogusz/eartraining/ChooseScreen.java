package com.example.bogusz.eartraining;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class ChooseScreen extends AppCompatActivity {

    private int liczba_okien = 0;
    private String[] tagOkno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int klikniete = MainActivity.getKlikniete();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_screen);
        MainActivity.getKlikniete();

        // ustawienie podstawowe, stworzenie kart zadań
        setUpScreen(klikniete);
        setUpScrollView(klikniete);

    }


    @Override
    protected void onStart() {
        super.onStart();

        setFragmentSize();



    }

    private void setUpScreen(int klikniete){

        IkonaFragment ikonaFragment = (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragmentIkona);

        switch (klikniete){
            case 0:
                ikonaFragment.zmianaObrazu(R.drawable.interwaly);
                ikonaFragment.zmianaNapisu(R.string.interwaly);
                break;

            case 1:
                ikonaFragment.zmianaObrazu(R.drawable.trojdzwieki);
                ikonaFragment.zmianaNapisu(R.string.trojDzwieki);
                break;

            case 2:
                ikonaFragment.zmianaObrazu(R.drawable.akordy);
                ikonaFragment.zmianaNapisu(R.string.akordy);
                break;

            case 3:
                ikonaFragment.zmianaObrazu(R.drawable.rytmiczne);
                ikonaFragment.zmianaNapisu(R.string.dyktandaRytmiczne);
                break;

            case 4:
                ikonaFragment.zmianaObrazu(R.drawable.melodyczne);
                ikonaFragment.zmianaNapisu(R.string.dyktandaMelodyczne);
                break;

            case 5:
                ikonaFragment.zmianaObrazu(R.drawable.solfez);
                ikonaFragment.zmianaNapisu(R.string.solfez);
                break;
        }

    }


    private void setUpScrollView(int klikniete){
        switch (klikniete){
            case 0:
                stworzFragmentow(3);
                break;

            case 1:
                stworzFragmentow(3);
                break;

            case 2:
                stworzFragmentow(3);
                break;

            case 3:
                stworzFragmentow(3);
                break;

            case 4:
                stworzFragmentow(3);
                break;

            case 5:
                stworzFragmentow(3);
                break;
        }

    }

    private void stworzFragmentow(int liczba_fragmentow){

        //lista potrzebna do stworzenia tagów do fragmentów

        List<String> listaTagow = new ArrayList<String>();

        LinearLayout linearLayout =(LinearLayout) findViewById(R.id.kontenerZadania);

        for (int i = 0; i<liczba_fragmentow; i++ ){


            liczba_okien++;

            listaTagow.add("oknoZadan" + liczba_okien);
            KartaZadan kartaZadan = new KartaZadan();

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(linearLayout.getId(),kartaZadan,listaTagow.get(i));

            ft.commit();


        }

        // konwertuje liste do stringów żeby później móc się odnosić do konkretnego fragmentu
        tagOkno = new String[listaTagow.size()];
        listaTagow.toArray(tagOkno);
    }

    private void setFragmentSize(){

        // ta funckcja dopasowuje fragmenty do ekranu

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getFragmentManager().
                findFragmentByTag(tagOkno[0]).getView().getLayoutParams();

        params.width =(int) (metrics.widthPixels * 0.8);

        int prawy = (int) (metrics.widthPixels * 0.03);
        int lewy = (int) (metrics.widthPixels * 0.1);
        params.setMargins(lewy,params.topMargin,prawy,params.bottomMargin);

        // dopasowanie pozostały kart

        for (int i = 1; i<tagOkno.length; i++){
            LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) getFragmentManager().
                    findFragmentByTag(tagOkno[i]).getView().getLayoutParams();

            int verticalMargin = (int) (metrics.widthPixels * 0.03);

            params2.width =(int) (metrics.widthPixels * 0.8);
            if(i == (tagOkno.length - 1) ) {
                params2.setMargins(verticalMargin, params2.topMargin,  (int) (metrics.widthPixels * 0.1), params2.bottomMargin);
            }else{
                params2.setMargins(verticalMargin, params2.topMargin, verticalMargin, params2.bottomMargin);
            }
        }

    }


}
