package com.example.rpc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rock, paper, scissor;
    TextView score;
    ImageView compchoice, humchoice;

    int HumanScore, ComputerScore;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paper = (Button) findViewById(R.id.paper);
        scissor = (Button) findViewById(R.id.scissor);
        rock = (Button) findViewById(R.id.rock);

        compchoice = (ImageView) findViewById(R.id.compchoice);
        humchoice = (ImageView) findViewById(R.id.humchoice);

        score = (TextView) findViewById(R.id.score);

        paper.setOnClickListener(view -> {
            humchoice.setImageResource(R.drawable.paper);
            String message = play_turn("paper");
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            score.setText("Human: "+ HumanScore + " Computer: "+ ComputerScore);

        });
        scissor.setOnClickListener(view -> {
            humchoice.setImageResource(R.drawable.scissor);
            String message = play_turn("scissor");
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            score.setText("Human: "+ HumanScore + " Computer: "+ ComputerScore);

        });
        rock.setOnClickListener(view -> {
            humchoice.setImageResource(R.drawable.rock);
            String message = play_turn("rock");
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            score.setText("Human: "+ HumanScore + " Computer: "+ ComputerScore);

        });
    }
    public String play_turn(String player_choice)
    {
        String computer_choice;
        Random r=new Random();
        int computer_choice_number = r.nextInt(3) + 1;

        if(computer_choice_number == 1)
        {
            computer_choice = "rock";
        } else
            if(computer_choice_number == 2)
        {
            computer_choice = "scissors";
        }
        else {
            computer_choice = "paper";
        }

        switch (computer_choice) {
            case "rock":
                compchoice.setImageResource(R.drawable.rock);
                break;
            case "paper":
                compchoice.setImageResource(R.drawable.paper);
                break;
        }

        if(computer_choice.equals(player_choice))
            return "Draw. Everyone lost :(";
        else if(Objects.equals(player_choice, "rock") && computer_choice.equals("paper")) {
            ComputerScore++;
            return "Who knew Paper could do that? Bye bye, Rock";
        }
        else if(Objects.equals(player_choice, "paper") && computer_choice.equals("rock")) {
            HumanScore++;
            return "Who knew Paper could do that? Bye bye, Rock";
        }
        else if(Objects.equals(player_choice, "scissor") && computer_choice.equals("paper")) {
            HumanScore++;
            return "Snip snip, paper. Scissor Wins!";
        }
        else if(Objects.equals(player_choice, "scissor") && computer_choice.equals("rock")) {
            ComputerScore++;
            return "The Rock cooked victory !! Go home, scissor";
        }
        else
            return "Wha...";

    }
}