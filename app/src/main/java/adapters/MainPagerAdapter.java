package adapters;

/**
 * Created by Prateek on 09/08/17.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.prateek.demonimbl3project.R;
import com.example.prateek.demonimbl3project.SurvayPageActivity;

import java.util.Random;

import models.SurvayModel;
import utility.Utility;
import utility.VolleyRequestSingleton;

public class MainPagerAdapter extends PagerAdapter implements View.OnClickListener{

    private final Random random = new Random();
    private int mSize;
    private ArrayList<SurvayModel> modelArrayList;
    Context context;

    public MainPagerAdapter() {
        mSize = 5;
    }

    public MainPagerAdapter(int count) {
        mSize = count;
    }

    public MainPagerAdapter(Context context, ArrayList<SurvayModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @Override public int getCount() {
        return modelArrayList.size();
    }

    @Override public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override public Object instantiateItem(ViewGroup view, int position) {



            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customView = layoutInflater.inflate(R.layout.adapter_main_pager_layout, view, false);
            ImageLoader imageLoader = VolleyRequestSingleton.getInstance(context).getImageLoader();

            SurvayModel survayModel = (SurvayModel) this.modelArrayList.get(position);
            String urlSurvay = survayModel.getCover_image_url();
            NetworkImageView networkImageView = (NetworkImageView) customView.findViewById(R.id.nivSurvay);
            Button btSurvay = (Button) customView.findViewById(R.id.btSurvay);

            btSurvay.setTag(position);


            btSurvay.setOnClickListener(this);
            imageLoader.get(urlSurvay, ImageLoader.getImageListener(networkImageView, 0, 0));
            networkImageView.setImageUrl(urlSurvay, imageLoader);
            networkImageView.setBackgroundColor(context.getResources().getColor(android.R.color.holo_orange_light));


            ((ViewPager)view).addView(customView);

            return customView;


    }

    public void addItem() {
        mSize++;
        notifyDataSetChanged();
    }

    public void removeItem() {
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btSurvay:
                Intent intent = new Intent(this.context, SurvayPageActivity.class);
                intent.putExtra("SURVAY_DESCRIPTION", ((SurvayModel)this.modelArrayList.get((Integer) view.getTag())).getDescription());
                intent.putExtra("SURVAY_TITLE", ((SurvayModel)this.modelArrayList.get((Integer) view.getTag())).getTitle());
                intent.putExtra("SURVAY_IMAGE_URL", ((SurvayModel)this.modelArrayList.get((Integer) view.getTag())).getCover_image_url());
                context.startActivity(intent);
                break;
        }

    }
}