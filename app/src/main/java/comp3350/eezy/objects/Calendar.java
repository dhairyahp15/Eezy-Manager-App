package comp3350.eezy.objects;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import comp3350.eezy.R;
import comp3350.eezy.logic.MainActivity;

public class Calendar extends AppCompatActivity{
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean darkMode = MainActivity.dark;
        if(darkMode)
            setContentView(R.layout.activity_calendar_dark);
        else
            setContentView(R.layout.activity_calendar);
    }
}