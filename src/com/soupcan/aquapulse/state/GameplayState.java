package com.soupcan.aquapulse.state;

import com.soupcan.aquapulse.controller.MovementHandler;
import com.soupcan.aquapulse.model.engine.Level;
import com.soupcan.aquapulse.model.entity.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameplayState extends BasicGameState
{
    private int stateID;

    private Image background;
    private Level level;
    private Player player;

    private MovementHandler movementHandler;

    public GameplayState(int stateID)
    {
        this.stateID = stateID;
    }

    @Override
    public int getID()
    {
        return stateID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        background = new Image("res/img/background.png");
        level = new Level("res/map/testmap03.tmx");
        player = new Player(new Vector2f(400, 400));

        movementHandler = new MovementHandler(player);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        background.draw(-150, 0, background.getWidth(), 600);
        level.render(new int[] {1, 2, 3,});
        player.render();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException
    {
        movementHandler.processInput(gameContainer.getInput(), delta);

        player.update();
    }
}
