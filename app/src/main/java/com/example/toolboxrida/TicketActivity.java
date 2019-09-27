package com.example.toolboxrida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toolboxrida.R;

public class TicketActivity extends AppCompatActivity {


    Switch RegPrem;
    private int regular = 100;
    private int premium = 250;
    RadioButton harry, pirates, cinderellah, gollywood;
    Spinner child;
    Spinner adult;
    private int ChildTickets, AdultTickets, TotalTickets;


    ImageView Hotel;
    CheckBox Duck;
    CheckBox Music;
    CheckBox None;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        harry = (RadioButton) findViewById(R.id.RadioButton1);
        harry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Fast Pass for Obligatory Harry Potter Ride", Toast.LENGTH_LONG).show();

            }
        });


        pirates = (RadioButton) findViewById(R.id.RadioButton2);
        pirates.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Fast Pass for Pirates of Carribean", Toast.LENGTH_LONG).show();

            }
        });


        cinderellah = (RadioButton) findViewById(R.id.radioButton);
        cinderellah.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Fast Pass for Cinderellah's Castle", Toast.LENGTH_LONG).show();

            }
        });


        gollywood = (RadioButton) findViewById(R.id.radioButton2);
        gollywood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "Fast Pass for Gollywood", Toast.LENGTH_LONG).show();

            }
        });

        Hotel = (ImageView) findViewById(R.id.imageView5);
        Duck = (CheckBox) findViewById(R.id.checkBox2);
        Duck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Hotel.setImageResource(R.drawable.gisney6);
                Music.setEnabled(false);
                None.setEnabled(false);
            }
        });
        Music = (CheckBox) findViewById(R.id.checkBox);
        Music.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Hotel.setImageResource(R.drawable.gisney8);
                Duck.setEnabled(false);
                None.setEnabled(false);
            }
        });
        None = (CheckBox) findViewById(R.id.checkBox3);
        None.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Hotel.setImageResource(R.drawable.gisney7);
                Music.setEnabled(false);
                Duck.setEnabled(false);
            }
        });

    }

    public void onClick(View v)
    {
        double price = 0.0;

        RegPrem = (Switch) findViewById(R.id.switch1);

        child = (Spinner) findViewById(R.id.spinner1);
        adult = (Spinner) findViewById(R.id.spinner2);

        int spinner_pos = child.getSelectedItemPosition();
        String[] size_values = getResources().getStringArray(R.array.ppl_arrays);
        ChildTickets = Integer.valueOf(size_values[spinner_pos]);

        int spinner_pos2 = child.getSelectedItemPosition();
        String[] size_values2 = getResources().getStringArray(R.array.ppl_arrays);
        AdultTickets = Integer.valueOf(size_values2[spinner_pos2]);

        //each ticket times price
        //-20 for kids bc kid tickets are 80 and 230
        if(RegPrem.isChecked())
            price += ((ChildTickets*premium)-20) + ((AdultTickets*premium));
        else
            price += ((ChildTickets*regular)-20) + ((AdultTickets*regular));

        //fast pass only reg
        if(!RegPrem.isChecked()) {
            harry = (RadioButton) findViewById(R.id.RadioButton1);
            if (harry.isChecked())
                price += 40;

            pirates = (RadioButton) findViewById(R.id.RadioButton2);
            if (pirates.isChecked())
                price += 40;

            cinderellah = (RadioButton) findViewById(R.id.radioButton);
            if (cinderellah.isChecked())
                price += 40;

            gollywood = (RadioButton) findViewById(R.id.radioButton2);
            if (gollywood.isChecked())
                price += 40;
        }

        TotalTickets = ChildTickets + AdultTickets;
        Duck = (CheckBox) findViewById(R.id.checkBox2);
        if(Duck.isChecked())
            price += 230;
        Music = (CheckBox) findViewById(R.id.checkBox);
        if(Music.isChecked())
            price += 200;
        None = (CheckBox) findViewById(R.id.checkBox3);
        if(None.isChecked())
            price += 0;

        TextView FinalPrice = (TextView) findViewById(R.id.textView13);
        FinalPrice.setText("Overall ticket prices: $" + price);

    }

}
