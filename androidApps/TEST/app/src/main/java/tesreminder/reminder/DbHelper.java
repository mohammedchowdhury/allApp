package tesreminder.reminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DEV";
    private static final int DB_VER = 1;
    public static final String DB_TABLE = "Task";
    public static final String DB_COLUM = "TaskName";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("Create Table %s (ID integer primary key autoincrement, %s Text Not NULL);",DB_TABLE, DB_COLUM);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = String.format("Delete table if exists %s", DB_TABLE);
        db.execSQL(query);
        onCreate(db);
    }

    public  void insertNewTask(String task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUM, task);
        db.insertWithOnConflict(DB_TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public  void deleteTask(String task){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE, DB_COLUM + " = ? ", new String[]{task});
        db.close();
    }

    public ArrayList<String> getTaskList(){
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DB_TABLE, new String[]{DB_COLUM}, null, null, null, null, null);
        while(cursor.moveToNext()){
            int index  = cursor.getColumnIndex(DB_COLUM);
            taskList.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return taskList;
    }
}
