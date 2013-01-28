package com.soupcan.aquapulse.controller;

import com.soupcan.aquapulse.AquapulseGame;
import com.soupcan.aquapulse.model.engine.LevelGroup;
import com.soupcan.aquapulse.model.entity.Player;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class MovementController
{
    public static float BPM_TO_ADD_IF_PLAYER_MOVED = 30;
    public static float BPM_TO_SUBTRACT_IF_PLAYER_DID_NOT_MOVE = 20;

    public static float MOVEMENT_COEFFICIENT = 0.1f;

    private Player player;
    private LevelGroup levels;

    private Sound collide;

    public MovementController(Player player, LevelGroup levels) throws SlickException
    {
        collide = new Sound("res/sound/collision.wav");

        this.player = player;
        this.levels = levels;
    }

    public void processInput(Input input, float delta, StateBasedGame stateBasedGame)
    {
        boolean playerMoved = false;

        if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
        {
            boolean collided = false;

            for(int i = 0; i < levels.size(); i++)
            {
                for(int j = 0; j < levels.get(i).bounds.size(); j++)
                {
                    Shape tileBlock = levels.get(i).bounds.get(j);

                    if(player.bounds.intersects(tileBlock) && player.bounds.getMinY() <= tileBlock.getMaxY())
                    {
                        collide.play();
                        stateBasedGame.enterState(AquapulseGame.GAME_OVER_STATE);
                    }
                }
            }

            if (!collided) player.position.y -= MOVEMENT_COEFFICIENT * delta;

            playerMoved = true;
        }

        if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
        {
            boolean collided = false;

            for(int i = 0; i < levels.size(); i++)
            {
                for(int j = 0; j < levels.get(i).bounds.size(); j++)
                {
                    Shape tileBlock = levels.get(i).bounds.get(j);

                    if(player.bounds.intersects(tileBlock) && player.bounds.getMinX() <= tileBlock.getMaxX())
                    {
                        collide.play();
                        stateBasedGame.enterState(AquapulseGame.GAME_OVER_STATE);
                    }
                }
            }

            if (!collided) player.position.x -= MOVEMENT_COEFFICIENT * delta;

            playerMoved = true;
        }

        if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
        {
            boolean collided = false;

            for(int i = 0; i < levels.size(); i++)
            {
                for(int j = 0; j < levels.get(i).bounds.size(); j++)
                {
                    Shape tileBlock = levels.get(i).bounds.get(j);

                    if(player.bounds.intersects(tileBlock) && player.bounds.getMinY() <= tileBlock.getMaxY())
                    {
                        collide.play();
                        stateBasedGame.enterState(AquapulseGame.GAME_OVER_STATE);
                    }
                }
            }

            if (!collided) player.position.y += MOVEMENT_COEFFICIENT * delta;

            playerMoved = true;
        }

        if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
        {
            boolean collided = false;

            for(int i = 0; i < levels.size(); i++)
            {
                for(int j = 0; j < levels.get(i).bounds.size(); j++)
                {
                    Shape tileBlock = levels.get(i).bounds.get(j);

                    if(player.bounds.intersects(tileBlock) && player.bounds.getMaxX() >= tileBlock.getMinX())
                    {
                        collide.play();
                        stateBasedGame.enterState(AquapulseGame.GAME_OVER_STATE);
                    }
                }
            }

            if (!collided) player.position.x += MOVEMENT_COEFFICIENT * delta;

            playerMoved = true;
        }

        player.heartRate += (playerMoved ? BPM_TO_ADD_IF_PLAYER_MOVED : -BPM_TO_SUBTRACT_IF_PLAYER_DID_NOT_MOVE) * delta/1000.0f;
    }

}
