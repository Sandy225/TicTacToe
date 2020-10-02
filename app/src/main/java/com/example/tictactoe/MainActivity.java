package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    //Player Presentation
    // 0 - x
    //1 - 0
    int activePlayer = 0;
    int[] GameState={2, 2, 2, 2, 2, 2, 2, 2, 2};
    // state meanings:
    // 0- x
    // 1- 0
    // 2- Null
    int[][] winPositions={{1,2,3},{4,5,6},{7,8,9},
                            {1,4,7},{2,5,8,},{3,6,9},
                            {1,5,9},{3,5,7}
                        };
    public void playerTab(View view){
        ImageView img = (ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if (!gameActive){
            gameReset(view);
        }
        if (GameState[tappedImage] == 2){
            GameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0){
                img.setImageResource(R.drawable.xs);
                activePlayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("O's turn - Tab To Play");
            }
            else{
                img.setImageResource(R.drawable.o2);
                activePlayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's turn - Tab To Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        //check if any player has won
        for(int[] winPosition: winPositions){
            if (GameState[winPosition[0]] == GameState[winPosition[1]] &&
                    GameState[winPosition[1]] == GameState[winPosition[2]] && GameState[winPosition[0]] !=2){
                //some body has won-Find out Who!
                String winnerStr;
                gameActive=false;
                if(GameState[winPosition[0]] == 0){
                    winnerStr = "X has won";
                }
                else {
                    winnerStr = "O has won";
                }
                // Update the status bar for winner Announcement

                TextView status=findViewById(R.id.status);
                status.setText(winnerStr);
            }

        }
    }
    public  void  gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for (int i=0; i<GameState.length; i++){
            GameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("X's turn - Tab To Play");

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
