package br.com.tchars.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText _email;
    private EditText _password;
    private TextView _errorNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        _email = findViewById(R.id.inputTextEmail);
        _password = findViewById(R.id.passwordInputText);
        _errorNotification = findViewById(R.id.error_text_view);
    }

    public void login(View view) {

        _errorNotification.setVisibility(View.INVISIBLE);

        if (!_email.getText().toString().equals("charlie@tchars.com") ||
            !_password.getText().toString().equals("12345"))
        {
            _errorNotification.setVisibility(View.VISIBLE);
            return;
        }

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}