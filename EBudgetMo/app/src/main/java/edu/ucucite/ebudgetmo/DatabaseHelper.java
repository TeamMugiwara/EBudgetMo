package edu.ucucite.ebudgetmo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String db_name = "budget";
    public static final String db_table1 = "bills";
    public static final String db_table2 = "expense";


    //column
    public static final String bill_id = "bill_id";
    public static final String bill_title = "bill_title";
    public static final String bill_amount = "bill_amount";

    public DatabaseHelper(Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + db_table1 + "(bill_id INTEGER PRIMARY KEY AUTOINCREMENT, bill_title TEXT, bill_amount integer)");
        sqLiteDatabase.execSQL("CREATE TABLE " + db_table2 + "(exp_id INTEGER PRIMARY KEY AUTOINCREMENT, exp_title TEXT, exp_amount integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+db_table1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+db_table2);
        onCreate(sqLiteDatabase);

    }
    //Insert Method
    public boolean insertInfo(String s_id, String s_title,String s_amount){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(bill_id,s_id);
        contentValues.put(bill_title,s_title);
        contentValues.put(bill_amount,s_amount);

        long res= sqLiteDatabase.insert(db_table1,null,contentValues);
        if(res == -1){
            return false;
        }else{
            return true;
        }

    }
    //Read Data
    public ArrayList<HashMap<String, String>> getAll(){

        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ArrayList<HashMap<String, String>> list= new ArrayList<>();

        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM " + db_table1 ,null);
        while(cursor.moveToNext()){
            HashMap<String, String> datas= new HashMap<>();
            datas.put("title", cursor.getString(cursor.getColumnIndex(bill_title)));
            datas.put("amount",cursor.getString(cursor.getColumnIndex(bill_amount)));

            list.add(datas);

        }
        return list;

    }

}
