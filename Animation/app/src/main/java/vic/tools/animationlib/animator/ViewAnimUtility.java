package vic.tools.animationlib.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

import java.util.ArrayList;

public class ViewAnimUtility {

    public static AnimatorObj set(BasicAnimatorView animator) {
        return new AnimatorObj(animator);
    }

    public static final class AnimatorObj {
        private BasicAnimatorView mAnimator;
        private final long mDefaultDuration = BasicAnimatorView.DEFAULT_DURATION;
        private View mTargetView;
        private int mRepeatTimes = 0;
        private int mRepeatMode = ValueAnimator.RESTART;
        private long mDuration = 0;
        private long mDelayTime = 0;
        private ArrayList<Animator.AnimatorListener> mListenerList = new ArrayList<>();

        AnimatorObj(BasicAnimatorView animator) {
            this.mAnimator = animator;
        }

        public void playOn(View v) {
            this.mTargetView = v;
            start();
        }

        public AnimatorObj setListener(Animator.AnimatorListener l) {
            this.mListenerList.add(l);
            return this;
        }

        public AnimatorObj setDuration(long duration) {
            this.mDuration = duration;
            return this;
        }

        public AnimatorObj setRepeatTime(int repeat) {
            this.mRepeatTimes = repeat;
            return this;
        }

        public AnimatorObj setRepeatMode(int mode) {
            this.mRepeatMode = mode;
            return this;
        }

        public AnimatorObj setDelayTime(long time) {
            this.mDelayTime = time;
            return this;
        }

        private void start() {
            mAnimator.setTargetView(mTargetView);

            if (mDuration <= 0)
                mDuration = mDefaultDuration;

            mAnimator.setDuration(mDuration);
            mAnimator.setDelayTime(mDelayTime);
            mAnimator.setRepeatTimes(mRepeatTimes);
            mAnimator.setRepeatMode(mRepeatMode);

            if (mListenerList.size() > 0) {
                mAnimator.addAnimatorListenerList(mListenerList);
            }
            mAnimator.start();
        }
    }

}
