package com.github.lykmapipo.listview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * A StateView is a derivative of {@link android.widget.LinearLayout} used to displays
 * action result or ui state with title, message and action to user.
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public class StateView extends LinearLayout {

    public StateView(Context context) {
        this(context, null);
    }

    public StateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
