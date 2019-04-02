package vic.tools.animationlib.animator.attention;

import android.animation.ObjectAnimator;
import android.view.View;

import vic.tools.animationlib.animator.BasicAnimatorView;

public class FlashAnim extends BasicAnimatorView {
    @Override
    protected void setAnimator(View v) {
        getAnimator().playTogether(
                ObjectAnimator.ofFloat(v, ALPHA, 1, 0, 1, 0, 1)
        );
    }
}
