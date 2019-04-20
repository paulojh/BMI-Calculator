package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {
        Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.weightInput);
                double weight = Double.parseDouble(edit.getText().toString());
                edit = (EditText) findViewById(R.id.heightInput);
                double height = Double.parseDouble(edit.getText().toString());
                double bmi = weight / (height*height);
                String strBmi = String.format("Your BMI: %.1f", bmi);
                TextView text = (TextView) findViewById(R.id.txtBmi);
                text.setText(strBmi);

                String category;
                if(bmi<18.5)
                    category = "Underweight";
                else if(bmi < 25)
                    category = "Normal (healthy weight)";
                else if(bmi < 30)
                    category = "Overweight";
                else if(bmi < 35)
                    category = "Obese Class I (Moderately obese)";
                else if(bmi < 40)
                    category = "Obese Class II (Severely obese)";
                else
                    category = "Obese Class III (Very severely obese)";

                text = (TextView) findViewById(R.id.txtCategory);
                text.setText(category);




            }});
    }
}
