package fragments;

/**
 * Created by Prateek on 09/08/17.
 */
import android.view.View;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.prateek.demonimbl3project.R;

import adapters.MainPagerAdapter;
import custom_pager_view.CircularIndicator;
import custom_pager_view.CustomViewPager;


public class CustomViewPagerFragment extends Fragment {

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_pagerview, container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        CustomViewPager viewpager = (CustomViewPager) view.findViewById(R.id.viewpager);
        CircularIndicator indicator = (CircularIndicator) view.findViewById(R.id.indicator);
        viewpager.setAdapter(new MainPagerAdapter());
        indicator.setViewPager(viewpager);
    }
}