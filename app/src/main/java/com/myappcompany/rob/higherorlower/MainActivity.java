package com.myappcompany.rob.higherorlower;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    String numberOfTries = "Number of Tries";





    public void generateRandomNumber() {

        Random rand = new Random();

        randomNumber = rand.nextInt(20) + 1;

    }

    public void guess(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);

        int guessValue = Integer.parseInt(editText.getText().toString());

        String message;

        TextView newText = (TextView) findViewById(R.id.textView3);
        numberOfTries = numberOfTries + " X";
        newText.setText(numberOfTries);

        if (guessValue > randomNumber) {

            message = "Lower!";
            editText.setText("");


        } else if (guessValue < randomNumber) {

            message = "Higher!";

            editText.setText("");

        } else {

            message = "You got it! Try again!";
            editText.setText("");
            numberOfTries = "Number of Tries";
            showWinner(view);
            generateRandomNumber();



        }



        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Log.i("Entered Value", editText.getText().toString());

        Log.i("Random Number", Integer.toString(randomNumber));



    }

    public void showWinner(View view){
        final ImageView winnerView = (ImageView) findViewById(R.id.imageWinner);

        winnerView.animate().alpha(1).setDuration(2000);

        new CountDownTimer(2000,1000){
            public void onTick(long millisUnitFinished){

            }
            public void onFinish(){
                winnerView.animate().alpha(0).setDuration(2000);
            }
        }.start();
    }

    public void hideWinner(View view){
        ImageView winnerView = (ImageView) findViewById(R.id.imageWinner);

        winnerView.animate().alpha(0).setDuration(2000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();

    }
}
