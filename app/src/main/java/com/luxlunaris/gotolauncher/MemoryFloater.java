package com.luxlunaris.gotolauncher;

import android.content.Context;
import android.util.Log;

import com.luxlunaris.gotolauncher.control.Paths;
import com.luxlunaris.skratchbook.interfaces.Metadata;
import com.luxlunaris.skratchbook.model.MetadataFile;
import com.luxlunaris.skratchbook.model.Tag;

/**
 * A Floater w/ an associated Metadata file.
 */
public class MemoryFloater extends Floater{


    /**
     * Metadata tags.
     */
    Tag TAG_X = new Tag("x", 0+"");
    Tag TAG_Y = new Tag("y", 0+"");

    Metadata metadata;


    public MemoryFloater(Context context, String pathname) {
        super(context);
        metadata = new MetadataFile(Paths.instance(getContext()).LINKS_METADATA_DIR()+pathname);
        metadata.create();
        float x = (float) metadata.getFloat(TAG_X);
        float y = (float)metadata.getFloat(TAG_Y);
        Log.d("METADATA", "moving to x="+x+" y="+y);
        setPosition(x, y);
    }

    protected void onStoppedMoving(float x, float y){
        metadata.setTag(TAG_X, x+"");
        metadata.setTag(TAG_Y, y+"");
        Log.d("METADATA", "done setting x="+metadata.getFloat(TAG_X)+" y="+metadata.getFloat(TAG_Y));
    }







}
