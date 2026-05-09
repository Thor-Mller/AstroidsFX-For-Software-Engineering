import dk.sdu.cbse.common.IEntitySystem;

module Collider {
    requires AstroidComponent;
    requires ColliderComponent;
    requires dk.sdu.cbse.bulletcomponent;
    requires dk.sdu.cbse.common;

    provides IEntitySystem with dk.sdu.cbse.colliderSystem;
}