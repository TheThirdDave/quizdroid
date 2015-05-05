package phida11.washington.edu.quizdroid;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by David on 4/29/2015.
 */
public class TopicActivity extends ActionBarActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_overview);


        intent = getIntent();
        TextView topic = (TextView) findViewById(R.id.topic);
        TextView description = (TextView) findViewById(R.id.description);
        topic.setText(intent.getStringExtra(MainActivity.TOPIC));
        description.setText(intent.getStringExtra(MainActivity.DESCRIPTION));

        Button begin = (Button) findViewById(R.id.startButton);
        begin.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent passing = new Intent(TopicActivity.this, QuestionActivity.class);
                passing.putExtra(MainActivity.QUESTIONS, intent.getStringArrayExtra(MainActivity.QUESTIONS));
                passing.putExtra("answersCorrect", 0);
                passing.putExtra("currentQuestion", 0);
                startActivity(passing);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
