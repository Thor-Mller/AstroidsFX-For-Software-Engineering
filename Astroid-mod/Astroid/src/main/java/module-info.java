import dk.sdu.cbse.astroid.AstroidPlugin;
import dk.sdu.cbse.astroid.AstroidSystem;
import dk.sdu.cbse.astroid.SplitSystem;

module Astroid {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires AstroidComponent;
    requires ColliderComponent;

    opens assets.astroid;
    exports dk.sdu.cbse.astroid to dk.sdu.cbse.game;

    provides dk.sdu.cbse.common.IGamePlugin with AstroidPlugin;
    provides dk.sdu.cbse.common.IEntitySystem with AstroidSystem, SplitSystem;

}