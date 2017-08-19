package fragments;

/**
 * Created by Prateek on 09/08/17.
 */
import android.util.Log;
import android.view.View;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.prateek.demonimbl3project.MainActivity;
import com.example.prateek.demonimbl3project.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import adapters.MainPagerAdapter;
import controller.GETSeverAsync;
import custom_pager_view.CircularIndicator;
import custom_pager_view.CustomViewPager;
import models.SurvayModel;
import utility.Constant;


public class CustomViewPagerFragment extends Fragment {
    private ArrayList<SurvayModel> modelArrayList = new ArrayList<>();
    CustomViewPager customViewPager;
    CircularIndicator circularIndicator;
    ProgressBar progressBar;
    String result;

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
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