package comp3350.eezy.presentation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import comp3350.eezy.R;
import comp3350.eezy.presentation.MainActivity;

public class Calendar extends AppCompatActivity{
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean darkMode = MainActivity.dark;
        if(darkMode)
            setContentView(R.layout.activity_calendar);
        else
            setContentView(R.layout.activity_calendar_dark);
    }

}