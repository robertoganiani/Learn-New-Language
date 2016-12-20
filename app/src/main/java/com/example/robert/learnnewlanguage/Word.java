package com.example.robert.learnnewlanguage;

/**
 * Created by rob on 12/20/16.
 */

public class Word {

    private String mEnglishVersion;
    private String mRussianVersion;

    public Word(String mEnglishVersion, String mRussianVersion) {
        this.mEnglishVersion = mEnglishVersion;
        this.mRussianVersion = mRussianVersion;
    }

    public String getmEnglishVersion() {
        return mEnglishVersion;
    }

    public String getmRussianVersion() {
        return mRussianVersion;
    }
}
