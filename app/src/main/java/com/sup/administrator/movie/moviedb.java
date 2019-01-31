package com.sup.administrator.movie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 1/30/2019.
 */
public class moviedb extends SQLiteOpenHelper {
    public static final String dbname="movie.db";
    public static final String tablename="movie";
    public static final String col1="id";
    public static final String col2="name";
    public static final String col3="act";
    public static final String col4="acts";
    public static final String col5="ry";
    public static final String col6="dir";
    public static final String col7="pro";
    public static final String col8="cm";
    public static final String col9="tc";
    public moviedb(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + tablename + "(" + col1 + " integer primary key autoincrement, " + col2 + " text, " + col3 + " text, " + col4 + " text, " + col5 + " text, " + col6 + " text, " + col7 + " text, " + col8 + " text, " + col9 + " text )";
        sqLiteDatabase.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="drop table if exists "+tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insert(String name,String actr,String actrs,String ry,String dir,String pro,String cm,String tc) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(col2,name);
        cv.put(col3,actr);
        cv.put(col4,actrs);
        cv.put(col5,ry);
        cv.put(col6,dir);
        cv.put(col7,pro);
        cv.put(col8,cm);
        cv.put(col9,tc);
        Long status=sqLiteDatabase.insert(tablename,null,cv);
        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor search(String name){
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cur=sq.rawQuery("SELECT * FROM "+tablename+" WHERE "+col2+"='"+name+"'",null);
        return cur;
    }
}
