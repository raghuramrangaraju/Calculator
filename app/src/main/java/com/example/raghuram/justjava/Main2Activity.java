package com.example.raghuram.justjava;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static String operator = "";
    private static double presentnumber = 0;
    private static double oldnumber = 0;
    private static int temp = 0;
    private static String nulltemp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void reset(View V) {
        presentnumber = 0;
        oldnumber = 0;
        operator = "";
        TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
        priceTextView.setText("" + String.valueOf(presentnumber).replaceFirst("\\.0+$", ""));
    }

    public void finalresult(View V) {
        if (operator != "") {
            if (operator == "+") {

                oldnumber = oldnumber + presentnumber;
                presentnumber = temp;
                operator = nulltemp;
                TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
                priceTextView.setText("" + String.valueOf(oldnumber).replaceFirst("\\.0+$", ""));
            } else if (operator == "-") {
                oldnumber = oldnumber - presentnumber;
                presentnumber = temp;
                operator = nulltemp;
                TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
                priceTextView.setText("" + String.valueOf(oldnumber).replaceFirst("\\.0+$", ""));
            } else if (operator == "*") {
                oldnumber = oldnumber * presentnumber;
                presentnumber = temp;
                operator = nulltemp;
                TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
                priceTextView.setText("" + String.valueOf(oldnumber).replaceFirst("\\.0+$", ""));
            } else if (operator == "/") {
                oldnumber = oldnumber / presentnumber;
                presentnumber = temp;
                operator = nulltemp;
                TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
                priceTextView.setText("" + String.valueOf(oldnumber).replaceFirst("\\.0+$", ""));
            }
        }

    }

    public void addition(View V) {
        operator = "+";
        oldnumber += presentnumber;
        presentnumber = temp;
        TextView priceTextView = (TextView) findViewById(R.id.display_view_text);

        priceTextView.setText("" + String.valueOf(oldnumber).replaceFirst("\\.0+$", ""));
    }

    public void subtration(View V) {
        operator = "-";
        if (oldnumber == 0) {
            oldnumber = presentnumber;
        } else {
            oldnumber -= presentnumber;
        }
        presentnumber = temp;
        TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
        priceTextView.setText("" + String.valueOf(oldnumber).replaceFirst("\\.0+$", ""));
    }

    public void multiplication(View V) {
        operator = "*";
        // if(presentnumber != 0 && oldnumber != 0)
        //   oldnumber *= presentnumber;

        if (oldnumber == 0.0 && presentnumber != 0.0) {
            oldnumber = presentnumber;
        } else if (oldnumber != 0) {

        } else {
            oldnumber *= presentnumber;
        }
        presentnumber = temp;
        TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
        priceTextView.setText("" + String.valueOf(oldnumber).replaceFirst("\\.0+$", ""));
    }

    public void division(View V) {
        //DecimalFormat numberFormat = new DecimalFormat("#.0000");
        //System.out.println(numberFormat.format(number));
        operator = "/";
        // if(presentnumber != 0 && oldnumber != 0)
        //   oldnumber /= presentnumber;

        if (oldnumber == 0 && presentnumber != 0) {
            oldnumber = presentnumber;
        } else if (oldnumber != 0) {

        } else {
            oldnumber /= presentnumber;
        }
        presentnumber = temp;
        TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
        //priceTextView.setText("" + String.valueOf(numberFormat.format(oldnumber)).replaceFirst("\\.0+$", ""));
        priceTextView.setText("" + String.valueOf(String.valueOf(oldnumber)).replaceFirst("\\.0+$", ""));
    }

    public void numberclick(View V) {

        int numberclicked = 0;
        int buttonid = V.getId();
        if (buttonid == R.id.button7) {
            numberclicked = 7;
        } else if (buttonid == R.id.button8) {
            numberclicked = 8;
        } else if (buttonid == R.id.button9) {
            numberclicked = 9;
        } else if (buttonid == R.id.button1) {
            numberclicked = 1;
        } else if (buttonid == R.id.button2) {
            numberclicked = 2;
        } else if (buttonid == R.id.button3) {
            numberclicked = 3;
        } else if (buttonid == R.id.button4) {
            numberclicked = 4;
        } else if (buttonid == R.id.button5) {
            numberclicked = 5;
        } else if (buttonid == R.id.button6) {
            numberclicked = 6;
        }
        if (presentnumber != 0.0)
            presentnumber = Float.parseFloat(String.valueOf(presentnumber).replaceFirst("\\.0+$", "") + Integer.toString(numberclicked));
        else
            presentnumber = Float.parseFloat(Integer.toString(numberclicked));
        TextView priceTextView = (TextView) findViewById(R.id.display_view_text);
        priceTextView.setText("" + String.valueOf(presentnumber).replaceFirst("\\.0+$", ""));
    }

    int count = 0;

    public void plusminus(View V) {
        count = count++;
        TextView numberview = (TextView) findViewById(R.id.display_view_text);
        int data = 0;
        if (count % 2 == 0) {
            data = -Integer.parseInt(numberview.getText().toString());
        } else {
            data = Integer.parseInt(numberview.getText().toString());
        }
        presentnumber = data;
        numberview.setText("" + String.valueOf(data).replaceFirst("\\.0+$", ""));
    }

    public void percentage(View V) {
        TextView numberview = (TextView) findViewById(R.id.display_view_text);
        float data = (Float.parseFloat(numberview.getText().toString()) / 100);
        //data = data/100;
        presentnumber = data;
        numberview.setText("" + String.valueOf(data).replaceFirst("\\.0+$", ""));

    }

}
