package com.gyoge.itcsgraphics.drawables

import java.awt.Color
import java.awt.Graphics
import java.awt.Polygon
import java.util.*

/**
 * A simple snowflake.
 *
 * @author Yogesh Thambidurai
 * @see com.gyoge.itcsgraphics.animators.SnowflakeAnimator
 * @see Drawable
 */
class Snowflake(x: Int, y: Int) : Drawable {
    var x: Double
    var y: Double

    /**
     * Constructs a new snowflake.
     */
    init {
        this.x = x.toDouble()
        this.y = y.toDouble()
    }

    /** Draws the snowflake. */
    override fun draw(goon: Graphics) {
        // Values to sub in
        val x: Int = this.x.toInt()
        val y: Int = this.y.toInt()

        val left: Int = x - 3
        val right: Int = x + 3
        val up: Int = y + 3
        val down: Int = y - 3

        // Random white hue
        val color: Int = random.nextInt(55) + 200
        goon.color = Color(color, color, color)

        // Diagonals
        goon.drawLine(left, y, right, y)
        goon.drawLine(x, up, x, down)
        goon.drawLine(left, up, right, down)
        goon.drawLine(right, up, left, down)

        // Center bit
        goon.drawPolygon(
            Polygon(
                intArrayOf(x - 1, x + 1, x, x, x - 1, x + 1, x - 1, x + 1),
                intArrayOf(y, y, y - 1, y + 1, y - 1, y + 1, y + 1, y - 1),
                8
            )
        )
    }

    companion object {
        /** Random object to use. */
        private val random = Random()
    }

}