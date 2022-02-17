package com.gyoge.itcsgraphics.animators;

import com.gyoge.itcsgraphics.drawables.Drawable;
import com.gyoge.itcsgraphics.drawables.Spaceship;

import java.util.HashMap;

/**
 * An animator for a spaceship.
 * <p>
 * This animator will have the spaceship accelerate up to the top, decelerate back down, and
 * continue accelerating up.
 *
 * @author Yogesh Thambidurai
 * @see Spaceship
 * @see Animator
 */
public class SpaceshipAnimator implements Animator {

    /** @see Animator#drawable */
    private final Spaceship drawable = new Spaceship();
    /** The string used in the params to signify the y acceleration. */
    private final String dy;
    /** If the spaceship is going down. */
    private boolean goingDown = false;
    /** The dy value used when going down. */
    @SuppressWarnings("SpellCheckingInspection")
    private int privDy = 0;

    /**
     * Constructs a new SpaceshipAnimator.
     *
     * @param x  The x coordinate of the spaceship.
     * @param y  The y coordinate of the spaceship.
     * @param dy The keyword used to signify the y acceleration.
     */
    public SpaceshipAnimator(int x, int y, String dy) {
        this.drawable.setX(x);
        this.drawable.setY(y);
        this.dy = dy;
    }

    /**
     * Constructs a new SpaceshipAnimator.
     *
     * @param x      The x coordinate of the spaceship.
     * @param y      The y coordinate of the spaceship.
     * @param width  The width of the spaceship.
     * @param height The height of the spaceship.
     * @param dy     The keyword used to signify the y acceleration.
     */
    @SuppressWarnings("unused")
    public SpaceshipAnimator(int x, int y, int width, int height, String dy) {
        this.drawable.setX(x);
        this.drawable.setY(y);
        this.drawable.setHeight(height);
        this.drawable.setWidth(width);
        this.dy = dy;
    }

    /** {@inheritDoc} */
    @SuppressWarnings({"DuplicateCondition", "ConstantConditions"})
    @Override
    public Drawable getDrawable(HashMap<String, Object> params) {
        double newY = this.drawable.getY() + (double) params.get(this.dy);
        if (newY > 400 && goingDown) {
            privDy = 0;
            this.drawable.setY(this.drawable.getY() + 1);
            goingDown = false;
        } else if (newY < 0 || goingDown) {
            privDy += 1;

            this.drawable.setY(this.drawable.getY() + privDy);
            goingDown = true;
        } else if (!goingDown) {
            this.drawable.setY(newY);
        }

        return this.drawable;
    }
}
