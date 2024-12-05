package com.myapplication.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.myapplication.R;
import com.myapplication.controller.Operacao;

public class MainActivity extends AppCompatActivity {

    private EditText etValorA;
    private EditText etValorB;
    private EditText etValorC;
    private TextView tvResDelta;
    private TextView tvResX1;
    private TextView tvResX2;
    private TextView tvRaizes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValorA = findViewById(R.id.etValorA);
        etValorA.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etValorB = findViewById(R.id.etValorB);
        etValorB.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etValorC = findViewById(R.id.etValorC);
        etValorC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvResDelta = findViewById(R.id.tvResDelta);
        tvResDelta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvResX2 = findViewById(R.id.tvResX2);
        tvResX2.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvResX1 = findViewById(R.id.tvResX1);
        tvResX1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRaizes = findViewById(R.id.tvRaizes);
        tvRaizes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calculo());
    }
    private void calculo(){
        Operacao o = new Operacao();

        float a = Float.parseFloat(etValorA.getText().toString());
        float b = Float.parseFloat(etValorB.getText().toString());
        float c = Float.parseFloat(etValorC.getText().toString());
        if(a == 0){
            tvRaizes.setText("Não é uma equação de 2º grau.");
            return;
        }
        float delta = o.calcularDelta(a, b, c);
        tvResDelta.setText(String.format("%.3f",delta));
        if(delta < 0){
            tvRaizes.setText("Não existem raízes reais.");
        }
        float x1 = o.calcularRaiz1(a,b,c);
        tvResX1.setText(String.format("%.3f", x1));
        float x2 = o.calcularRaiz2(a,b,c);
        tvResX2.setText(String.format("%.3f", x2));
    }
}