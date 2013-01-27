package com.soupcan.aquapulse.model.entity;

import com.soupcan.aquapulse.model.engine.SpriteAnimation;
import org.newdawn.slick.geom.Vector2f;

public class Player extends Entity
{
    public static final int WIDTH = 293;
    public static final int HEIGHT = 137;
    private static final String SHEET_REF = "res/img/player.png";

    private SpriteAnimation animation;

    public Player(Vector2f position)
    {
        super(position, WIDTH, HEIGHT);

        animation = new SpriteAnimation(SHEET_REF, WIDTH, HEIGHT);
    }

    public void render()
    {
        animation.draw(position);
    }
}
