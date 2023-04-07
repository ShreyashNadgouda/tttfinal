package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class playername extends AppCompatActivity {

        EditText t1,t2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_playername);

                t1=(EditText)findViewById(R.id.player1);
                t2=(EditText)findViewById(R.id.player2);

        }

        public void nextplay(View view)

        {
                //storing values in player1
                Intent intent1 = new Intent(this, play.class);
                TextView name1 = (TextView) findViewById(R.id.player1);
                String player1 = name1.getText().toString();
                intent1.putExtra("connect1", player1);

                //storing values in player2
                TextView name2 = (TextView) findViewById(R.id.player2);
                String player2 = name2.getText().toString();
                intent1.putExtra("connect2", player2);
                startActivity(intent1);

                DBBrowser db=new DBBrowser(this);
                String res= db.addRecord(t1.getText().toString(),t2.getText().toString());
                Toast.makeText(this, res, Toast.LENGTH_LONG).show();
                t1.setText("");
                t2.setText("");


        }
}