package com.github.lykmapipo.listview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * A subclass of {@link FrameLayout} that can display different state of view i.e contentView, emptyView,
 * errorView and loadingView.
 * <p>
 * // TODO update usage javadocs
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public class SimpleStateLayout extends FrameLayout {

    private LoadingView loadingView;
    private StateView stateView;
    private View contentView;

    public SimpleStateLayout(Context context) {
        this(context, null);
    }

    public SimpleStateLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleStateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // initialize loading & state views
        loadingView = new LoadingView(context, attrs);
        stateView = new StateView(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // ensure views
        if (getChildCount() == 1) {
            contentView = getChildAt(0);
        }

        // add other loading & state views
        initStateView(stateView);
        initStateView(loadingView);

        // always start with loading view
        showLoadingView();
    }

    /**
     * Obtain reference to {@link SimpleStateLayout} loading view
     *
     * @return {@link LoadingView}
     * @since 0.1.0
     */
    public LoadingView getLoadingView() {
        return loadingView;
    }

    /**
     * Obtain reference to {@link SimpleStateLayout} state view
     *
     * @return {@link StateView}
     * @since 0.1.0
     */
    public StateView getStateView() {
        return stateView;
    }

    /**
     * Show loading view
     *
     * @since 0.1.0
     */
    public void showLoading() {
        showLoadingView();
    }

    private void showLoadingView() {
        showView(loadingView);
        hideView(stateView);
        hideView(contentView);
    }

    private void initStateView(View stateView) {
        if (stateView != null) {
            addView(stateView);
        }
    }

    private void showView(View view) {
        if (view != null) {
            view.setVisibility(VISIBLE);
        }
    }

    private void hideView(View view) {
        if (view != null) {
            view.setVisibility(GONE);
        }
    }
}
