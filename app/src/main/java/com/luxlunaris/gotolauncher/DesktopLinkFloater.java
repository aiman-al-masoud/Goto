package com.luxlunaris.gotolauncher;

import android.content.Context;
import android.util.Log;

import com.luxlunaris.gotolauncher.model.Coordinate;
import com.luxlunaris.gotolauncher.model.DesktopLink;

/**
 * A MemoryFloater that displays a DesktopLink on a DesktopLinkFragment.
 */
public class DesktopLinkFloater extends Floater {//MemoryFloater{


    DesktopLink desktopLink;
    DesktopLinkFragment fragment;

    public DesktopLinkFloater(Context context, DesktopLink desktopLink) {
        //super(context, desktopLink.getId());
        super(context);
        fragment = DesktopLinkFragment.newInstance(desktopLink);
        addFragment(fragment);
        this.desktopLink = desktopLink;
        //set last position
        Coordinate coordinate = desktopLink.getCoordinate();
        setPosition(coordinate.x, coordinate.y);
    }

    @Override
    protected void onClick(){
        getContext().startActivity(desktopLink.getLaunchIntent(getContext()));
    }


    @Override
    protected void onStoppedMoving(float x, float y){
        //metadata.setTag(TAG_X, x+"");
        //metadata.setTag(TAG_Y, y+"");
        Log.d("METADATA", "done setting x="+x+" y="+y);
        desktopLink.setCoordinate(x, y);
    }




}
