package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class VelocityComponent implements IComponent {
    public double dx, dy;
    public double acceleration;
    public double maxspeed;

    public VelocityComponent(double acceleration, double maxspeed) {
        this.acceleration = acceleration;
        this.maxspeed = maxspeed;
    }

    public double getDx() {
        return this.dx;
    }

    public double getDy() {
        return this.dy;
    }

    public void setDx(double newDx) {
        this.dx = newDx;
    }

    public void setDy(double newDy) {
        this.dy = newDy;
    }
}