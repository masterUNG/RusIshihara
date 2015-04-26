package appewtc.masterung.rusishihara;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 4/26/15 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    private static final String DATABASE_NAME = "Rus.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_SCORE_TABLE = "";

    public MyOpenHelper() {
        super(null, null, null, 0);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   //Main Class
