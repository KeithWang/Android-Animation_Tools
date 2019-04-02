package vic.tools.animationlib.animator.attention;

import android.animation.ObjectAnimator;
import android.view.View;

import vic.tools.animationlib.animator.BasicAnimatorView;

public class ShakeAnim extends BasicAnimatorView {
    @Override
    protected void setAnimator(View v) {
        getAnimator().playTogether(
                ObjectAnimator.ofFloat(v, TRANSLATION_X, 0, 25, -25, 25, -25, 15, -15, 6, -6, 0)
        );
    }
}
