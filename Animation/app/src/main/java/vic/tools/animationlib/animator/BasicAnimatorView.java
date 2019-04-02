package vic.tools.animationlib.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;

import java.util.ArrayList;

public abstract class BasicAnimatorView {

    protected static final long DEFAULT_DURATION = 500;
    protected final String ALPHA = "alpha";
    protected final String TRANSLATION_Y = "translationY";
    protected final String TRANSLATION_X = "translationX";
    protected final String ROTATION = "rotation";
    protected final String ROTATION_X = "rotationX";
    protected final String ROTATION_Y = "rotationY";
    protected final String PIVOT_X = "pivotX";
    protected final String PIVOT_Y = "pivotY";
    protected final String SCALE_X = "scaleX";
    protected final String SCALE_Y = "scaleY";

    private AnimatorSet mAnimatorSet;
    private int mRepeatTimes = 0;
    private int mRepeatMode = ValueAnimator.RESTART;
    private long mDuration = DEFAULT_DURATION;
    private long mDelayTime = 0;

    public enum POSITION {
        Up, Down, Right, Left
    }

    public BasicAnimatorView() {
        mAnimatorSet = new AnimatorSet();
    }

    protected abstract void setAnimator(View v);

    public AnimatorSet getAnimator() {
        return mAnimatorSet;
    }

    public void setTargetView(View v) {
        setAnimator(v);
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }

    public void setDelayTime(long delayTime) {
        mDelayTime = delayTime;
        getAnimator().setStartDelay(mDelayTime);
    }

    public void addAnimatorListenerList(ArrayList<Animator.AnimatorListener> listener) {
        for (Animator.AnimatorListener l : listener) {
            mAnimatorSet.addListener(l);
        }
    }

    public void start() {
        for (Animator animator : mAnimatorSet.getChildAnimations()) {
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).setRepeatCount(mRepeatTimes);
                ((ValueAnimator) animator).setRepeatMode(mRepeatMode);
            }
        }
        mAnimatorSet.setDuration(mDuration);
        mAnimatorSet.start();
    }

    public void cancel() {
        mAnimatorSet.cancel();
    }

    public boolean isRunning() {
        return mAnimatorSet.isRunning();
    }

    public void removeAnimatorListener(Animator.AnimatorListener listener) {
        mAnimatorSet.removeListener(listener);
    }

    public void removeAllListener() {
        mAnimatorSet.removeAllListeners();
    }

    public long getDuration() {
        return mDuration;
    }

    public long getDelayTime() {
        return mDelayTime;
    }

    public void setRepeatTimes(int repeatTimes) {
        mRepeatTimes = repeatTimes;
    }

    public void setRepeatMode(int repeatMode) {
        mRepeatMode = repeatMode;
    }
}
