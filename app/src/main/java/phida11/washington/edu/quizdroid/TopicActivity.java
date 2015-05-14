package phida11.washington.edu.quizdroid;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by David on 4/29/2015.
 */
public class TopicActivity extends FragmentActivity {
    private Intent intent;

    private TopicReprository topicRepo;
    private QuizApp app;
    private Topic topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_overview);

        app = (QuizApp)getApplication();
        topicRepo = app.getTopicReprository();


        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            TopicFragment firstFragment = new TopicFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }
    }

    public void loadQuestionFrag(int currentQuestion, int answersCorrect) {
        intent = getIntent();
        topic = topicRepo.getTopic(intent.getStringExtra(MainActivity.TOPIC));


        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        QuestionFragment questionFrag = new QuestionFragment();

        Bundle questionBundle = new Bundle();
       // questionBundle.putStringArrayList(MainActivity.QUESTIONS, topic.getQuestions()));
        questionBundle.putInt(MainActivity.CURRENT_QUESTION, currentQuestion);
        questionBundle.putInt(MainActivity.ANSWERS_CORRECT, answersCorrect);
        questionBundle.putString(MainActivity.TOPIC, intent.getStringExtra(MainActivity.TOPIC));

        questionFrag.setArguments(questionBundle);

        ft.replace(R.id.fragment_container, questionFrag);
        ft.commit();
    }

    public void loadAnswerFrag(int currentQuestion, int answersCorrect, String answerSelected, String correctAnswer) {
        intent = getIntent();
        topic = topicRepo.getTopic(intent.getStringExtra(MainActivity.TOPIC));

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        AnswerFragment answerFrag = new AnswerFragment();

        Bundle answerBundle = new Bundle();
        answerBundle.putString(MainActivity.TOPIC, intent.getStringExtra(MainActivity.TOPIC));
        answerBundle.putString("answerSelected", answerSelected);
        answerBundle.putString("correctAnswer", correctAnswer);
        answerBundle.putInt(MainActivity.CURRENT_QUESTION, currentQuestion);
        answerBundle.putInt(MainActivity.ANSWERS_CORRECT, answersCorrect);
        answerBundle.putInt("questionCount", topic.getQuestions().size());
        //answerBundle.putStringArray(MainActivity.QUESTIONS, intent.getStringArrayExtra(MainActivity.QUESTIONS));

        answerFrag.setArguments(answerBundle);

        ft.replace(R.id.fragment_container, answerFrag);
        ft.commit();
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
