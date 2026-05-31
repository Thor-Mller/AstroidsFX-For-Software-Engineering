module Collider {
    requires AstroidComponent;
    requires ColliderComponent;
    requires dk.sdu.cbse.bulletcomponent;
    requires dk.sdu.cbse.common;
    requires EnemyComponent;
    requires PlayerComponents;
    requires spring.web;

    opens dk.sdu.cbse.collider to org.junit.platform.commons, org.mockito;

    exports dk.sdu.cbse.collider;

    provides dk.sdu.cbse.common.IEntitySystem with dk.sdu.cbse.collider.ColliderSystem;
}