package com.luxlunaris.gotolauncher.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

/**
 * A desktop link to an app.
 */
public class AppLink implements DesktopLink{

    private String packageName;
    private String activityName;


    public AppLink(String packageName, String activityName){
        this.packageName = packageName;
        this.activityName = activityName;
    }

    public Intent getLaunchIntent(Context context){
        return context.getPackageManager().getLaunchIntentForPackage(packageName);
    }

    public String getLabel(Context context){
        PackageManager pm = context.getPackageManager();
        ResolveInfo resolveInfo = getResolveInfo(pm);
        return (String)resolveInfo.loadLabel(pm);
    }

    public Drawable getIcon(Context context) {
        PackageManager pm = context.getPackageManager();
        ResolveInfo resolveInfo = getResolveInfo(pm);
        return resolveInfo.loadIcon(pm);
    }


    private ResolveInfo getResolveInfo(PackageManager pm){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
        return resolveInfo;
    }


    public String getPackageName(){
        return packageName;
    }

    public String getActivityName(){
        return activityName;
    }

    public String getId(){
        return  getPackageName()+"_"+getActivityName();
    }















}
