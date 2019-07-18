package com.github.lykmapipo.listview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.github.lykmapipo.listview.R;
import com.google.android.material.button.MaterialButton;

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

    /**
     * Show content view
     *
     * @since 0.1.0
     */
    public void showContent() {
        showContentView();
    }

    /**
     * Show latest state view
     *
     * @since 0.1.0
     */
    public void showState() {
        showStateView();
    }

    /**
     * Show quick empty state
     *
     * @since 0.1.0
     */
    public void showEmpty() {
        showState(
                R.string.text_empty_state_title,
                R.string.text_empty_state_message,
                R.string.text_empty_state_action_text,
                R.drawable.ic_empty,
                null
        );
    }

    /**
     * Show quick empty state
     *
     * @since 0.1.0
     */
    public void showEmpty(OnClickListener clickListener) {
        showState(
                R.string.text_empty_state_title,
                R.string.text_empty_state_message,
                R.string.text_empty_state_action_text,
                R.drawable.ic_empty,
                clickListener
        );
    }

    /**
     * Show quick empty state
     *
     * @since 0.1.0
     */
    public void showEmpty(
            @StringRes int titleResId, @StringRes int messageResId,
            OnClickListener clickListener
    ) {
        showState(
                titleResId,
                messageResId,
                R.string.text_empty_state_action_text,
                R.drawable.ic_empty,
                clickListener
        );
    }

    /**
     * Show state view
     *
     * @param titleResId          resource id for title
     * @param messageResId        resource id for message
     * @param actionResId         resource id for action
     * @param actionClickListener callback to invoke when action clicked
     * @since 0.1.0
     */
    public void showState(
            @StringRes int titleResId, @StringRes int messageResId,
            @StringRes int actionResId, @DrawableRes int imageResId,
            OnClickListener actionClickListener
    ) {
        // reference state view
        AppCompatTextView title = stateView.getTitle();
        title.setText(titleResId);

        AppCompatTextView message = stateView.getMessage();
        message.setText(messageResId);

        AppCompatImageView image = stateView.getImage();
        image.setImageResource(imageResId);

        MaterialButton action = stateView.getAction();
        action.setText(actionResId);

        // show action
        if (actionClickListener != null) {
            action.setVisibility(VISIBLE);
            action.setOnClickListener(actionClickListener);
        }
        // hide action
        else {
            action.setVisibility(GONE);
        }

        // show state view
        showStateView();
    }

    /**
     * Show state view
     *
     * @param titleResId   resource id for title
     * @param messageResId resource id for message
     * @param actionResId  resource id for action
     * @since 0.1.0
     */
    public void showState(
            @StringRes int titleResId, @StringRes int messageResId,
            @StringRes int actionResId, @DrawableRes int imageResId
    ) {
        showState(titleResId, messageResId, actionResId, imageResId, null);
    }

    private void showLoadingView() {
        showView(loadingView);
        hideView(stateView);
        hideView(contentView);
    }

    private void showContentView() {
        showView(contentView);
        hideView(loadingView);
        hideView(stateView);
    }

    private void showStateView() {
        showView(stateView);
        hideView(loadingView);
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
