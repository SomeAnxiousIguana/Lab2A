package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    Button rock,paper,scissors;
    TextView Score;
    ImageView HC, CC;
    int HS, CS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock = (Button) findViewById(R.id.rock);
        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);

        CC = (ImageView) findViewById(R.id.CC);
        HC = (ImageView) findViewById(R.id.PC);

        Score = (TextView) findViewById(R.id.Score);


        rock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                HC.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Score.setText("Score: You - " + Integer.toString(HS) + " / Computer - " + Integer.toString(CS));
            }
        });

        paper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                HC.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Score.setText("Score: You - " + Integer.toString(HS) + " / Computer - " + Integer.toString(CS));
            }
        });

        scissors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                HC.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Score.setText("Score: You - " + Integer.toString(HS) + " / Computer - " + Integer.toString(CS));
            }
        });
    }



    public String play_turn( String player_choice) {

        String CompC= "";
        Random r = new Random();

        int CompC_Number = r.nextInt(3) + 1;

        if (CompC_Number == 1){
            CompC = "Rock";
        } else
        if (CompC_Number == 2){
            CompC = "Paper";
        } else
        if (CompC_Number == 3){
            CompC = "Scissors";
        }



        if (CompC == "Rock"){
            CC.setImageResource(R.drawable.rock);
        }else
        if (CompC == "Paper"){
            CC.setImageResource(R.drawable.paper);
        }else
        if (CompC == "Scissors"){
            CC.setImageResource(R.drawable.scissors);
        }



       // if (CompC == player_choice){
         //   return "Draw. Nobody won.";
        //}
        //else
            if (player_choice == "paper" && CompC_Number == 3){
            CS++;
            return "Scissors cuts paper. Computer win!";
        }
        else if (player_choice == "rock" && CompC_Number == 2){
            CS++;
            return "Paper covers rock. Computer wins!";
        }
        else if (player_choice == "scissors" && CompC_Number == 1){
            CS++;
            return "Rock crushes scissors. Computer wins!";
        }
        else if (player_choice == "scissors" && CompC_Number == 2){
            HS++;
            return "Scissors cuts paper. You win!";
        }
        else if (player_choice == "paper" && CompC_Number == 1){
            HS++;
            return "Paper covers rock. You win!";
        }
        else if (player_choice == "rock" && CompC_Number == 3){
            HS++;
            return "Rock crushes scissors. You win!";
        }
        else return "Draw. Nobody won.";
    }
}