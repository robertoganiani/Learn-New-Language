package com.example.robert.learnnewlanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by rob on 12/20/16.
 */


public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorsToLearn = new ArrayList<Word>();

        colorsToLearn.add(new Word("Father", "Отец", R.drawable.family_father));
        colorsToLearn.add(new Word("Mother", "Мать", R.drawable.family_mother));
        colorsToLearn.add(new Word("Son", "Сын", R.drawable.family_son));
        colorsToLearn.add(new Word("Daughter", "Дочь", R.drawable.family_daughter));
        colorsToLearn.add(new Word("Brother", "Брат", R.drawable.family_younger_brother));
        colorsToLearn.add(new Word("Sister", "Сестра", R.drawable.family_daughter));
        colorsToLearn.add(new Word("GrandMother", "Бабушка", R.drawable.family_grandmother));
        colorsToLearn.add(new Word("Grandfather", "Дедушка", R.drawable.family_grandfather));
        colorsToLearn.add(new Word("Uncle", "Дядя", R.drawable.family_older_brother));
        colorsToLearn.add(new Word("Aunt", "Тётя", R.drawable.family_mother));
        colorsToLearn.add(new Word("Cousin", "Двоюродный брат/сестра", R.drawable.family_older_brother));
        colorsToLearn.add(new Word("Grandson", "Внук", R.drawable.family_younger_brother));
        colorsToLearn.add(new Word("Granddaughter", "Внучка", R.drawable.family_daughter));
        colorsToLearn.add(new Word("Husband", "Муж", R.drawable.family_father));
        colorsToLearn.add(new Word("Wife", "Жена", R.drawable.family_mother));
        colorsToLearn.add(new Word("Parents", "Родители", R.drawable.family_grandfather));
        colorsToLearn.add(new Word("Relatives", "Родственники", R.drawable.family_younger_sister));
        colorsToLearn.add(new Word("Bride", "Невеста", R.drawable.family_older_sister));
        colorsToLearn.add(new Word("Groom", "Жених", R.drawable.family_older_brother));
        colorsToLearn.add(new Word("Marriage", "Брак", R.drawable.family_father));

        WordAdapter adapter = new WordAdapter(this, colorsToLearn, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(adapter);

    }
}
