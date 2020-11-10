package edu.ucucite.ebudgetmo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void btnexpense(View view) {
        Intent intent = new Intent(this, Expense.class);
        startActivity(intent);
    }

    public void btnlist(View view) {
        Intent intent = new Intent(this, Mylist.class);
        startActivity(intent);
    }

    public void btnbills(View view) {
        Intent intent = new Intent(this, Bills.class);
        startActivity(intent);
    }

    public void btnincome(View view) {
        Intent intent = new Intent(this, Income.class);
        startActivity(intent);
    }

    public void btnsavings(View view) {
        Intent intent = new Intent(this, Savings.class);
        startActivity(intent);
    }
}