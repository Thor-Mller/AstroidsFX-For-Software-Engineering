package dk.sdu.cbse.core;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.SpriteComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RenderSystem extends BaseRenderSystem {
    private Pane pane;
    private final Map<IEntity, ImageView> entityImageViewMap = new HashMap<>();

    public RenderSystem(){}

    public void initialize(Pane pane){
        this.pane = pane;
    }

    @Override
    public Priority getPriority() {
        return Priority.Render;
    }

    public void process(IWorld world){
        if (pane == null) throw new IllegalStateException("RenderSystem not initialized");
        Set<IEntity> rendableEntities = world.getEntitiesWithComponent(SpriteComponent.class, PositionComponent.class);
        // System.out.println("Renderable entities: " + rendableEntities.size());
        // System.out.println("Pane children: " + pane.getChildren().size());

        for (IEntity entity : rendableEntities){
            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);
            SpriteComponent spr = (SpriteComponent) entity.getComponent(SpriteComponent.class);
            // System.out.println("Pos: " + pos.getX() + ", " + pos.getY());
            // System.out.println("Image null? " + (spr.getPath() == null));

            ImageView view = entityImageViewMap.computeIfAbsent(entity, e-> {
                Image img = spr.getPath();
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
