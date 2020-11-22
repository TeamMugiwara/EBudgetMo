package edu.ucucite.ebudgetmo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addbillls extends AppCompatActivity {
    DatabaseHelper db;
    EditText editid, edttitle, edtamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbillls);

        db = new DatabaseHelper(this);
        editid=findViewById(R.id.edtid);
        edttitle=findViewById(R.id.edttitle);
        edtamount=findViewById(R.id.edtamount);
    }

    public void btnadd(View view){

        String id = editid.getText().toString();
        String title = edttitle.getText().toString();
        String amount = edtamount.getText().toString();


        boolean res = db.insertInfo(id,title,amount);
        if (amount != (null)){
            if (res){
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent (this, Bills.class);
                startActivity(intent);
            }

        }else {
            Toast.makeText(this, "Not", Toast.LENGTH_SHORT).show();
        }

    }
}