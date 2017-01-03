package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

public class FlyWithDogeAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
//1
    ValueAnimator positionAnimator = ValueAnimator.ofFloat(0, -mScreenHeight);
    positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();
        // You can use value to set properties of many objects
        mRocket.setTranslationY(value);
        mDoge.setTranslationY(value);
      }
    });

//2
    ValueAnimator rotationAnimator = ValueAnimator.ofFloat(0, 360);
    rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();
        mDoge.setRotation(value);
      }
    });

//3
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.play(positionAnimator).with(rotationAnimator);
    animatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
    animatorSet.start();
  }
}
