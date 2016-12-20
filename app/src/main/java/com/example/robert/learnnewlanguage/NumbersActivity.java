package com.example.robert.learnnewlanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        List<Word> numbersToLearn = new ArrayList<Word>();

        numbersToLearn.add(new Word("One", "Один"));
        numbersToLearn.add(new Word("Two", "Два"));
        numbersToLearn.add(new Word("Three", "Три"));
        numbersToLearn.add(new Word("Four", "Четыре"));
        numbersToLearn.add(new Word("Five", "Пять"));
        numbersToLearn.add(new Word("Six", "Шесть"));
        numbersToLearn.add(new Word("Seven", "Семь"));
        numbersToLearn.add(new Word("Eight", "Восемь"));
        numbersToLearn.add(new Word("Nine", "Девять"));
        numbersToLearn.add(new Word("Ten", "Десять"));
        numbersToLearn.add(new Word("Eleven", "Одиннадцать"));
        numbersToLearn.add(new Word("Twelve", "Двенадцать"));
        numbersToLearn.add(new Word("Thirteen", "Тринадцать"));
        numbersToLearn.add(new Word("Fourteen", "Четырнадцать"));
        numbersToLearn.add(new Word("Fifteen", "Пятнадцать"));
        numbersToLearn.add(new Word("Sixteen", "Шестнадцать"));
        numbersToLearn.add(new Word("Seventeen", "Семнадцать"));
        numbersToLearn.add(new Word("Eighteen", "Восемнадцать"));
        numbersToLearn.add(new Word("Nineteen", "Девятнадцать"));
        numbersToLearn.add(new Word("Twenty", "Двадцать"));

        WordAdapter<Word> adapter = new WordAdapter(this, R.layout.list_item, numbersToLearn);
        ListView listView = (ListView) findViewById(R.id.numbers_list);
        listView.setAdapter(adapter);

    }
}
