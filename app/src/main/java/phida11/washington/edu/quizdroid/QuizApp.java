package phida11.washington.edu.quizdroid;

import android.app.Application;
import android.util.Log;


public class QuizApp extends Application {
    private static QuizApp instance;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("loadTest", "Is this being loaded?");
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
