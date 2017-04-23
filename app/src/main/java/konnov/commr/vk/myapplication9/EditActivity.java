package konnov.commr.vk.myapplication9;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    private EditText id;
    private EditText film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        id = (EditText) findViewById(R.id.editTextID);
        film = (EditText) findViewById(R.id.editTextFilm);
    }

    private void removeEntireDB(){
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete(DBHelper.TABLE_CUSTOMERS, null, null);
        Toast.makeText(this, "The entire database is deleted", Toast.LENGTH_SHORT).show();
    }

    public void removeall(View v){
        new AlertDialog.Builder(this)
                .setTitle("Warning")
                .setMessage("Are you sure you want to delete all the records?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removeEntireDB();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //no
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    public void deleteOneUser(View v){
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String stringId = id.getText().toString();

        if (stringId.equalsIgnoreCase("")){
            Toast.makeText(this, "The id section is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        database.delete(DBHelper.TABLE_CUSTOMERS, DBHelper.KEY_ID + "=" + stringId, null);
        Toast.makeText(this, "The user was successfully deleted", Toast.LENGTH_SHORT).show();


    }


    public void changeUsersFilm(View v){
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String stringId = id.getText().toString();
        String stringFilm = film.getText().toString();
        if (stringId.equalsIgnoreCase("")){
            Toast.makeText(this, "The id section is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (stringFilm.equalsIgnoreCase("")){
            Toast.makeText(this, "The film section is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_FILM, stringFilm);
        database.update(DBHelper.TABLE_CUSTOMERS, contentValues, DBHelper.KEY_ID + "= ?", new String[] {stringId});
        Toast.makeText(this, "The film has been changed for this user", Toast.LENGTH_SHORT).show();
    }

}
