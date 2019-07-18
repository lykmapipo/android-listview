package com.github.lykmapipo.listview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.core.widget.ContentLoadingProgressBar;

import com.github.lykmapipo.listview.R;

/**
 * A LoadingView is a derivative of {@link LinearLayout} used to displays
 * loading progress bar to user.
 * <p>
 * // TODO update usage javadocs
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public class LoadingView extends LinearLayout {

    private ContentLoadingProgressBar pbLoadingViewProgress;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // inflate layout
        inflate(context, R.layout.loading_view, this);

        // reference views
        pbLoadingViewProgress = findViewById(R.id.pbLoadingViewProgress);
    }

    /**
     * Obtain reference to {@link LoadingView} progress bar
     *
     * @return {@link ContentLoadingProgressBar}
     * @since 0.1.0
     */
    public ContentLoadingProgressBar getProgressBar() {
        return pbLoadingViewProgress;
    }
}
