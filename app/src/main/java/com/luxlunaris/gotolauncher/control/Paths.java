package com.luxlunaris.gotolauncher.control;

import android.content.Context;

import java.io.File;

public class Paths {

    private static Paths instance;
    private Context context;
    private static final String LINKS_METADATA_DIR = "links_metadata";

    private Paths(Context context){
        this.context = context;
    }

    public static Paths instance(Context context){
        return instance!=null? instance : (instance = new Paths(context));
    }


    /**
     * Get the path of the dir that stores the Metadata files for each link on the launcher.
     * @return
     */
    public String LINKS_METADATA_DIR(){
        return context.getFilesDir()+ File.separator+LINKS_METADATA_DIR;
    }





}
