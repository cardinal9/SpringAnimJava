package com.example.sprinanimjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button springButton, springButtonY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        springButton = (Button) findViewById(R.id.springButtonId);
        springButtonY = (Button) findViewById(R.id.springButtonYId);

        springButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingItX(imageView);
            }
        });

        springButtonY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingItY(imageView);
            }
        });

    }

    public void flingItX(View view) {
        final SpringAnimation springAnimation = new SpringAnimation(imageView, DynamicAnimation.X);

        SpringForce springForce = new SpringForce();
        springForce.setFinalPosition(imageView.getX());
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        springForce.setStiffness(SpringForce.STIFFNESS_LOW);

        springAnimation.setSpring(springForce);

        springAnimation.setStartVelocity(2000f);
        springAnimation.start();
    }

    public void flingItY(View view) {
        SpringAnimation springAnimation = new SpringAnimation(imageView, DynamicAnimation.Y);

        SpringForce springForce = new SpringForce();
        springForce.setFinalPosition(imageView.getY());
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        springForce.setStiffness(SpringForce.STIFFNESS_LOW);

        springAnimation.setSpring(springForce);

        springAnimation.setStartVelocity(2000f);
        springAnimation.start();
    }
}
