package com.soupcan.aquapulse.model.engine;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;

import java.util.ArrayList;
import java.util.List;

public class Level
{
    public Vector2f position;
    public List<Rectangle> bounds;

    private TiledMap map;

    public Level(String mapLocation) throws SlickException
    {
        map = new TiledMap(mapLocation);
        position = new Vector2f();
        bounds = new ArrayList<Rectangle>();

        for(int x = 0; x < map.getWidth(); x++)
        {
            for(int y = 0; y < map.getHeight(); y++)
            {
                int tileId = map.getTileId(x, y, 0);

                if(tileId == 7)
                {
                    bounds.add(new Rectangle(x * 32, y * 32, 32, 32));
                }
            }
        }
    }

    public Level(String mapLocation, Vector2f position) throws SlickException
    {
        map = new TiledMap(mapLocation);

        this.position = position;
    }

    public void render()
    {
        map.render((int) position.x, (int) position.y);
    }

    public void render(int layer)
    {
        map.render((int) position.x, (int) position.y, layer);
    }

    public void render(int[] layer)
    {
        for (int index = 0; index < layer.length; index++)
        {
            map.render((int) position.x, (int) position.y, layer[index]);
        }
    }

    public int getWidth()
    {
        return map.getWidth() * map.getTileWidth();
    }

    public int getHeight()
    {
        return map.getHeight() * map.getHeight();
    }

    public int getHorizontalTiles()
    {
        return map.getWidth();
    }

    public int getVerticalTiles()
    {
        return map.getHeight();
    }

    public int getTileId(int x, int y, int layer)
    {
        return map.getTileId(x, y, layer);
    }
}
