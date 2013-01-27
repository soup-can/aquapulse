package com.soupcan.aquapulse.state;

import com.soupcan.aquapulse.AquapulseGame;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState
{
    private int stateId;

    private Image background;
    private Image startButtonDown;
    private Image startButtonUp;

    private Vector2f startButtonPosition;

    private Sound hover;
    private Sound select;

    boolean insideStart;

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
        background = new Image("res/img/ui/mainmenu.png");
        startButtonDown = new Image("res/img/ui/startbutton_down.png");
        startButtonUp = new Image("res/img/ui/startbutton_up.png");

        startButtonPosition = new Vector2f(325, 400);

        hover = new Sound("res/snd/ui/hover.wav");
        select = new Sound("res/snd/ui/select.wav");

        insideStart = false;
    }

    @Override
    public void render(GameContainer container, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        background.draw(0, 0, 800, 600);

        if(insideStart)
        {
            startButtonDown.draw(startButtonPosition.x, startButtonPosition.y);
        }
        else
        {
            startButtonUp.draw(startButtonPosition.x, startButtonPosition.y);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException
    {
        Input input = container.getInput();

        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();

        if((mouseX >= startButtonPosition.x && mouseX <= startButtonPosition.x + startButtonDown.getWidth()) &&
                (mouseY >= startButtonPosition.y && mouseY <= startButtonPosition.y + startButtonDown.getHeight()))
        {
            if(!insideStart)
            {
                hover.play();
            }

            insideStart = true;

            if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
            {
                select.play();
                stateBasedGame.enterState(AquapulseGame.GAMEPLAY_STATE);
            }
        }
        else
        {
            insideStart = false;
        }
    }
}
