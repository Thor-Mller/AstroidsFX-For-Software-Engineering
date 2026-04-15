package dk.sdu.cbse.core;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.AngleComponent;
import dk.sdu.cbse.common.components.SpriteComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RenderSystem extends BaseIOSystem {
    private Pane pane;
    private final Map<IEntity, ImageView> entityImageViewMap = new HashMap<>();

    public RenderSystem(){}

    @Override
    public void initialize(GameData gameData){
        this.pane = gameData.getPane();
    }

    @Override
    public Priority getPriority() {
        return Priority.Render;
    }

    public void process(IWorld world){
        if (pane == null) throw new IllegalStateException("RenderSystem not initialized");
        Set<IEntity> rendableEntities = world.getEntitiesWithComponent(SpriteComponent.class, PositionComponent.class, AngleComponent.class);
        // System.out.println("Renderable entities: " + rendableEntities.size());
        // System.out.println("Pane children: " + pane.getChildren().size());

        for (IEntity entity : rendableEntities){
            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);
            SpriteComponent spr = (SpriteComponent) entity.getComponent(SpriteComponent.class);
            AngleComponent ang = (AngleComponent) entity.getComponent(AngleComponent.class);
            // System.out.println("Pos: " + pos.getX() + ", " + pos.getY());
            // System.out.println("Image null? " + (spr.getPath() == null));

            ImageView view = entityImageViewMap.computeIfAbsent(entity, e-> {
                Image img = spr.getPath();
                ImageView iv = new ImageView(img);
                iv.setSmooth(false);
                iv.rotateProperty().set(ang.getAngle());
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
