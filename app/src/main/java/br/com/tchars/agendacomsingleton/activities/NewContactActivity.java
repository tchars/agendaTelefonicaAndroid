package br.com.tchars.agendacomsingleton.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.tchars.agendacomsingleton.R;
import br.com.tchars.agendacomsingleton.models.Contato;
import br.com.tchars.agendacomsingleton.services.ContatoService;

public class NewContactActivity extends AppCompatActivity {

    private ContatoService _contatoService;
    private static Context _context;
    private int _idUsuarioLogado;
    private int _idContato;

    private EditText _nomeNovoContato;
    private EditText _enderecoNovoContato;
    private EditText _telefoneNovoContato;
    private Spinner _tipoContato;

    private Button _btnSalvarOuAtualizar;

    Contato contatoSalvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        getSupportActionBar().hide();

        _context = this.getApplicationContext();
        _contatoService = new ContatoService(_context);

        _idUsuarioLogado = getIntent().getIntExtra("ID_USUARIO_LOGADO", -1);
        _idContato = getIntent().getIntExtra("ID_CONTATO", -1);

        _nomeNovoContato = findViewById(R.id.nomeNovoContato);
        _enderecoNovoContato = findViewById(R.id.enderecoNovoContato);
        _telefoneNovoContato = findViewById(R.id.telefoneNovoContato);
        _tipoContato = findViewById(R.id.spinner);

        _btnSalvarOuAtualizar = findViewById(R.id.btnSalvarOuAtualizarContato);

        if (_idContato != -1) {
            contatoSalvo = _contatoService.BuscarContatoPeloId(_idContato);

            _nomeNovoContato.setText(contatoSalvo.getNome());
            _enderecoNovoContato.setText(contatoSalvo.getEndereco());
            _telefoneNovoContato.setText(contatoSalvo.getTelefone());
            _tipoContato.setSelection(contatoSalvo.getTipoContato());

            _btnSalvarOuAtualizar.setText("Atualizar");
        }
    }

    public void criarOuAtualizarContato(View view) {

        Contato contato = new Contato();

        contato.setId(_idContato);
        contato.setNome(_nomeNovoContato.getText().toString());
        contato.setEndereco(_enderecoNovoContato.getText().toString());
        contato.setTipoContato((int) _tipoContato.getSelectedItemId());
        contato.setTelefone(_telefoneNovoContato.getText().toString());
        contato.setIdUsuarioPai(_idUsuarioLogado);

        if (_idContato != -1) {
            _contatoService.AtualizarContato(contato);
        } else {
            _contatoService.CadastrarContato(contato);
        }

        DashboardActivity.adapter.clear();
        DashboardActivity.adapter.notifyDataSetChanged();

        ArrayList<Contato> novosContatos = _contatoService.BuscarTodosContatosDoUsuario(_idUsuarioLogado);

        DashboardActivity.adapter.addAll(novosContatos);
        DashboardActivity.adapter.notifyDataSetChanged();

        Toast.makeText(getApplicationContext(), "Sucesso!", Toast.LENGTH_LONG).show();

        finish();
    }
}