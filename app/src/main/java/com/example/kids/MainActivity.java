package com.example.kids;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Btn_feed,Btn_play;
    private TextView stage,Score;
    private ImageView ImgChange;
    private int FeedCount = 0,StageCount = 1,Currentcount = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_feed = findViewById(R.id.Btn_feed);
        Btn_play = findViewById(R.id.Btn_play);
        stage = findViewById(R.id.stage);
        Score = findViewById(R.id.Score);
        ImgChange = findViewById(R.id.ImgChange);

        functioneventclick();
    }

    private void functioneventclick(){
        Btn_play.setVisibility(View.GONE);
        Btn_feed.setVisibility(View.VISIBLE);
        Btn_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Currentcount < 5){
                    Currentcount++;
                    functionscorechange();
                }
                else{
                    Currentcount = 1;
                    functionscorechange();
                    functionstagechange();
                }
            }
        });
        Btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                functionplayagain();
            }
        });

    }

    private void functionscorechange(){
        FeedCount++;
        Score.setText("Total apples eaten : "+FeedCount);
    }

    private void functionstagechange(){
        StageCount++;
        stage.setText("Stage "+StageCount);
        functionimgchange();
    }

    private void functionimgchange(){
        if(StageCount == 1){
            ImgChange.setImageResource(R.drawable.group84);
        }
        else if(StageCount == 2){
            ImgChange.setImageResource(R.drawable.group85);
        }
        else if(StageCount == 3){
            ImgChange.setImageResource(R.drawable.group86);
        }
        else if(StageCount == 4){
            ImgChange.setImageResource(R.drawable.group88);
        }
        else if(StageCount == 5){
            ImgChange.setImageResource(R.drawable.group89);
            functionchangeevent();
        }
    }

    private void functionchangeevent(){
        Btn_feed.setEnabled(false);
        Btn_play.setEnabled(true);
        Btn_feed.setVisibility(View.GONE);
        Btn_play.setVisibility(View.VISIBLE);
        customalert();
    }

    private void functionplayagain(){
        FeedCount = 0;
        StageCount = 1;
        Currentcount = 1;
        Score.setText("Total apples eaten : "+FeedCount);
        stage.setText("Stage "+StageCount);
        ImgChange.setImageResource(R.drawable.group84);

        Btn_feed.setEnabled(true);
        Btn_play.setEnabled(false);
        Btn_feed.setVisibility(View.VISIBLE);
        Btn_play.setVisibility(View.GONE);

    }

    private void customalert() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.CustomAlertDialog);
        LayoutInflater inflateview = LayoutInflater.from(MainActivity.this);
        final View view = inflateview.inflate(R.layout.customview, null);
        final Button buttonOk = view.findViewById(R.id.buttonOk);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.hide();
            }
        });
    }
}