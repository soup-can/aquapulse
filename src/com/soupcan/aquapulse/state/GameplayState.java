package com.soupcan.aquapulse.state;

import com.soupcan.aquapulse.AquapulseGame;
import com.soupcan.aquapulse.controller.MovementController;
import com.soupcan.aquapulse.model.engine.Level;
import com.soupcan.aquapulse.model.engine.LevelGroup;
import com.soupcan.aquapulse.model.entity.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.RoundedRectangle;
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

    private Sound inhaleSound;
    private Sound exhaleSound;
    private boolean readyToExhale = true;

    private Music music;

    private MovementController movementController;

    public GameplayState(int stateID) throws SlickException
    {
        this.stateID = stateID;
        music = new Music("res/sound/game_music.wav");
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

        inhaleSound = new Sound("res/sound/inhale.wav");
        exhaleSound = new Sound("res/sound/exhale.wav");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        background.draw(0, 0);
        levels.render();
        player.render();

        // Draw the heart rate meter as a simple rectangle.
        graphics.setColor(new Color(player.heartRate / player.MAX_HEART_RATE, .1f, 1 - player.heartRate / player.MAX_HEART_RATE));
        graphics.fillRoundRect(20, // x in pixels, from left edge of screen
                40, // y in pixels, from top edge of screen
                player.heartRate * 4, // width of rectangle
                10, // height of rectangle
                5); // rectangle rounded corner radius in pixels
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException
    {
        if (!music.playing()) music.loop();


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

        if ((player.heartRate < player.MIN_HEART_RATE) || (player.heartRate > player.MAX_HEART_RATE))
        {
            stateBasedGame.enterState(AquapulseGame.GAME_OVER_STATE);
        }

        // Occasionally play the bubble sound
        if (Math.random() < .005) // 1 in 200 chance
        {
            Sound bubbles = new Sound("res/sound/bubbles.wav");
            bubbles.play();
        }

        // Occasionally play the inhale/exhale sound
        //if (Math.random())
    }

    private boolean collides(Shape shape1, Shape shape2)
    {
        return shape1.intersects(shape2);
    }
}
