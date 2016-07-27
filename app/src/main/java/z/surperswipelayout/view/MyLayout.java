package z.surperswipelayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by max on 2016/7/27.
 */
public class MyLayout extends FrameLayout {
    private View surfaceView;

    public MyLayout(Context context) {
        this(context,null);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }


}
