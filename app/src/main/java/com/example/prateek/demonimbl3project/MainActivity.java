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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GETSeverAsync.OnFinishGETAsync {
    private ArrayList<SurvayModel> modelArrayList = new ArrayList<>();
    Button btMain;
    ProgressBar progressBar;
    String data = "";

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        initToolbar();
        initilizeGetAPI();
        initilizeView();

    }

    private void initilizeView() {
        btMain = (Button) findViewById(R.id.btMain);
        progressBar = (ProgressBar) findViewById(R.id.pbMain);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void initilizeGetAPI() {
        new GETSeverAsync(this, Constant.BASE_URL + Constant.ACCESS_TOKEN, Constant.BASE_URL_REQUEST_CODE, this).execute();
    }

    private void initToolbar() {
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        findViewById(R.id.ivRefreash).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivRefreash:
                String result = Prefs.getStringValueFromPreferences(getApplicationContext(), Constant.APP_PREFERENCE);
                result = "";
                initilizeGetAPI();
                progressBar.setVisibility(View.VISIBLE);
                break;
        }
    }


    private void navigateToFragment(String fragmentName, String result) {
        String key = "SURVAY_DATA";
        CustomViewPagerFragment customViewPagerFragment = new CustomViewPagerFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(key, result);
        customViewPagerFragment.setArguments(bundle);
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_container, customViewPagerFragment);
        fragmentTransaction.addToBackStack(fragmentName);
        fragmentTransaction.commit();
    }

    @Override
    public void onGETFinish(String result, int requestCode, boolean isSuccess) {
        Log.e("result", result);

        if(Constant.BASE_URL_REQUEST_CODE == requestCode){
            try {
                progressBar.setVisibility(View.GONE);
                navigateToFragment("CustomViewPagerFragment", result);
                Prefs.setStringValueToPreferences(getApplicationContext(), Constant.APP_PREFERENCE, result);
            }catch (Exception e){
                e.printStackTrace();
            }


        }

    }

}

