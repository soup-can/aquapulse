package com.soupcan.aquapulse.model.engine;

import java.util.ArrayList;
import java.util.List;

public class LevelGroup
{
    public static final float SCROLL_COEFF = 0.05f;

    private List<Level> levels;

    public LevelGroup()
    {
        levels = new ArrayList<Level>();
    }

    public void addLevel(Level level)
    {
        // If there's no other levels in the group, then set the new level's position to 0, 0. Otherwise, set it to the
        // last level's position + width + 1
        try
        {
            Level preceding = levels.get(levels.size() - 1);

            level.position.x = preceding.position.x + preceding.getWidth() + 1;

            for(int i = 0; i < level.bounds.size(); i++)
            {
                level.bounds.get(i).setBounds(level.bounds.get(i).getX() + level.position.x,
                        level.bounds.get(i).getY() + level.position.y,
                        level.bounds.get(i).getWidth(),
                        level.bounds.get(i).getHeight());
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            level.position.x = 0;
            level.position.y = 0;
        }

        levels.add(level);
    }

    public void render()
    {
        for(Level level : levels)
        {
            level.render(new int[] {1, 2});
        }
    }

    public void scroll(int delta)
    {
        for(int index = 0; index < levels.size(); index++)
        {
            levels.get(index).position.x -= SCROLL_COEFF * delta;

            for(int i = 0; i < levels.get(index).bounds.size(); i++)
            {
                levels.get(index).bounds.get(i).setX(levels.get(index).bounds.get(i).getX() - SCROLL_COEFF * delta);
            }
        }
    }

    public int size()
    {
        return levels.size();
    }

    public Level get(int index)
    {
        return levels.get(index);
    }
}
