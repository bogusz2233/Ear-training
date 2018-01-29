package com.example.bogusz.eartraining.interwaly;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bogusz.eartraining.R;

/**
 * Created by bogusz on 06.09.17.
 */

public class FragmentQuest extends Fragment {

    //GUI object
    private TextView quest_title;
    private TextView quest_content;
    private Button quest_button;

    // To carring information
    private String butString;
    private String contentString;
    private String titleString;

    private View.OnClickListener onClicker;
    public FragmentQuest(){}

    public FragmentQuest(String butString, String contentString, String titleString) {
        this.butString = butString;
        this.contentString = contentString;
        this.titleString = titleString;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quest, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        quest_button = (Button) getView().findViewById(R.id.quest_button);
        quest_title = (TextView) getView().findViewById(R.id.quest_title);
        quest_content = (TextView) getView().findViewById(R.id.quest_content);

        quest_button.setText(butString);
        quest_content.setText(contentString);
        quest_title.setText(titleString);

        if(onClicker != null) {
            quest_button.setOnClickListener(onClicker);
        }
    }

    public void changeOnclickBut(View.OnClickListener onClickListener){
        quest_button.setOnClickListener(onClickListener);
    }

    public void changeTitle(String title){
        quest_title.setText(title);
    }
    public void changeContent(String content){
        quest_content.setText(content);
    }
    public void changeButtonText(String text){ butString = text; }
    public void changeOnClick(View.OnClickListener onClicker){
        this.onClicker = onClicker;
    }

    //animation


    public static abstract class BaseTransformer implements ViewPager.PageTransformer {

        protected abstract void onTransform(View view, float position);

        @Override
        public void transformPage(View view, float position) {
            onPreTransform(view, position);
            onTransform(view, position);
            onPostTransform(view, position);
        }

        protected boolean hideOffscreenPages() {
            return true;
        }

        protected boolean isPagingEnabled() {
            return false;
        }


        protected void onPreTransform(View view, float position) {
            final float width = view.getWidth();

            view.setRotationX(0);
            view.setRotationY(0);
            view.setRotation(0);
            view.setScaleX(1);
            view.setScaleY(1);
            view.setPivotX(0);
            view.setPivotY(0);
            view.setTranslationY(0);
            view.setTranslationX(isPagingEnabled() ? 0f : -width * position);

            if (hideOffscreenPages()) {
                view.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);
            } else {
                view.setAlpha(1f);
            }
        }


        protected void onPostTransform(View view, float position) {
        }

    }

    public static class FlipHorizontalTransformer extends BaseTransformer {

        @Override
        protected void onTransform(View view, float position) {
            final float rotation = 180f * position;

            view.setVisibility(rotation > 90f || rotation < -90f ? View.INVISIBLE : View.VISIBLE);
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setRotationY(rotation);
        }

    }

    public static class CubeOutTransformer extends BaseTransformer {

        @Override
        protected void onTransform(View view, float position) {
            view.setPivotX(position < 0f ? view.getWidth() : 0f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setRotationY(90f * position);
        }

        @Override
        public boolean isPagingEnabled() {
            return true;
        }

    }
}
