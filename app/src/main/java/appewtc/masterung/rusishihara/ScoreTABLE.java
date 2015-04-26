package appewtc.masterung.rusishihara;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 4/26/15 AD.
 */
public class ScoreTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSQLite, readSQLite;

    public static final String SCORE_TABLE = "scoreTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TIME = "Time";
    public static final String COLUMN_SCORE = "Score";

    public ScoreTABLE(Context context) {

        objMyOpenHelper = new MyOpenHelper(context);
        writeSQLite = objMyOpenHelper.getWritableDatabase();
        readSQLite = objMyOpenHelper.getReadableDatabase();

    }// Constructor

    //Read AllData
    public Cursor readAllData() {

        Cursor objCursor = readSQLite.query(SCORE_TABLE, new String[]{COLUMN_ID, COLUMN_TIME, COLUMN_SCORE}, null, null, null, null, null);

        if (objCursor != null) {
            objCursor.moveToFirst();
        }

        return objCursor;
    }


    //Update Record
    public long addNewValueToSQLite(String strTime, String strScore) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_TIME, strTime);
        objContentValues.put(COLUMN_SCORE, strScore);

        return writeSQLite.insert(SCORE_TABLE, null, objContentValues);
    }


}   // Main Class
