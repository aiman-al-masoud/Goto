package com.luxlunaris.gotolauncher.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

public class AppLink {

    String packageName;
    String activityName;


    public AppLink(String packageName, String activityName){
        this.packageName = packageName;
        this.activityName = activityName;
    }

    public Intent getLaunchIntent(Context context){
        return context.getPackageManager().getLaunchIntentForPackage(packageName);
    }

    public String getName(Context context){
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
        return (String)resolveInfo.loadLabel(pm);
    }


    public Drawable getIcon(Context context) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
        return resolveInfo.loadIcon(pm);
    }















}
