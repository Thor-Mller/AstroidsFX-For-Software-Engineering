module PlayerDeathSystem {
    requires dk.sdu.cbse.common;
    requires PlayerComponents;

    provides dk.sdu.cbse.common.IEntitySystem with dk.sdu.cbse.playerDeathSystem.PlayerDeathSystem;
}