package com.gyoge.itcsgraphics.testers;

import com.gyoge.itcsgraphics.animators.FalconNineAnimator;
import com.gyoge.itcsgraphics.animators.FalconNineAnimator.Masses;

import java.util.EnumMap;
import java.util.HashMap;

import java.time.Duration;

public class FalconHeavyTester {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        System.out.println("Time, Mass, Net Force, Y-Acceleration, Y-velocity, Altitude");

        FalconNineAnimator animator = new FalconNineAnimator(
            0,
            0,
            6,
            1,
            Duration.ofMillis(500),
            new EnumMap<>(Masses.class) {{
                put(Masses.PHASE_1_STARTING, 546443.0);
                put(Masses.PHASE_1_ENDING, 113262.0);
                put(Masses.PHASE_1_FUEL, 433181.0);
                put(Masses.PHASE_1_THRUST, 22820000.0);
                put(Masses.PHASE_1_ENDING_TIME, 187.0);
                put(Masses.PHASE_2_STARTING, 113262.0);
                put(Masses.PHASE_2_ENDING, 1678.0);
                put(Masses.PHASE_2_FUEL, 111584.0);
                put(Masses.PHASE_2_THRUST, 934000.0);
                put(Masses.PHASE_2_ENDING_TIME, 397.0);
            }}
        );

        HashMap<String, Object> params = new HashMap<>();
        params.put("HEIGHT", 800);

        for (
            int i = 0;
            i < 324; i++) {
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
