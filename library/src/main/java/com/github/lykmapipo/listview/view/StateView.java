package com.github.lykmapipo.listview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.github.lykmapipo.listview.R;
import com.google.android.material.button.MaterialButton;

/**
 * A StateView is a derivative of {@link android.widget.LinearLayout} used to displays
 * action result or ui state with title, message and action to user.
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public class StateView extends LinearLayout {

    private int titleResId = R.string.state_view_title;
    private int messageResId = R.string.state_view_message;
    private int imageSrcResId = R.drawable.ic_empty;
    private int imageWidthResId = R.dimen.state_view_image_width;
    private int imageHeightResId = R.dimen.state_view_image_height;
    private int imageDescriptionResId = R.string.state_view_image_description;
    private int actionTextResId = R.string.state_view_action_text;

    private AppCompatImageView ivStateViewImage;
    private AppCompatTextView tvStateViewTitle;
    private AppCompatTextView tvStateViewMessage;
    private MaterialButton btnStateViewAction;

    public StateView(Context context) {
        this(context, null);
    }

    public StateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StateView);
        try {
            // obtain attributes
            titleResId = ta.getResourceId(R.styleable.StateView_title, titleResId);
            messageResId = ta.getResourceId(R.styleable.StateView_message, messageResId);
            imageSrcResId = ta.getResourceId(R.styleable.StateView_image_src, imageSrcResId);
            imageWidthResId = ta.getResourceId(R.styleable.StateView_image_width, imageWidthResId);
            imageHeightResId = ta.getResourceId(R.styleable.StateView_image_height, imageHeightResId);
            imageDescriptionResId = ta.getResourceId(R.styleable.StateView_image_description, imageDescriptionResId);
            actionTextResId = ta.getResourceId(R.styleable.StateView_action_text, actionTextResId);

            // reference views
            ivStateViewImage = findViewById(R.id.ivStateViewImage);
            tvStateViewTitle = findViewById(R.id.tvStateViewTitle);
            tvStateViewMessage = findViewById(R.id.tvStateViewMessage);
            btnStateViewAction = findViewById(R.id.btnStateViewAction);
        }
        // recycle TypedArray
        finally {
            ta.recycle();
        }
    }

    /**
     * Obtain reference to {@link StateView} image
     *
     * @return {@link AppCompatImageView}
     * @since 0.1.0
     */
    public AppCompatImageView getImage() {
        return ivStateViewImage;
    }

    /**
     * Obtain reference to {@link StateView} title
     *
     * @return {@link AppCompatTextView}
     * @since 0.1.0
     */
    public AppCompatTextView getTitle() {
        return tvStateViewTitle;
    }

    /**
     * Obtain reference to {@link StateView} message
     *
     * @return {@link AppCompatTextView}
     * @since 0.1.0
     */
    public AppCompatTextView getMessage() {
        return tvStateViewMessage;
    }

    /**
     * Obtain reference to {@link StateView} action
     *
     * @return {@link MaterialButton}
     * @since 0.1.0
     */
    public MaterialButton getAction() {
        return btnStateViewAction;
    }
}
