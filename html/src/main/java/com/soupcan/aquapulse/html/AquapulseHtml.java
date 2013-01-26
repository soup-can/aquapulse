package com.soupcan.aquapulse.html;

import com.soupcan.aquapulse.core.Aquapulse;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class AquapulseHtml extends GwtApplication
{
    @Override
    public ApplicationListener getApplicationListener()
    {
        return new Aquapulse();
    }

    @Override
    public GwtApplicationConfiguration getConfig()
    {
        return new GwtApplicationConfiguration(480, 320);
    }
}
