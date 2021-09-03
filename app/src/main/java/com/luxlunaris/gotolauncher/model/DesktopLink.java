package com.luxlunaris.gotolauncher.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public interface DesktopLink {

    String getLabel(Context context);
    String getId();
    Drawable getIcon(Context context);
    Intent getLaunchIntent(Context context);

}
