package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class VelocityComponent implements IComponent {
    public double dx;
    public double dy;


    VelocityComponent(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
}