package vic.tools.animationlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vic.tools.animationlib.animator.ViewAnimUtility;
import vic.tools.animationlib.animator.attention.BounceAnim;
import vic.tools.animationlib.animator.attention.WaveAnim;

public class MainActivity extends AppCompatActivity {

    private Button wBtn_Test_One;
    private Button wBtn_Test_Two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setViewListener();
    }

    private void initView() {
        wBtn_Test_One = findViewById(R.id.test_one);
        wBtn_Test_Two = findViewById(R.id.test_two);
    }

    private void setViewListener() {
        wBtn_Test_One.setOnClickListener(mNormalClieck);
        wBtn_Test_Two.setOnClickListener(mNormalClieck);
    }

    private View.OnClickListener mNormalClieck = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.test_one:
                    ViewAnimUtility
                            .set(new BounceAnim())
                            .setDuration(500)
                            .playOn(wBtn_Test_One);
                    break;
                case R.id.test_two:
                    ViewAnimUtility
                            .set(new WaveAnim())
                            .setDuration(500)
                            .playOn(wBtn_Test_Two);
                    break;
            }
        }
    };
}
