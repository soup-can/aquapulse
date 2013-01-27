package com.soupcan.aquapulse.controller;

import com.soupcan.aquapulse.model.entity.Player;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.RoundedRectangle;

public class InputController
{
    public static float BPM_TO_ADD_IF_PLAYER_MOVED = 30;
    public static float BPM_TO_SUBTRACT_IF_PLAYER_DID_NOT_MOVE = 20;

    public static float MOVEMENT_COEFFICIENT = 0.1f;

    private Player player;

    public InputController(Player player)
    {
        this.player = player;
    }

    public void processInput(Input input, float delta)
    {
        boolean playerMoved = false;

        if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
        {
            player.position.y -= MOVEMENT_COEFFICIENT * delta;
            playerMoved = true;
        }

        if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
        {
            player.position.x -= MOVEMENT_COEFFICIENT * delta;
            playerMoved = true;
        }

        if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
        {
            player.position.y += MOVEMENT_COEFFICIENT * delta;
            playerMoved = true;
        }

        if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
        {
            player.position.x += MOVEMENT_COEFFICIENT * delta;
            playerMoved = true;
        }

        player.heartRate += (playerMoved ? BPM_TO_ADD_IF_PLAYER_MOVED : -BPM_TO_SUBTRACT_IF_PLAYER_DID_NOT_MOVE) * delta/1000.0f;
    }
}
