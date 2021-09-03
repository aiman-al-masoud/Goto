package com.luxlunaris.gotolauncher;

import android.content.Context;
import android.util.Log;

import com.luxlunaris.gotolauncher.model.AppLink;
import com.luxlunaris.skratchbook.interfaces.Metadata;
import com.luxlunaris.skratchbook.model.MetadataFile;
import com.luxlunaris.skratchbook.model.Tag;

import java.io.File;

public class AppLinkFloater extends Floater{


    AppLink appLink;
    AppLinkFragment fragment;
    Metadata metadata;

    Tag TAG_X = new Tag("x", 0+"");
    Tag TAG_Y = new Tag("y", 0+"");


    public AppLinkFloater(Context context, AppLink appLink) {
        super(context);
        fragment = AppLinkFragment.newInstance(appLink);
        addFragment(fragment);
        this.appLink = appLink;
        metadata = new MetadataFile(getContext().getFilesDir()+ File.separator+appLink.getName(getContext()));

        if(!((MetadataFile)metadata ).exists()){
            metadata.create();
        }


        float x = Float.parseFloat(metadata.getString(TAG_X));
        float y = Float.parseFloat(metadata.getString(TAG_Y));
        Log.d("TEST", "reloading at: "+x+" "+y);
        setPosition(x, y);

    }

    @Override
    protected void onClick(){
        getContext().startActivity(appLink.getLaunchIntent(getContext()));
    }

    @Override
    protected void onStoppedMoving() {
        metadata.setTag(TAG_X, getXPos()+"");
        metadata.setTag(TAG_Y, getYPos()+"");
        Log.d("TEST","saved: "+metadata.getString(TAG_X)+" "+metadata.getString(TAG_Y));
    }



}
