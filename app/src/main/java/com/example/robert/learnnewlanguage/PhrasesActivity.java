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


public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colorsToLearn = new ArrayList<Word>();

        colorsToLearn.add(new Word("What's your name?", "Как тебя зовут?", R.raw.kak_tebia_zovut));
        colorsToLearn.add(new Word("Where are you from?", "Oткуда ты?", R.raw.otkuda_ti));
        colorsToLearn.add(new Word("Pleased to meet you", "Приятно познакомиться", R.raw.priatno_poznakomitsia));
        colorsToLearn.add(new Word("Good morning", "Доброе утро!", R.raw.dobroe_utro));
        colorsToLearn.add(new Word("Good afternoon", "Добрый день!", R.raw.dobri_den));
        colorsToLearn.add(new Word("Good evening", "Добрый вечер!", R.raw.dobri_vecher));
        colorsToLearn.add(new Word("Good night", "Спокойной ночи!", R.raw.spokoinoi_nochi));
        colorsToLearn.add(new Word("Cheers! Good Health!", "Будем здоровы!", R.raw.budem_zdorovi));
        colorsToLearn.add(new Word("Have a nice day", "Хорошего дня!", R.raw.xoroshego_dnia));
        colorsToLearn.add(new Word("Have a nice meal", "Приятного аппетита!", R.raw.priatnogo_apetita));
        colorsToLearn.add(new Word("Have a good journey", "Счастливого пути!", R.raw.schastlivogo_puti));
        colorsToLearn.add(new Word("Please speak more slowly", "Вы не могли бы говорить помедленнее?", R.raw.govorit_pomedlenee));
        colorsToLearn.add(new Word("Please say that again", "Повторите, пожалуйста", R.raw.povtorite_pojaluista));
        colorsToLearn.add(new Word("Please write it down", "Запишите, пожалуйста", R.raw.zapishite_pozhaluista));
        colorsToLearn.add(new Word("Where's the toilet?", "Где находится туалет?", R.raw.gde_naxoditsia_tualet));
        colorsToLearn.add(new Word("Do you come here often?", "Ты сюда часто приходишь?", R.raw.ti_siuda_chasto_prixodish));
        colorsToLearn.add(new Word("Good luck", "Удачи!", R.raw.udachi));
        colorsToLearn.add(new Word("Maybe", "Может быть", R.raw.mozhet_bit));
        colorsToLearn.add(new Word("Do you speak English?", "Вы говорите по-английски?", R.raw.vi_govorite_po_angliski));
        colorsToLearn.add(new Word("How do you say ... in Russian?", "Как сказать ... по-русски?", R.raw.kak_skazat_poruski));

        WordAdapter adapter = new WordAdapter(this, colorsToLearn, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = colorsToLearn.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}
