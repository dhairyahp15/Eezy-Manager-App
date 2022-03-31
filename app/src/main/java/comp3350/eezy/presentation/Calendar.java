package comp3350.eezy.presentation;

import static comp3350.eezy.presentation.HomePage.dark;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import comp3350.eezy.R;
import comp3350.eezy.persistence.CalendarDB;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

public class Calendar extends AppCompatActivity {

    private CalendarDB db;
    private EditText eventName;
    private CalendarView calendarView;
    private String selectedDate;
    private SQLiteDatabase sqliteDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean darkMode = dark;
        if (darkMode) {
            setContentView(R.layout.activity_calendar_dark);
            calendarView = findViewById(R.id.calendar_view2);
        } else {
            setContentView(R.layout.activity_calendar);
            calendarView = findViewById(R.id.calendar_view);
        }
        eventName = findViewById(R.id.eventName);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = Integer.toString(year) + Integer.toString(month) + Integer.toString(dayOfMonth);
                readEvent(view);
            }
        });

        try {
            db = new CalendarDB(this, "Calendardatabase", null, 1);
            sqliteDatabase = db.getWritableDatabase();
            sqliteDatabase.execSQL("CREATE TABLE CalendarEvent (Date TEXT, Event, TEXT)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readEvent(View view) {
        String query = "Select Event from CalendarEvent where Date = " + selectedDate;
        try {
            Cursor cursor = sqliteDatabase.rawQuery(query, null);
            cursor.moveToFirst();
            eventName.setText(cursor.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
            eventName.setText("");
        }
    }

    public void insertEvent(View view){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date", selectedDate);
        contentValues.put("Event", eventName.getText().toString());
        Cursor cursor = sqliteDatabase.rawQuery("Select Event from CalendarEvent where Date = ?", new String[]{selectedDate});

        if(cursor.getCount() > 0){
            sqliteDatabase.update("CalendarEvent", contentValues, "Date = ?",new String[]{selectedDate});
        }
        else{
            sqliteDatabase.insert("CalendarEvent", null, contentValues);
        }

    }

    public void deleteEvent(View view){
        Cursor cursor = sqliteDatabase.rawQuery("Select Event from CalendarEvent where Date = ?", new String[]{selectedDate});
        if(cursor.getCount() > 0){
            sqliteDatabase.delete("CalendarEvent", "Date = ?", new String[]{selectedDate});
        }
    }



}