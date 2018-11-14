package com.example.aryane.dart2020.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aryane.dart2020.ClienteDao.ClienteDao;
import com.example.aryane.dart2020.R;

public class ClientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
    }
    public void cadastrarCliente(View v){
        ClienteDao clienteDao = new ClienteDao( getBaseContext());
        EditText nome = (EditText)findViewById(R.id.edtNome);
        EditText endereco = (EditText)findViewById(R.id.edtEndereco);
        EditText numero = (EditText)findViewById(R.id.edtNumero);
        EditText bairro = (EditText)findViewById(R.id.edtBairro);
        EditText cep = (EditText)findViewById(R.id.edtCep);
        EditText cidade = (EditText)findViewById(R.id.edtCidade);
        EditText estado = (EditText)findViewById(R.id.edtEstado);

        boolean resultado  = clienteDao.criarClientes(nome.getText().toString(),
                endereco.getText().toString(),numero.getText().toString(),bairro.getText().toString(),
                cep.getText().toString(),cidade.getText().toString(),estado.getText().toString());

        if (resultado) {
            Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Infelismente  ocorreu um erro ,tente novamente", Toast.LENGTH_LONG).show();
        }
        voltar(v);
    }
    public void  voltar (View v){
        Intent  startNewActivity = new Intent(this,MainActivity.class);
        startActivity(startNewActivity);
    }
    public void consultarCliente(View v){
        Intent  startNewActivity = new Intent(this,DadosActivity.class);
        startActivity(startNewActivity);

    }


}
