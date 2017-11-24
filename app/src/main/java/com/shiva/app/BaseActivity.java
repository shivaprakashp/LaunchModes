package com.shiva.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

/**
 * Created by 19569 on 11/24/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    //to find activities
    protected static ActivityManager activityManager;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        //create instance of activity manager
        if (activityManager == null) {
            activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        }
    }


    protected void startActivity(Activity activity, Class myActivity) {
        Intent intent = new Intent(activity, myActivity);
        startActivity(intent);
    }

    protected static int getNumberOfTasks() {
        return activityManager.getAppTasks().size();
    }

    protected static String getAppTaskState() {
//Returns total number of tasks - stacks
        StringBuilder stringBuilder = new StringBuilder();
        int totalNumberOfTasks = activityManager.getRunningTasks(10).size();
        stringBuilder.append("\nTotal Number of Tasks: " + totalNumberOfTasks + "\n\n");

        List<ActivityManager.RunningTaskInfo> taskInfo = activityManager.getRunningTasks(10);
        //returns List of RunningTaskInfo - corresponding to tasks - stacks

        for (ActivityManager.RunningTaskInfo info : taskInfo) {
            stringBuilder.append(" Number of Activities : " + info.numActivities + "\n");
            //Number of Activities in task - stack

            // Display the root Activity of task-stack
            stringBuilder.append("TopActivity: " + info.topActivity.getClassName().
                    toString().replace("Launch modes. ", " ") + "\n");

            // Display the top Activity of task-stack
            stringBuilder.append("BaseActivity:" + info.baseActivity.getClassName().
                    toString().replace("Launch modes.", "") + "\n");
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }

}
