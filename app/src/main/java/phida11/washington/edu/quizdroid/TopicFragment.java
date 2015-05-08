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



public class TopicFragment extends Fragment {

    private Activity hostActivity;

    // TODO: Rename and change types of parameters
    private String topicName;
    private String topicDescription;
    private int currentQuestion;
    private int answersCorrect;

    public TopicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: going to add parameters or initialize arguments
            topicName = getArguments().getString(MainActivity.TOPIC);
            topicDescription = getArguments().getString(MainActivity.DESCRIPTION);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_topic, container, false);


        TextView topic = (TextView) v.findViewById(R.id.topic);
        TextView description = (TextView) v.findViewById(R.id.description);
        topic.setText(topicName);
        description.setText(topicDescription);

        Button begin = (Button) v.findViewById(R.id.startButton);
        begin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hostActivity instanceof TopicActivity) {
                    ((TopicActivity) hostActivity).loadQuestionFrag(0, 0);
                }
            }
        });


        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //todo get hostActivity
        this.hostActivity = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
