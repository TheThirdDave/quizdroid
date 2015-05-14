package phida11.washington.edu.quizdroid;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by GoldFish on 5/13/2015.
 */
public interface TopicReprository {

    public Set<String> getTopics();
    public Topic getTopic(String topic);
}
