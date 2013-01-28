package com.soupcan.aquapulse.state;

import com.soupcan.aquapulse.AquapulseGame;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState
{
    private int stateId;

    private Image background;
    private Image startButtonDown;
    private Image startButtonUp;

    private Vector2f restartButtonPosition;

    private Sound hover;
    private Sound select;

    private Music music;
    private Sound death1, death2, death3, death4;

    boolean insideRestart;

    public GameOverState(int stateId)
    {
        this.stateId = stateId;
    }

    @Override
    public int getID()
    {
        return stateId;
    }

    @Override
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        switch((int)(Math.random() * ((4 -1)) + 1))
        {
            case 1:
                death1.play();
                break;

            case 2:
                death2.play();
                break;

            case 3:
                death3.play();
                break;

            case 4:
                death4.play();
                break;
        }

        music.loop();
    }

    @Override
    public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException
    {
        background = new Image("res/img/ui/gameover.png");
        startButtonDown = new Image("res/img/ui/restartbutton_down.png");
        startButtonUp = new Image("res/img/ui/restartbutton_up.png");

        restartButtonPosition = new Vector2f(325, 400);

        hover = new Sound("res/sound/ui/hover.wav");
        select = new Sound("res/sound/ui/select.wav");

        music = new Music("res/sound/menu_music.ogg");
        death1 = new Sound("res/sound/death_01.wav");
        death2 = new Sound("res/sound/death_02.wav");
        death3 = new Sound("res/sound/death_03.wav");
        death4 = new Sound("res/sound/death_04.wav");

        insideRestart = false;
    }

    @Override
    public void render(GameContainer container, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        background.draw(0, 0, 800, 600);

        if(insideRestart)
        {
            startButtonDown.draw(restartButtonPosition.x, restartButtonPosition.y);
        }
        else
        {
            startButtonUp.draw(restartButtonPosition.x, restartButtonPosition.y);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException
    {
        Input input = container.getInput();

        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();

        if((mouseX >= restartButtonPosition.x && mouseX <= restartButtonPosition.x + startButtonDown.getWidth()) &&
                (mouseY >= restartButtonPosition.y && mouseY <= restartButtonPosition.y + startButtonDown.getHeight()))
        {
            if(!insideRestart)
            {
                hover.play();
            }

            insideRestart = true;

            if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
            {
                select.play();
                music.stop();
                stateBasedGame.enterState(AquapulseGame.GAMEPLAY_STATE);
            }
        }
        else
        {
            insideRestart = false;
        }
    }
}
