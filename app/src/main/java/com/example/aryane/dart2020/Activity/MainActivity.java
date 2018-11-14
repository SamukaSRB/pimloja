package com.example.aryane.dart2020.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.aryane.dart2020.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  abrirTelaClientes(View v){
        Intent startNewActivity = new  Intent(this,ClientesActivity.class);
        startActivity(startNewActivity);

    }
}
