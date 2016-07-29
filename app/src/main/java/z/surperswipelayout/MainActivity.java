package z.surperswipelayout;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout dialog;
    private ImageView bt;
    boolean isOpen;
    private LinearLayout llcontent;
    private ImageView bg;
    private int measuredHeight;
    private TextView tvmoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvmoney = (TextView) findViewById(R.id.tv_money);
        this.bg = (ImageView) findViewById(R.id.bg);
        this.llcontent = (LinearLayout) findViewById(R.id.ll_content);
        this.bt = (ImageView) findViewById(R.id.bt);
        this.dialog = (LinearLayout) findViewById(R.id.dialog);
        MeasureUtil.measureView(dialog);
        measuredHeight = dialog.getMeasuredHeight();
        dialog.setTranslationY(measuredHeight);
//        tvmoney.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "去付款", Toast.LENGTH_SHORT).show();
//            }
//        });
        //如果需要点击dialog以外的部分关闭dialog,则打开次方法,否则不打开
        //注意:设置此方法是,dialog中的控件需要设置点击事件,否则点击dialog也会关闭dialog
    /*    bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDialog();
            }
        });*/
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    closeDialog();
                } else {
                    openDialog();
                }
            }
        });
    }


    private void openDialog() {
        ObjectAnimator.ofFloat(dialog, "translationY", measuredHeight, 0f).setDuration(500).start();
        ObjectAnimator.ofFloat(bt, "translationY", 0f, -measuredHeight).setDuration(500).start();
        isOpen = true;
        bg.setVisibility(View.VISIBLE);
    }

    private void closeDialog() {
        ObjectAnimator.ofFloat(dialog, "translationY", 0f, measuredHeight).setDuration(500).start();
        ObjectAnimator.ofFloat(bt, "translationY", -measuredHeight, 0f).setDuration(500).start();
        isOpen = false;
        bg.setVisibility(View.GONE);
    }
}
