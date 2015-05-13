package phida11.washington.edu.quizdroid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by David on 5/13/2015.
 */
public class Topic implements Serializable {
    private String title;
    private String shortDesc;
    private String longDesc;
    private ArrayList<Question> questions;

    public Topic(String title, String shortDesc, String longDesc, ArrayList<Question> questions) {
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.questions= questions;
    }

    public String getTitle() {
        return this.title;
    }

    public String getShortDesc() {
        return this.shortDesc;
    }

    public String getLongDesc() {
        return this.longDesc;
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }
}
