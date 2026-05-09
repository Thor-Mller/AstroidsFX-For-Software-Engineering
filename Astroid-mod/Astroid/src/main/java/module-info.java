import dk.sdu.astroid.AstroidPlugin;

module Astroid {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires AstroidComponent;

    exports dk.sdu.astroid to dk.sdu.cbse.game;
    opens assets.astroid;

    provides dk.sdu.cbse.common.IGamePlugin with AstroidPlugin;
    provides dk.sdu.cbse.common.IEntitySystem with dk.sdu.astroid.AstroidSystem;

}