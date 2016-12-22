package com.example.robert.learnnewlanguage;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by rob on 12/20/16.
 */


public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colorsToLearn = new ArrayList<Word>();

        colorsToLearn.add(new Word("Red", "Красный", R.drawable.color_red, R.raw.color_red));
        colorsToLearn.add(new Word("Green", "Зеленый", R.drawable.color_green, R.raw.color_green));
        colorsToLearn.add(new Word("Brown", "Коричневый", R.drawable.color_brown, R.raw.color_brown));
        colorsToLearn.add(new Word("Gray", "Серый", R.drawable.color_gray, R.raw.color_gray));
        colorsToLearn.add(new Word("Black", "Черный", R.drawable.color_black, R.raw.color_black));
        colorsToLearn.add(new Word("White", "Белый", R.drawable.color_white, R.raw.color_white));
        colorsToLearn.add(new Word("Yellow", "Желтый", R.drawable.color_yellow, R.raw.color_yellow));
        colorsToLearn.add(new Word("Orange", "Оранжевый", R.drawable.color_orange, R.raw.color_orange));

        WordAdapter adapter = new WordAdapter(this, colorsToLearn, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = colorsToLearn.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });

    }
}
