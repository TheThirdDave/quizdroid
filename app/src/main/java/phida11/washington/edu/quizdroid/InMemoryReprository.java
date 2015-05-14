package phida11.washington.edu.quizdroid;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GoldFish on 5/13/2015.
 */
public class InMemoryReprository implements TopicReprository {
    private HashMap<String, Topic> topics;


    public InMemoryReprository() {

        //Science Topics
        ArrayList<Question> scienceQs = new ArrayList<Question>();

        scienceQs.add(new Question("What is fire?", new ArrayList<String>(Arrays.asList("One of the four classical elements",
                "A magical reaction given to us by God",
                "A band that hasn't yet been discovered",
                "Fire! Fire! Fire! heh-heh")), 1));

        Topic science = new Topic("Science", "Because Science!", null, scienceQs);

        topics.put("Science", science);

        //Marvel Super Heroes Topic
        ArrayList<Question> marvelQs = new ArrayList<Question>();

        marvelQs.add(new Question("Who is Iron Man?", new ArrayList<String>(Arrays.asList("Tony Stark",
                "Obadiah Stane",
                "A rock hit by Megadeth",
                "Nobody knows")), 1));

        marvelQs.add(new Question("Who founded the X-Men?", new ArrayList<String>(Arrays.asList("Tony Stark",
                "Professor X",
                "The X-Institute",
                "Erik Lensherr")), 2));

        marvelQs.add(new Question("How did Spider-Man get his powers?", new ArrayList<String>(Arrays.asList("He was bitten by a radioactive spider",
                "He ate a radioactive spider",
                "He is a radioactive spider",
                "He looked at a radioactive spider")), 1));

        Topic marvel = new Topic("Marvel Super Heroes", "Avengers, Assemble!", null, marvelQs);

        topics.put("Marvel Super Heroes", marvel);


        //Math Topic
        ArrayList<Question> mathQs = new ArrayList<Question>();

        mathQs.add(new Question("What is 2+2?", new ArrayList<String>(Arrays.asList("4",
                "22",
                "An irrational number",
                "Nobody knows")), 1));

        Topic math = new Topic("Math", "Did you pass the third grade?", null, mathQs);

        topics.put("Math", math);
    }

    @Override
    public Set<String> getTopics() {
        HashSet<String> value = new HashSet(topics.keySet());
        return value;
    }

    @Override
    public Topic getTopic(String topic) {
        return topics.get(topic);
    }
}
