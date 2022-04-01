package comp3350.eezy.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import comp3350.eezy.R;

public class HomePage extends AppCompatActivity{
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch darkMode;
    private ConstraintLayout mainLayout;
    public static boolean dark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        darkMode = findViewById(R.id.darkSwitch);
        mainLayout = findViewById(R.id.layout);
        Button goToCalendar = findViewById(R.id.buttonCalendar);
        Button goToPassword = findViewById(R.id.buttonPassword);

        darkMode.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                dark = true;
                mainLayout.setBackgroundColor(Color.parseColor("#150E1A"));
                darkMode.setTextColor(Color.parseColor("#FFFFFF"));
            } else {
                dark = false;
                mainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                darkMode.setTextColor(Color.parseColor("#000000"));
            }
        });
        mainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        darkMode.setTextColor(Color.parseColor("#000000"));
        goToCalendar.setOnClickListener(view -> {
            Intent in = new Intent(HomePage.this, Calendar.class);
            startActivity(in);
        });
        goToPassword.setOnClickListener(view -> {
            Intent in = new Intent(HomePage.this, PasswordManager.class);
            startActivity(in);
        });
    }
}
