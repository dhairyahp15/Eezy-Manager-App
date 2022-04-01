package comp3350.eezy.presentation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import comp3350.eezy.R;
import comp3350.eezy.persistence.CalendarDB;

public class LoginPage extends AppCompatActivity {
    private CalendarDB db;
    Button loginButton;
    EditText user, pass;
    private ConstraintLayout mainLayout;
    private SQLiteDatabase sqliteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            db = new CalendarDB(this, "logindatabase", null, 1);
            sqliteDatabase = db.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        login();
        redirectSignup();
    }

    public void redirectSignup() {
        TextView signupText = (TextView) findViewById(R.id.signupButton);
        String text = "New to Eezy? Click Here!";
        SpannableString ss = new SpannableString(text);
        signupText.setTextColor(Color.parseColor("#F7A9A8"));
        ClickableSpan numberOne = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(LoginPage.this, SignupPage.class);
                startActivity(intent);
            }
        };
        ss.setSpan(numberOne, 13,24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        signupText.setText(ss);
        signupText.setMovementMethod(LinkMovementMethod.getInstance());
        mainLayout = (ConstraintLayout) findViewById(R.id.layout);
    }

    public void login() {
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Cursor userPassCheck = sqliteDatabase.rawQuery("SELECT PASSWORD FROM SignupInfo WHERE USERNAME = ? AND PASSWORD =?", new String[]{user.getText().toString(), pass.getText().toString()});

                if(!user.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()){
                    if(userPassCheck.moveToFirst()){
                        Toast.makeText(LoginPage.this, "Login Successful!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginPage.this, HomePage.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginPage.this, "Username and/or Password is incorrect!", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(LoginPage.this, "Username and/or Password cannot be empty!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
