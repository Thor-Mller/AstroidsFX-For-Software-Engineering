import dk.sdu.cbse.astroid.AstroidPlugin;
import dk.sdu.cbse.astroid.AstroidSystem;

module Astroid {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires AstroidComponent;
    requires ColliderComponent;
    requires spring.context;
    requires spring.beans;
    requires spring.core;

    opens assets.astroid;
    exports dk.sdu.cbse.astroid to dk.sdu.cbse.game;

    provides dk.sdu.cbse.common.IGamePlugin with AstroidPlugin;
    provides dk.sdu.cbse.common.IEntitySystem with AstroidSystem;

}