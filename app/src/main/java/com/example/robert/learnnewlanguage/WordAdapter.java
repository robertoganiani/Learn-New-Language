package com.example.robert.learnnewlanguage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by rob on 12/20/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private Context mContext;
    private int mLayoutResourceId;
    private Word mData[];

    public WordAdapter(Context context, int resource, Word[] data) {
        super(context, resource, data);

        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Nullable
    @Override
    public Word getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mLayoutResourceId, parent, false);

        TextView englishTextView = (TextView) convertView.findViewById(R.id.english_text_view);
        TextView russianTextView = (TextView) convertView.findViewById(R.id.russian_text_view);

        Word word = mData[position];

        englishTextView.setText(word.getmEnglishVersion());
        russianTextView.setText(word.getmRussianVersion());

        return convertView;
    }
}
