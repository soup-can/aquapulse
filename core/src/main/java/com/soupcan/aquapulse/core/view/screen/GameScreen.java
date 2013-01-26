package com.soupcan.aquapulse.core.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.soupcan.aquapulse.core.model.world.GameWorld;
import com.soupcan.aquapulse.core.view.render.GameRenderer;

/**
 * The screen in which the actual gameplay takes place.
 *
 * @author Zachary Latta
 */
public class GameScreen extends AbstractScreen
{
    public GameScreen()
    {
        super(new GameWorld(), new GameRenderer());
    }

    @Override
    public void show()
    {
    }

    @Override
    public void hide()
    {
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0.196078f, 0.196078f, 0.8f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {
    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void dispose()
    {
    }

    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int x, int y)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }
}
