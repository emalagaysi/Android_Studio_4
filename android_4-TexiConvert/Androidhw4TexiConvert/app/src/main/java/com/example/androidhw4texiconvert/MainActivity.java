package com.example.androidhw4texiconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.co1);
        button.setOnClickListener(the_texi);
    }
    private View.OnClickListener the_texi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0");
            EditText findcount = (EditText)findViewById(R.id.ch1);
            EditText findcount1 = (EditText)findViewById(R.id.ch2);
            EditText findcount2 = (EditText)findViewById(R.id.ch3);

            int basic = 75;
            //距離
            double distance = Double.parseDouble(findcount.getText().toString());
            double basicCount = Double.parseDouble(findcount1.getText().toString());
            double addCost = Double.parseDouble(findcount2.getText().toString());
            //費用計算
            double count = basic + ((distance / basicCount) * addCost);

            TextView cost = (TextView)findViewById(R.id.tex3);
            //里程低於250公尺時
            if (distance < 250){
                cost.setText("80 元");
            }//每250公尺時且費率加收5元
            else if(distance >= 250 && addCost >=5){
                cost.setText(nf.format(count) + "元");
            }
        }
    };
}