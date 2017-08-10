package utility;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Prateek on 10-08-2017.
 */
public class VolleyRequestSingleton {
    private static VolleyRequestSingleton mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;

    private VolleyRequestSingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue ();
    }

    public static VolleyRequestSingleton getInstance(Context context) {
        if (mInstance == null) {
            synchronized (VolleyRequestSingleton.class) {
                if (mInstance == null) {
                    mInstance = new VolleyRequestSingleton ( context );
                }
            }

        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue ().add ( req );
    }

    /*public ImageLoader getImageLoader() {
        return mImageLoader;
    }*/

    public ImageLoader getImageLoader() {

        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,  new LruBitmapCache(mCtx));
        }
        return this.mImageLoader;
    }
}