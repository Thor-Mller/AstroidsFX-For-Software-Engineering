package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IWorld;

public class EnemySystem extends BaseLogicSystem{
    float timeToRespawn = 1.5f;
    float cooldown = 5f;

    EnemyPlugin enemy = new EnemyPlugin();
    @Override
    public void process(IWorld world, double dateTime){
        cooldown -= dateTime;

        if (cooldown <= 0){
            enemy.spawnEnemy(world);
            cooldown = timeToRespawn;
        }
    }
}
