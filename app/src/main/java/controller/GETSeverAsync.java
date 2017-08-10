package controller;

import android.content.Context;
import android.os.AsyncTask;

import utility.Constant;

/**
 * Created by Mangal on 09/08/2017.
 * This Async class is used for GET server request
 */
public class GETSeverAsync extends AsyncTask<String, Void, String> {
    private String GETUrl = "";
    private int REQUEST_CODE;
    private OnFinishGETAsync onFinishGETAsync;
    boolean isSuccess = true;
    private String tokenValue = "";
    private Context context;
    public GETSeverAsync(Context context,String url, int requestCode, OnFinishGETAsync onFinishGETAsync) {
        this.context = context;
        this.GETUrl = url;
        this.REQUEST_CODE = requestCode;
        this.onFinishGETAsync = onFinishGETAsync;
    }
    public GETSeverAsync(Context context, String url, String token, int requestCode, OnFinishGETAsync onFinishGETAsync) {
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
            if(context!=null && tokenValue!=null && tokenValue.length()> Constant.ZERO){
                result = multipartUtility.finishGetWithToken(context,GETUrl,tokenValue);
            }else if(context!=null) {
                result = multipartUtility.finishGet(context, GETUrl);
            }else{
                result = multipartUtility.finishGet(GETUrl);
            }

        } catch (Exception e) {
         //   Log.e("GetServerAsync", e.getMessage());
            isSuccess = false;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {

            onFinishGETAsync.onGETFinish(result, REQUEST_CODE, isSuccess);

        }catch (Exception e){
       // Log.e("Post result exception :",e.getMessage());
        }
    }

    public interface OnFinishGETAsync {
        /**
         * Callback method that return result after completion op GET Server request
         * @param result
         * @param requestCode
         * @param isSuccess
         */
         void onGETFinish(String result, int requestCode, boolean isSuccess);
    }



}
