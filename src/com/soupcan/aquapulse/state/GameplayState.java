package com.soupcan.aquapulse.state;

import com.soupcan.aquapulse.AquapulseGame;
import com.soupcan.aquapulse.controller.MovementController;
import com.soupcan.aquapulse.model.engine.Level;
import com.soupcan.aquapulse.model.engine.LevelGroup;
import com.soupcan.aquapulse.model.entity.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;

public class GameplayState extends BasicGameState
{
    private int stateID;

    private Image background;
    private LevelGroup levels;
    private Player player;

    private MovementController movementController;

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
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        super.enter(gameContainer, stateBasedGame);

        player = new Player(new Vector2f(400, 400));

        levels = new LevelGroup();
        levels.addLevel(new Level("res/map/finalmap01.tmx"));

        movementController = new MovementController(player, levels);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        background = new Image("res/img/ui/background.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        background.draw(0, 0);
        levels.render();
        player.render();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException
    {
        // Check collision from map scrolling
        for(int i = 0; i < levels.size(); i++)
        {
            for(int j = 0; j < levels.get(i).bounds.size(); j++)
            {
                Shape tileBlock = levels.get(i).bounds.get(j);

                if(collides(player.bounds, tileBlock) && player.bounds.getMaxX() >= tileBlock.getMinX())
                {
                    player.position.x -= LevelGroup.SCROLL_COEFF * delta;
                }
            }
        }

        // Checks if player is off screen and ends the game if they are.
        if(player.position.x + Player.WIDTH < 0)
        {
            stateBasedGame.enterState(AquapulseGame.GAME_OVER_STATE);
        }

        movementController.processInput(gameContainer.getInput(), delta);

        levels.scroll(delta);
        player.update();
    }

    private boolean collides(Shape shape1, Shape shape2)
    {
        return shape1.intersects(shape2);
    }
}
