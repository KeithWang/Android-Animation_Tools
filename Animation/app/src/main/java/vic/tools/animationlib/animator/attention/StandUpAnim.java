package vic.tools.animationlib.animator.attention;

import android.animation.ObjectAnimator;
import android.view.View;

import vic.tools.animationlib.animator.BasicAnimatorView;

public class StandUpAnim extends BasicAnimatorView {
    @Override
    protected void setAnimator(View v) {
        float x = (v.getWidth() - v.getPaddingLeft() - v.getPaddingRight()) / 2
                + v.getPaddingLeft();
        float y = v.getHeight() - v.getPaddingBottom();
        getAnimator().playTogether(
                ObjectAnimator.ofFloat(v, PIVOT_X, x, x, x, x, x),
                ObjectAnimator.ofFloat(v, PIVOT_Y, y, y, y, y, y),
                ObjectAnimator.ofFloat(v, ROTATION_X, 55, -30, 15, -15, 0)
        );
    }
}
