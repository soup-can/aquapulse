package com.soupcan.aquapulse.model.entity;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class Entity
{
    public Vector2f position;
    protected Shape bounds;

    public Entity(Vector2f position, float width, float height)
    {
        this.position = position;
        this.bounds = new Rectangle(position.x, position.y, width, height);
    }

    public Entity(float width, float height)
    {
        this.position = new Vector2f(0, 0);
        this.bounds = new Rectangle(position.x, position.y, width, height);
    }

    public void update()
    {
        bounds.setX(position.x);
        bounds.setY(position.y);
    }
}
