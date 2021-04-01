package br.com.tchars.agendacomsingleton.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;

    private static final String DATABASE_NAME = "app";
    private static final String TABELA_USUARIOS = "usuarios";
    private static final String TABLEA_CONTATOS = "contatos";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_USUARIOS = "CREATE TABLE IF NOT EXISTS usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT, nomeDeUsuario VARCHAR, senha VARCHAR)";

    private static final String CREATE_TABLE_CONTATOS = "CREATE TABLE IF NOT EXISTS contatos(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, endereco VARCHAR, telefone VARCHAR, tipoContato int(3), idUsuarioPai int(3))";

    public static synchronized DatabaseHelper getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }

        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USUARIOS);
        db.execSQL(CREATE_TABLE_CONTATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLEA_CONTATOS);

        onCreate(db);
    }
}
