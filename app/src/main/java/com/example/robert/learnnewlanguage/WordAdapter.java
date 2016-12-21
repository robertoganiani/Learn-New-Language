package com.example.robert.learnnewlanguage;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by rob on 12/20/16.
 */


public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
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

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        /*if currentWord doesn't have image hide it*/
        if (currentWord.hasImage()) {

            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        /*set background*/
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}
