package br.com.tchars.agendacomsingleton.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.tchars.agendacomsingleton.R;
import br.com.tchars.agendacomsingleton.models.Usuario;
import br.com.tchars.agendacomsingleton.services.UsuarioService;

public class NewUserActivity extends AppCompatActivity {

    private UsuarioService _usuarioService;
    private static Context _context;

    private EditText _nomeDeUsuario;
    private EditText _senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        getSupportActionBar().hide();

        _context = this.getApplicationContext();
        _usuarioService = new UsuarioService(_context);

        _nomeDeUsuario = findViewById(R.id.inputCadastrarUsuario);
        _senha = findViewById(R.id.inputCadastrarSenha);
    }

    public void criarUsuario(View view) {

        if (_nomeDeUsuario.getText().toString().isEmpty() || _nomeDeUsuario.getText().toString() == null ||
            _senha.getText().toString().isEmpty() || _senha.getText().toString() == null
        ) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Nome de usuário e senha são obrigatórios",
                    Toast. LENGTH_SHORT);
            toast.show();
            return;
        }

        Usuario usuario = new Usuario(_nomeDeUsuario.getText().toString(), _senha.getText().toString());
        _usuarioService.CriarUsuario(usuario);

        finish();
    }
}