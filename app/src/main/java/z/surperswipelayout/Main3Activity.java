package z.surperswipelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private android.widget.ImageView bt;
    private android.widget.TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.tv = (TextView) findViewById(R.id.tv);
        this.bt = (ImageView) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindow popupWindow = new PopupWindow(getApplicationContext());
                TextView view = new TextView(getApplicationContext());
                view.setText("jljljljljlljlklljk");
                popupWindow.setContentView(view);
                popupWindow.showAsDropDown(bt);
            }
        });
    }
}
