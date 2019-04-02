package vic.tools.animationlib.animator.attention;

import android.animation.ObjectAnimator;
import android.view.View;

import vic.tools.animationlib.animator.BasicAnimatorView;

public class WobbleAnim extends BasicAnimatorView {
    @Override
    protected void setAnimator(View v) {
        float width = v.getWidth();
        float one = (float) (width / 100.0);
        getAnimator().playTogether(
                ObjectAnimator.ofFloat(v, TRANSLATION_X, 0 * one, -25 * one, 20 * one, -15 * one, 10 * one, -5 * one, 0 * one, 0),
                ObjectAnimator.ofFloat(v, ROTATION, 0, -5, 3, -3, 2, -1, 0)
        );
    }
}
