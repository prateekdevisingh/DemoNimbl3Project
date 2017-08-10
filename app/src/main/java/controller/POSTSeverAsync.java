package controller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Prateek on 09/08/2017
 * This Async class is used for POST execution
 */
public class POSTSeverAsync extends AsyncTask<String, Void, String> {
    String serverUrl = "";
    int REQUEST_CODE;
    OnFinishPOSTAsync onFinishPOSTAsync;
    boolean isSuccess = true;
    private String jsonData;
    private String header;
    private Context context;


    public POSTSeverAsync(Context context,String url, String jsonData, int requestCode, OnFinishPOSTAsync onFinishPOSTAsync) {
        this.context = context;
        this.serverUrl = url;
        this.jsonData = jsonData;
        this.REQUEST_CODE = requestCode;
        this.onFinishPOSTAsync = onFinishPOSTAsync;
    }


    public POSTSeverAsync(Context context,String url, String jsonData, String header, int requestCode, OnFinishPOSTAsync onFinishPOSTAsync) {
        this.context = context;
        this.serverUrl = url;
        this.jsonData = jsonData;
        this.header = header;
        this.REQUEST_CODE = requestCode;
        this.onFinishPOSTAsync = onFinishPOSTAsync;
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

            if (header != null && header.length() > 0) {
                multipartUtility = new MultipartUtility(context,serverUrl, header);
            } else if (header == null || header.length() == 0) {
                multipartUtility = new MultipartUtility(context,serverUrl);
            }


            if (jsonData != null && jsonData.length() > 0) {
                try {
                    multipartUtility.writeJSONData(jsonData);
                } catch (Exception e) {
                    Log.e("Error +++", e.getMessage());
                    // e.printStackTrace();
                }
            }
            result = multipartUtility.finishPost();
        } catch (Exception e) {
            Log.e("PostServerAsync", "exception");
            isSuccess = false;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            onFinishPOSTAsync.onPOSTFinish(result, REQUEST_CODE, isSuccess);
        } catch (Exception e) {

        }
    }


    public interface OnFinishPOSTAsync {
        /**
         * Callback method to publish result of server POST execution
         * @param result server result
         * @param requestCode to identify calling operation
         * @param isSuccess true is operation is completed successfully false otherwise
         */
        void onPOSTFinish(String result, int requestCode, boolean isSuccess);


    }


}
