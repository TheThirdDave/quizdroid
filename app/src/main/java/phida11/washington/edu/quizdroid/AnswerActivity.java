package phida11.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AnswerActivity extends ActionBarActivity {
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        if (getIntent() != null) {
            intent = getIntent();

            //Set the users answer
            TextView userAnswer = (TextView) findViewById(R.id.userAnswer);
            userAnswer.setText(intent.getStringExtra("answerSelected"));

            //set the correct answer
            TextView correctAnswer = (TextView) findViewById(R.id.correctAnswer);
            correctAnswer.setText(intent.getStringExtra("correctAnswer"));

            //set the number of correct questions answered
            TextView answersCorrect = (TextView) findViewById(R.id.numerCorrect);
            answersCorrect.setText(intent.getIntExtra("answersCorrect", 0) + " out of " +
                    intent.getStringArrayExtra(MainActivity.QUESTIONS).length);

            Button next = (Button) findViewById(R.id.next);

            if (intent.getIntExtra("currentQuestion", 0) != intent.getStringArrayExtra(MainActivity.QUESTIONS).length) {
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent passing = new Intent(AnswerActivity.this, QuestionActivity.class);

                        //pass on the question array
                        passing.putExtra(MainActivity.QUESTIONS, intent.getStringArrayExtra(MainActivity.QUESTIONS));

                        //pass what questions user is on
                        passing.putExtra("currentQuestion", intent.getIntExtra("currentQuestion", 0));

                        //pass on number of questions correct
                        passing.putExtra("answersCorrect", intent.getIntExtra("answersCorrect", 0));

                        startActivity(passing);
                    }
                });
            } else {
                next.setText("Finish");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent finish = new Intent(AnswerActivity.this, MainActivity.class);
                        startActivity(finish);
                    }
                });

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_answer, menu);
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
