package com.soupcan.aquapulse.entity;

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

    public void render(int x, int y)
    {
        map.render(x, y);
    }

    public void render(int x, int y, int layer)
    {
        map.render(x, y, layer);
    }
}
