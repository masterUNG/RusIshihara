package appewtc.masterung.rusishihara;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class ListTimeActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_list_time);

        //Create ListView
        ScoreTABLE objScoreTABLE = new ScoreTABLE(this);
        Cursor myListTime = objScoreTABLE.readAllData();
        String[] from = new String[]{ScoreTABLE.COLUMN_TIME};
        int[] target = new int[]{R.id.txtShowTime};
        SimpleCursorAdapter objAdapter = new SimpleCursorAdapter(this, R.layout.activity_list_time, myListTime, from, target);
        setListAdapter(objAdapter);

    }   //onCreate

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Cursor objCursor = (Cursor) l.getItemAtPosition(position);
        String myScore = objCursor.getString(objCursor.getColumnIndex(ScoreTABLE.COLUMN_SCORE));
        Toast.makeText(getApplicationContext(), "Score = " + myScore, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_time, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
