package com.example.robert.learnnewlanguage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by rob on 12/20/16.
 */


public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorsToLearn = new ArrayList<Word>();

        colorsToLearn.add(new Word("What's your name?", "Как тебя зовут?"));
        colorsToLearn.add(new Word("Where are you from?", "Oткуда ты?"));
        colorsToLearn.add(new Word("Pleased to meet you", "Приятно познакомиться"));
        colorsToLearn.add(new Word("Good morning", "Доброе утро!"));
        colorsToLearn.add(new Word("Good afternoon", "Добрый день!"));
        colorsToLearn.add(new Word("Good evening", "Добрый вечер!"));
        colorsToLearn.add(new Word("Good night", "Спокойной ночи!"));
        colorsToLearn.add(new Word("Cheers! Good Health!", "Будем здоровы!"));
        colorsToLearn.add(new Word("Have a nice day", "Хорошего дня!"));
        colorsToLearn.add(new Word("Have a nice meal", "Приятного аппетита!"));
        colorsToLearn.add(new Word("Have a good journey", "Счастливого пути!"));
        colorsToLearn.add(new Word("Please speak more slowly", "Вы не могли бы говорить помедленнее?"));
        colorsToLearn.add(new Word("Please say that again", "Повторите, пожалуйста"));
        colorsToLearn.add(new Word("Please write it down", "Запишите, пожалуйста"));
        colorsToLearn.add(new Word("Where's the toilet?", "Где находится туалет?"));
        colorsToLearn.add(new Word("Do you come here often?", "Ты сюда часто приходишь?"));
        colorsToLearn.add(new Word("Good luck", "Удачи!"));
        colorsToLearn.add(new Word("Maybe", "Может быть"));
        colorsToLearn.add(new Word("Do you speak English?", "Вы говорите по-английски?"));
        colorsToLearn.add(new Word("How do you say ... in Russian?", "Как сказать ... по-русски?"));

        WordAdapter adapter = new WordAdapter(this, colorsToLearn, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.word_list);
        listView.setAdapter(adapter);

    }
}
