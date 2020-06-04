package com.example.emicalculator2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText principle;
    private EditText rate;
    private EditText nmi;

    private TextView princ;
    private TextView rat;
    private TextView inst;
    private TextView result;

    private Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        principle = (EditText)findViewById(R.id.etPrincipal);
        rate = (EditText)findViewById(R.id.etRate);
        nmi = (EditText)findViewById(R.id.etNMI);
        princ = (TextView)findViewById(R.id.tvPrincipal);
        rat = (TextView)findViewById(R.id.tvRate);
        inst = (TextView)findViewById(R.id.tvNMI);
        result = (TextView)findViewById(R.id.result);
        Calculate = (Button)findViewById(R.id.calculate);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                EMI();
            }
        });

    }private void EMI(){
        float P, R;

        String a = principle.getText().toString();
        String b = rate.getText().toString();
        String c = nmi.getText().toString();


        if(a.length()<=0 || b.length()<=0 || c.length()<=0) {
            Toast.makeText(getApplicationContext(), "Empty Text Field. Enter Data", Toast.LENGTH_LONG).show();
        }
        else{
            P = Float.parseFloat(principle.getText().toString());
            R = Float.parseFloat(rate.getText().toString());
            String N = nmi.getText().toString();
            int n = new Integer(N).intValue();

            float f1, f2, f3;

            f1 = (P * R/100);
            f2 = f1 + P;
            f3 = f2 / n;
            double d = f3;
            DecimalFormat f = new DecimalFormat("##.00");
            String emi = String.valueOf(f.format(d));

            result.setText(emi);
        }


        princ.setText(a);
        rat.setText(b);
        inst.setText(c);

    }
}

