package controller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Prateek on 09-08-2017
 * This Async class is used for DELETE execution
 */
public class DELETESeverAsync extends AsyncTask<String, Void, String> {
    private String serverUrl = "";
    private int REQUEST_CODE;
    private OnFinishDELETEAsync onFinishDELETEAsync;
    private boolean isSuccess = true;
    private String header;
    private Context context;

    public DELETESeverAsync(Context context,String url,  String header, int requestCode, OnFinishDELETEAsync onFinishDELETEAsync) {
        this.context = context;
        this.serverUrl = url;
        this.header = header;
        this.REQUEST_CODE = requestCode;
        this.onFinishDELETEAsync = onFinishDELETEAsync;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try {
            MultipartUtility multipartUtility = null;
            multipartUtility = new MultipartUtility(context,serverUrl, header, "DELETE");


            result = multipartUtility.finishDelete();
        } catch (Exception e) {
            Log.e("DELETE", "exception");
            isSuccess = false;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            onFinishDELETEAsync.onDELETEFinish(result, REQUEST_CODE, isSuccess);
        } catch (Exception e) {

        }
    }


    public interface OnFinishDELETEAsync {
        /**
         * Callback method to publish result of server DELETE execution
         *
         * @param result
         * @param requestCode
         * @param isSuccess
         */
        void onDELETEFinish(String result, int requestCode, boolean isSuccess);


    }


}
