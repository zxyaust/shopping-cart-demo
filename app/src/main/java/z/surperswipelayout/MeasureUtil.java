package z.surperswipelayout;

import android.view.View;

/**
 * Created by max on 2016/7/20.
 */
public class MeasureUtil {
    public static void measureView(View view) {
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
    }
}
