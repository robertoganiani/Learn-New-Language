package com.example.robert.learnnewlanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by rob on 12/20/16.
 */


public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbersToLearn = new ArrayList<Word>();

        numbersToLearn.add(new Word("One", "Один", R.drawable.number_one));
        numbersToLearn.add(new Word("Two", "Два", R.drawable.number_two));
        numbersToLearn.add(new Word("Three", "Три", R.drawable.number_three));
        numbersToLearn.add(new Word("Four", "Четыре", R.drawable.number_four));
        numbersToLearn.add(new Word("Five", "Пять", R.drawable.number_five));
        numbersToLearn.add(new Word("Six", "Шесть", R.drawable.number_six));
        numbersToLearn.add(new Word("Seven", "Семь", R.drawable.number_seven));
        numbersToLearn.add(new Word("Eight", "Восемь", R.drawable.number_eight));
        numbersToLearn.add(new Word("Nine", "Девять", R.drawable.number_nine));
        numbersToLearn.add(new Word("Ten", "Десять", R.drawable.number_ten));
//        numbersToLearn.add(new Word("Eleven", "Одиннадцать"));
//        numbersToLearn.add(new Word("Twelve", "Двенадцать"));
//        numbersToLearn.add(new Word("Thirteen", "Тринадцать"));
//        numbersToLearn.add(new Word("Fourteen", "Четырнадцать"));
//        numbersToLearn.add(new Word("Fifteen", "Пятнадцать"));
//        numbersToLearn.add(new Word("Sixteen", "Шестнадцать"));
//        numbersToLearn.add(new Word("Seventeen", "Семнадцать"));
//        numbersToLearn.add(new Word("Eighteen", "Восемнадцать"));
//        numbersToLearn.add(new Word("Nineteen", "Девятнадцать"));
//        numbersToLearn.add(new Word("Twenty", "Двадцать"));

        WordAdapter adapter = new WordAdapter(this, numbersToLearn, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(adapter);

    }
}
