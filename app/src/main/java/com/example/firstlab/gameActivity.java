package com.example.firstlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class gameActivity extends AppCompatActivity {
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


    int player = 0;
    int robot = 0;
    public void onButtonClick(View v){
        TextView firstScore = (TextView)findViewById(R.id.playerScore);
        TextView secondScore = (TextView)findViewById(R.id.robotScore);
        player +=  random.nextInt(6) + 1;
        robot +=  random.nextInt(6) + 1;
        firstScore.setText(String.valueOf(player));
        secondScore.setText(String.valueOf(robot));
        if(player >=100 && robot<100){
            Intent winIntent = new Intent(getApplicationContext(), winActivity.class);
            startActivity(winIntent);
        }
        else {
            if(robot >=100 && player<100){
                Intent loseIntent = new Intent(getApplicationContext(), loseActivity.class);
                startActivity(loseIntent);
            } else{
                if(robot >=100 && player>=100){
                    Intent drawIntent = new Intent(getApplicationContext(), drawActivity.class);
                    startActivity(drawIntent);
                }
            }

        }
    }


}
