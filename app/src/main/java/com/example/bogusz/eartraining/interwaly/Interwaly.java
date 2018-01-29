package com.example.bogusz.eartraining.interwaly;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.bogusz.eartraining.Constants;
import com.example.bogusz.eartraining.R;
import com.example.bogusz.eartraining.database.CardQuest;
import com.example.bogusz.eartraining.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogusz on 03.09.17.
 */

public class Interwaly extends AppCompatActivity {

    //GUI
    ViewPager viewPagerChose;
    ImageView choseIcon;

    FragmentQuestAdapter adapter;
    List<FragmentQuest> questList;

    //database fields
    private DatabaseHelper myDBHelper;
    private List<CardQuest> cardQuestList;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chose_activity);

        databaseLoading();
        questList = new ArrayList<>();

        for (int i = 0; i < cardQuestList.size(); i++) {
            questList.add(new FragmentQuest(cardQuestList.get(i).getButton(),
                    cardQuestList.get(i).getContent(),
                    cardQuestList.get(i).getTitle()));

        }


        adapter = new FragmentQuestAdapter(getSupportFragmentManager(),  questList);
        FragmentQuest fQ = (FragmentQuest) adapter.getItem(2);
        // GUI init
        viewPagerChose = (ViewPager) findViewById(R.id.viewPagerChose);
        choseIcon = (ImageView) findViewById(R.id.choseIcon);

        //setting image on topside
        choseIcon.setImageResource(getIntent().getIntExtra(Constants.NAME_IMAGE,0));

        //setting viewPager
        viewPagerChose.setPageTransformer(true, new FragmentQuest.CubeOutTransformer());
        viewPagerChose.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void databaseLoading(){
        cardQuestList = new ArrayList<>();
        myDBHelper = new DatabaseHelper(this);
        cardQuestList = myDBHelper.getAllCards();
    }



}
