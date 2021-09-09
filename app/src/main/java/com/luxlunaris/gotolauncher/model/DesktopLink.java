package com.luxlunaris.gotolauncher.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import com.luxlunaris.skratchbook.model.Tag;

/**
 * Stores the information for a link sitting on the launcher's homepage, aka "desktop".
 */
public interface DesktopLink  {

    /**
     * Metadata tags.
     */
    Tag TAG_X = new Tag("x", 0+"");
    Tag TAG_Y = new Tag("y", 0+"");


    String getLabel(Context context);
    String getId();
    Drawable getIcon(Context context);
    Intent getLaunchIntent(Context context);
    Coordinate getCoordinate();
    void setCoordinate(float x, float y);


}
