package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);
        TextView textView = findViewById(R.id.textView);

        loginButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v)
                                           {

                                               String username = usernameEditText.getText().toString();
                                               String password = passwordEditText.getText().toString();

                                               // Here, you would typically perform some authentication logic to determine
                                               // whether the user's entered credentials are valid. For example, you could
                                               // make an HTTP request to a server that checks the username and password
                                               // against a database or other backend system.

                                               // For this example, we'll just check if the username and password match
                                               // some hardcoded values.
                                               if (username.equals("user") && password.equals("pass")) {
                                                   // If the credentials are valid, launch the next activity
                                                   Intent intent = new Intent(MainActivity.this,
                                                           playername.class);
                                                   startActivity(intent);
                                               } else {
                                                   // If the credentials are invalid, display an error message
                                                   Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                                               }



                                           }
                                       }
        );
    }

    public void startdb(View view){
        new DBBrowser(this);
        startActivity(new Intent(MainActivity.this, playername.class));
    }
}