package konnov.commr.vk.myapplication9;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddCustomerActivity extends AppCompatActivity {

    private EditText inputedName;
    private EditText inputedFilm;
    private EditText inputedDate;
    private EditText inputedEmail;

    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        inputedName = (EditText) findViewById(R.id.etName);
        inputedFilm = (EditText) findViewById(R.id.etFilm);
        inputedDate = (EditText) findViewById(R.id.etDate);
        inputedEmail = (EditText) findViewById(R.id.etEmail);
        outputText = (TextView) findViewById(R.id.outputTextForAddActivity);
    }

    private void addUserToTheDatabase(String name, String film, String date, String email){
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_NAME, name);
        contentValues.put(DBHelper.KEY_FILM, film);
        contentValues.put(DBHelper.KEY_DATE, date);
        contentValues.put(DBHelper.KEY_MAIL, email);

        database.insert(DBHelper.TABLE_CUSTOMERS, null, contentValues);
    }

    public void addButtonClicked(View v){
        //Log.d("myLogs", "public void addButtonClicked(View v)");

        String name = inputedName.getText().toString();
        String film = inputedFilm.getText().toString();
        String date = inputedDate.getText().toString();
        String email = inputedEmail.getText().toString();

        if(name.isEmpty() || film.isEmpty() || date.isEmpty() || email.isEmpty()){
            outputText.setText("Some parameters are missed");
        }
        else {
            addUserToTheDatabase(name, film, date, email);
            outputText.setText("User " + name + " with film \"" + film + "\" is added successfully, " + "email: "+ email + ", date " + date);
        }
    }

    public void clearFieldsButtonClicked(View v){
        inputedName.setText("");
        inputedFilm.setText("");
        inputedDate.setText("");
        inputedEmail.setText("");
        outputText.setText("");
    }
}
