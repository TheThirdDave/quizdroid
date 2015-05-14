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
import android.widget.TextView;


public class AnswerFragment extends Fragment {
    private Activity hostActivity;

    private String selectedAnswer;
    private String correctAns;
    private int currentQuestion;
    private int answersCorrect;
    private int questionCount;


    private View v;

    public AnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            currentQuestion = getArguments().getInt(MainActivity.CURRENT_QUESTION);
            answersCorrect = getArguments().getInt(MainActivity.ANSWERS_CORRECT);
            selectedAnswer = getArguments().getString("answerSelected");
            correctAns = getArguments().getString("correctAnswer");
            questionCount = getArguments().getInt("questionCount");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_answer, container, false);

        TextView userAnswer = (TextView) v.findViewById(R.id.userAnswer);
        userAnswer.setText(selectedAnswer);

        //set the correct answer
        TextView correctAnswer = (TextView) v.findViewById(R.id.correctAnswer);
        correctAnswer.setText(correctAns);

        //set the number of correct questions answered
        final TextView score = (TextView) v.findViewById(R.id.numerCorrect);
        score.setText(answersCorrect + " out of " + questionCount);

        Button next = (Button) v.findViewById(R.id.next);

        if (currentQuestion != questionCount) {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (hostActivity instanceof TopicActivity) {
                        ((TopicActivity) hostActivity).loadQuestionFrag(currentQuestion, answersCorrect);
                    }
                }
            });
        } else {
            next.setText("Finish");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent finished = new Intent(getActivity(), MainActivity.class);
                    startActivity(finished);
                }
            });

        }

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
