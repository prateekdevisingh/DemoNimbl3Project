package utility;


/**
 * Created by Prateek on 09/08/17.
 */


/**
 * This is a constant class where all static variable, method and memory handle performing
 * and all APIs url also define here
 */
public class Constant {

    private static final int DEFAULT_CACHE_SIZE = 1024 * 1024 * 10; // 10 MiB

    public static final int LRU_CACHE_SIZE_IN_BYTES;

    public static final String APP_PREFERENCE = "data_preference";

    static {
        final long thirdOfMemory = Runtime.getRuntime().maxMemory() / 3L;
        if (DEFAULT_CACHE_SIZE > thirdOfMemory) {
            LRU_CACHE_SIZE_IN_BYTES = (int) thirdOfMemory;
        } else {
            LRU_CACHE_SIZE_IN_BYTES = DEFAULT_CACHE_SIZE;
        }
    }

    public static final int ZERO = 0;
    public static final String CHARSET = "UTF-8";


    ////////////////////////////APIs/////////////////////////////
    public static final String BASE_URL ="https://nimbl3-survey-api.herokuapp.com/surveys.json?";
    public static final String ACCESS_TOKEN ="access_token=b08f6f28db04b5a05ba73da2de9a28a9dc06efb561d59ad6e0c96d26b07f2679"; //"https://vtbeta101.videotap.com";

    ////////////////////REQUEST CODES///////////////////////////
    public static final int BASE_URL_REQUEST_CODE = 10001;

    ///////////////////KEY NAME////////////////////////////////
    public static final String FRAGMENT_TITLE = "CustomViewPagerFragment";

    ////////////////////////IMAGE THUMBNAIL URL/////////////////
    public static final String IMAGE_SEVER_URL = "";


}
