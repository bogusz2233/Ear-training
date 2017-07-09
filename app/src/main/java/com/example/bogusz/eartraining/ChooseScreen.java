package com.example.bogusz.eartraining;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.DisplayMetrics;

import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class ChooseScreen extends AppCompatActivity {

    Constants.TransitionType type;                          // typ do określenia rodzaju animacji

    private int liczba_okien = 0;                           //zlicza liczbe stworzonych fragmentów
    private String[] tagOkno;                               //przechowuje tagi do określenia fragmentów

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int klikniete = MainActivity.getKlikniete();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_screen);
        MainActivity.getKlikniete();

        // ustawienie podstawowe, stworzenie kart zadań
        setUpScreen(klikniete);
        setUpScrollView(klikniete);
        // For overlap between Exiting  MainActivity.java and Entering TransitionActivity.java
        getWindow().setAllowEnterTransitionOverlap(false);
    }


    @Override
    protected void onStart() {
        super.onStart();
        setFragmentSize();

    }

    private void setUpScreen(int klikniete) {
        //wczytanie odpowiedniej grafiki i tekstu do fragmentu w górnej części ekranu

        IkonaFragment ikonaFragment = (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragmentIkona);
        String[] podpisIkony = getResources().getStringArray(R.array.podpisyIkon);


        ikonaFragment.zmianaNapisu(podpisIkony[klikniete]);

        switch (klikniete) {
            case 0:
                ikonaFragment.zmianaObrazu(R.drawable.interwaly);
                break;

            case 1:
                ikonaFragment.zmianaObrazu(R.drawable.trojdzwieki);
                break;

            case 2:
                ikonaFragment.zmianaObrazu(R.drawable.akordy);
                break;

            case 3:
                ikonaFragment.zmianaObrazu(R.drawable.rytmiczne);
                break;

            case 4:
                ikonaFragment.zmianaObrazu(R.drawable.melodyczne);
                break;

            case 5:
                ikonaFragment.zmianaObrazu(R.drawable.solfez);
                break;
        }

    }


    private void setUpScrollView(int klikniete) {
        //stworzenie odpowiedniej liczby kart zadań
        switch (klikniete) {
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

    private void stworzFragmentow(int liczba_fragmentow) {

        //lista potrzebna do stworzenia tagów do fragmentów
        // po tych tagach później bedzie możliwość odwonania sie do konkretnego elementu

        List<String> listaTagow = new ArrayList<String>();

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.kontenerZadania);

        for (int i = 0; i < liczba_fragmentow; i++) {


            liczba_okien++;

            listaTagow.add("oknoZadan" + liczba_okien);
            KartaZadan kartaZadan = new KartaZadan();

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(linearLayout.getId(), kartaZadan, listaTagow.get(i));

            ft.commit();


        }

        // konwertuje liste do stringów żeby później móc się odnosić do konkretnego fragmentu
        tagOkno = new String[listaTagow.size()];
        listaTagow.toArray(tagOkno);
    }

    private void setFragmentSize() {

        // ta funckcja dopasowuje fragmenty do ekranu danego telefonu

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        // dopasowanie pozostały kart

        for (int i = 0; i < tagOkno.length; i++) {

            int normalnyMargines = (int) (metrics.widthPixels * 0.03);
            int wiekszyMargines = (int) (metrics.widthPixels * 0.1);


            LinearLayout.LayoutParams paramKarty = (LinearLayout.LayoutParams) getFragmentManager().
                    findFragmentByTag(tagOkno[i]).getView().getLayoutParams();


            //ustawienie szerokości karty
            paramKarty.width = (int) (metrics.widthPixels * 0.8);

            //ustawienie poszczególnych akapitów

            if (i == 0) {

                // ustawienie dla pierwszej karty zadań
                paramKarty.setMargins(wiekszyMargines, paramKarty.topMargin, normalnyMargines, paramKarty.bottomMargin);

            } else if (i == (tagOkno.length - 1)) {

                //ustawienia dla ostatniej karty zadań
                paramKarty.setMargins(normalnyMargines, paramKarty.topMargin, wiekszyMargines, paramKarty.bottomMargin);

            } else {

                //ustawienia marginesów dla kart w środku
                paramKarty.setMargins(normalnyMargines, paramKarty.topMargin, normalnyMargines, paramKarty.bottomMargin);

            }


        }


    }


}
