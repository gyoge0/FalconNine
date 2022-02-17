package com.gyoge.itcsgraphics.testers;

import com.gyoge.itcsgraphics.animators.FalconNineAnimator;

import java.util.HashMap;

import java.time.Duration;

public class FalconNineTester {

    public static void main(String[] args) {
        System.out.println("Time, Mass, Net Force, Y-Acceleration, Y-velocity, Altitude");

        FalconNineAnimator animator = new FalconNineAnimator(
            0,
            0,
            6,
            1,
            Duration.ofMillis(500)
        );

        HashMap<String, Object> params = new HashMap<>();
        params.put("HEIGHT", 800);

        for (int i = 0; i < 324; i++) {
            animator.getDrawable(params);
            System.out.printf("%f, %f, %f, %f, %f, %f%n",
                animator.getTime().toMillis() / 1000.0,
                animator.getMass(),
                animator.getNetForce(),
                animator.getAccel(),
                animator.getVel(),
                animator.getAlt()
            );
        }
    }
}
