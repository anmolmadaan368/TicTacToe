package com.madaan.anmol.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player{
        one,two,No
    }

    Player currentplayer=Player.one;
    Player[] playerchoices=new Player[9];
    private boolean gameover= false;
    private Button btnreset;
    private GridLayout gridview;

    int[][] winnerRowsColoums={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        playerchoices[0]=Player.No;
//        playerchoices[1]=Player.No;
//        playerchoices[2]=Player.No;
//        playerchoices[3]=Player.No;
//        playerchoices[4]=Player.No;
//        playerchoices[5]=Player.No;
//        playerchoices[6]=Player.No;
//        playerchoices[7]=Player.No;
//        playerchoices[8]=Player.No;

        for(int i=0;i<playerchoices.length;i++){
            playerchoices[i]=Player.No;



        }

        btnreset=findViewById(R.id.btnreset);
        gridview=findViewById(R.id.gridview);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetthegame();

            }
        });
    }

    public void ImageViewIsTapped(View imageView){

        ImageView TappedImageView =(ImageView) imageView;

        int TiTag=Integer.parseInt(TappedImageView.getTag().toString());
        if(playerchoices[TiTag]==Player.No&&gameover==false) {

            TappedImageView.setTranslationX(-2000);

            playerchoices[TiTag] = currentplayer;
            if (currentplayer == Player.one) {

                TappedImageView.setImageResource(R.drawable.leopard1);
                currentplayer = Player.two;
            } else if (currentplayer == Player.two) {
                TappedImageView.setImageResource(R.drawable.lion1);
                currentplayer = Player.one;
            }
            TappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

            Toast.makeText(this, TappedImageView.getTag().toString(), Toast.LENGTH_LONG).show();

            for (int[] winnercolumns : winnerRowsColoums) {
                if (playerchoices[winnercolumns[0]] ==
                        playerchoices[winnercolumns[1]]
                        && playerchoices[winnercolumns[1]]
                        == playerchoices[winnercolumns[2]]
                        && playerchoices[winnercolumns[0]] != Player.No) {
                    btnreset.setVisibility(View.VISIBLE);
                    gameover=true;
                    String winnerofgame=" ";
                    if(currentplayer==Player.one) {
                        winnerofgame="player two";

                    }
                    else if(currentplayer==Player.two){
                        winnerofgame="player one";

                    }
                    Toast.makeText(this,winnerofgame+" is the winner",Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
    private void resetthegame(){
        for(int index=0; index<gridview.getChildCount();index++){
            ImageView imageView= (ImageView) gridview.getChildAt(index);
            imageView.setImageDrawable(null);
        }

        Player currentplayer=Player.one;
//        playerchoices[0]=Player.No;
//        playerchoices[1]=Player.No;
//        playerchoices[2]=Player.No;
//        playerchoices[3]=Player.No;
//        playerchoices[4]=Player.No;
//        playerchoices[5]=Player.No;
//        playerchoices[6]=Player.No;
//        playerchoices[7]=Player.No;
//        playerchoices[8]=Player.No;

        for(int i=0;i<playerchoices.length;i++){
            playerchoices[i]=Player.No;
        }
        gameover=false;

        btnreset.setVisibility(View.INVISIBLE);

    }

}
