/*
Name:- Meet A. Patel
Class:- CIS-3515
Assignment:- Assignment 4
Date:- 02/17/2019
 */
/*
 Name:- Meet A. Patel
 Class:- CIS-3515
 Assignment:- Lab 5


 */


package temple.edu;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;   //creating a spinner object
    String[] myColor = {"White", "Red", "Blue", "Black", "Yellow", "Green", "Gray", "Cyan", "Magenta"};  //creatting array list
    int colorIntValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);

        //Underneath is for lab 4 if you uncommant this then you could go back to lab 4
        /*
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myColor);

        // specify the layout to use when the list of choices appears
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(myAdapter);
        */


        //ColorAdapter ArrayAdapter = new ColorAdapter(this, myColor);


        //this is for lab 5 which conevert english to spanish
        //you have to change the language in the setting to spanich lang
        Resources res = getResources();

        final String[] English= res.getStringArray(R.array.myColorList);
        final String[] Span = res.getStringArray(R.array.myColor);


        ColorAdapter ArrayAdapter = new ColorAdapter(this, English, Span);



        spinner.setAdapter(ArrayAdapter);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = parent.getItemAtPosition(position).toString();
                view.setBackgroundColor(Color.parseColor("White"));
                View mainll = findViewById(R.id.first);
                //mainll.setBackgroundColor(Color.parseColor(color));

                if(position == -1){
                    return;
                }else{
                    colorIntValue = Color.parseColor(English[position]);//convert to int values
                    //creating new intent
                    Intent nextIntent = new Intent(MainActivity.this, Main2Activity.class);
                   nextIntent.putExtra("newColor", colorIntValue);
                  //  nextIntent.putExtra("newColor", English[position]);
                    startActivity(nextIntent);//start the activity
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




    }

}



