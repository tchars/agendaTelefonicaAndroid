package br.com.tchars.agendacomsingleton.repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.tchars.agendacomsingleton.helpers.DatabaseHelper;
import br.com.tchars.agendacomsingleton.models.Contato;

public class ContatoRepository implements IContatoRepository {

    private SQLiteDatabase _db;

    public ContatoRepository(Context context) {
        _db = DatabaseHelper.getInstance(context).getWritableDatabase();
    }

    @Override
    public boolean CriarContato(Contato contato) {

        try {
            String insert = "INSERT INTO contatos(nome, telefone, endereco, tipoContato, idUsuarioPai) VALUES('" +
                    "" + contato.getNome() + "', " +
                    "'" + contato.getTelefone() + "', " +
                    "'" + contato.getEndereco() + "', " + contato.getTipoContato() + ", " + contato.getIdUsuarioPai() + ")";

            _db.execSQL(insert);

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Contato BuscarContatoPeloId(int idContato) {
        try {
            String consulta = "SELECT * FROM contatos WHERE id = " + idContato + "";

            Cursor cursor = _db.rawQuery(consulta, null);

            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEndereco = cursor.getColumnIndex("endereco");
            int indiceTelefone = cursor.getColumnIndex("telefone");
            int indiceTipoContato = cursor.getColumnIndex("tipoContato");
            int indiceIdUsuarioPai = cursor.getColumnIndex("idUsuarioPai");

            Contato contato = new Contato();

            boolean registro = cursor.moveToFirst();

            if (registro) {
                contato.setId(cursor.getInt(indiceId));
                contato.setNome(cursor.getString(indiceNome));
                contato.setEndereco(cursor.getString(indiceEndereco));
                contato.setTelefone(cursor.getString(indiceTelefone));
                contato.setTipoContato(cursor.getInt(indiceTipoContato));
                contato.setIdUsuarioPai(cursor.getInt(indiceIdUsuarioPai));
            }

            return contato;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Contato> BuscarTodosContatosDoUsuario(int idUsuarioLogado) {

        ArrayList<Contato> contatos = new ArrayList<>();

        try {

            String consulta = "SELECT * FROM contatos WHERE idUsuarioPai = " + idUsuarioLogado + "";

            Cursor cursor = _db.rawQuery(consulta, null);

            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEndereco = cursor.getColumnIndex("endereco");
            int indiceTelefone = cursor.getColumnIndex("telefone");
            int indiceTipoContato = cursor.getColumnIndex("tipoContato");
            int indiceIdUsuarioPai = cursor.getColumnIndex("idUsuarioPai");
            
            boolean registros = cursor.moveToFirst();

            while (registros) {

                Contato contato = new Contato();

                contato.setId(cursor.getInt(indiceId));
                contato.setNome(cursor.getString(indiceNome));
                contato.setEndereco(cursor.getString(indiceEndereco));
                contato.setTelefone(cursor.getString(indiceTelefone));
                contato.setTipoContato(cursor.getInt(indiceTipoContato));
                contato.setIdUsuarioPai(cursor.getInt(indiceIdUsuarioPai));

                contatos.add(contato);

                cursor.moveToNext();
            }

            cursor.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            return contatos;
        }
    }

    @Override
    public void AtualizarContato(Contato contato) {

        try {
            String strSQL = "UPDATE contatos SET nome = '" + contato.getNome() + "', endereco = '" + contato.getEndereco() + "', telefone = '" + contato.getTelefone() + "', tipoContato = " + contato.getTipoContato() + " WHERE id = " + contato.getId();
            _db.execSQL(strSQL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
