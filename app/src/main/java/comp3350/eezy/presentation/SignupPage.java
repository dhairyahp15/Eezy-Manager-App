package comp3350.eezy.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import comp3350.eezy.R;
import comp3350.eezy.objects.User;

public class SignupPage extends MainActivity {

    EditText name, email, username, password;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        signupButton = (Button) findViewById(R.id.button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupPage.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }

    public void signupUser() {
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        User newUser = new User(name.getText().toString(), email.getText().toString(),
                password.getText().toString(), username.getText().toString());
        list.addUser(newUser);
    }

}
