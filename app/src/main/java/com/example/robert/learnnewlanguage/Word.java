package com.example.robert.learnnewlanguage;


/**
 * Created by rob on 12/20/16.
 */


public class Word {

    private String mEnglishVersion;
    private String mRussianVersion;
    private int mImageResourceId = NO_IMAGE;

    private static final int NO_IMAGE = -1;

    public Word(String mEnglishVersion, String mRussianVersion) {
        this.mEnglishVersion = mEnglishVersion;
        this.mRussianVersion = mRussianVersion;
    }

    public Word(String mEnglishVersion, String mRussianVersion, int mImageResourceId) {
        this.mEnglishVersion = mEnglishVersion;
        this.mRussianVersion = mRussianVersion;
        this.mImageResourceId = mImageResourceId;
    }

    public String getmEnglishVersion() {
        return mEnglishVersion;
    }

    public String getmRussianVersion() {
        return mRussianVersion;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE;
    }

}
