package edu.ucucite.ebudgetmo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Bills extends AppCompatActivity {

    DatabaseHelper db;
    ListView list_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        db = new DatabaseHelper(this);
        list_item=findViewById(R.id.list_item);

        ArrayList<HashMap<String,String>> billsDataList= db.getAll();


        ListAdapter listAdapter= new SimpleAdapter(Bills.this,billsDataList,
                R.layout.list_bills, new String[]{"title","amount"}, new int[]{R.id.txttitle, R.id.txtamount});
        list_item.setAdapter(listAdapter);

    }

    public void btnadd(View view) {
        Intent intent = new Intent(this, addbillls.class);
        startActivity(intent);
    }
}