package com.linecorp.reviewexam.rockpaperscissors;

import android.content.Context;
import android.util.AttributeSet;

/**
 * A {@link Hand} which stands for a rock hand.
 */
public class RockButton extends HandButton {

    public RockButton(Context context) {
        super(context);
    }

    public RockButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    String getHandText() {
        return "Rock";
    }

    @Override
    Hand getHand() {
        return Hand.ROCK;
    }
}
