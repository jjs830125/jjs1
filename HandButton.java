package com.linecorp.reviewexam.rockpaperscissors;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * A {@link Button} to play a hand. For each hand, a user can play 10 times at most.
 * This also controls a playable count left.
 */
public abstract class HandButton extends Button {

    /**
     * Playable count for this hand.
     */
    private int rest;

    public HandButton(Context context) {
        super(context);
        rest = 10;
        setText(getHandText());
    }

    public HandButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        rest = 10;
        setText(getHandText() + "\nrest: " + rest);
    }

    /**
     * Updates button text by means of {@link #getHandText()} and the rest count.
     */
    public void updateText() {
        setText(getHandText() + "\nrest: " + rest);
    }

    public int getRest() {
        return rest;
    }

    public void play() {
        --rest;
    }

    /**
     * Returns a hand name corresponding to this button.
     */
    abstract String getHandText();

    abstract Hand getHand();
}
