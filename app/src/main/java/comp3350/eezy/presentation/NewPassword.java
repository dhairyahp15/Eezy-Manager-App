package comp3350.eezy.presentation;

import static comp3350.eezy.presentation.HomePage.dark;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import comp3350.eezy.R;

public class NewPassword extends AppCompatActivity{
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean darkMode = dark;
        if (darkMode) {
            setContentView(R.layout.activity_new_password_dark);
        } else {
            setContentView(R.layout.activity_new_password);
        }
    }

}