package com.example.tictactoygam;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void BuClick(View view) {
        Button buSelected = (Button) view;
        int CellID = 0;
        switch (buSelected.getId()){
            case R.id.bu1:
                CellID = 1;
                break;
            case R.id.bu2:
                CellID = 2;
                break;
            case R.id.bu3:
                CellID = 3;
                break;
            case R.id.bu4:
                CellID = 4;
                break;
            case R.id.bu5:
                CellID = 5;
                break;
            case R.id.bu6:
                CellID = 6;
                break;
            case R.id.bu7:
                CellID = 7;
                break;
            case R.id.bu8:
                CellID = 8;
                break;
            case R.id.bu9:
                CellID = 9;
                break;

        }
        playGame(CellID ,buSelected);
    }
    int ActivePlayer = 1; //1 for first ,2 for second
    ArrayList<Integer> player1 = new ArrayList<>(); // hold player 1 data
    ArrayList<Integer> player2 = new ArrayList<>(); // hold player 2 data

    void playGame(int CellID , Button buSelected){
        Log.d("player : " , String.valueOf(CellID));

        if(ActivePlayer ==1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.GREEN);
            player1.add(CellID);
            ActivePlayer =2;

        }
        else if(ActivePlayer ==2){
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.BLUE);
            player2.add(CellID);
            ActivePlayer =1;
        }
        buSelected.setEnabled(false);
        CheckWinner();
    }
    // This Method For Checking All possible possibilities
    void CheckWinner(){
        int winner = -1;
        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2;
        }
        //rwo 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1;
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2;
        }
        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2;
        }
        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2;
        }
        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1;
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2;
        }
        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2;
        }
        //mix 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2;
        }
        //mix 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1;
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2;
        }

        if(winner !=-1){
            // we have winner!
            if(winner ==1){
                Toast.makeText(this, "Player 1 is winner", Toast.LENGTH_SHORT).show();
            }
            if(winner ==2){
                Toast.makeText(this, "Player 2 is winner", Toast.LENGTH_SHORT).show();
            }

        }
    }

}