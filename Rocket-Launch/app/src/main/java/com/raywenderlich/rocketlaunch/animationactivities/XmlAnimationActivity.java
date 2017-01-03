package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;

import com.raywenderlich.rocketlaunch.R;

public class XmlAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {
// 1
    AnimatorSet rocketAnimatorSet =
            (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink);
    // 2
    rocketAnimatorSet.setTarget(mRocket);

    // 3
    AnimatorSet dogeAnimatorSet =
            (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.jump_and_blink);
    // 4
    dogeAnimatorSet.setTarget(mDoge);

    // 5
    AnimatorSet bothAnimatorSet = new AnimatorSet();
    bothAnimatorSet.playTogether(rocketAnimatorSet, dogeAnimatorSet);
    // 6
    bothAnimatorSet.setDuration(DEFAULT_ANIMATION_DURATION);
    bothAnimatorSet.start();
  }
}
