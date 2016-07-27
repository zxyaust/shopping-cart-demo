package z.surperswipelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;

public class Main2Activity extends AppCompatActivity {


    private android.widget.ImageView bt;
    private com.daimajia.swipe.SwipeLayout swipe;
    boolean isOpen = false;//是否展开

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.swipe = (SwipeLayout) findViewById(R.id.swipe);
        swipe.setSwipeEnabled(false);//不允许边缘拉出
        this.bt = (ImageView) findViewById(R.id.bt);
        swipe.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {//关闭时回调
                super.onClose(layout);
                isOpen = false;
            }

            @Override
            public void onOpen(SwipeLayout layout) {//打开时回调
                super.onOpen(layout);
                isOpen = true;
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {//弹出框位置更新是回调
                super.onUpdate(layout, leftOffset, topOffset);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bt.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, -topOffset + 15);
                bt.setLayoutParams(layoutParams);//这段是图片的位置更新操作,通过重新设置他的marginBottom值实现
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    swipe.close(true);
                } else {
                    swipe.open(true, true, SwipeLayout.DragEdge.Bottom);
                }
            }
        });
    }
}
