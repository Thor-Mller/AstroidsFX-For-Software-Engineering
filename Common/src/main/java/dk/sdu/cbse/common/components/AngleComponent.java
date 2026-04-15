package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class AngleComponent implements IComponent {
    private int Angle;

    public AngleComponent(int angle){
        setAngle(angle);
    }

    public int getAngle() {
        return Angle;
    }

    public void setAngle(int angle) {
        Angle = angle % 360;
    }
}
