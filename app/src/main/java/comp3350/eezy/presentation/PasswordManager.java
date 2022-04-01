package comp3350.eezy.presentation;

import static comp3350.eezy.presentation.HomePage.dark;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import comp3350.eezy.R;

public class PasswordManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean darkMode = dark;
        if (darkMode) {
            setContentView(R.layout.activity_password_manager_dark);
        } else {
            setContentView(R.layout.activity_password_manager);
        }
        Button goToAdd = findViewById(R.id.buttonAdd);

        goToAdd.setOnClickListener(view -> {
            Intent in = new Intent(PasswordManager.this, NewPassword.class);
            startActivity(in);
        });

    }

}