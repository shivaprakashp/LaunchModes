package com.shiva.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends BaseActivity {

    private static final String TAG=ActivityOne.class.getSimpleName();
    private static int instanceCounter=0;
    private int currentInstanceValue;

    private Button buttonStartActivityOne,
            buttonStartActivityTwo,
            buttonStartActivityThree,
            buttonStartActivityFour;

    private TextView textViewTaskInfo,
            textViewInstanceValue;

    public ActivityOne(){
        super();
        instanceCounter++;
        currentInstanceValue=instanceCounter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        initView();
        initData();
    }

    private void initView(){

        buttonStartActivityOne = (Button) findViewById(R.id.buttonStartActivityOne);
        buttonStartActivityTwo = (Button) findViewById(R.id.buttonStartActivityTwo);
        buttonStartActivityThree = (Button) findViewById(R.id.buttonStartActivityThree);
        buttonStartActivityFour = (Button) findViewById(R.id.buttonStartActivityFour);


        buttonStartActivityOne.setOnClickListener(this);
        buttonStartActivityTwo.setOnClickListener(this);
        buttonStartActivityThree.setOnClickListener(this);
        buttonStartActivityFour.setOnClickListener(this);
    }

    private void initData(){
        textViewTaskInfo=(TextView)findViewById(R.id.textViewTaskInfo);
        textViewInstanceValue=(TextView)findViewById(R.id.textViewInstanceValue);
        textViewInstanceValue.append(",Current instance: "+currentInstanceValue);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonStartActivityOne: startActivity(this,ActivityOne.class);break;
            case R.id.buttonStartActivityTwo: startActivity(this,ActivityTwo.class);break;
            case R.id.buttonStartActivityThree: startActivity(this,ActivityThree.class);break;
            case R.id.buttonStartActivityFour: startActivity(this,ActivityFour.class);break;
            default:break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Instances: "+currentInstanceValue);
        textViewTaskInfo.setText(getAppTaskState());
    }
}
