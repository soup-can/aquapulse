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
            level.render();
        }
    }

    public void scroll(int delta)
    {
        for(int index = 0; index < levels.size(); index++)
        {
            levels.get(index).position.x -= SCROLL_COEFF * delta;
        }
    }
}
