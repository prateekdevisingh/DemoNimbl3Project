package com.example.prateek.demonimbl3project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import utility.VolleyRequestSingleton;

/**
 * Created by Prateek on 19/08/17.
 */


/**
 * This class is used to initialize all views and data for Survay Landing page
 */
public class SurvayPageActivity extends AppCompatActivity {
    String title;
    String description;
    String imageUrl;
    NetworkImageView mNVSurvayImageUrl;
    TextView mTVSurvayTitle;
    TextView mTVtDescription;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survay_page_activity);

        /**
         * Here, intent data check for null and getting data from intent as per keys
         */
        try {
            if(getIntent().getStringExtra("SURVAY_DESCRIPTION") != null){
                title = getIntent().getStringExtra("SURVAY_TITLE");
                description = getIntent().getStringExtra("SURVAY_DESCRIPTION");
                imageUrl = getIntent().getStringExtra("SURVAY_IMAGE_URL");

            }
        }catch (Exception e){
            e.printStackTrace();
        }


        /**
         * This function is used to initialize all views for survay_page_activity
         */
        initilizeViews();
    }

    private void initilizeViews() {

        ImageLoader imageLoader = VolleyRequestSingleton.getInstance(getApplicationContext()).getImageLoader();

        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        ((TextView)findViewById(R.id.mTVTitle)).setText(R.string.restaurant);
        ((ImageView)findViewById(R.id.mIVRefreash)).setVisibility(View.GONE);
        ((ImageView)findViewById(R.id.mIVNav)).setVisibility(View.GONE);
        mTVSurvayTitle = (TextView) findViewById(R.id.mTVSurvayTitle);
        mTVtDescription = (TextView) findViewById(R.id.mTVtDescription);
        mNVSurvayImageUrl = (NetworkImageView) findViewById(R.id.mNVSurvayImageUrl);

        mTVSurvayTitle.setText(title);
        mTVtDescription.setText("Description :" + description);
        imageLoader.get(imageUrl, ImageLoader.getImageListener(mNVSurvayImageUrl, 0, 0));
        mNVSurvayImageUrl.setImageUrl(imageUrl, imageLoader);
    }


}
