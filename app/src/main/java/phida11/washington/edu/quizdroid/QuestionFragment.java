package phida11.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class QuestionFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private String[] question;
    private ArrayList<Question> questions;
    private int currentQuestion;
    private int answersCorrect;
    private ArrayList<String> answers;
    private View v;

    private Topic topic;
    private QuizApp app;
    private TopicReprository topicRepo;

    private Activity hostActivity;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app = (QuizApp)hostActivity.getApplication();
        topicRepo = app.getTopicReprository();

        if (getArguments() != null) {
            answersCorrect = getArguments().getInt(MainActivity.ANSWERS_CORRECT);
            currentQuestion = getArguments().getInt(MainActivity.CURRENT_QUESTION);
            topic = topicRepo.getTopic(getArguments().getString(MainActivity.TOPIC));
            questions = topic.getQuestions();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_question, container, false);

        TextView questionDisplay = (TextView) v.findViewById(R.id.question);
        /*
        int arrayID = getResources().getIdentifier(questions[currentQuestion], "array", hostActivity.getPackageName());
        String[] question = getResources().getStringArray(arrayID);
        */

        questionDisplay.setText(questions.get(currentQuestion).getQuestion());

        //Getting a reference to the radio buttons and the answers to the question

        //int arrayId2 = getResources().getIdentifier(question[1], "array", hostActivity.getPackageName());
        //answers = getResources().getStringArray(arrayId2);
        answers = questions.get(currentQuestion).getAnswers();

        RadioButton ans1 = (RadioButton) v.findViewById(R.id.radioButton);
        RadioButton ans2 = (RadioButton) v.findViewById(R.id.radioButton2);
        RadioButton ans3 = (RadioButton) v.findViewById(R.id.radioButton3);
        RadioButton ans4 = (RadioButton) v.findViewById(R.id.radioButton4);

        //Setting the answers to the radio buttons
        ans1.setText(answers.get(0));
        ans2.setText(answers.get(1));
        ans3.setText(answers.get(2));
        ans4.setText(answers.get(3));

        Button submit = (Button) v.findViewById(R.id.submit);
        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                RadioGroup group = (RadioGroup) v.findViewById(R.id.answers);
                if (group.getCheckedRadioButtonId() != -1) {
                    int selectedId = group.getCheckedRadioButtonId();

                    //Increment the correct answers counter if necessary
                    RadioButton selected = (RadioButton) v.findViewById(selectedId);
                    if (answers.get(questions.get(currentQuestion).getCorrect() - 1).equals(selected.getText())) {
                        answersCorrect++;
                    }

                    //Grab the selected answer and correct answer
                    String selectedAnswer = (String) selected.getText();
                    String correctAnswer = (String) answers.get(questions.get(currentQuestion).getCorrect());

                    if (hostActivity instanceof TopicActivity) {
                        ((TopicActivity) hostActivity).loadAnswerFrag(currentQuestion + 1, answersCorrect, selectedAnswer, correctAnswer);
                    }
                }
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.hostActivity = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
