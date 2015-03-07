package com.andtinder.DatabaseInterface;

import com.andtinder.model.CardModel;
import com.andtinder.model.cardQuestion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Casey on 1/24/2015.
 */
public class tableCardInterface extends SQLiteOpenHelper {

    String cardTitle;
    int mCardId;
    int mPlayerId;
    cardQuestion mCardQuestion;
    int mImageSrcResourceId;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cardDB.db";
    private static final String TABLE_CARD = "TABLECARD";

    public static final String COLUMN_CARD_ID = "card_id";
    public static final String COLUMN_CARD_STATUS = "card_status";
    public static final String COLUMN_PLAYER_ID = "player_id";
    public static final String COLUMN_PTS_STAT = "points_stat";
    public static final String COLUMN_STAT_2_ABV = "stat_2_abbrv";
    public static final String COLUMN_STAT_2 = "stat_2";
    public static final String COLUMN_PIC_RES_ID = "picture_res_id";



    public tableCardInterface(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CARD_TABLE = "CREATE TABLE " +
                TABLE_CARD + "("
                + COLUMN_CARD_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_CARD_STATUS + " INTEGER,"
                + COLUMN_PLAYER_ID + " INTERGER,"
                + COLUMN_PTS_STAT + " INTERGER,"
                + COLUMN_STAT_2_ABV + " TEXT,"
                + COLUMN_STAT_2 + " INTERGER,"
                + COLUMN_PIC_RES_ID + " INTERGER"
                + ")";
        db.execSQL(CREATE_CARD_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARD);
        onCreate(db);
    }
    public void clearTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_CARD);
        onCreate(db);
    }

    public void addCard(CardModel card) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_CARD_ID, card.getmCardId());
        values.put(COLUMN_CARD_STATUS, card.getmCardStatus());
        values.put(COLUMN_PLAYER_ID, card.getmPlayerId());
        values.put(COLUMN_PTS_STAT,card.getCardQuestion().getmPointsStat());
        values.put(COLUMN_STAT_2_ABV,card.getCardQuestion().getmStat2Abbrivation());
        values.put(COLUMN_STAT_2,card.getCardQuestion().getmStat2());
        values.put(COLUMN_PIC_RES_ID, card.getImageSourceResourceId());

        SQLiteDatabase db = this.getWritableDatabase();
        long success = db.insert(TABLE_CARD, null, values);
        db.close();
    }

    public CardModel getCard(int cardId) {
        String query = "Select * FROM " + TABLE_CARD + " WHERE " + COLUMN_CARD_ID + " =  " + cardId;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        CardModel cardModel = new CardModel();

          if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            cardModel.setmCardId(cursor.getInt(0));
            cardModel.setmCardStatus(cursor.getInt(1));
            cardModel.setmPlayerId(cursor.getInt(2));
            cardQuestion cardQ = new cardQuestion(cursor.getInt(3),cursor.getString(4),cursor.getInt(5));
            cardModel.setCardQuestion(cardQ);
            cardModel.setImageSourceResourceId(cursor.getInt(6));

            cursor.close();
        } else {
            cardModel = null;
        }
        db.close();
        return cardModel;
    }
//    public tableCardInterface(CardModel cardMod){
//        mPlayerId = cardMod.getmPlayerId();
//        mCardId = cardMod.getmCardId();
//        mCardQuestion = cardMod.getCardQuestion();
//        mImageSrcResourceId = cardMod.getImageSourceResourceId();
//    }
}
