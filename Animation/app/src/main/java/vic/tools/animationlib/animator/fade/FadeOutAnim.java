package vic.tools.animationlib.animator.fade;

import android.animation.ObjectAnimator;
import android.view.View;

import vic.tools.animationlib.animator.BasicAnimatorView;

public class FadeOutAnim extends BasicAnimatorView {

    private float mStartAlpha = 1f;
    private float mEndAlpha = 0f;
    private boolean mHasPosition = false;
    private String mPosition;
    private int mDivideBy = 1;

    public FadeOutAnim() {

    }

    public FadeOutAnim(float startAlpha, float endAlpha) {
        if (startAlpha >= 1f && startAlpha <= 0f)
            mStartAlpha = startAlpha;

        if (endAlpha >= 1f && endAlpha <= 0f)
            mEndAlpha = endAlpha;
    }

    public FadeOutAnim setPosition(POSITION position, int viewDivideBy) {
        mHasPosition = true;
        switch (position) {
            case Up:
                mPosition = TRANSLATION_Y;
                mDivideBy = viewDivideBy;
                break;
            case Down:
                mPosition = TRANSLATION_Y;
                mDivideBy = -viewDivideBy;
                break;
            case Left:
                mPosition = TRANSLATION_X;
                mDivideBy = -viewDivideBy;
                break;
            case Right:
                mPosition = TRANSLATION_X;
                mDivideBy = viewDivideBy;
                break;
        }
        return this;
    }

    @Override
    protected void setAnimator(View v) {
        if (mHasPosition && mPosition != null) {
            getAnimator().playTogether(
                    ObjectAnimator.ofFloat(v, ALPHA, mStartAlpha, mEndAlpha),
                    ObjectAnimator.ofFloat(v, mPosition, 0, v.getHeight() / mDivideBy)
            );
        } else {
            getAnimator().playTogether(
                    ObjectAnimator.ofFloat(v, ALPHA, mStartAlpha, mEndAlpha)
            );

        }
    }
}
