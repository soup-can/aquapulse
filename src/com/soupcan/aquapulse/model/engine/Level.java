package com.soupcan.aquapulse.model.engine;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Level
{
    private TiledMap map;

    public Level(String mapLocation) throws SlickException
    {
        map = new TiledMap(mapLocation);
    }

    public void render()
    {
        map.render(0, 0);
    }

    public void render(int layer)
    {
        map.render(0, 0, layer);
    }

    public void render(int[] layer)
    {
        for (int index = 0; index < layer.length; index++)
        {
            map.render(0, 0, layer[index]);
        }
    }

    public void render(int x, int y)
    {
        map.render(x, y);
    }

    public void render(int x, int y, int layer)
    {
        map.render(x, y, layer);
    }

    public void render(int x, int y, int[] layer)
    {
        for (int index = 0; index < layer.length; index++)
        {
            map.render(x, y, layer[index]);
        }
    }
}
