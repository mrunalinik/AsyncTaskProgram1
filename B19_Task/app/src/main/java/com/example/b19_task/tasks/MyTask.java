package com.example.b19_task.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.b19_task.interfaces.DataCallback;

/**
 * Created by chethan on 11/17/2015.
 */
public class MyTask extends AsyncTask<String, Integer, String>{

    private DataCallback dataCallback;
    private final String TAG = "MyTask";

    public MyTask(DataCallback dataCallback){
        this.dataCallback = dataCallback;
    }

    //Runs on the non ui thread
    @Override
    protected String doInBackground(String... urlArray) {

        String url0 = urlArray[0];
        String url1 = urlArray[1];

        Log.i(TAG, "url0 = "+url0+" url1 = "+url1);


        int j=0;
        for(int i=0;i<10;i++){


            try {
                Thread.sleep(1000);
                j = j+10;
                publishProgress(j);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        String message = "This message is from the server";


        return message;
    }


    //Runs on the ui thread
    @Override
    protected void onPostExecute(String data) {
        dataCallback.getServerResult(data);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        Log.i(TAG,"progress = "+values[0] + "%");
    }
}
