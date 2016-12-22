package com.example.robert.learnnewlanguage;

import android.content.Context;
import android.media.AudioManager;
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


public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

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

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> colorsToLearn = new ArrayList<Word>();
        colorsToLearn.add(new Word("Father", "Отец", R.drawable.family_father, R.raw.otec));
        colorsToLearn.add(new Word("Mother", "Мать", R.drawable.family_mother, R.raw.mat));
        colorsToLearn.add(new Word("Son", "Сын", R.drawable.family_son, R.raw.sin));
        colorsToLearn.add(new Word("Daughter", "Дочь", R.drawable.family_daughter, R.raw.doch));
        colorsToLearn.add(new Word("Brother", "Брат", R.drawable.family_younger_brother, R.raw.brat));
        colorsToLearn.add(new Word("Sister", "Сестра", R.drawable.family_daughter, R.raw.sestra));
        colorsToLearn.add(new Word("GrandMother", "Бабушка", R.drawable.family_grandmother, R.raw.babushka));
        colorsToLearn.add(new Word("Grandfather", "Дедушка", R.drawable.family_grandfather, R.raw.dedushka));
        colorsToLearn.add(new Word("Uncle", "Дядя", R.drawable.family_older_brother, R.raw.diadia));
        colorsToLearn.add(new Word("Aunt", "Тётя", R.drawable.family_mother, R.raw.tetia));
        colorsToLearn.add(new Word("Cousin", "Двоюродный брат/сестра", R.drawable.family_older_brother, R.raw.dvoiurodnaia_setrabrat));
        colorsToLearn.add(new Word("Grandson", "Внук", R.drawable.family_younger_brother, R.raw.vnuk));
        colorsToLearn.add(new Word("Granddaughter", "Внучка", R.drawable.family_daughter, R.raw.vnuchka));
        colorsToLearn.add(new Word("Husband", "Муж", R.drawable.family_father, R.raw.muzh));
        colorsToLearn.add(new Word("Wife", "Жена", R.drawable.family_mother, R.raw.zhena));
        colorsToLearn.add(new Word("Parents", "Родители", R.drawable.family_grandfather, R.raw.roditeli));
        colorsToLearn.add(new Word("Relatives", "Родственники", R.drawable.family_younger_sister, R.raw.rodstvenniki));
        colorsToLearn.add(new Word("Bride", "Невеста", R.drawable.family_older_sister, R.raw.nevesta));
        colorsToLearn.add(new Word("Groom", "Жених", R.drawable.family_older_brother, R.raw.zhenix));
        colorsToLearn.add(new Word("Marriage", "Брак", R.drawable.family_father, R.raw.brak));

        WordAdapter adapter = new WordAdapter(this, colorsToLearn, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = colorsToLearn.get(position);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
