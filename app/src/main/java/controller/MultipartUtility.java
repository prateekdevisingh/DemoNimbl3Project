package controller;

import android.content.Context;
import android.util.Log;




import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import utility.Constant;

/**
 * Created by Prateek on 09/08/2017.
 */
public class MultipartUtility {
    private String boundary;
    private static final String LINE_FEED = "\r\n";
    private HttpURLConnection httpConn;
    private String charset;
    private OutputStream outputStream;
    private PrintWriter writer;





    /**
     * applicaion-json with header
     *
     * @param requestURL
     * @param header
     * @throws IOException
     */
    public MultipartUtility(Context context,String requestURL, String header) throws IOException {
        try {
//            this.charset = Constant.CHARSET;
            // creates a unique boundary based on time stamp
            boundary = "===" + System.currentTimeMillis() + "===";
            URL url = new URL(requestURL);
            httpConn = (HttpURLConnection) url.openConnection();
            try {
//                httpConn = CustomCAHttpsProvider.getHttpsUrlConnection(requestURL, context, Utility.getDecodeString(Constant.SSL_KEY), Utility.getDecodeString(Constant.INTERMEDIATE_KEY), false);
            }catch (Exception e){

            }
            httpConn.setUseCaches(false);
            httpConn.setDoOutput(true); // indicates POST method
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("POST");
            //httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            httpConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpConn.setRequestProperty("Accept", "application/json, text/plain, */*");
//        httpConn.setRequestProperty("Content-Type", "application/json");
//        httpConn.setRequestProperty("Accept", "application/json");
            try {
                JSONObject jsonObject = new JSONObject(header);
                httpConn.setRequestProperty(jsonObject.getString("headerName"), jsonObject.getString("headerKey") + " " + jsonObject.getString("headerValue"));
            } catch (Exception e) { }
//            setXSRFToken(context,httpConn);
            outputStream = httpConn.getOutputStream();
            writer = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
        } catch (Exception e) {
            Log.e("Exeption", e.getMessage());
        }
    }

    /**
     * applicaion-json with header
     *
     * @param requestURL
     * @param header
     * @throws IOException
     */
    public MultipartUtility(Context context,String requestURL, String header, String delete) throws IOException {
        try {
            this.charset = Constant.CHARSET;
            try {
//                httpConn = CustomCAHttpsProvider.getHttpsUrlConnection(requestURL, context, Utility.getDecodeString(Constant.SSL_KEY), Utility.getDecodeString(Constant.INTERMEDIATE_KEY), false);
            }catch (Exception e){

            }
            httpConn.setUseCaches(false);
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("DELETE");
            httpConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpConn.setRequestProperty("Accept", "application/json, text/plain, */*");
            httpConn.setRequestProperty("charset", "utf-8");
            try {
                JSONObject jsonObject = new JSONObject(header);
                httpConn.setRequestProperty(jsonObject.getString("headerName"), jsonObject.getString("headerKey") + " " + jsonObject.getString("headerValue"));
            } catch (Exception e) {}
//            setXSRFToken(context,httpConn);

            httpConn.connect();
        } catch (Exception e) {
            Log.e("dat", e.getMessage());
        }
    }


    public MultipartUtility(Context context,String requestURL) throws IOException {
    try {
        this.charset = Constant.CHARSET;
        // creates a unique boundary based on time stamp
        boundary = "===" + System.currentTimeMillis() + "===";
        try {
//            httpConn = CustomCAHttpsProvider.getHttpsUrlConnection(requestURL, context, Utility.getDecodeString(Constant.SSL_KEY), Utility.getDecodeString(Constant.INTERMEDIATE_KEY), false);
        } catch (Exception e) {

        }
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true); // indicates POST method
        httpConn.setDoInput(true);
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpConn.setRequestProperty("Accept", "application/json, text/plain, */*");
//        setXSRFToken(context, httpConn);
        outputStream = httpConn.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
    }catch (Exception e){
        Log.e("exce",e.getMessage());
    }
    }


    public MultipartUtility() throws IOException {
        boundary = "===" + System.currentTimeMillis() + "===";
    }


    /**
     * Adds a form field to the request
     *
     * @param name  field name
     * @param value field value
     */
    public void addFormField(String name, String value) {
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
                .append(LINE_FEED);
        writer.append("Content-Type: text/plain; charset=" + charset).append(
                LINE_FEED);
        writer.append(LINE_FEED);
        writer.append(value).append(LINE_FEED);
        writer.flush();
    }

    public void writeJSONData(String data) {
        if (data != null && data.length() > 0) {
            try {
                outputStream.write(data.getBytes());
                outputStream.close();
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                // e.printStackTrace ();

            }
        }
    }

    /**
     * Adds a upload file section to the request
     *
     * @param fieldName  name attribute in <input type="file" name="..." />
     * @param uploadFile a File to be uploaded
     * @throws IOException
     */
    public void addFilePart(String fieldName, File uploadFile)
            throws IOException {
        String fileName = uploadFile.getName();
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append(
                "Content-Disposition: form-data; name=\"" + fieldName
                        + "\"; filename=\"" + fileName + "\"")
                .append(LINE_FEED);
        writer.append(
                "Content-Type: "
                        + URLConnection.guessContentTypeFromName(fileName))
                .append(LINE_FEED);
        writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.flush();

        FileInputStream inputStream = new FileInputStream(uploadFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        int total = inputStream.available();

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);

            //int percent = (inputStream.available()*100)/total;
            //onProgressUpdateListener.onProgress(100-percent);
        }
        outputStream.flush();
        inputStream.close();

        writer.append(LINE_FEED);
        writer.flush();
    }

    /**
     * Adds a header field to the request.
     *
     * @param name  - name of the header field
     * @param value - value of the header field
     */
    public void addHeaderField(String name, String value) {
        writer.append(name + ": " + value).append(LINE_FEED);
        writer.flush();
    }

    /**
     * Completes the request and receives response from the server.
     *
     * @return a list of Strings as response in case the server returned
     * status OK, otherwise an exception is thrown.
     * @throws IOException
     */
    public String finishPost() throws IOException {

        try {
            StringBuilder responseStrBuilder = new StringBuilder();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();

            // checks server's status code first
            int status = httpConn.getResponseCode();
/*
        if (status == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream()));

            String line = null;
            while ((line = reader.readLine()) != null) {
                responseStrBuilder.append(line);
            }
            reader.close();
            httpConn.disconnect();
        } else {
            throw new IOException("Server returned non-OK status: " + status);
        }
*/

            BufferedReader reader = null;
            if (status == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(
                        httpConn.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(httpConn.getErrorStream()));
                Log.e("Error +++", String.valueOf(reader));
            }


            String line = null;
            while ((line = reader.readLine()) != null) {
                responseStrBuilder.append(line);
            }
            reader.close();
            httpConn.disconnect();

            Log.e("response",responseStrBuilder.toString());
            return responseStrBuilder.toString();
        } catch (Exception e) {
            Log.e("response",e.getMessage().toString());
            return "";

        }
    }

    public String finishDelete() throws IOException {
        int status =  -1;
        try {
            status = httpConn.getResponseCode();
            StringBuilder responseStrBuilder = new StringBuilder();
            BufferedReader reader = null;
            if (status == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(
                        httpConn.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(httpConn.getErrorStream()));
            }


            String line = null;
            while ((line = reader.readLine()) != null) {
                responseStrBuilder.append(line);
            }
            reader.close();
            httpConn.disconnect();
            return responseStrBuilder.toString();
        } catch (Exception e) {
            Log.e("error",e.getMessage());
            return String.valueOf(status);
        }


    }

    public static String finishGet(Context context,String requestURL) throws IOException {

       // long start = System.currentTimeMillis();
        URL url = new URL(requestURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        try {
//            httpConn = CustomCAHttpsProvider.getHttpsUrlConnection(requestURL, context, C.getDecodeString(Constant.SSL_KEY), Utility.getDecodeString(Constant.INTERMEDIATE_KEY), false);
        }catch (Exception e){

        }


      //  Log.e("getrequest","calling");
        httpConn.setUseCaches(false);
        httpConn.setRequestMethod("GET");


        httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        httpConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        StringBuilder responseStrBuilder = new StringBuilder();


        // checks server's status code first
        try {
            int status = httpConn.getResponseCode();



        BufferedReader reader = null;
        if (status == HttpURLConnection.HTTP_OK) {
            reader = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream()));

        } else {
            reader = new BufferedReader(new InputStreamReader(
                    httpConn.getErrorStream()));

        }

      //  long end = System.currentTimeMillis();
        String line = null;
        while ((line = reader.readLine()) != null) {
            responseStrBuilder.append(line);

        }

        reader.close();
        }catch (Exception e){
          e.printStackTrace();
            Log.e("error", e.getMessage());
        }
        httpConn.disconnect();


       // System.out.println("Round trip response time = " + (end-start) + " millis"+"   "+responseStrBuilder.toString());
      // Log.e("response",responseStrBuilder.toString());
        //Log.e("newnewnew_http",responseStrBuilder.toString());

        return responseStrBuilder.toString();
    }
    public static String finishGet(String requestURL) throws IOException {

          URL url = new URL(requestURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        httpConn.setUseCaches(false);
        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        StringBuilder responseStrBuilder = new StringBuilder();


        // checks server's status code first
        int status = httpConn.getResponseCode();

        BufferedReader reader = null;
        if (status == HttpURLConnection.HTTP_OK) {
            reader = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream()));

        } else {
            reader = new BufferedReader(new InputStreamReader(
                    httpConn.getErrorStream()));

        }


        String line = null;
        while ((line = reader.readLine()) != null) {
            responseStrBuilder.append(line);

        }

        reader.close();
        httpConn.disconnect();
        Log.e("response",responseStrBuilder.toString());

        return responseStrBuilder.toString();
    }
    /*public static ByteArrayDataModel finishGetForByte(Context context, String requestURL) throws IOException {
        HttpURLConnection httpConn = null;// = (HttpURLConnection) url.openConnection();
        try {
            httpConn = CustomCAHttpsProvider.getHttpsUrlConnection(requestURL, context, Utility.getValue(Constant.KEY_ONE), Utility.getValue(Constant.KEY_TWO), false);
        }catch (Exception e){

        }

        httpConn.setUseCaches(false);
        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        // checks server's status code first

        InputStream inputStream;
        long contentLength = DefaultHttpDataSource.getContentLength(httpConn);
        //String contentType = httpConn.getContentType();
        //int responseCode = httpConn.getResponseCode();

        //Map<String, List<String>> headers = httpConn.getHeaderFields();
        inputStream =  httpConn.getInputStream();

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int count;
        byte[] data = new byte[16384];

        while ((count = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, count);
        }

        buffer.flush();

        inputStream.close();
        httpConn.disconnect();
        ByteArrayDataModel byteArrayDataModel = new ByteArrayDataModel(buffer.toByteArray(),contentLength);
        return byteArrayDataModel;
    }*/

    public static String finishGetWithToken(Context context, String requestURL, String token) throws IOException {


        URL url = new URL(requestURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        try {
//            httpConn = CustomCAHttpsProvider.getHttpsUrlConnection(requestURL, context, Utility.getDecodeString(Constant.SSL_KEY), Utility.getDecodeString(Constant.INTERMEDIATE_KEY), false);
        }catch (Exception e){

        }

        httpConn.setUseCaches(false);
        httpConn.setRequestMethod("GET");
        httpConn.addRequestProperty("Content-Type", "application/json");
//        httpConn.addRequestProperty("Authorization","Bearer"+" "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1NzcyMDU0ZGQ2YzE4NWFjN2Y2OWU3N2QiLCJpYXQiOjE0NjcwOTAyNTM4NDcsImV4cCI6MTQ2NzEwODI1Mzg0N30.7OBehytNR5YnOWscmr4TARgw93N1AylQM4M41idVDtk");
        httpConn.addRequestProperty("Authorization", "Bearer" + " " + token);

        StringBuilder responseStrBuilder = new StringBuilder();


        // checks server's status code first
        int status = httpConn.getResponseCode();

        if (status == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream()));

            String line = null;
            while ((line = reader.readLine()) != null) {
                responseStrBuilder.append(line);

            }

            reader.close();
            httpConn.disconnect();
        } else {
            throw new IOException("Server returned non-OK status: " + status);
        }

        return responseStrBuilder.toString();
    }


    /*private void setXSRFToken(Context context, HttpURLConnection httpConn){
        try{
            String data = Prefs.getStringValueFromPreferences(context,Constant.XSRF_TOKEN_PREF);
            JSONObject jsonObject = new JSONObject(data);
            String xsfr_key = jsonObject.getString("key");
            JSONArray jsonArray = jsonObject.getJSONArray("array");
            StringBuilder stringBuilder = new StringBuilder();
            for(int index = 1;index<jsonArray.length();index++){
                stringBuilder.append(jsonArray.getString(index));
                stringBuilder.append("; ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);

            if(xsfr_key!=null && xsfr_key.length()>Constant.ZERO){
                httpConn.setRequestProperty("XSRF-TOKEN",xsfr_key);
            }

            if(stringBuilder.length()>Constant.ZERO){
                httpConn.setRequestProperty("cookie",stringBuilder.toString());
            }

        }catch (Exception e){

        }
    }*/


}