package com.example.robert.learnnewlanguage;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by rob on 12/20/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        Word currentWord = getItem(position);

        TextView russianWordTextView = (TextView) listItemView.findViewById(R.id.russian_text_view);
        russianWordTextView.setText(currentWord.getmRussianVersion());

        TextView englishWordTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        englishWordTextView.setText(currentWord.getmEnglishVersion());

        return listItemView;
    }

}
