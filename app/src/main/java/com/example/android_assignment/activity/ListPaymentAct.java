package com.example.android_assignment.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_assignment.R;
import com.example.android_assignment.database.DBHelper;

public class ListPaymentAct extends AppCompatActivity {
    private DBHelper db;
    private Cursor c;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        db = new DBHelper(this);
        ListView lvPayment = (ListView) findViewById(R.id.lvPayment);

        c = db.getAllPayment();

//        adapter =new SimpleCursorAdapter(this,R.layout.item_payment,c,new String[]{
//                DBHelper.ID,DBHelper.NAME,DBHelper.AMOUNT,DBHelper.DES,DBHelper.TIME,DBHelper.CATEGORY},
//                 new int[]{R.id.tvId, R.id.tvName,R.id.tvAmount,R.id.}
//        })
    }

}
