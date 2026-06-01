package dk.sdu.cbse.collider;

import dk.sdu.cbse.astroidComponent.AstroidComponent;
import dk.sdu.cbse.astroidComponent.AstroidIsHitComponent;
import dk.sdu.cbse.astroidComponent.SmallAstroidComponent;
import dk.sdu.cbse.playerBulletComponent.PlayerBulletComponent;
import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.colliderComponent.ColliderComponent;
import dk.sdu.cbse.playerComponents.PlayerComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import dk.sdu.cbse.enemyComponent.EnemyComponent;
import dk.sdu.cbse.playerComponents.PlayerIsDeadComponent;
import org.springframework.web.client.RestTemplate;

public class ColliderSystem extends BaseLogicSystem {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String Url = "http://localhost:8080/api/score";

    @Override
    public void process(IWorld world, double deltaTime){
        for (IEntity entity : world.getEntitiesWithComponent(ColliderComponent.class, PositionComponent.class)){
                for (IEntity entity1 : world.getEntitiesWithComponent(ColliderComponent.class, PositionComponent.class)){
                    if (entity == entity1){
                        continue;
                    }
                    if (collides(entity,entity1)){
                        handleCollision(world, entity, entity1);
                    }
                }
        }
    }

    public boolean collides(IEntity e1, IEntity e2){
        PositionComponent pos1 = (PositionComponent) e1.getComponent(PositionComponent.class);
        PositionComponent pos2 = (PositionComponent) e2.getComponent(PositionComponent.class);
        ColliderComponent col1 = (ColliderComponent) e1.getComponent(ColliderComponent.class);
        ColliderComponent col2 = (ColliderComponent) e2.getComponent(ColliderComponent.class);

        double x1 = pos1.getX() + col1.getRadius();
        double y1 = pos1.getY() + col1.getRadius();
        double x2 = pos2.getX() + col2.getRadius();
        double y2 = pos2.getY() + col2.getRadius();

        double distanceX = x1 - x2;
        double distanceY = y1 - y2;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return distance < col1.getRadius() + col2.getRadius();
    }

    public void handleCollision(IWorld world, IEntity e1, IEntity e2){

        if (isAstroid(e1) && isBullet(e2)){
            world.removeEntity(e2);
            // world.removeEntity(e2);
            e1.addComponent(new AstroidIsHitComponent());
            world.updateEntity(e1);
            // System.out.println("Astroid Hit!!!");
            addPoints(20);
        }
        if (isPlayer(e1) && isAstroid(e2)){
            e1.addComponent(new PlayerIsDeadComponent());
            world.updateEntity(e1);
            //System.out.println(e1.getComponent(PlayerIsDeadComponent.class));
            world.removeEntity(e2);
        }
        if (isPlayer(e1) && isSmallAstroid(e2)){
            e1.addComponent(new PlayerIsDeadComponent());
            world.updateEntity(e1);
            world.removeEntity(e2);
        }
        if (isPlayer(e1) && isEnemy(e2)){
            e1.addComponent(new PlayerIsDeadComponent());
            world.updateEntity(e1);
            world.removeEntity(e2);
        }
        if (isBullet(e1) && isEnemy(e2)){
            world.removeEntity(e1);
            world.removeEntity(e2);
            addPoints(30);
        }
        if (isBullet(e1) && isSmallAstroid(e2)){
            world.removeEntity(e1);
            world.removeEntity(e2);
            addPoints(50);
        }



    }

    private void addPoints(int add){
        try {
            String response = restTemplate.getForObject(Url + "/update?add=" + add, String.class);
        } catch (Exception e){}
    }

    private boolean isBullet(IEntity e){ return e.getComponent(PlayerBulletComponent.class) != null;}
    private boolean isAstroid(IEntity e){ return e.getComponent(AstroidComponent.class) != null;}
    private boolean isPlayer(IEntity e){ return e.getComponent(PlayerComponent.class) != null;}
    private boolean isSmallAstroid(IEntity e){ return e.getComponent(SmallAstroidComponent.class) != null;}
    private boolean isEnemy(IEntity e){ return e.getComponent(EnemyComponent.class) != null;}


}
