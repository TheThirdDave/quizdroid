package phida11.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class QuestionActivity extends ActionBarActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if (getIntent() != null) {
            intent = getIntent();
            int currentQuestion = intent.getIntExtra("currentQuesiont", 0);
            String[] questions = intent.getStringArrayExtra(MainActivity.QUESTIONS);
            TextView questionDisplay = (TextView) findViewById(R.id.question);
            int arrayID = getResources().getIdentifier(questions[0], "array", this.getPackageName());
            String[] question = getResources().getStringArray(arrayID);
            questionDisplay.setText(question[0]);
            int arrayId2 = getResources().getIdentifier(question[1], "array", this.getPackageName());
            String[] answers = getResources().getStringArray(arrayId2);
            RadioButton ans1 = (RadioButton) findViewById(R.id.radioButton);
            RadioButton ans2 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton ans3 = (RadioButton) findViewById(R.id.radioButton3);
            RadioButton ans4 = (RadioButton) findViewById(R.id.radioButton4);

            ans1.setText(answers[0]);
            ans2.setText(answers[1]);
            ans3.setText(answers[2]);
            ans4.setText(answers[3]);

            Button submit = (Button) findViewById(R.id.submit);
            submit.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
