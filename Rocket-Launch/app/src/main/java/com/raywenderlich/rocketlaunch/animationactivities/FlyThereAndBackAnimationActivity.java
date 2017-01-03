package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.ValueAnimator;

public class FlyThereAndBackAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
// 1
    ValueAnimator animator = ValueAnimator.ofFloat(0, -mScreenHeight);

    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();
        mRocket.setTranslationY(value);
        mDoge.setTranslationY(value);
      }
    });

// 2
    animator.setRepeatMode(ValueAnimator.REVERSE);
// 3
    animator.setRepeatCount(3);

// 4
    animator.setDuration(500L);
    animator.start();
  }
}
