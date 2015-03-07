/**
 * AndTinder v0.1 for Android
 *
 * @Author: Enrique López Mañas <eenriquelopez@gmail.com>
 * http://www.lopez-manas.com
 *
 * TAndTinder is a native library for Android that provide a
 * Tinder card like effect. A card can be constructed using an
 * image and displayed with animation effects, dismiss-to-like
 * and dismiss-to-unlike, and use different sorting mechanisms.
 *
 * AndTinder is compatible with API Level 13 and upwards
 *
 * @copyright: Enrique López Mañas
 * @license: Apache License 2.0
 */

package com.andtinder.model;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class CardModel {

	private String   title;
	private String   description;


    private Drawable mCardImageDrawable;
	private Drawable mCardLikeImageDrawable;
	private Drawable mCardDislikeImageDrawable;
    private OnCardDimissedListener mOnCardDimissedListener = null;
    private OnCardSkipedListener mOnCardSkipedListener = null;
    private OnClickListener mOnClickListener = null;
    private int mCardId = 0;
    private int mPlayerId = 0;
    cardQuestion mCardQuestion;
    private int mImageResourceId = 0;



    int mCardStatus = 0; // 0 for neutral, 1 for yes, -1 for no

     //Iterfaces
    public interface OnCardSkipedListener {
        public void onSkip(int cardId);

    }

    public interface OnCardDimissedListener {
        public void onLike(int cardId);
        public void onDislike(int cardId);

    }

    public interface OnClickListener {
        void OnClickListener();


    }

    //CONSTRUCTOR AND METHODS
	public CardModel() {
		this(null, null, (Drawable)null,0);
	}

    public CardModel(String title, String description, int ResId,int cardNum,Activity parent) {
        this.title = title;
        this.description = description;
        this.mImageResourceId = ResId;
        this.mCardImageDrawable = parent.getResources().getDrawable(mImageResourceId);
        this.mCardId = cardNum;
        this.mCardQuestion = new cardQuestion(2,"TOTY",325);//TOTY total yards


    }

	public CardModel(String title, String description, Drawable cardImage,int cardNum) {
		this.title = title;
		this.description = description;
		this.mCardImageDrawable = cardImage;
        this.mCardId = cardNum;
	}

	public CardModel(String title, String description, Bitmap cardImage,int cardNum) {
		this.title = title;
		this.description = description;
		this.mCardImageDrawable = new BitmapDrawable(null, cardImage);
        this.mCardId = cardNum;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Drawable getCardLikeImageDrawable() {
		return mCardImageDrawable;
	}

	public void setCardLikeImageDrawable(Drawable cardLikeImageDrawable) {
		this.mCardImageDrawable = cardLikeImageDrawable;
	}

	public Drawable getCardDislikeImageDrawable() {
		return mCardImageDrawable;
	}

	public void setCardDislikeImageDrawable(Drawable cardDislikeImageDrawable) {
		this.mCardImageDrawable = cardDislikeImageDrawable;
	}


    public void setOnCardDimissedListener( OnCardDimissedListener listener ) {
        this.mOnCardDimissedListener = listener;
    }

    public OnCardDimissedListener getOnCardDimissedListener() {
       return this.mOnCardDimissedListener;
    }

    public void setOnCardSkipedListener( OnCardSkipedListener listener ) {
        this.mOnCardSkipedListener = listener;
    }
    public OnCardSkipedListener getOnCardSkipedListener() {
        return this.mOnCardSkipedListener;
    }


    public void setOnClickListener( OnClickListener listener ) {
        this.mOnClickListener = listener;
    }

    public OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }




    //Getters and setters
    public int getmCardId() {
        return mCardId;
    }

    public void setmCardId(int mCardId) {
        this.mCardId = mCardId;
    }

    public int getmPlayerId() {
        return mPlayerId;
    }

    public void setmPlayerId(int mPlayerId) {
        this.mPlayerId = mPlayerId;
    }
    public cardQuestion getCardQuestion() {
        return mCardQuestion;
    }

    public void setCardQuestion(cardQuestion cardQuestion) {
        this.mCardQuestion = cardQuestion;
    }

    public int getImageSourceResourceId(){
        return this.mImageResourceId;
    }


    public void setImageSourceResourceId(int ResId){
        this.mImageResourceId = ResId;
    }

    public int getmCardStatus() {
        return mCardStatus;
    }

    public void setmCardStatus(int mCardStatus) {
        this.mCardStatus = mCardStatus;
    }



    public Drawable getCardImageDrawable() {
        return mCardImageDrawable;
    }

    public void setCardImageDrawable(Drawable cardImageDrawable) {
        this.mCardImageDrawable = cardImageDrawable;
    }


}