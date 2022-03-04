package comp3350.eezy.objects;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import comp3350.eezy.R;
import comp3350.eezy.logic.MainActivity;

public class LoginPage extends MainActivity {

    Button loginButton;
    EditText user, pass;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redirectSignup();
        login();
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
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, Calendar.class);
                startActivity(intent);
            }
        });

    }

}
