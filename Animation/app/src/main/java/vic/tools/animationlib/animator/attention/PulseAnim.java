package vic.tools.animationlib.animator.attention;

import android.animation.ObjectAnimator;
import android.view.View;

import vic.tools.animationlib.animator.BasicAnimatorView;

public class PulseAnim extends BasicAnimatorView {
    @Override
    protected void setAnimator(View v) {
        getAnimator().playTogether(
                ObjectAnimator.ofFloat(v, SCALE_X, 1, 1.1f, 1),
                ObjectAnimator.ofFloat(v, SCALE_X, 1, 1.1f, 1)
        );
    }
}
