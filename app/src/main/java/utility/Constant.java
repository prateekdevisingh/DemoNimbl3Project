package utility;

import java.util.TreeSet;

/**
 * Created by Prateek on 09/08/17.
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

    public static final int EIGHT = 8;
    public static final int SEVEN = 7;
    public static final int SIX = 6;
    public static final int FIVE = 5;
    public static final int FOUR = 4;
    public static final int THREE = 3;
    public static final int TWO = 2;
    public static final int ONE = 1;
    public static final int ZERO = 0;
    public static final int CONTENT = 0;
    public static final int LOADER = 1;
    public static final int HEADER = 2;
    public static final int NOTIFICATION_ID = 11;
    public static final String HEADER_AUTH = "Authorization";
    public static final String HEADER_KEY = "Bearer";
    public static final String CHARSET = "UTF-8";
    ////////////////////////////APIs/////////////////////////////
    public static final String BASE_URL ="https://nimbl3-survey-api.herokuapp.com/surveys.json?";
    public static final String ACCESS_TOKEN ="access_token=b08f6f28db04b5a05ba73da2de9a28a9dc06efb561d59ad6e0c96d26b07f2679"; //"https://vtbeta101.videotap.com";


    public static final int BASE_URL_REQUEST_CODE = 10001;
    ////////////////////////IMAGE THUMBNAIL URL/////////////////
    public static final String IMAGE_SEVER_URL = "https://vt-img-cdn.videotap.com/unsafe/fit-in/size/";


    ////////////////////FONTS///////////////////////
    public static final int FONT_REGULAR = 1;
    public static final int FONT_MEDIUM = 2;
    public static final int FONT_CALIBRI = 3;
    public static final int FONT_CURSIVE = 4;
    public static final int FONT_FANTASY = 5;


    ////////////////CATEGORY NUMBERING////////////////
    public static final String CATEGORY_ORI = "0";
    public static final String CATEGORY_TRAIL = "1";
    public static final String CATEGORY_FILM = "2";
    public static final String CATEGORY_WTF = "3";
    public static final String CATEGORY_MUSIC = "4";
    public static final String CATEGORY_KIDS = "5";
    public static final String CATEGORY_TV_NET = "6";
    public static final String CATEGORY_EDITORIAL = "7";


    ////////////////////LOGICAL CATEGORY/////////////////
    public static final String LOGI_CAT_RECENT = "01";
    public static final String LOGI_CAT_POPU = "02";
    public static final String LOGI_CAT_TREND = "03";
    public static final String LOGI_CAT_MOSTVIEW = "04";
    public static final String LOGI_CAT_HANDPICK = "05";


    /////////////////////logical category key list////////////
    public static final String POPULAR_KEY = "POPULAR";
    public static final String TRENDING_KEY = "TRENDING";
    public static final String RECENT_KEY = "RECENT";
    public static final String EDITORIAL_PICK_KEY = "Editorial Picks";
    public static final String HAND_PICKED_KEY = "HAND_PICKED_KEY";
    public static final String MOST_VIEWED_KEY = "MOST_VIEWED";
    public static final String RECOMMENDED_KEY = "RECOMMENDED";
    public static final String MY_LIST_KEY = "MY_LIST";


    public static final String ORIGINLA_ID = "1000";
    public static final String TRAILOR_ID = "2000";
    public static final String FILM_ID = "3000";
    public static final String WTF_ID = "4000";
    public static final String MUSIC_ID = "5000";
    public static final String KIDS_ID = "6000";
    public static final String TV_NETWORK_ID = "7000";
    public static final String EDITORIAL_PICK_ID = "8000";
    public static final String GENRE_ID = "genres";
    public static final String CHANNEL_TAG = "channel";
    public static final String TV_SPORTS_ID = "7050";
    public static final String TV_NEWS_ID = "7100";
    public static final String TV_INFORMATION_ID = "7150";
    public static final String TV_COMEDY_ID = "7200";
    public static final String TV_ENTERTAINMENT_ID = "7250";
    public static final String TV_LIFE_STYLE = "7300";
    public static final String HOME_ID = "Home";
    public static final String NEWS_BULLETIN = "mynews";

    //===================DATE FORMAT====================//
    public static final String DATE_DD_MM_YYYY = "dd-MM-yyyy";
    public static final String DATE_MM_DD_YYYY_slash = "MM/dd/yyyy";
    public static final String DATE_DD_MM_YYYY_slash_HH_MM_a = "dd/MM/yyyy hh:mm a";
    public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_YYYY_MM_DD__HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_DD_MMM_YYYY = "dd MMM yyyy";
    public static final String DATE_MM_DD_HH_MM_SS = "dd  HH:mm:ss";

    //===================TIME FORMAT====================//
    public static final String TIME_HH_MM = "HH:mm";
    public static final String TIME_HH_MM_SS = "HH:mm:ss";
    public static final String TIME_HH_MM_a = "hh:mm a";


    public static final String BOARD_FIELDS = "id,name,description,creator,image,counts,created_at";

    public static final int SUCCESS_RESULT = 0;
    public static final int FAILURE_RESULT = 1;
    public static final String PACKAGE_NAME = "com.videotap.com.vt";
    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    public static final String RESULT_DATA_KEY = PACKAGE_NAME + ".RESULT_DATA_KEY";
    public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME + ".LOCATION_DATA_EXTRA";


    //====================EDIT TEXT NAME==================//

    public static final String EDIT_NAME = "name";
    public static final String EDIT_MOBILE = "mobile";
    public static final String EDIT_CITY = "city";
    public static final String EDIT_ADDRESS = "address";
    public static final String EDIT_EMAIL = "email";
    public static final String EDIT_GENDER = "gender";
    public static final String EDIT_STATE = "state";
    public static final String EDIT_COUNTRY = "country";
    public static final String EDIT_NO_DATA = " ";

    public static final int FACEBOOK = 1;
    public static final int TWITER = 2;
    public static final int GMAIL = 3;
    public static final int GOOGLE_PLUS = 4;
    public static final int INSTAGRAM = 5;
    public static final int PINTEREST = 6;
    public static final int LIKED_IN = 7;
    public static final int WHATS_APP = 8;

    //==========================HTTPS Security kes===================//
    public static final String SSL_KEY = "TFMwdExTMUNSVWRKVGlCRFJWSlVTVVpKUTBGVVJTMHRMUzB0RFFwTlNVbEdkM3BEUTBKTGRXZEJkMGxDUVdkSlVVRnllWEZoY3pkR1RVSklSR3htV1dZeFJrcERaM3BCVGtKbmEzRm9hMmxIT1hjd1FrRlJjMFpCUkVKQ0RRcE5VWE4zUTFGWlJGWlJVVWRGZDBwV1ZYcEZWazFDVFVkQk1WVkZRMmhOVFdSSGFHaGtNMUpzVEVOQ1NtSnRUWFZOVW5OM1IxRlpSRlpSVVVSRmVFb3dEUXBoUjBZelpFZFZaMVV4VGsxSlJVNUNTVU13WjFKNlNYZElhR05PVFZSamQwNXFSVEJOUkVGM1RVUkJkMWRvWTA1TlZHZDNUbXBGTUUxcVRURlBWRlUxRFFwWGFrSjNUVkZ6ZDBOUldVUldVVkZIUlhkS1NsUnFSVk5OUWtGSFFURlZSVU5CZDBwVWJWWXpTVVZTYkdKSGFIQk5Va2wzUlVGWlJGWlJVVWhFUVd4UERRcGFXR05uVWtkV2MyRkhhM2hKUkVGbFFtZE9Wa0pCYjAxR01WcHdXakk1TWxwWFJXZFVWMVpyWVZkRloxVklXakJNYVVKTlpFZFJkVTFTWTNkR1VWbEVEUXBXVVZGRVJFRTBjVXh1V25CYVIxWjJaRWRHZDB4dFRuWmlWRU5EUVZOSmQwUlJXVXBMYjFwSmFIWmpUa0ZSUlVKQ1VVRkVaMmRGVUVGRVEwTkJVVzlERFFwblowVkNRVXhyT1ZkT2RqUnJSSFZ4Y2xkcWFGSTJZMUpPWjBSa1pscHlUbUp6TURWUWVIRnBNRXhWWkhFd1dFbzVVRlZ1TW1KMk1YSk1NazA1T1Raa0RRbzJOamszVVdWcWQwb3hlRUl4U0daemRWTTJibEV3ZEUxUFlXeHRTSEl6ZFRSQ2RFTk9VM1pRVGxaTVVVdE5SRmxWY2xGdGFsQTVUekpVY1dkUksyOWFEUXBuZVVGd2VUWXlNRU5tTkRaYVdEQXJSR05uTmxOb1RuaDFiRGxPUzFWRlpYRjNUV1Y1YW14a1IxbEhhM1JZZUVWUWFpdEJhMDFQY0haUlYyRnZRblp5RFFwUGNXMUJSMU5sV1dwaVRWaHNhek41VGs1TWFVOVBUWEprZUhWNmRIUllVbGhoZUdsbGQyNVlOMHBSYkhwWWFtUXhPRTQzVVVORWVFcFBSMEZaZVNzekRRcE9OVmt5YzAxelRWRlJlbU0zYzBZelkwRkRRWEF6VUZWaWJWVnBhbEkwY20xdGVHeE9Na0ZzV21OalJYWm5kak50UnpGbFdtUjFZMlo2WW1KSFVuUnhEUXB3ZDB4elV5OXlOMmRKTkV0WmNrMURWbTl1Tm5sUk5rOTBNREJEUVhkRlFVRmhUME5CYjFsM1oyZExRMDFEWTBkQk1WVmtSVkZSWjAxQ05rTkVhVzkxRFFwa2JXeHJXbGM1TUZsWVFYVlpNamwwWjJkNE1tRlhVbXhpTTFKb1kwTTFhbUl5TUhkRFVWbEVWbEl3VkVKQlNYZEJSRUoxUW1kT1ZraFRRVVZhZWtKc0RRcE5SMDFIUW0xbFFrUkJSVU5CYWtKYVRVTlpSME5EYzBkQlVWVkdRbmRKUWtab2NHOWtTRkozWTNwdmRrd3paRE5rZVRVd1lVZEdNMlJIVlhWWk1qbDBEUXBNTWs1M1kzcEJka0puWjNKQ1owVkdRbEZqUTBGcVFXcEVRMFp2WkVoU2QyTjZiM1pNTTJRelpIazFNR0ZIUmpOa1IxVjFXVEk1ZEV3elNteGpSemw2RFFwaFdGSjJZMjVyZDBSbldVUldVakJRUVZGSUwwSkJVVVJCWjFkblRVSTRSMEV4VldSSmQxRlpUVUpoUVVaTlNsQlRSbVk0TUZVcllYZEdNRFJtVVRSR0RRb3lPV3QxZEZaS1owMURjMGRCTVZWa1NIZFJhMDFEU1hkSlMwRmxiMEo1UjBkdGFEQmtTRUUyVEhrNU1HRnBOWHBsVnpGcVdXazFhbUl5TUhaa1IyOTFEUXBaTTBwelRVSXdSMEV4VldSS1VWRlhUVUpSUjBORGMwZEJVVlZHUW5kTlFrSm5aM0pDWjBWR1FsRmpSRUZxUWxoQ1oyZHlRbWRGUmtKUlkwSkJVVkpNRFFwTlJXdDNTSGRaU1V0M1dVSkNVVlZJVFVGSFIwVXlhREJrU0VFMlRIazVNR0ZwTlhwbFZ6RnFXa00xYW1JeU1IZEtaMWxKUzNkWlFrSlJWVWhOUVV0SERRcEhiV2d3WkVoQk5reDVPVEJoYVRWNlpWY3hhbGxwTldwaU1qQjJaRWR2ZFZrelNqQk5TVWxDUWtGWlMwdDNXVUpDUVVoWFpWRkpSVUZuVTBJNVVWTkNEUW80WjBSM1FVaGpRVE5sYzJSTE0yOU9WRFpaWjJrMFIzUm5WMmgzWm1rMlQyNVJTRlpZU1dsT1VGSklSWHBpWW5OMmMzZEJRVUZHWTNCVllsZG1kMEZCRFFwQ1FVMUJVMFJDUjBGcFJVRm9iekk1WkVGNmMydHFNR2RTYzFVNVltZGpSRGRMVDJOeFNsazVTR1ZpTTNNM2FFUnhNMVE1UjBORlEwbFJSRU5KVkV4eERRcGtaMWN4YjNCVFNtMU9hSEJ1UTFsdk4wOU5XbEoyTkdkbEwzSnRSMll4V1hvNVdVeE1kMEl4UVV0VE5VTmFRekJIUm1kVmFEZHpWRzl6ZUc1alFXODREUXBPV21kRksxSjJablZQVGpONlVUZEpSR1IzVVVGQlFVSllTMVpITVhCdlFVRkJVVVJCUlZsM1VrRkpaMGhyWkdrNE9ERm9ZMU5wV0VGeWQxWkNZWFkwRFFwWGNERk1Welp1VGprclIwaHZSbmhKTmpGRmJWaFRiME5KUjJWa1lYUmhZVWhLTkVvelNGRm1aR2hpVEZCemVVeEhiR2xVTmxGNFdGbFJkMWd6UVVoUkRRcE5XREpWVFVFd1IwTlRjVWRUU1dJelJGRkZRa04zVlVGQk5FbENRVkZEUm14RWVrSnJlRmMzTTNFelUwZHFVak12UVdObFZEZHFiamxRY1RSWk9GaG9EUXAxUzJ0S1VqVmxOVVZtTldSQmEwRnBjR1l2VDB3d1JXRkxlRXR2V0VacGNEaFpkVGhvV1U1RGNDdGFkbWxGUTNkVWNqbEhUVFUzYWpGSlducExOa3B1RFFvd1NrZ3JaVGhCTnk5Q1ZsUjRaMHhZWkZZNVVWUkZNVXRUTUVZelEweGtiVkk0ZEhWSGFXNUJWM1JHWTNOWFozTjJLMU14TTI5c2JHTktMMlZMZEc1TURRcGhhazV6TUdOaWJXNXBUR0k0V25aM1dtVndTRXhNVjBGTVNuSm5hbGhPYTBoMlVEUldZM0ExUWpSTVMydDRTbUpqWldsTVozUkROVGRJTlRkQ2QxQlFEUXBzZGpGYWFWTXlORUoxTUZGWFRVNXlNWGxoY1haQlIzWjRUSFprUzFSbVJVUnBVM04wZFdvclJ6bGhiekJvY2poT1pIaEZVRkpFZG0wek9URTVUalpGRFFwSWNtcDZNbEU1Ykc1YWMyd3dSMFZJV0VGWGN6QlVXVll6WmpJMk9YWTFPVk5wTlVOeU9FaHphWEZXTUVSV2RuRnlhMkZ3RFFvdExTMHRMVVZPUkNCRFJWSlVTVVpKUTBGVVJTMHRMUzB0RFFvPQ==";
    public static final String INTERMEDIATE_KEY = "TFMwdExTMUNSVWRKVGlCRFJWSlVTVVpKUTBGVVJTMHRMUzB0RFFwTlNVbEZjMnBEUTBFMWNXZEJkMGxDUVdkSlVVWnZabGRwUnpOcFRVRmhSa2w2TWk5RllqbHNiSHBCVGtKbmEzRm9hMmxIT1hjd1FrRlJjMFpCUkVOQ0RRcHhWRVZNVFVGclIwRXhWVVZDYUUxRFZsWk5lRVpVUVZSQ1owNVdRa0Z2VkVSSVVtOVpXR1F3V2xOM1oxTlhOV3BNYWtWdlRVTlpSMEV4VlVWRGVFMW1EUXBSTWxaNVpFZHNiV0ZYVG1oa1IyeDJZbWxDVkZwWVNqSmhWMDVzWTNsQ1JXRllXbkJqTW14MlltcEZORTFFV1VkQk1WVkZRM2hOZGt0SFRYQkpSRWwzRFFwTlJGbG5aRWRvYUdRelVteE1RMEpLWW0xTmRVbERNR2RTYlRsNVNVZEdNV1JIYUhaamJXdzJXbGRSWjJSWVRteEpSemwxWWtocmVFaDZRV1JDWjA1V0RRcENRVTFVUm01U2IxbFlaREJhVTBKUlkyMXNkRmxZU2pWSlJrcDJZak5SWjFFd1JYZElhR05PVFZSTmVFMUVUWGhOUkVGM1RVUkJkMWRvWTA1TmFrMTREUXBOUkUxM1RXcE5NVTlVVlRWWGFrSkNUVkZ6ZDBOUldVUldVVkZIUlhkS1ZsVjZSVlpOUWsxSFFURlZSVU5vVFUxa1IyaG9aRE5TYkV4RFFrcGliVTExRFFwTlVuTjNSMUZaUkZaUlVVUkZlRW93WVVkR00yUkhWV2RWTVU1TlNVVk9Ra2xETUdkU2VrbDNaMmRGYVUxQk1FZERVM0ZIVTBsaU0wUlJSVUpCVVZWQkRRcEJORWxDUkhkQmQyZG5SVXRCYjBsQ1FWRkRlUzlCWWpkQ1NsQlRObXhyWjA4d1UwWnNNVWsxTlhoRWQyVjFRM2RzUlVSaFVuWm5UVXRNZFRWNmJVRTBEUXBRT1V4WlJWVkpZbXRoTVVvM2J5OUlNMjE2WlU0eUx6bHBlVUU0WW1Wa01EQTVlbFpLU1doQ1owbHVkVTV5TjBVeFlqWk9WWGhQY1RWTFZ6UnJkM0VyRFFvM1RuSk9VRTVSZVZaMUwxRlVjVU0wYkRkek5WVkNOWFZhWTFBNWMzTTNaMWRoYkVsRFkySXJkbkUzT0ZCcWRVSkpTbVZNYWpCaVpsbEhVVWhrWW5OaURRcG9hbWxtVWpOek1IcHhTRkpzTmpFeU1rb3JNMHAwZERWblJGcEpPSE5WTXl0T2EzbHlibmxyVlRSSVNHMWhSbFZQUXpsUVpHRkROMWR4VnpkNllYZEREUXBYZUd0RE1WSk5XWEE0Tm5Oa1JsVlRRbGwxWW05d1ZrZGFTRWswZWxadllrOW9ZVzUyYmtkYWFrWlJSSFZLV25OQlpFMHJRbkJuTDBsWlJUZEJialJCRFFwU01VMUNTR2MxUjFFdmRFeE1aSGRNUjNWbmRtMVFhQ3N3V20xeVJUSjVhMFk1TlhZNWFGZ3hRV2ROUWtGQlIycG5aMFUzVFVsSlFrNTZRVk5DWjA1V0RRcElVazFDUVdZNFJVTkVRVWRCVVVndlFXZEZRVTFCTkVkQk1WVmtSSGRGUWk5M1VVVkJkMGxDUW1wQmVVSm5UbFpJVWpoRlMzcEJjRTFEWldkS1lVRnFEUXBvYVVadlpFaFNkMDlwT0haa1JFVjFZek5zZEZreVNYVlpNamwwVERGU2IxbFlaREJhVmtKRVVWTTFhbU50ZDNkTWQxbEpTM2RaUWtKUlZVaEJVVVZGRFFwSmVrRm9UVUk0UjBORGMwZEJVVlZHUW5wQlFtaG9UbTlrU0ZKM1QyazRkbVJFU1hWak0yeDBXVEpKZFZreU9YUk5SVVZIUVRGVlpFbEJVVFpOUkdkM0RRcE9aMWxMV1VsYVNVRlpZalJTVVVWSVRtcEJiMDFEV1VkRFEzTkhRVkZWUmtKM1NVSkdhSEJ2WkVoU2QyTjZiM1pNTTJRelpIazFNR0ZIUmpOa1IxVjFEUXBaTWpsMFRESk9kMk42UVhCQ1owNVdTRkpGUlVscVFXZHdRalIzU0VSRllVMUNaMGRCTVZWRlFYaE5VbFV6YkhSWlZ6VXdXbGRPVVZNd2EzUk5VekF4RFFwTmVtTjNTRkZaUkZaU01FOUNRbGxGUmsxS1VGTkdaamd3VlN0aGQwWXdOR1pSTkVZeU9XdDFkRlpLWjAxQ09FZEJNVlZrU1hkUldVMUNZVUZHU0hSaURRcFNZeXQyZW5OME5pOVVSMU5IYlhFeU9EQmljbFl3YUZGTlFUQkhRMU54UjFOSllqTkVVVVZDUTNkVlFVRTBTVUpCVVVOT1FuUTFSSGxZV1VONWRHdHFEUXBzTVRkNldUbGtPVkpOU1ZCaGQzSXhRaXRYVEhWUWNtZHZMM0J5WjBwTE1VRjVla1pPSzBSRE5WcFhNV3R1UVZsTFJVdFZOMnQwTTJGblJWQnBlVkJ6RFFwV2F6TXdRVWR1YkdoTmFtazJkRFZpVUhaWk9FSjZjVlY1YlhkdWMyTjVSRWR0UW5oS09Vc3ZRWFpWWlZKT1Rra3hZV0pVWkdsRlFXNVFjVmxhVDNOWURRcE9haTl5UjNwM0szQnlTRnBYUVZsUFkzUnNiM1oyUjI1SlRtUlROVXRTTTBnelJuZHVWbFV4YUZSbWFFaFZNbFYzYmtJdmJGVkNkVk16TW5sMFEydHhEUXBCTTI1SmRWVjRibGxSVTJkcGVXWXZWMUZFY2xaWUwwZDBlazB4VEZZMVQzSk1hbkZGYzFodk9UZHRjblp1VTFOTVRHWmFWR054UlV4NGVrTTRTRW80RFFwemFrWjFlalJFYkdsQll6SlZXSFUyV1dFNWRHcFRUbUpPUzA5V2RrdEplR1l2VERFMU4yWnZOemhUTVVwNlRIQTVOVFZ3ZUhsMmIzWnljMDF4ZFdaeERRcFpRa3h4U205d05BMEtMUzB0TFMxRlRrUWdRMFZTVkVsR1NVTkJWRVV0TFMwdExRMEs=";


}
