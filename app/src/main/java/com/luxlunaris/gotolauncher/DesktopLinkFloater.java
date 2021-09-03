package com.luxlunaris.gotolauncher;

import android.content.Context;

import com.luxlunaris.gotolauncher.model.DesktopLink;

/**
 * A MemoryFloater that displays a DesktopLink on a DesktopLinkFragment.
 */
public class DesktopLinkFloater extends MemoryFloater{


    DesktopLink desktopLink;
    DesktopLinkFragment fragment;

    public DesktopLinkFloater(Context context, DesktopLink desktopLink) {
        super(context, desktopLink.getId());
        fragment = DesktopLinkFragment.newInstance(desktopLink);
        addFragment(fragment);
        this.desktopLink = desktopLink;
    }

    @Override
    protected void onClick(){
        getContext().startActivity(desktopLink.getLaunchIntent(getContext()));
    }




}
