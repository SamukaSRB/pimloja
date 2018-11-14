package com.example.aryane.dart2020.Activity;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import com.example.aryane.dart2020.ClienteDao.ClienteDao;
import com.example.aryane.dart2020.R;

public class DadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        ClienteDao clienteDao = new ClienteDao(getBaseContext());
        final Cursor cursor = clienteDao.consultarClientes();
        String[] nomeCampos = new String[]{"_id", "nome", "endereco", "numero", "cep", "bairro", "cidade", "estado"};
        int[] idViews = new int[]{R.id.labelId, R.id.labelNome, R.id.labelEndereco, R.id.labelNumero, R.id.labelBairro, R.id.labelCep, R.id.labelCidade, R.id.labelEstado};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.modelo_lista, cursor, nomeCampos, idViews, 0);
        ListView lista = (ListView) findViewById(R.id.lista_dados);
        lista.setAdapter(adaptador);

        }

    }
