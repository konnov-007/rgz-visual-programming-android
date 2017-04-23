package konnov.commr.vk.myapplication9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String customers[];
    String films[][];
    String date[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void customersOutput(View v){
        Intent intent = new Intent(this, ShowCustomersActivity.class);
        startActivity(intent);
    }

    public void addCustomer(View v){
        Intent intent = new Intent(this, AddCustomerActivity.class);
        startActivity(intent);
    }

    public void editCustomers(View v){
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }

}
