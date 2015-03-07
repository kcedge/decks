package com.andtinder.model;

/**
 * Created by Casey on 1/24/2015.
 */
public class cardQuestion {


    private int mPointsStat;
    private int mStat2;

    String mStat2Abbrivation;

    public cardQuestion(int points, String stat2Abrv, int s2){
        mPointsStat = points;
        mStat2 = s2;
        mStat2Abbrivation = stat2Abrv;
    }

    public int getmPointsStat() {
        return mPointsStat;
    }

    public void setmPointsStat(int mPointsStat) {
        this.mPointsStat = mPointsStat;
    }

    public int getmStat2() {
        return mStat2;
    }

    public void setmStat2(int mStat2) {
        this.mStat2 = mStat2;
    }
    public String getmStat2Abbrivation() {
        return mStat2Abbrivation;
    }

    public void setmStat2Abbrivation(String mStat2Abbrivation) {
        this.mStat2Abbrivation = mStat2Abbrivation;
    }
}
