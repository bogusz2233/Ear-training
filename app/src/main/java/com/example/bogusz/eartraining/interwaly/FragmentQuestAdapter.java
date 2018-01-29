package com.example.bogusz.eartraining.interwaly;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by bogusz on 06.09.17.
 */

public class FragmentQuestAdapter extends FragmentPagerAdapter {

    private List<FragmentQuest> quests;

    public FragmentQuestAdapter(FragmentManager fm, List<FragmentQuest> quests) {
        super(fm);
        this.quests = quests;
    }

    @Override
    public Fragment getItem(int position) {
        return quests.get(position);
    }

    @Override
    public int getCount() {
        return quests.size();
    }
}
