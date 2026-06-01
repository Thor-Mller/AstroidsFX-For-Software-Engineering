package dk.sdu.cbse.collider;

import dk.sdu.cbse.astroidComponent.AstroidComponent;
import dk.sdu.cbse.playerBulletComponent.PlayerBulletComponent;
import dk.sdu.cbse.colliderComponent.ColliderComponent;
import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.PositionComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.Mockito.*;

public class ColliderSystemTest {
    private ColliderSystem colliderSystem;
    private IWorld world;
    private IEntity bulletMock;
    private IEntity astroidMock;

    @BeforeEach
    public void setUp(){
        colliderSystem = new ColliderSystem();
        world = mock(IWorld.class);
        bulletMock = mock(IEntity.class);
        astroidMock = mock(IEntity.class);

        HashSet<IEntity> entities = new HashSet<>(Arrays.asList(bulletMock,astroidMock));

        PlayerBulletComponent bulletCom = new PlayerBulletComponent();
        AstroidComponent astroidCom = new AstroidComponent();

        PositionComponent bulletPos = new PositionComponent(1,1);
        PositionComponent astroidPos = new PositionComponent(1,2);

        ColliderComponent bulletCol = new ColliderComponent(5);
        ColliderComponent astroidCol = new ColliderComponent(5);

        when(bulletMock.getComponent(PositionComponent.class)).thenReturn(bulletPos);
        when(astroidMock.getComponent(PositionComponent.class)).thenReturn(astroidPos);
        when(bulletMock.getComponent(ColliderComponent.class)).thenReturn(bulletCol);
        when(astroidMock.getComponent(ColliderComponent.class)).thenReturn(astroidCol);

        when(bulletMock.getComponent(PlayerBulletComponent.class)).thenReturn(mock(PlayerBulletComponent.class));
        when(astroidMock.getComponent(AstroidComponent.class)).thenReturn(mock(AstroidComponent.class));

        when(world.getEntitiesWithComponent(ColliderComponent.class, PositionComponent.class)).thenReturn(entities);
    }

    @Test
    public void collititonTest(){

        colliderSystem.process(world, 0.016);
        verify(world, atLeastOnce()).removeEntity(bulletMock);
        verify(world, atLeastOnce()).updateEntity(astroidMock);
    }
}
