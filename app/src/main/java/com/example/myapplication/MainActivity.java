package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TextView mResultado;
    private ActivityMainBinding binding;

    private EditText mPesoInput;
    private EditText mAlturaInput;
    private Button mCalcularBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mPesoInput = findViewById(R.id.peso);
        mAlturaInput = findViewById(R.id.altura);
        mCalcularBtn = findViewById(R.id.calcular);
        mResultado = findViewById(R.id.resultado);
    }

    public void handleCalcularIMC(View view){
        String pesoStr = mPesoInput.getText().toString();
        String alturaStr = mAlturaInput.getText().toString();

        double peso = Double.parseDouble(pesoStr);
        double altura = Double.parseDouble(alturaStr);

        double resultadoDouble = peso / Math.pow(altura, 2);
        String resultadoStr = String.format("%,.2f", resultadoDouble);

        mResultado.setText("IMC: " + resultadoStr);
    }
}