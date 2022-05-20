package com.example.babycare;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.lang.Float;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final int DB_VERSION =1;
    private static final String DB_NAME = "stdDBNew.db";
    private static final String TABLE_NAME = "male";
    private static String DB_PATH = "/data/data/com.example.babycare/databases/";
    //SQLiteDatabase myDatabase;

    private final Context mContext;


    public MyDBHandler(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,DB_NAME,factory,DB_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }

    private boolean checkDatabase(){
        try {
            final String mPath = DB_PATH + DB_NAME;
            final File file = new File(mPath);
            if (file.exists())
                return true;
            else
                return false;

        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    private void copyDatabase() throws IOException {
        try {
            InputStream mInputStream = mContext.getAssets().open(DB_NAME);
            String OutFileName = DB_PATH + DB_NAME;
            OutputStream mOutputStream = new FileOutputStream(OutFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = mInputStream.read(buffer)) > 0) {
                mOutputStream.write(buffer, 0, length);
            }
            mOutputStream.flush();
            mOutputStream.close();
            mInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createDatabase() throws IOException{
        boolean mDatabaseExist = checkDatabase();
        if(!mDatabaseExist){
            this.getReadableDatabase();
            this.close();
            try{
                copyDatabase();
            } catch (IOException mIOException){
                mIOException.printStackTrace();
                throw new Error("Error copying database");
            }
        }

    }

    public String loadHandlerW(int idNo,float userWeight){
        try{
            createDatabase();
        }   catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        int comp_result1,comp_result2;

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from male where Age = ? ";

        String[] selectionArgs = {idNo+""};
        Cursor c = db.rawQuery(query,selectionArgs);

        while(c.moveToNext()){
            int result_id = c.getInt(0);
            String result_maxw = c.getString(2);
            String result_minw = c.getString(1);
            float Max = Float.parseFloat(result_maxw);
            float Min = Float.parseFloat(result_minw);


            comp_result1 =Float.compare(userWeight,Max);
            comp_result2 =Float.compare(userWeight,Min);

            if(comp_result1>0){
                result = "Attention! Your baby is over weight!\n std.maxWeight:"+result_maxw+"    std.minWeight :"+result_minw;
            }
            else if(comp_result2<0){
                result = "Attention! Your baby is less weight! \nstd.maxWeight:"+result_maxw+"    std.minWeight :"+result_minw;
            }
            else{
                result = "Your baby is in good health!\nstd.maxWeight:"+result_maxw+"    std.minWeight :"+result_minw;

            }


        }
        c.close();
        db.close();
        System.out.println("output is :"+result);
        return result;

    }

    public String loadHandlerH(int idNo,float userHeight){
        try{
            createDatabase();
        }   catch (IOException e){
            e.printStackTrace();
        }
        String result = "";
        int comp_result1,comp_result2;

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from male where Age = ? ";

        String[] selectionArgs = {idNo+""};
        Cursor c = db.rawQuery(query,selectionArgs);

        while(c.moveToNext()){
            int result_id = c.getInt(0);
            String result_maxw = c.getString(4);
            String result_minw = c.getString(3);
            float Max = Float.parseFloat(result_maxw);
            float Min = Float.parseFloat(result_minw);


            comp_result1 =Float.compare(userHeight,Max);
            comp_result2 =Float.compare(userHeight,Min);

            if(comp_result1>0){
                result = "Attention! Height is more than standard!\nstd.maxHeight:"+result_maxw+"    std.minHeight :"+result_minw;
            }
            else if(comp_result2<0){
                result = "Attention! Height is less than standard! \nstd.maxHeight:"+result_maxw+"    std.minHeight :"+result_minw;
            }
            else{
                result = "Your baby is in good health!\nstd.maxHeight:"+result_maxw+"    std.minHeight :"+result_minw;

            }


        }
        c.close();
        db.close();
        System.out.println("output is :"+result);
        return result;

    }

}