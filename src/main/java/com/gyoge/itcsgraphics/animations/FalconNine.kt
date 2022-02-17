package com.gyoge.itcsgraphics.animations

import com.gyoge.itcsgraphics.animators.Animator
import com.gyoge.itcsgraphics.animators.FalconNineAnimator
import com.gyoge.itcsgraphics.animators.SnowflakeAnimator
import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import java.time.Duration
import java.time.temporal.ChronoUnit
import java.util.*

class FalconNine : Animation() {
    init {
        setUp()
        TimerListener().startTimer(FPS)
    }

    /** Set up values for the animation. */
    override fun setUp() {

        // Set up Buffered Image and Graphics objects
        bufferedImage = BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB)
        goon = bufferedImage.graphics

        // Set name
        setShownName("Falcon 9")

        params = hashMapOf("HEIGHT" to HEIGHT, "WIDTH" to WIDTH, "dummy" to 0.0)

        val animatorsAL = arrayListOf<Animator>(
            FalconNineAnimator(
                WIDTH / 2, HEIGHT,
                6, 25,
                DT,
            )
        )

        // Who doesn't love repurposed snowflakes?
        for (i in 0..99) {
            animatorsAL.add(
                SnowflakeAnimator(
                    random.nextInt(WIDTH),
                    random.nextInt(HEIGHT / 2),
                    "dummy",
                    "dummy"
                )
            )
        }

        animators = animatorsAL.toTypedArray()
    }

    /** Called on each tick. */
    override fun tick() {
        // Draw background
        goon.color = Color.BLACK
        goon.fillRect(0, 0, WIDTH, HEIGHT)


        for (animator in animators) {
            animator.getDrawable(params).draw(goon)
        }

        // Draw average values
        goon.color = Color.WHITE
        goon.font = Font("Comic Sans MS", Font.BOLD, 16)
        goon.drawString(
            "Delta time: ${
                (animators[0] as FalconNineAnimator)
                    .time
                    .toNanos().toDouble()
                        / 1e9
            } second(s)",
            10,
            30 + 10
        )

        val animator = animators[0] as FalconNineAnimator
        goon.drawString("Phase: ${animator.getStage()}", 10, 50 + 10)
        goon.drawString("Altitude: ${animator.alt} m", 10, 70 + 10)
        goon.drawString("Velocity: ${animator.vel} m/s", 10, 90 + 10)
        goon.drawString("Acceleration: ${animator.accel} m/s^2", 10, 110 + 10)
        goon.drawString("Mass: ${animator.mass} kg", 10, 130 + 10)

    }


    companion object {
        const val WIDTH = 800

        const val HEIGHT = 800

        const val FPS = 60

        val random = Random()

        val DT: Duration = ChronoUnit.SECONDS.duration

        @JvmStatic
        fun main(args: Array<String>) {
            val animation: Animation = FalconNine()
            startUp(animation, WIDTH, HEIGHT)
        }

    }

}
