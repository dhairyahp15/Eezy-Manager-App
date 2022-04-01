package comp3350.eezy.presentation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.eezy.R;
import comp3350.eezy.objects.User;
import comp3350.eezy.persistence.CalendarDB;

public class SignupPage extends AppCompatActivity {
    private CalendarDB db;
    EditText name, email, username, password, confirmPassword;
    Button signupButton;
    private SQLiteDatabase sqliteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        confirmPassword = findViewById(R.id.confirm_password);

        try {
            db = new CalendarDB(this, "logindatabase", null, 1);
            sqliteDatabase = db.getWritableDatabase();
            sqliteDatabase.execSQL("CREATE TABLE SignupInfo (USERNAME TEXT, NAME TEXT, EMAIL TEXT, PASSWORD TEXT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertUser(View view){
        Log.d("SignupPage","Okayyy");
        ContentValues contentValues = new ContentValues();

        Cursor emailCheck = sqliteDatabase.rawQuery("SELECT EMAIL FROM SignupInfo WHERE EMAIL = ?", new String[]{email.getText().toString()});
        Cursor usernameCheck = sqliteDatabase.rawQuery("SELECT USERNAME FROM SignupInfo WHERE USERNAME = ?", new String[]{username.getText().toString()});

        if(emailCheck.moveToFirst()){
            Toast.makeText(SignupPage.this, "Something went wrong! Try Again..", Toast.LENGTH_LONG).show();
        }
        else if(usernameCheck.moveToFirst()){
            Toast.makeText(SignupPage.this, "Something went wrong! Try Again..", Toast.LENGTH_LONG).show();
        }
        else if(!username.getText().toString().isEmpty() && !name.getText().toString().isEmpty()
                && !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty() && !confirmPassword.getText().toString().isEmpty()){
            contentValues.put("USERNAME", username.getText().toString());
            contentValues.put("NAME", name.getText().toString());
            contentValues.put("EMAIL", email.getText().toString());
            contentValues.put("PASSWORD", password.getText().toString());

            sqliteDatabase.insert("SignupInfo", null, contentValues);
            Toast.makeText(SignupPage.this, "Successfully signed up!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SignupPage.this, LoginPage.class);
            this.startActivity(intent);
       }
        else {
            Toast.makeText(SignupPage.this, "Fields cannot be empty!", Toast.LENGTH_LONG).show();
        }
    }
}
