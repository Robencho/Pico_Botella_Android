package com.example.rubio.picobotella;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView botella;
    Button lanzar;
    Random rand;
    int agle;
    boolean restart = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand = new Random();
        botella = (ImageView)findViewById(R.id.botella);
        lanzar = (Button)findViewById(R.id.lanzar);

        lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(restart){
                    agle = agle % 360;
                    RotateAnimation rotate = new RotateAnimation(agle, 360,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f,
                            RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(360);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                    botella.startAnimation(rotate);
                    lanzar.setText("GO");
                    restart = false;
                }else{
                    agle = rand.nextInt(3600) + 360;
                    RotateAnimation rotate = new RotateAnimation(0, agle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(3600);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                    botella.startAnimation(rotate);
                    restart = true;
                    lanzar.setText("RESET");
                }
            }
        });



    }
}
