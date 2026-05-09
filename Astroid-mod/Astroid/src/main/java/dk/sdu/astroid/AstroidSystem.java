package dk.sdu.astroid;

import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IWorld;

public class AstroidSystem extends BaseLogicSystem{
    float timeToRespawn = 1.5f;
    float cooldown = 5f;

    AstroidPlugin astroid = new AstroidPlugin();
    @Override
    public void process(IWorld world, double dateTime){
        cooldown -= dateTime;

        if (cooldown <= 0){
            astroid.spawnAstroid(world);
            cooldown = timeToRespawn;
        }
    }
}
