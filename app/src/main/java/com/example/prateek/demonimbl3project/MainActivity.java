package com.example.prateek.demonimbl3project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import java.util.ArrayList;
import controller.GETSeverAsync;
import fragments.CustomViewPagerFragment;
import models.SurvayModel;
import utility.Constant;
import utility.Prefs;

/**
 * This class is used to handle all initial views and data
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, GETSeverAsync.OnFinishGETAsync {
    ProgressBar mProgressBar;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /**
         * This function is used to initialize toolbar for header
         */
        initToolbar();

        /**
         * This function is used to initialize API by using GET Rest function
         */
        initilizeGetAPI();

        /**
         * This function is used to initialize all views
         */
        initilizeView();

    }

    private void initilizeView() {
        mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void initilizeGetAPI() {
        new GETSeverAsync(this, Constant.BASE_URL + Constant.ACCESS_TOKEN, Constant.BASE_URL_REQUEST_CODE, this).execute();
    }

    private void initToolbar() {
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        findViewById(R.id.mIVRefreash).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mIVRefreash:
                String result = Prefs.getStringValueFromPreferences(getApplicationContext(), Constant.APP_PREFERENCE);
                result = "";
                initilizeGetAPI();
                mProgressBar.setVisibility(View.VISIBLE);
                break;
        }
    }


    private void navigateToFragment(String fragmentName, String result) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        CustomViewPagerFragment customViewPagerFragment = CustomViewPagerFragment.newInstance(getApplicationContext(), result);
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_container, customViewPagerFragment);

        fragmentTransaction.addToBackStack(fragmentName);
        fragmentTransaction.commit();
    }


    /**
     * This override function is used to get response from API
     * @param result
     * @param requestCode
     * @param isSuccess
     */
    @Override
    public void onGETFinish(String result, int requestCode, boolean isSuccess) {

        if(Constant.BASE_URL_REQUEST_CODE == requestCode){
            try {
                mProgressBar.setVisibility(View.GONE);

                /**
                 * This function is used to call fragment by passing Fragment name and result
                 */
                navigateToFragment(Constant.FRAGMENT_TITLE, result);
                Prefs.setStringValueToPreferences(getApplicationContext(), Constant.APP_PREFERENCE, result);
            }catch (Exception e){
                e.printStackTrace();
            }


        }

    }

}

