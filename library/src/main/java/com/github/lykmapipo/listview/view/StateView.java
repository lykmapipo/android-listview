package com.github.lykmapipo.listview.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.github.lykmapipo.listview.R;
import com.google.android.material.button.MaterialButton;

//ref: https://trickyandroid.com/protip-inflating-layout-for-your-custom-view/
//ref: https://medium.com/@douglas.iacovelli/the-beauty-of-custom-views-and-how-to-do-it-79c7d78e2088

/**
 * A StateView is a derivative of {@link FrameLayout} used to displays
 * action result or ui state with title, message and action to user.
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public class StateView extends LinearLayout {

    private int titleResId = R.string.state_view_title;
    private int messageResId = R.string.state_view_message;
    private int imageSrcResId = R.drawable.ic_empty;
    private int imageDescriptionResId = R.string.state_view_image_description;
    private int actionTextResId = R.string.state_view_action_text;

    private AppCompatTextView tvStateViewTitle;
    private AppCompatTextView tvStateViewMessage;
    private AppCompatImageView ivStateViewImage;
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
            // inflate layout
            inflate(context, R.layout.state_view, this);

            // obtain attributes
            titleResId = ta.getResourceId(R.styleable.StateView_state_title, titleResId);
            messageResId = ta.getResourceId(R.styleable.StateView_state_message, messageResId);
            imageSrcResId = ta.getResourceId(R.styleable.StateView_state_image_src, imageSrcResId);
            imageDescriptionResId = ta.getResourceId(R.styleable.StateView_state_image_description, imageDescriptionResId);
            actionTextResId = ta.getResourceId(R.styleable.StateView_state_action_text, actionTextResId);

            // reference views
            tvStateViewTitle = findViewById(R.id.tvStateViewTitle);
            tvStateViewMessage = findViewById(R.id.tvStateViewMessage);
            ivStateViewImage = findViewById(R.id.ivStateViewImage);
            btnStateViewAction = findViewById(R.id.btnStateViewAction);

            // apply values
            tvStateViewTitle.setText(titleResId);
            tvStateViewMessage.setText(messageResId);

            Resources resources = getContext().getResources();
            String description = resources.getString(imageDescriptionResId);
            ivStateViewImage.setContentDescription(description);
            ivStateViewImage.setBackgroundResource(imageSrcResId);

            btnStateViewAction.setText(actionTextResId);
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
