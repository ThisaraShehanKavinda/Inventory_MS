/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author USER
 */
public class AnimatedGradientPanel extends JPanel{
     private Color startColor;
    private Color endColor;
    private Timer timer;

    public AnimatedGradientPanel(Color startColor, Color endColor, int interval) {
        this.startColor = startColor;
        this.endColor = endColor;

        timer = new Timer(interval, new TimerHandler());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable antialiasing for smoother rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a gradient paint object
        GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);

        // Set the gradient paint as the background
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Swap the start and end colors
            Color temp = startColor;
            startColor = endColor;
            endColor = temp;

            // Repaint the panel to update the gradient
            repaint();
        }
    }
}
