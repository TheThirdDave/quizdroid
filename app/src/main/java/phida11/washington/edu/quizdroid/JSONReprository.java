package phida11.washington.edu.quizdroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by GoldFish on 5/13/2015.
 */
public class JSONReprository implements TopicReprository {
    private HashMap<String, Topic> topics;

    public JSONReprository(JSONArray data) throws JSONException {
        topics = new HashMap<>();

        for (int i = 0; i < data.length(); i++) {
            JSONObject object = (JSONObject) data.get(i);
            String title = object.getString("title");
            String desc = object.getString("desc");
            JSONArray questions = object.getJSONArray("questions");
            Topic topic;
            Question tempQuestion;
            ArrayList<Question> questionList = new ArrayList<>();
            for (int q = 0; q < questions.length(); q++) {
                JSONObject question = (JSONObject) questions.get(i);
                String text = question.getString("text");
                int correct = question.getInt("answer");
                JSONArray answers = question.getJSONArray("answers");
                ArrayList<String> answersArray = new ArrayList<>();
                for (int a = 1; a < answers.length(); a++) {
                    answersArray.add(answers.getString(a));
                }
                tempQuestion = new Question(text, answersArray, correct);
                questionList.add(tempQuestion);
            }
            topics.put(title, new Topic(title, desc, null, questionList));
        }

    }


    @Override
    public Set<String> getTopics() {
        return topics.keySet();
    }

    @Override
    public Topic getTopic(String topic) {
        return topics.get(topic);
    }
}
