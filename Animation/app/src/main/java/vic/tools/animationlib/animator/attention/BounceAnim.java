package vic.tools.animationlib.animator.attention;

import android.animation.ObjectAnimator;
import android.view.View;

import vic.tools.animationlib.animator.BasicAnimatorView;

public class BounceAnim extends BasicAnimatorView {
    @Override
    protected void setAnimator(View v) {
        getAnimator().playTogether(
                ObjectAnimator.ofFloat(v, TRANSLATION_Y, 0, 0, -30, 0, -15, 0, 0)
        );
    }
}
