package br.com.tchars.agendacomsingleton.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import br.com.tchars.agendacomsingleton.R;
import br.com.tchars.agendacomsingleton.models.Usuario;
import br.com.tchars.agendacomsingleton.services.UsuarioService;

public class MainActivity extends AppCompatActivity {

    private UsuarioService _usuarioService;
    private static Context _context;

    private EditText _nomeDeUsuario;
    private EditText _senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        _context = this.getApplicationContext();
        _usuarioService = new UsuarioService(_context);

        _nomeDeUsuario = findViewById(R.id.inputLogin);
        _senha = findViewById(R.id.inputSenha);
    }

    public void logarUsuario(View view) {

        if (_nomeDeUsuario.getText().toString().isEmpty() || _senha.getText().toString().isEmpty()) {
            criaAlerta("Atenção!", "Nome de usuário e senha são obrigatórios!");
            return;
        }

        Usuario usuario = _usuarioService.AutenticarUsuario(_nomeDeUsuario.getText().toString(), _senha.getText().toString());

        if (usuario == null) {
            criaAlerta("Falha ao acessar", "Nome de usuário e/ou senha estão incorretos.");
            return;
        }

        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        intent.putExtra("ID_USUARIO", usuario.getId());
        startActivity(intent);
        finish();
    }

    public void criarUsuario(View view) {
        startActivity(new Intent(getApplicationContext(), NewUserActivity.class));
    }

    private void criaAlerta(String titulo, String mensagem) {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(titulo)
                .setMessage(mensagem)
                .setPositiveButton(android.R.string.yes, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}