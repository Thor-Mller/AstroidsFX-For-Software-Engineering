package dk.sdu.cbse.core;

import dk.sdu.cbse.common.IEntitySystem;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.Priority;
import dk.sdu.cbse.common.components.SpriteComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import dk.sdu.cbse.common.IEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RenderSystem implements IEntitySystem {
    private final Pane pane;
    private final Map<IEntity, ImageView> entityImageViewMap = new HashMap<>();

    public RenderSystem(Pane pane){this.pane = pane;}

    @Override
    public Priority getPriority() {
        return Priority.Render;
    }

    public void process(IWorld world){

        Set<IEntity> rendableEntities = world.getEntitiesWithComponent(SpriteComponent.class, PositionComponent.class);

        for (IEntity entity : rendableEntities){
            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);
            SpriteComponent spr = (SpriteComponent) entity.getComponent(SpriteComponent.class);

            ImageView view = entityImageViewMap.computeIfAbsent(entity, e-> {
                Image img = new Image(getClass().getResourceAsStream(spr.getPath()));
                ImageView iv = new ImageView(img);
                iv.setSmooth(false);
                pane.getChildren().add(iv);
                return iv;
            });

            view.setTranslateX(pos.getX());
            view.setTranslateY(pos.getY());
        }

        entityImageViewMap.keySet().removeIf(e -> {
            boolean hasEntity = !rendableEntities.contains(e);
            if (hasEntity){
                pane.getChildren().remove(entityImageViewMap.get(e));
            }
            return hasEntity;
        });
    }
}
