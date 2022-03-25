package comp3350.eezy.presentation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import comp3350.eezy.objects.UserList;
import comp3350.eezy.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch darkMode;
    public static boolean dark;

    protected static UserList list;
    EditText user, pass;
    Button loginButton;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redirectSignup();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

    }

    public void redirectSignup() {
        TextView signupText = (TextView) findViewById(R.id.signupButton);
        String text = "New to Eezy? Click Here!";
        SpannableString ss = new SpannableString(text);
        signupText.setTextColor(Color.parseColor("#F7A9A8"));
        ClickableSpan numberOne = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(MainActivity.this, SignupPage.class);
                MainActivity.this.startActivity(intent);
            }
        };
        ss.setSpan(numberOne, 13,24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        signupText.setText(ss);
        signupText.setMovementMethod(LinkMovementMethod.getInstance());
        mainLayout = (ConstraintLayout) findViewById(R.id.layout);
    }

}