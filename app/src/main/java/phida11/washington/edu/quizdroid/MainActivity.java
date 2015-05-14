package phida11.washington.edu.quizdroid;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener {
    public final static String DESCRIPTION = "phida11.washington.edu.quizdroid.DESCRIPTION";
    public final static String TOPIC = "phida11.washington.edu.quizdroid.TOPIC";
    public final static String QUESTIONS = "phida11.washington.edu.quizdroid.QUESTIONS";
    public final static String CURRENT_QUESTION = "phida11.washington.edu.quizdroid.CURRENT_QUESTION";
    public final static String ANSWERS_CORRECT = "phida11.washingtone.edu.quizdroid.ANSWERS_CORRECT";

    private QuizApp app;
    private TopicReprository topicRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app = (QuizApp)getApplication();
        topicRepo = app.getTopicReprository();

        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {

            case R.id.button1:
                intent = new Intent(this, TopicActivity.class);
                Button temp = (Button) findViewById(R.id.button1);
                String type = temp.getText().toString();
                intent.putExtra(TOPIC, type);
                intent.putExtra(QUESTIONS, getResources().getStringArray(R.array.mathQuestions));
                intent.putExtra(DESCRIPTION, getResources().getString(R.string.mathDesc));
                startActivity(intent);
                break;

            case R.id.button2:
                intent = new Intent(this, TopicActivity.class);
                Button temp2 = (Button) findViewById(R.id.button2);
                String type2 = temp2.getText().toString();
                intent.putExtra(TOPIC, type2);
                intent.putExtra(QUESTIONS, getResources().getStringArray(R.array.physicsQuestions));
                intent.putExtra(DESCRIPTION, getResources().getString(R.string.physicsDesc));
                startActivity(intent);
                break;

            case R.id.button3:
                intent = new Intent(this, TopicActivity.class);
                Button temp3 = (Button) findViewById(R.id.button3);
                String type3 = temp3.getText().toString();
                intent.putExtra(TOPIC, type3);
                intent.putExtra(QUESTIONS, getResources().getStringArray(R.array.superQuestions));
                intent.putExtra(DESCRIPTION, getResources().getString(R.string.superDesc));
                startActivity(intent);
                break;
        }
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
