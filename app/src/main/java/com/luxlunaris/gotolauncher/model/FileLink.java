package com.luxlunaris.gotolauncher.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import androidx.core.content.FileProvider;

import com.luxlunaris.gotolauncher.R;

import java.io.File;

public class FileLink implements DesktopLink{

    String pathname;

    public FileLink(String pathname){
        this.pathname = pathname;
    }

    @Override
    public String getLabel(Context context) {
        return new File(pathname).getName();
    }

    @Override
    public String getId() {
        return Uri.fromFile(new File(pathname)).toString();
    }

    @Override
    public Drawable getIcon(Context context) {
        return context.getResources().getDrawable(R.drawable.ic_launcher_foreground);
    }

    @Override
    public Intent getLaunchIntent(Context context) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);

        Uri uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".fileprovider",new File(pathname));

        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/jpeg");
        context.startActivity(Intent.createChooser(shareIntent,"send"));
        return shareIntent;
    }


}
