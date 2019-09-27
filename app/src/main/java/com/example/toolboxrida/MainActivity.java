package com.example.toolboxrida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView17);
        textView.setMovementMethod(new ScrollingMovementMethod());

        button = (Button)findViewById(R.id.NextPage);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openTicketActivity();
            }
        });


    }


    public void openTicketActivity() {
        Intent intent = new Intent(this, TicketActivity.class);
        startActivity(intent);
    }

}
