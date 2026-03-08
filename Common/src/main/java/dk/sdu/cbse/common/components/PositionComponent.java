package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class PositionComponent implements IComponent {
    public double x;
    public double y;


    PositionComponent(double x, double y) {
        this.x = x;
        this.y = y;
    }
}