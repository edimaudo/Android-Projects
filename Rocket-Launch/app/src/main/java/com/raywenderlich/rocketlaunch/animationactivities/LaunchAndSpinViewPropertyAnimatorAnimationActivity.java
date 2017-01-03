package com.raywenderlich.rocketlaunch.animationactivities;

public class LaunchAndSpinViewPropertyAnimatorAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
    mRocket.animate().translationY(-mScreenHeight)
            .rotationBy(360f)
            .setDuration(DEFAULT_ANIMATION_DURATION)
            .start();
  }
}
