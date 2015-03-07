package com.example.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.andtinder.DatabaseInterface.tableCardInterface;
import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;


public class gamePlayingActivity extends ActionBarActivity {
    int currentCardNumber = 0;


    CardContainer mCardContainer;
    SimpleCardStackAdapter mAdapterCardModel;
    tableCardInterface mTableCardInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        //Testing checking in code
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game_playing);
        mCardContainer = (CardContainer) findViewById(R.id.layoutview);
        mAdapterCardModel = new SimpleCardStackAdapter(this);
        mTableCardInterface = new tableCardInterface(this, "cardDB", null, 1);



        // SQLiteDatabase db = dbHandler.getWritableDatabase();
        for (short i = 0; i < 10; i++) {
            int resID = getResources().getIdentifier("staffordfingersup", "drawable", getPackageName());
      //      Drawable d = getResources().getDrawable(resID);
            final CardModel card = new CardModel("Card " + Integer.toString(i), "This is the description", resID, i,this);
            card.setOnClickListener(new CardModel.OnClickListener() {
                @Override
                public void OnClickListener() {
                    Log.i("Swipeable Cards", "I am pressing the card");
                }
            });

            card.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
                @Override
                public void onLike(int cardNum) {
                    card.setmCardStatus(1);
                    String progressDotViewId = "dot" + cardNum;
                    //Change image on event
                    int cardDotIdentifier = getResources().getIdentifier(progressDotViewId, "id", getPackageName());
                    ImageView dotImageView = ((ImageView) findViewById(cardDotIdentifier));
                    dotImageView.setImageResource(R.drawable.greendot);
                }

                @Override
                public void onDislike(int cardNum) {
                    card.setmCardStatus(-1);
                    String progressDotViewId = "dot" + cardNum;
                    int cardDotIdentifier = getResources().getIdentifier(progressDotViewId, "id", getPackageName());
                    ImageView dotImageView = ((ImageView) findViewById(cardDotIdentifier));
                    dotImageView.setImageResource(R.drawable.reddot);
                }
            });

            card.setOnCardSkipedListener(new CardModel.OnCardSkipedListener() {

                @Override
                public void onSkip(int cardNum) {
                    String progressDotViewId = "dot" + cardNum;
                    int cardDotIdentifier = getResources().getIdentifier(progressDotViewId, "id", getPackageName());
                    ImageView dotImageView = ((ImageView) findViewById(cardDotIdentifier));
                    dotImageView.setImageResource(R.drawable.graydot);
                }

            });

            mTableCardInterface.addCard(card);
            mAdapterCardModel.add(card);
        }
        mCardContainer.setAdapter(mAdapterCardModel);
//        Player mattStafford = new Player("Matthew", "Stafford" + Integer.toString(1));
//        Card mattStaffordCard = new Card(mattStafford, 1, "Matthew Stafford throws for more than 275 yards passing at home Sunday against the Packers", "staffordfingersup");
//        deckOfCards.addCard(mattStaffordCard);

//        for(int i = 0; i < 10;i++){
//            deckOfCards.addCard(new Card(new Player("Matthew","Stafford" + Integer.toString(i)),i,"Matthew Stafford throws for more than 275 yards passing at home Sunday against the Packers","staffordfrontface"));
//        }
       CardModel cardMod =  mTableCardInterface.getCard(1);



    }

    public void cardClicked(View view) {
        View v = view;
        CardModel cm = mTableCardInterface.getCard(1);
    }

    public void noClicked(View view) {
        int cardNumberClicked = currentCardNumber;
        View v = view;

    }

    public void yesClicked(View view) {
        int cardNumberClicked = currentCardNumber;
        View v = view;

    }

    public void skipButtonClicked(View view) {
        View v = view;
        // CardModel cardSkiped = mCardContainer.getCurrentCard();
        mCardContainer.skipButtonClickedOn();//Removes the card from layou
        //   mAdapterCardModel.topToBottom();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_playing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
