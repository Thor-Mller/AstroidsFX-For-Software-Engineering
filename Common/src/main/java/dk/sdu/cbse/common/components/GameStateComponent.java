package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class GameStateComponent implements IComponent {
    public enum GameState {Menu,Playin,Game_Over}

    public GameState currentState = GameState.Playin;

    public GameState getGameState(){return currentState;}
    public void setCurrentState(GameState gameState){currentState = gameState;}
}
