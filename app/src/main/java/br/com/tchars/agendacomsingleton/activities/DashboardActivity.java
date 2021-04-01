package br.com.tchars.agendacomsingleton.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.tchars.agendacomsingleton.R;
import br.com.tchars.agendacomsingleton.helpers.ContatoListAdapter;
import br.com.tchars.agendacomsingleton.models.Contato;
import br.com.tchars.agendacomsingleton.services.ContatoService;

public class DashboardActivity extends AppCompatActivity {

    private ContatoService _contatoService;
    private static Context _context;
    private int _idUsuarioLogado;

    private ListView _listView;

    private ArrayList<Contato> _contatos;

    public static ContatoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().hide();

        _context = this.getApplicationContext();
        _contatoService = new ContatoService(_context);
        _idUsuarioLogado = getIntent().getIntExtra("ID_USUARIO", 0);

        _contatos = new ArrayList<>();
        _contatos = _contatoService.BuscarTodosContatosDoUsuario(_idUsuarioLogado);

        _listView = findViewById(R.id.listaDeContatos);

        adapter = new ContatoListAdapter(this, _contatos);

        // adiciona adapter na lista
        _listView.setAdapter(adapter);

        _listView.setOnItemClickListener((parent, view, position, id) -> {
            Contato itemSelecionado = (Contato) _listView.getItemAtPosition(position);
            Intent intent = new Intent(getApplicationContext(), NewContactActivity.class);
            intent.putExtra("ID_CONTATO", itemSelecionado.getId());
            intent.putExtra("ID_USUARIO_LOGADO", _idUsuarioLogado);
            startActivity(intent);
        });
    }

    public void criarNovoContato(View view) {
        Intent intent = new Intent(getApplicationContext(), NewContactActivity.class);
        intent.putExtra("ID_USUARIO_LOGADO", _idUsuarioLogado);
        startActivity(intent);
    }
}