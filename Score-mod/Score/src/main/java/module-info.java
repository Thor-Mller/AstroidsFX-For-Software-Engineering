module Score {
    requires dk.sdu.cbse.common;
    requires ScoreComponent;
    requires spring.web;

    provides dk.sdu.cbse.common.IGamePlugin with dk.sdu.cbse.score.ScorePlugin;
    provides dk.sdu.cbse.common.IEntitySystem with dk.sdu.cbse.score.ScoringSystem;
}