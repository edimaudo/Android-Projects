package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

public class LaunchRocketValueAnimatorAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
  //1
      ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);

  //2
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
          //3
          float value = (float) animation.getAnimatedValue();
          //4
          mRocket.setTranslationY(value);
        }
      });

  //5
      valueAnimator.setInterpolator(new LinearInterpolator());
      valueAnimator.setDuration(DEFAULT_ANIMATION_DURATION);
  //6
      valueAnimator.start();
    }
}
