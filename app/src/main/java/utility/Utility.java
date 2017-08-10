package utility;

import android.content.Context;
import android.os.Build;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.prateek.demonimbl3project.R;

/**
 * Created by Prateek on 10/08/17.
 */

public class Utility {

    public static void loadNetworkImageView(Context context, String url, final NetworkImageView networkImageView, int width, int height) {


        try {
            ImageLoader imageLoader = VolleyRequestSingleton.getInstance(context).getImageLoader();
            url = getURLWithWidthAndHeight(context, url, width, height);
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
                imageLoader.get(url, ImageLoader.getImageListener(networkImageView, 0, 0));
            } else {
                /*imageLoader.get(url, ImageLoader.getImageListener(networkImageView, R.drawable.img_placeholder, R.drawable.img_placeholder));*/
                imageLoader.get(url, ImageLoader.getImageListener(networkImageView, /*R.drawable.img_new_placeholder*/ R.drawable.ic_drag_handle_black_24dp, /*R.drawable.img_new_placeholder*/ R.drawable.ic_drag_handle_black_24dp));
            }
            networkImageView.setImageUrl(url, imageLoader);
            //   Log.e("URL", getSizedBaseImageUrl(width, height) + url);
        } catch (Exception e) {
            e.printStackTrace();
        }

         /*if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
             VTapSingleImageRequest.getInstance(context).load(networkImageView, url);
         }else {

         }*/

    }

    public static String getURLWithWidthAndHeight(Context context, String url, int width, int height) {
        if(url.endsWith(".gif")){
            return url;
        }
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            url = getURLWithWidthAndHeightForKitKat(context, url, width, height);
        } else {

            if (width == 0 && height == 0) {
                url = getSizedBaseImageUrl(130, 130) + url;
            } else if (width == Constant.ZERO || height == Constant.ZERO) {
                url = getSizedBaseImageUrl(130, 130) + url;
            } else if (width == height) {
                url = getSizedBaseImageUrl(200, 200) + url;
            } else {

                url = getSizedBaseImageUrl(400, 225) + url;
            }
        }
        return url;
    }


    public static String getURLWithWidthAndHeightForKitKat(Context context, String url, int width, int height) {

        if (width == Constant.ZERO || height == Constant.ZERO) {
            url = getSizedBaseImageUrl(70, 70) + url;
        } else if (width == height) {
            url = getSizedBaseImageUrl(70, 70) + url;
        } else {
            url = getSizedBaseImageUrl(250, 140) + url;
        }
        // getMemoryInfo(context);

        return url;
    }

    public static String getSizedBaseImageUrl(int width, int height) {
        String baseUrl = Constant.IMAGE_SEVER_URL;
        if (width == 0 && height == 0) {
            baseUrl = baseUrl.replace("/size", "");
        }
        baseUrl = baseUrl.replace("size", String.valueOf(width) + "x" + String.valueOf(height));
        return baseUrl;
    }
}
