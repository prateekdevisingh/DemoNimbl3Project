package custom_pager_view;

/**
 * Created by Prateek on 09/08/17.
 */

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Build;
import android.support.annotation.AnimatorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Build;
import android.support.annotation.AnimatorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import com.example.prateek.demonimbl3project.R;

import java.util.ArrayList;

import models.SurvayModel;

import static android.support.v4.view.ViewPager.OnPageChangeListener;

/**
 * This class is used to create custom circular indicator by extending Linear layout
 */
public class CircularIndicator extends LinearLayout {

    private static int DEFAULT_INDICATOR_WIDTH = 5;
    private static int DEFAULT_INDICATOR_MARGIN = 10;
    private ViewPager mViewpager;
    private int mIndicatorMargin = -1;
    private int mIndicatorWidth = -1;
    private int mIndicatorHeight = -1;
    private int mAnimatorResId = R.animator.scale_with_alpha;
    private int mAnimatorReverseResId = 0;
    private int mIndicatorBackgroundResId = R.drawable.white_radius;
    private int mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
    private Animator mAnimatorOut;
    private Animator mAnimatorIn;
    private Animator mImmediateAnimatorOut;
    private Animator mImmediateAnimatorIn;
    private Context context;
    private ArrayList<SurvayModel> modelArrayList;
    private int mLastPosition = -1;


    /**
     * This is class constructor with init method to initialize circular indicator functionality
     * @param context
     */
    public CircularIndicator(Context context) {
        super(context);
        init(context, null);
    }


    /**
     * This is class constructor with init method to initialize circular indicator with attrs
     * @param context
     * @param attrs
     */
    public CircularIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    /**
     * This is class constructor with init method to initialize circular indicator with context, attrs and defstyleattr
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CircularIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    /**
     * This is class constructor with init method to initialize circular indicator with context, attrs, defstylattr and defstyleres
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircularIndicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }


    /**
     * This function is used to call handleTypeArray by passing context and attrs
     * and call checkIndicatorconfig function bby passing context
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        handleTypedArray(context, attrs);
        checkIndicatorConfig(context);
    }


    /**
     * All styling of circular indicator has been done by this method
     * @param context
     * @param attrs
     */
    private void handleTypedArray(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleIndicator);
        mIndicatorWidth =
                typedArray.getDimensionPixelSize(R.styleable.CircleIndicator_ci_width, -1);
        mIndicatorHeight =
                typedArray.getDimensionPixelSize(R.styleable.CircleIndicator_ci_height, -1);
        mIndicatorMargin =
                typedArray.getDimensionPixelSize(R.styleable.CircleIndicator_ci_margin, -1);

        mAnimatorResId = typedArray.getResourceId(R.styleable.CircleIndicator_ci_animator,
                R.animator.scale_with_alpha);
        mAnimatorReverseResId =
                typedArray.getResourceId(R.styleable.CircleIndicator_ci_animator_reverse, 0);
        mIndicatorBackgroundResId =
                typedArray.getResourceId(R.styleable.CircleIndicator_ci_drawable,
                        R.drawable.white_radius);
        mIndicatorUnselectedBackgroundResId =
                typedArray.getResourceId(R.styleable.CircleIndicator_ci_drawable_unselected,
                        mIndicatorBackgroundResId);

        int orientation = typedArray.getInt(R.styleable.CircleIndicator_ci_orientation, -1);
//        setOrientation(orientation == VERTICAL ? VERTICAL : HORIZONTAL);
        setOrientation(orientation == VERTICAL ? VERTICAL : VERTICAL);
        int gravity = typedArray.getInt(R.styleable.CircleIndicator_ci_gravity, -1);
//        setGravity(gravity >= 0 ? gravity : Gravity.CENTER);

        setGravity(gravity >= 0 ? gravity : Gravity.RIGHT);

        typedArray.recycle();
    }

    /**
     * Create and configure Indicator in Java code.
     */
    public void configureIndicator(int indicatorWidth, int indicatorHeight, int indicatorMargin) {
        configureIndicator(indicatorWidth, indicatorHeight, indicatorMargin,
                R.animator.scale_with_alpha, 0, R.drawable.white_radius, R.drawable.white_radius);
    }

    public void configureIndicator(int indicatorWidth, int indicatorHeight, int indicatorMargin,
                                   @AnimatorRes int animatorId, @AnimatorRes int animatorReverseId,
                                   @DrawableRes int indicatorBackgroundId,
                                   @DrawableRes int indicatorUnselectedBackgroundId) {

        mIndicatorWidth = indicatorWidth;
        mIndicatorHeight = indicatorHeight;
        mIndicatorMargin = indicatorMargin;

        mAnimatorResId = animatorId;
        mAnimatorReverseResId = animatorReverseId;
        mIndicatorBackgroundResId = indicatorBackgroundId;
        mIndicatorUnselectedBackgroundResId = indicatorUnselectedBackgroundId;

        checkIndicatorConfig(getContext());
    }


    /**
     * This function is used to set configuration of circular indicator
     * and convert dip to pixal
     * and createAnimator in and out with duration
     * @param context
     */
    private void checkIndicatorConfig(Context context) {
        mIndicatorWidth = (mIndicatorWidth < 0) ? dip2px(DEFAULT_INDICATOR_WIDTH) : mIndicatorWidth;
        mIndicatorHeight =
                (mIndicatorHeight < 0) ? dip2px(DEFAULT_INDICATOR_WIDTH) : mIndicatorHeight;
        mIndicatorMargin =
//                (mIndicatorMargin < 0) ? dip2px(DEFAULT_INDICATOR_WIDTH) : mIndicatorMargin;
                (mIndicatorMargin < 0) ? dip2px(DEFAULT_INDICATOR_WIDTH) : mIndicatorMargin;

        mAnimatorResId = (mAnimatorResId == 0) ? R.animator.scale_with_alpha : mAnimatorResId;

        mAnimatorOut = createAnimatorOut(context);
        mImmediateAnimatorOut = createAnimatorOut(context);
        mImmediateAnimatorOut.setDuration(0);

        mAnimatorIn = createAnimatorIn(context);
        mImmediateAnimatorIn = createAnimatorIn(context);
        mImmediateAnimatorIn.setDuration(0);

        mIndicatorBackgroundResId = (mIndicatorBackgroundResId == 0) ? R.drawable.white_radius
                : mIndicatorBackgroundResId;
        mIndicatorUnselectedBackgroundResId =
                (mIndicatorUnselectedBackgroundResId == 0) ? mIndicatorBackgroundResId
                        : mIndicatorUnselectedBackgroundResId;
    }


    /**
     * This function is used load animation for out
     * @param context
     * @return
     */
    private Animator createAnimatorOut(Context context) {
        return AnimatorInflater.loadAnimator(context, mAnimatorResId);
    }



    /**
     * This function is used load animation for in
     * @param context
     * @return
     */
    private Animator createAnimatorIn(Context context) {
        Animator animatorIn;
        if (mAnimatorReverseResId == 0) {
            animatorIn = AnimatorInflater.loadAnimator(context, mAnimatorResId);
            animatorIn.setInterpolator(new ReverseInterpolator());
        } else {
            animatorIn = AnimatorInflater.loadAnimator(context, mAnimatorReverseResId);
        }
        return animatorIn;
    }


    /**
     * This function is used to instantiate viewpager and their adapter class
     * @param viewPager
     */
    public void setViewPager(ViewPager viewPager) {
        mViewpager = viewPager;
        if (mViewpager != null && mViewpager.getAdapter() != null) {
            mLastPosition = -1;
            createIndicators();
            mViewpager.removeOnPageChangeListener(mInternalPageChangeListener);
            mViewpager.addOnPageChangeListener(mInternalPageChangeListener);
            mInternalPageChangeListener.onPageSelected(mViewpager.getCurrentItem());
        }
    }

    /**
     * This function is used to set ArrayList
     * @param modelArrayList
     */
    public void setArrayList(ArrayList<SurvayModel> modelArrayList){
        this.modelArrayList = modelArrayList;
        DEFAULT_INDICATOR_WIDTH = modelArrayList.size();
    }

    /**
     * This function is used to call pagerlistener and perform animation operation like running, end and cancel
     */
    private final ViewPager.OnPageChangeListener mInternalPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override public void onPageSelected(int position) {

            if (mViewpager.getAdapter() == null || mViewpager.getAdapter().getCount() <= 0) {
                return;
            }

            if (mAnimatorIn.isRunning()) {
                mAnimatorIn.end();
                mAnimatorIn.cancel();
            }

            if (mAnimatorOut.isRunning()) {
                mAnimatorOut.end();
                mAnimatorOut.cancel();
            }

            View currentIndicator;
            if (mLastPosition >= 0 && (currentIndicator = getChildAt(mLastPosition)) != null) {
                currentIndicator.setBackgroundResource(mIndicatorUnselectedBackgroundResId);
                mAnimatorIn.setTarget(currentIndicator);
                mAnimatorIn.start();
            }

            View selectedIndicator = getChildAt(position);
            if (selectedIndicator != null) {
                selectedIndicator.setBackgroundResource(mIndicatorBackgroundResId);
                mAnimatorOut.setTarget(selectedIndicator);
                mAnimatorOut.start();
            }
            mLastPosition = position;
        }

        @Override public void onPageScrollStateChanged(int state) {
        }
    };

    public DataSetObserver getDataSetObserver() {
        return mInternalDataSetObserver;
    }


    /**
     * This is abstract data set observer class for changed state check
     */
    private DataSetObserver mInternalDataSetObserver = new DataSetObserver() {
        @Override public void onChanged() {
            super.onChanged();
            if (mViewpager == null) {
                return;
            }

            int newCount = mViewpager.getAdapter().getCount();
            int currentCount = getChildCount();

            if (newCount == currentCount) {  // No change
                return;
            } else if (mLastPosition < newCount) {
                mLastPosition = mViewpager.getCurrentItem();
            } else {
                mLastPosition = -1;
            }

            createIndicators();
        }
    };

    /**
     * @deprecated User ViewPager addOnPageChangeListener
     */
    @Deprecated public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (mViewpager == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        }
        mViewpager.removeOnPageChangeListener(onPageChangeListener);
        mViewpager.addOnPageChangeListener(onPageChangeListener);
    }

    private void createIndicators() {
        removeAllViews();
        int count = mViewpager.getAdapter().getCount();
        Log.e("count", String.valueOf(count));
        if (count <= 0) {
            return;
        }
        int currentItem = mViewpager.getCurrentItem();
        int orientation = getOrientation();

        for (int i = 0; i < count; i++) {
            if (currentItem == i) {
                addIndicator(orientation, mIndicatorBackgroundResId, mImmediateAnimatorOut);
            } else {
                addIndicator(orientation, mIndicatorUnselectedBackgroundResId,
                        mImmediateAnimatorIn);
            }
        }
    }


    /**
     * This function is used to add indicator as per orientation like Horiontal or Vertical
     * @param orientation
     * @param backgroundDrawableId
     * @param animator
     */
    private void addIndicator(int orientation, @DrawableRes int backgroundDrawableId,
                              Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }

        View Indicator = new View(getContext());
        Indicator.setBackgroundResource(backgroundDrawableId);
//        addView(Indicator, mIndicatorWidth, mIndicatorHeight);

        addView(Indicator, mIndicatorWidth, mIndicatorHeight);
        LayoutParams lp = (LayoutParams) Indicator.getLayoutParams();

/*
        if (orientation == HORIZONTAL) {
            lp.leftMargin = mIndicatorMargin;
            lp.rightMargin = mIndicatorMargin;
        } else {
            lp.topMargin = mIndicatorMargin;
            lp.bottomMargin = mIndicatorMargin;
        }
*/


        if (orientation == VERTICAL) {
            lp.leftMargin = mIndicatorMargin;
            lp.rightMargin = mIndicatorMargin;
            lp.bottomMargin = 50;
        } else {
            lp.topMargin = mIndicatorMargin;
            lp.bottomMargin = mIndicatorMargin;
        }

        Indicator.setLayoutParams(lp);

        animator.setTarget(Indicator);
        animator.start();
    }


    /**
     * This class is used to perform reverse interpolation
     */
    private class ReverseInterpolator implements Interpolator {
        @Override public float getInterpolation(float value) {
            return Math.abs(1.0f - value);
        }
    }


    /**
     * This function is used to convert dip to pixal
     * @param dpValue
     * @return
     */
    public int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

