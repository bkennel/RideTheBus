package bkennel.ridethebus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public CardDeck deck;
    public TextView valueView;
    public TextView suitView;
    public Button drawButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueView=(TextView) findViewById(R.id.textView);
        suitView=(TextView) findViewById(R.id.textView2);
        drawButton=(Button) findViewById(R.id.button);
        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawCard();
            }
        });

        setupDeck();
    }

    public void setupDeck(){
        deck=new CardDeck();
        deck.shuffle();
    }

    public void drawCard(){
        if(deck.getCount()<=0){
            setupDeck();
        }
        Card c=deck.draw();
        valueView.setText(Integer.toString(c.getValue()));
        suitView.setText(c.getSuit());
        setCardImage(c);

    }

    //Get corresponding image of a card
    private String getImageFilename(Card c){
        char value, suit;
        int v=c.getValue();
        switch(v){
            case 1:
                value='A';
                break;
            case 11:
                value='J';
                break;
            case 12:
                value='Q';
                break;
            case 13:
                value='K';
                break;
            default:
                value=Character.forDigit(v,10);
        }
        String s=c.getSuit();
        switch(s){
            case "SPADES":
                suit='S';
                break;
            case "HEARTS":
                suit='H';
                break;
            case "DIAMONDS":
                suit='D';
                break;
            case "CLUBS":
                suit='C';
                break;
            default:
                suit=' ';
                break;
                //throw new Exception("Invalid card type");
        }
        return ""+value+suit;
        //return new StringBuilder().append(value).append(suit).toString();
    }

    private void setCardImage(Card c){
        String filename=getImageFilename(c)+".png";
        ImageView cardView=(ImageView) findViewById(R.id.cardView1);
        //cardView.setImageDrawable(getResources().getDrawable(R.drawable.blue_back));

    }
}
