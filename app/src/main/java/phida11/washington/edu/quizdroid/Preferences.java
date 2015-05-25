package phida11.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Preferences extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        Button apply = (Button) findViewById(R.id.apply);

        final String url = ((EditText) findViewById(R.id.url)).getText().toString();
        EditText timeBetween = (EditText) findViewById(R.id.minutes);
        int temp;
        try {
            temp = Integer.parseInt(timeBetween.getText().toString());
        } catch (NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
            temp = 0;
        }

        final int time = temp;

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent download = new Intent(Preferences.this, DownloadQuestions.class);
                download.putExtra("URL", url);
                download.putExtra("Interval", time);

                Preferences.this.startService(download);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
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
