package phida11.washington.edu.quizdroid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by David on 5/13/2015.
 */
public class Question implements Serializable {
    private int correct;
    private String question;
    private ArrayList<String> answers;

    public Question(String question, ArrayList<String> answers, int correct) {
        this.correct = correct;
        this.answers = answers;
        this.question = question;
    }

    public int getCorrect() {
        return this.correct;
    }

    public String getQuestion() {
        return this.question;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }
}
