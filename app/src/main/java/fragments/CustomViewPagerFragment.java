package fragments;

/**
 * Created by Prateek on 09/08/17.
 */
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.prateek.demonimbl3project.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import adapters.MainPagerAdapter;
import custom_pager_view.CircularIndicator;
import custom_pager_view.CustomViewPager;
import models.SurvayModel;

/**
 * This class is used to create all views and data manipulation on fragment
 */
public class CustomViewPagerFragment extends Fragment {
    private ArrayList<SurvayModel> modelArrayList = new ArrayList<>();
    CustomViewPager customViewPager;
    CircularIndicator circularIndicator;
    String result;

    /**
     * This CustomViewPagerFragment newInstance is used to get data from activity
     * and then put data in bundle for further uses
     * @param context
     * @param result
     * @return
     */
    public static CustomViewPagerFragment newInstance(Context context, String result){
        CustomViewPagerFragment customViewPagerFragment = new CustomViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SURVAY_DATA", result);
        customViewPagerFragment.setArguments(bundle);
        return customViewPagerFragment;
    }

    /**
     * This function is used to create all views
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        /**
         * Here, bundle data is check and getting result for further purpose in fragment
         */
        try {
            if(getArguments().getString("SURVAY_DATA") != null){
                result = getArguments().getString("SURVAY_DATA");

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return inflater.inflate(R.layout.fragment_custom_pagerview, container, false);
    }


    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        customViewPager = (CustomViewPager) view.findViewById(R.id.viewpager);
        circularIndicator = (CircularIndicator) view.findViewById(R.id.indicator);

        /**
         * This function is used to parse result data
         */
        resultParsing(result);

    }

    public void resultParsing(String result) {

            try {
                JSONArray jsonArray = new JSONArray(result);


            for (int index = 0 ; index < jsonArray.length() ; index++){
                try{
                    JSONObject jsonObject = jsonArray.getJSONObject(index);
                    parseJsonSurvay(jsonObject);

                     }catch (Exception e){
                    e.printStackTrace();
                }
                customViewPager.setAdapter(new MainPagerAdapter(getContext(), modelArrayList));
                circularIndicator.setViewPager(customViewPager);

            }


                circularIndicator.setArrayList(modelArrayList);
            }catch (Exception e){
               e.printStackTrace();
            }

    }


    /**
     * This function is used to parse json survay data from jsonobject in SurvayModel class
     * and add to modelArrayList
     * @param jsonObject
     */
    private void parseJsonSurvay(JSONObject jsonObject) {
        try{
            modelArrayList.add(new SurvayModel(jsonObject.optString("access_code_prompt"),
                    jsonObject.optString("access_code_validation"),
                    jsonObject.optString("active_at"),
                    jsonObject.optString("cover_background_color"),
                    jsonObject.optString("cover_image_url"),
                    jsonObject.optString("created_at"),
                    jsonObject.optString("default_language"),
                    jsonObject.optString("description"),
                    jsonObject.optString("footer_content"),
                    jsonObject.optString("id"),
                    jsonObject.optString("inactive_at"),
                    jsonObject.optBoolean("is_access_code_required"),
                    jsonObject.optBoolean("is_access_code_valid_required"),
                    jsonObject.optBoolean("is_active"),
                    jsonObject.optString("language_list"),
                    jsonObject.optString("questions"),
                    jsonObject.optString("short_url"),
                    jsonObject.optString("survey_version"),
                    jsonObject.optString("tag_list"),
                    jsonObject.optString("thank_email_above_threshold"),
                    jsonObject.optString("thank_email_below_threshold"),
                    jsonObject.optString("theme"),
                    jsonObject.optString("title"),
                    jsonObject.optString("type")));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}