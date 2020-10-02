package com.example.listadetarefas2.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

//Primeira extender de SQLITE e depois sobrescrever alguns metodos utilizando o (Implement Methods da lampada de sugestão)
public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 2;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";



//Depois de implemtar os metodos, criar a construtor
    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL); ";

        try{
            db.execSQL( sql );
            Log.i("INFO BD", "Tabela criada com sucesso");

        }catch (Exception e){
            Log.i("INFO BD", "Erro ao criar a tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  //Atualizar dados da tabel ao mudar a versão

        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ; ";
    //String sql = "ALTER TABLE " + TABELA_TAREFAS + " ADD COLUMN status VARCHAR(2) ";

        try{
            db.execSQL( sql );
            onCreate(db);
            Log.i("INFO BD", "Atualização bem sucessedida");

        }catch (Exception e){
            Log.i("INFO BD", "Erro ao atualizar" + e.getMessage());
        }



    }
}
