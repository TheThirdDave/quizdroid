package phida11.washington.edu.quizdroid;

import android.app.Application;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


public class QuizApp extends Application {
    private static QuizApp instance;
    HashMap<String, Integer> questions;

    public QuizApp() {
        if (instance == null) {
            instance = this;
        } else {
            Log.e("MyApp", "There is an error. You tried to create more than 1 QuizApp");
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("loadTest", "Is this being loaded?");

        this.questions = new HashMap<String, Integer>();
        String json = null;

        // Fetch data.json in assets/ folder
        try {
            InputStream inputStream = getAssets().open("data.json");
            json = readJSONFile(inputStream);

            JSONObject jsonData = new JSONObject(json);

            // get the array that exist in the key 'questions'
            /*
                {
                    question: "Why is it always raining here?",
                    food : 124
                }
             */

            String questionString = jsonData.getString("question");
            int food = jsonData.getInt("food");

            this.questions.put(questionString, food); // populate your repository

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String readJSONFile(InputStream inputStream) throws IOException {

        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();

        return new String(buffer, "UTF-8");
    }

    protected void initSingletons()
    {
        // Initialize the instance of MySingleton
    }

    public void customAppMethod()
    {
        // Custom application method
    }
}
