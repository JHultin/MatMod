package edu.cth.balls;

import java.awt.*;

/**
 * Created by Gaku on 2016-04-24.
 */
public class Ball {

    private double x, y, vx, vy, pixelsPerMeter;
    private int radius, pixelX, pixelY;
    private Color color = Color.red;
    private Dimension d;

    public Ball(Dimension d, double x, double y, double vx, double vy, double pixelsPerMeter, int radius, Color color){
        this.d = d;
        this.x = x; // in meters
        this.y = y; // y reference direction downwards!
        this.vx = vx; // in m/s
        this.vy = vy;
        this.pixelsPerMeter = pixelsPerMeter;

        this.radius = radius; // in pixels!
    }

    public void tick(double deltaT){
        if (pixelX < radius || pixelX > d.width - radius) {
            vx = -vx;
        }
        if (pixelY < radius || pixelY > d.height - radius) {
            vy =  -vy;
        }

        x += vx * deltaT;
        y += vy * deltaT;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public int getRadius(){
        return radius;
    }

    public void draw(Graphics g){
        pixelX = (int) (pixelsPerMeter * x);
        pixelY = (int) (pixelsPerMeter * y);

        g.setColor(color);
        g.fillOval( pixelX - radius
                , pixelY - radius, radius * 2, radius * 2);
    }
}
