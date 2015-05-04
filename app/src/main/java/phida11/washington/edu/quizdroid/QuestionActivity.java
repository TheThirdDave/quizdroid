package phida11.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionActivity extends ActionBarActivity {
    private Intent intent;
    private int currentQuestion;
    private String[] answers;
    private String[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        if (getIntent() != null) {
            intent = getIntent();
            currentQuestion = intent.getIntExtra("currentQuestion", 0);
            questions = intent.getStringArrayExtra(MainActivity.QUESTIONS);
            TextView questionDisplay = (TextView) findViewById(R.id.question);
            int arrayID = getResources().getIdentifier(questions[currentQuestion], "array", this.getPackageName());
            String[] question = getResources().getStringArray(arrayID);
            questionDisplay.setText(question[0]);

            //Getting a reference to the radio buttons and the answers to the question
            int arrayId2 = getResources().getIdentifier(question[1], "array", this.getPackageName());
            answers = getResources().getStringArray(arrayId2);
            RadioButton ans1 = (RadioButton) findViewById(R.id.radioButton);
            RadioButton ans2 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton ans3 = (RadioButton) findViewById(R.id.radioButton3);
            RadioButton ans4 = (RadioButton) findViewById(R.id.radioButton4);

            //Setting the answers to the radio buttons
            ans1.setText(answers[0]);
            ans2.setText(answers[1]);
            ans3.setText(answers[2]);
            ans4.setText(answers[3]);

            Button submit = (Button) findViewById(R.id.submit);
            submit.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(QuestionActivity.this, "working?", Toast.LENGTH_SHORT).show();

                    //Increment the current question being asked
                    Intent passing = new Intent(QuestionActivity.this, AnswerActivity.class);
                    passing.putExtra("currentQuestion", currentQuestion + 1);

                    RadioGroup group = (RadioGroup) findViewById(R.id.answers);
                    int selectedId = group.getCheckedRadioButtonId();

                    //Increment the correct answers counter if necessary
                    RadioButton selected = (RadioButton) findViewById(selectedId);
                    if (answers[4].equals(selected.getText())) {
                        passing.putExtra("answersCorrect", intent.getIntExtra("answersCorrect", 0) + 1);
                    } else {
                        passing.putExtra("answersCorrect", intent.getIntExtra("answersCorrect", 0));
                    }

                    //pass on the selected anwser
                    passing.putExtra("answerSelected", selected.getText());

                    //Pass on the question array
                    passing.putExtra(MainActivity.QUESTIONS, questions);
                    startActivity(passing);
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
