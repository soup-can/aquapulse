package com.soupcan.aquapulse.controller;

import com.soupcan.aquapulse.model.engine.LevelGroup;
import com.soupcan.aquapulse.model.entity.Player;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class MovementController
{
    public static float MOVEMENT_COEFFICIENT = 0.1f;

    private Player player;
    private LevelGroup levels;

    public MovementController(Player player, LevelGroup levels)
    {
        this.player = player;
        this.levels = levels;
    }

    public void processInput(Input input, float delta)
    {
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
                        collided = true;
                    }
                }
            }

            if (!collided) player.position.y -= MOVEMENT_COEFFICIENT * delta;
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
                        collided = true;
                    }
                }
            }

            if (!collided) player.position.x -= MOVEMENT_COEFFICIENT * delta;
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
                        collided = true;
                    }
                }
            }

            if (!collided) player.position.y += MOVEMENT_COEFFICIENT * delta;
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
                        collided = true;
                    }
                }
            }

            if (!collided) player.position.x += MOVEMENT_COEFFICIENT * delta;
        }
    }

}
