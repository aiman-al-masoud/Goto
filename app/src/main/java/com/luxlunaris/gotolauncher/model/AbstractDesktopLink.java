package com.luxlunaris.gotolauncher.model;

import android.content.Context;
import android.util.Log;

import com.luxlunaris.gotolauncher.control.Paths;
import com.luxlunaris.skratchbook.interfaces.Metadata;
import com.luxlunaris.skratchbook.model.MetadataFile;

import java.io.File;

public abstract class AbstractDesktopLink implements DesktopLink{

    Metadata metadata;


    public AbstractDesktopLink(Context context, String pathname){
        metadata = new MetadataFile(Paths.instance(context).LINKS_METADATA_DIR()+File.separator+pathname);
        Log.d("PATHNAME", ((File)metadata).getPath());
        metadata.create();
    }


    @Override
    public Coordinate getCoordinate() {
        return new Coordinate((float) metadata.getFloat(TAG_X), (float) metadata.getFloat(TAG_Y));
    }

    @Override
    public void setCoordinate(float x, float y) {
        metadata.setTag(TAG_X, x+"");
        metadata.setTag(TAG_Y, y+"");
    }








}
