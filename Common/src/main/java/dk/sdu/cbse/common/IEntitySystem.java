package dk.sdu.cbse.common;

public interface IEntitySystem {
    void process(IWorld world);

    Priority getPriority();
}



