package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

public class RotateRocketAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
// 1
    ValueAnimator animator = ValueAnimator.ofFloat(0, 360);

    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();
        // 2
        mRocket.setRotation(value);
      }
    });

    animator.setInterpolator(new LinearInterpolator());
    animator.setDuration(DEFAULT_ANIMATION_DURATION);
    animator.start();
  }
}
