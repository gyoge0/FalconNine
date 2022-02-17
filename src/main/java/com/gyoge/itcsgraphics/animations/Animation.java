package com.gyoge.itcsgraphics.animations;

import com.gyoge.itcsgraphics.animators.Animator;

import java.util.HashMap;
import java.util.Objects;

import java.io.IOException;

import java.net.URL;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Animation
 * <p>
 * A superclass for all animations to inherit from. Provides methods to partially set up the
 * animation, but requires overriding of some methods.
 *
 * @author Yogesh Thambidurai
 */
public class Animation extends JPanel {

    /** Width for animations. Can be overridden. */
    @SuppressWarnings("unused")
    public static final int WIDTH = 400;
    /** Height for animations. Can be overridden. */
    @SuppressWarnings("unused")
    public static final int HEIGHT = 400;
    /** FPS/Tick rate for animations. Can be overridden. */
    @SuppressWarnings("unused")
    protected static final int FPS = 60;
    /** BufferedImage to draw objects on. */
    protected BufferedImage bufferedImage;
    /** Graphics object to draw objects with. */
    protected Graphics goon;
    /** Default name shown in title bar. */
    protected String shownName = "An Animation";
    /** List of animators for each object drawn. */
    protected Animator[] animators;
    /** Params with info for each animator. */
    protected HashMap<String, Object> params;

    /**
     * A method to quickly start up an animation.
     *
     * @param animation The animation to run.
     * @param width     The default width of the animation.
     * @param height    The default height of the animation.
     */
    public static void startUp(Animation animation, int width, int height) {
        JFrame frame = new JFrame(
            String.format("Goon presents: %s by Yogesh Thambidurai", animation.getShownName())
        );

        frame.setSize(width, height);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(animation);
    }

    /**
     * Set up animators.
     *
     * <p>
     * Should be overridden by subclasses.
     *
     * @see Animator
     */
    protected void setUp() {
        // Should be overridden by subclasses
    }


    /**
     * Play a sound.
     *
     * @param resource URL to the resource to play.
     * @throws LineUnavailableException      If the line is unavailable.
     * @throws UnsupportedAudioFileException If the file is not supported.
     * @throws IOException                   If the file cannot be found.
     * @author Yogesh Thambidurai
     * @see <a href=https://stackoverflow.com/a/20514020>https://stackoverflow.com/a/20514020</a>
     */
    protected void playSound(URL resource) throws
        LineUnavailableException,
        UnsupportedAudioFileException,
        IOException {
        // Open an audio input stream.
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(
            Objects.requireNonNull(resource)
        );

        // Get a sound clip resource.
        Clip clip = AudioSystem.getClip();

        // Open audio clip and load samples from the audio input stream.
        clip.open(audioIn);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Play a sound.
     *
     * @param path The path to the resource to play.
     * @throws UnsupportedAudioFileException If the file is not supported.
     * @throws LineUnavailableException      If the line is unavailable.
     * @throws IOException                   If the file cannot be found.
     * @author Yogesh Thambidurai
     */
    protected void playSound(String path) throws
        LineUnavailableException,
        UnsupportedAudioFileException,
        IOException {
        playSound(this.getClass().getClassLoader().getResource(path));
    }

    /**
     * Draw all objects in the animations.
     *
     * <p>
     * Should be overridden by subclasses.
     *
     * @see Animator
     */
    protected void tick() {
        for (Animator animator : animators) {
            animator.getDrawable(params).draw(goon);
        }
    }

    /**
     * Getter for name.
     *
     * @return The name.
     */
    public String getShownName() {
        return this.shownName;
    }

    /**
     * Set name. Mostly used in setUp() boilerplate.
     *
     * @param name The value to set name to.
     */
    @SuppressWarnings("SameParameterValue")
    protected void setShownName(String name) {
        this.shownName = name;
    }

    /**
     * Paint the animation.
     *
     * @param goon The graphics object to draw on.
     */
    @Override
    public void paintComponent(Graphics goon) {
        goon.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
    }

    /**
     * Timer for the animation.
     */
    protected class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tick();
            repaint();
        }

        /**
         * Start the timer at the fps specified.
         *
         * @param fps The fps/tick rate.
         */
        public void startTimer(int fps) {
            Timer timer = new Timer(1000 / fps, this);
            timer.start();
        }

    }

}

