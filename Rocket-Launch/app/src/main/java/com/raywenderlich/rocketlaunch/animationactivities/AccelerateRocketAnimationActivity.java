package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateInterpolator;

public class AccelerateRocketAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
// 1
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();
        mRocket.setTranslationY(value);
      }
    });

// 2 - Here set your favorite interpolator
    valueAnimator.setInterpolator(new AccelerateInterpolator(1.5f));
    valueAnimator.setDuration(DEFAULT_ANIMATION_DURATION);

// 3
    valueAnimator.start();
  }
}
