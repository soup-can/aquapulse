package com.soupcan.aquapulse.core.view.screen;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.soupcan.aquapulse.core.model.world.World;
import com.soupcan.aquapulse.core.view.render.Renderer;

public abstract class AbstractScreen implements Screen, InputProcessor
{
    public final World world;
    public final Renderer renderer;

    public AbstractScreen(World world, Renderer renderer)
    {
        this.world = world;
        this.renderer = renderer;
    }
}
