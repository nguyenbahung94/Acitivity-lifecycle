package com.example.android.acitivity_lifecycle;

import android.widget.TextView;
import android.os.Handler;

import java.util.List;

/**
 * Created by everything on 4/6/2016.
 */
public class Utils {
    private static StatusTracker mStatusTracker=StatusTracker.getInstance();
    public static void  printStatus(final TextView ViewTheMethod,final TextView viewStatus){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Get the stack of Activity lifecycle methods called and print to TextView
                StringBuilder sbMethod=new StringBuilder();
                List<String> listMethod=mStatusTracker.getMethodList();
                for (String method:listMethod){
                    sbMethod.insert(0,method+"\r\n");
                }
                if (ViewTheMethod!=null);{
                    ViewTheMethod.setText(sbMethod.toString());
                }
                // Get the status of all Activity classes and print to TextView
                StringBuilder sbStatus=new StringBuilder();
                for (String key:mStatusTracker.keySet()){
                    sbStatus.insert(0,key+":"+mStatusTracker.getStatus(key)+"\n");

                }
                if (viewStatus!=null){
                    viewStatus.setText(sbStatus.toString());
                }


            }
        },750);
    }
}
