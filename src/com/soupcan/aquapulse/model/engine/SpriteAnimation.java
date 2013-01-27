package com.soupcan.aquapulse.model.engine;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

public class SpriteAnimation
{
    private SpriteSheet spriteSheet;
    private Animation animation;

    public SpriteAnimation(String ref, int tileWidth, int tileHeight)
    {
        try
        {
            spriteSheet = new SpriteSheet(new Image(ref), tileWidth, tileHeight);
            animation = new Animation(spriteSheet, 250);
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

    public void draw(Vector2f position)
    {
        animation.draw(position.x, position.y);
    }
}
