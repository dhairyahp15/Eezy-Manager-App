package com.example.calendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private Switch darkMode;
    private ConstraintLayout mainLayout;
    private ImageView image;
    private Button goToCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        darkMode = (Switch) findViewById(R.id.darkSwitch);
        mainLayout = (ConstraintLayout) findViewById(R.id.layout);
        image = (ImageView) findViewById(R.id.imageView);

        goToCalendar = (Button) findViewById(R.id.buttonCalendar);

        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    mainLayout.setBackgroundColor(Color.parseColor("#141D26"));
                    image.setColorFilter(Color.parseColor("#FFFFFF"));
                    darkMode.setTextColor(Color.parseColor("#FFFFFF"));
                    goToCalendar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent in = new Intent(MainActivity.this, CalendarDark.class);
                            startActivity(in);
                        }
                    });
                } else {
                    mainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    image.setColorFilter(Color.parseColor("#000000"));
                    darkMode.setTextColor(Color.parseColor("#000000"));
                    goToCalendar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("MainActivity", "onsetDate: date: ");
                            Intent in = new Intent(MainActivity.this, CalendarLight.class);
                            startActivity(in);
                        }
                    });
                }
            }
        });
        mainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        image.setColorFilter(Color.parseColor("#000000"));
        darkMode.setTextColor(Color.parseColor("#000000"));
        goToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "onsetDate: date: ");
                Intent in = new Intent(MainActivity.this, CalendarLight.class);
                startActivity(in);
            }
        });
    }

}