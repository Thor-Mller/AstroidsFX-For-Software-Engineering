package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class VelocityComponent implements IComponent {
    public double dx, dy;
    public double acceleration;
    public double maxspeed;
    public double drag;

    public VelocityComponent(double acceleration, double maxspeed, double drag) {
        this.acceleration = acceleration;
        this.maxspeed = maxspeed;
        this.drag = drag;
    }

    public double getDx() {
        return this.dx;
    }

    public double getDy() {
        return this.dy;
    }

    public double getDrag(){return this.drag;}

    public void setDx(double newDx) {
        this.dx = newDx;
    }

    public void setDy(double newDy) {
        this.dy = newDy;
    }

    public void setDrag(double drag) {this.drag = drag;}
}