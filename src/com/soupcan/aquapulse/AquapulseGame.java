package com.soupcan.aquapulse;

import com.soupcan.aquapulse.state.GameplayState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class AquapulseGame extends StateBasedGame
{
    public static final int GAMEPLAY_STATE = 1;

    public AquapulseGame()
    {
        super("Aquapulse");
    }

    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new AquapulseGame());

        app.setTargetFrameRate(30);
        app.setDisplayMode(800, 600, false);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException
    {
        this.addState(new GameplayState(GAMEPLAY_STATE));
    }
}
