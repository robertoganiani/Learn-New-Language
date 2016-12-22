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


public class NumbersActivity extends AppCompatActivity {

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

        final ArrayList<Word> numbersToLearn = new ArrayList<Word>();
        numbersToLearn.add(new Word("One", "Один", R.drawable.number_one, R.raw.number_one));
        numbersToLearn.add(new Word("Two", "Два", R.drawable.number_two, R.raw.number_two));
        numbersToLearn.add(new Word("Three", "Три", R.drawable.number_three, R.raw.number_three));
        numbersToLearn.add(new Word("Four", "Четыре", R.drawable.number_four, R.raw.number_four));
        numbersToLearn.add(new Word("Five", "Пять", R.drawable.number_five, R.raw.number_five));
        numbersToLearn.add(new Word("Six", "Шесть", R.drawable.number_six, R.raw.number_six));
        numbersToLearn.add(new Word("Seven", "Семь", R.drawable.number_seven, R.raw.number_seven));
        numbersToLearn.add(new Word("Eight", "Восемь", R.drawable.number_eight, R.raw.number_eight));
        numbersToLearn.add(new Word("Nine", "Девять", R.drawable.number_nine, R.raw.number_nine));
        numbersToLearn.add(new Word("Ten", "Десять", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, numbersToLearn, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = numbersToLearn.get(position);
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
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
