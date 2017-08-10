package controller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Prateek on 09/08/2017.
 * This Async class is used for GET server request
 */
public class GETServerAsyncWithToken extends AsyncTask<String, Void, String> {
    String GETUrl = "";
    int REQUEST_CODE;
    OnFinishGETAsync onFinishGETAsync;
    boolean isSuccess = true;
    String tokenValue = "";
    private Context context;

    public GETServerAsyncWithToken(Context context, String url, String token, int requestCode, OnFinishGETAsync onFinishGETAsync) {
        this.context = context;
        this.tokenValue = token;
        this.GETUrl = url;
        this.REQUEST_CODE = requestCode;
        this.onFinishGETAsync = onFinishGETAsync;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try {
            MultipartUtility multipartUtility = new MultipartUtility();
            result = multipartUtility.finishGetWithToken(context,GETUrl,tokenValue);
        } catch (Exception e) {
            Log.e("GetServerAsync", e.getMessage());
            isSuccess = false;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            onFinishGETAsync.onGETFinishWithToken(result, REQUEST_CODE, isSuccess);
        }catch (Exception e){
          //  Log.e("Post result exception :",e.getMessage());
        }
    }

    public interface OnFinishGETAsync {
        /**
         * Callback method that return result after completion op GET Server request
         * @param result
         * @param requestCode
         * @param isSuccess
         */
        void onGETFinishWithToken(String result, int requestCode, boolean isSuccess);
    }



}
