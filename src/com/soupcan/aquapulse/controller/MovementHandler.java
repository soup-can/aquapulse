package com.soupcan.aquapulse.controller;

import com.soupcan.aquapulse.model.entity.Player;
import org.newdawn.slick.Input;

public class MovementHandler
{
    public static float MOVEMENT_COEFFICIENT = 0.1f;

    private Player player;

    public MovementHandler(Player player)
    {
        this.player = player;
    }

    public void processInput(Input input, float delta)
    {
        if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
        {
            player.position.y -= MOVEMENT_COEFFICIENT * delta;
        }

        if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
        {
            player.position.x -= MOVEMENT_COEFFICIENT * delta;
        }

        if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
        {
            player.position.y += MOVEMENT_COEFFICIENT * delta;
        }

        if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
        {
            player.position.x += MOVEMENT_COEFFICIENT * delta;
        }
    }
}
