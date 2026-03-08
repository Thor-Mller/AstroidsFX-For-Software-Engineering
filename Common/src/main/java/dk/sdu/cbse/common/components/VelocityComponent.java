package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class VelocityComponent implements IComponent {
    public double dx;
    public double dy;


    VelocityComponent(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public double getDx() {return this.dx;}
    public double getDy() {return this.dy;}
    public void setDx(double newDx) {this.dx = newDx;}
    public void setDy(double newDy) {this.dy = newDy;}
}