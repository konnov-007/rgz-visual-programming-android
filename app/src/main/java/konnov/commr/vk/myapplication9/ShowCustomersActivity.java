package konnov.commr.vk.myapplication9;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowCustomersActivity extends AppCompatActivity {
    TextView textView;
    String outputString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_customers);
        textView = (TextView) findViewById(R.id.textViewForShowCustomersActivity);
        readTheBase();
    }

    private void readTheBase(){
        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_CUSTOMERS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) { // делает первую запись курсор активно и проверяет есть ли вообще записи в нем (выбиралось ли что-нибудь в методе query)
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int filmIndex = cursor.getColumnIndex(DBHelper.KEY_FILM);
            int dateIndex = cursor.getColumnIndex(DBHelper.KEY_DATE);
            int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
            do {
                outputString = outputString + "ID = " + cursor.getInt(idIndex) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", film = " + cursor.getString(filmIndex) +
                        ", date = " + cursor.getString(dateIndex) +
                        ", email = " + cursor.getString(emailIndex) + "\n\n";

            } while (cursor.moveToNext());
            textView.setText(outputString);
        } else
            textView.setText("0 rows");
        cursor.close();
    }
}
