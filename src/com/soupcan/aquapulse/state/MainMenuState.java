package com.soupcan.aquapulse.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState
{
    private int stateId;

    public MainMenuState(int stateId)
    {
        this.stateId = stateId;
    }

    @Override
    public int getID()
    {
        return stateId;
    }

    @Override
    public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException
    {

    }

    @Override
    public void render(GameContainer container, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {

    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException
    {

    }
}
