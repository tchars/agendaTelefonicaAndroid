package br.com.tchars.agendacomsingleton.repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.tchars.agendacomsingleton.helpers.DatabaseHelper;
import br.com.tchars.agendacomsingleton.models.Usuario;

public class UsuarioRepository implements IUsuarioRepository {

    private SQLiteDatabase _db;

    public UsuarioRepository(Context context) {
        _db = DatabaseHelper.getInstance(context).getWritableDatabase();
    }

    @Override
    public boolean SalvarUsuario(Usuario usuario) {
        try {

            String insert = "INSERT INTO usuarios(nomeDeUsuario, senha) VALUES('" + usuario.getNomeDeUsuario() + "', '" + usuario.getSenha() + "')";

            _db.execSQL(insert);

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Usuario BuscarUsuarioPeloNomeDeUsuario(String nomeDeUsuario) {

        try {
            String consulta = "SELECT * FROM usuarios WHERE nomeDeUsuario = '" + nomeDeUsuario + "'";

            Cursor cursor = _db.rawQuery(consulta, null);

            int indiceId = cursor.getColumnIndex("id");
            int indiceNomeDeUsuario = cursor.getColumnIndex("nomeDeUsuario");
            int indiceSenha = cursor.getColumnIndex("senha");

            Usuario usuario = new Usuario();

            if (cursor != null) {
                cursor.moveToFirst();
                usuario.setId(cursor.getInt(indiceId));
                usuario.setNomeDeUsuario(cursor.getString(indiceNomeDeUsuario));
                usuario.setSenha(cursor.getString(indiceSenha));
            }

            return usuario;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
