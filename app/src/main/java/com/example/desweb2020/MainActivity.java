package com.example.desweb2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtCodigo,edtNombre,edtApellido,edtTelefono;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCodigo=(EditText)findViewById(R.id.edtCodigo);
        edtNombre=(EditText)findViewById(R.id.edtNombre);
        edtApellido=(EditText)findViewById(R.id.edtApellido);
        edtTelefono=(EditText)findViewById(R.id.edtTelefono);
        btnAgregar=(Button) findViewById(R.id.btnAgregar);

        final  BD bd=new BD(getApplicationContext());
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.agregarRegistroP(edtCodigo.getText().toString(),edtNombre.getText().toString(),edtApellido.getText().toString(),edtTelefono.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
            }
        });
    }
}