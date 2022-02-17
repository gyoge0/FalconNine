package com.gyoge.itcsgraphics.drawables

import java.awt.Color
import java.awt.Graphics
import javax.swing.ImageIcon

/**
 * Spaceship
 * <p>
 * A spaceship with an image of Dwayne "The Rock" Johnson in it.
 *
 * @author Yogesh Thambidurai
 * @property x The x coordinate of the spaceship.
 * @property y The y coordinate of the spaceship.
 * @property width The width of the spaceship.
 * @property height The height of the spaceship.
 * @see com.gyoge.itcsgraphics.animators.SpaceshipAnimator
 * @see Drawable
 */
class Spaceship : Drawable {
    var x: Double = 0.0
    var y: Double = 0.0
    var width: Int = 50
    var height: Int = 100

    /** Draws the spaceship. */
    override fun draw(goon: Graphics) {

        goon.color = Color(186, 181, 169)
        goon.fillRect(this.x.toInt(), this.y.toInt(), width, height)

        // fill triangle
        goon.color = Color(255, 255, 255)
        goon.fillPolygon(
            intArrayOf(this.x.toInt(), this.x.toInt() + width / 2, this.x.toInt() + width),
            intArrayOf(this.y.toInt(), this.y.toInt() - height / 2, this.y.toInt()),
            3
        )
        goon.drawImage(
            ImageIcon("src/main/resources/images/rock.jpg").image,
            this.x.toInt() + 5,
            this.y.toInt() + 5,
            width - 10,
            height - 10,
            null
        )
    }

}