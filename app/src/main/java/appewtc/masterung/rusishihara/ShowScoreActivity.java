package appewtc.masterung.rusishihara;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ShowScoreActivity extends ActionBarActivity {

    //Explicit
    private TextView txtShowScore;
    private int intMyScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        //Bind Widget
        txtShowScore = (TextView) findViewById(R.id.txtShowScore);

        //Receive From Main Activity
        intMyScore = getIntent().getExtras().getInt("Score");
        txtShowScore.setText(Integer.toString(intMyScore) + "/10" );

    }   //onCreate

    public void clickPlay(View view) {

        Intent objIntent = new Intent(ShowScoreActivity.this, MainActivity.class);
        startActivity(objIntent);
        finish();
    }

    public void clickSave(View view) {

        //Get Time
        DateFormat objDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date objDate = new Date();
        String strCurrentTime = objDateFormat.format(objDate);

        //Updata Data
        ScoreTABLE objScoreTABLE = new ScoreTABLE(this);
        objScoreTABLE.addNewValueToSQLite(strCurrentTime, Integer.toString(intMyScore));
        Toast.makeText(getApplicationContext(), "Save Finish", Toast.LENGTH_SHORT).show();

        Intent objIntent = new Intent(ShowScoreActivity.this, ListTimeActivity.class);
        startActivity(objIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_score, menu);
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
}   // Main Class
