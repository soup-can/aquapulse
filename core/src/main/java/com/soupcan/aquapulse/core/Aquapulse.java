package com.soupcan.aquapulse.core;

import com.badlogic.gdx.Game;
import com.soupcan.aquapulse.core.view.screen.GameScreen;

public class Aquapulse extends Game
{
    public GameScreen gameScreen = null;

    @Override
    public void create()
    {
        gameScreen = new GameScreen();

        setScreen(gameScreen);
    }
}
