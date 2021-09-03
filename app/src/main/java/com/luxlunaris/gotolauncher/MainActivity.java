package com.luxlunaris.gotolauncher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import com.luxlunaris.gotolauncher.model.AppLink;
import com.luxlunaris.gotolauncher.model.FileLink;

/**
 * This activity functions as the "desktop"-part of the launcher.
 */
public class MainActivity extends AppCompatActivity {


    ConstraintLayout consLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consLay = (ConstraintLayout) findViewById(R.id.layout_main);


        AppLink appLink = new AppLink("com.android.chrome", "com.google.android.apps.chrome.Main");
        DesktopLinkFloater f = new DesktopLinkFloater(this, appLink);
        consLay.addView(f);
        appLink = new AppLink("com.luxlunaris.noadpadlight", "com.luxlunaris.noadpadlight.ui.MainActivity");
        f = new DesktopLinkFloater(this, appLink);
        consLay.addView(f);


        FileLink fLink = new FileLink("/data/user/0/com.luxlunaris.gotolauncher/files/links_metadata");
        consLay.addView( new DesktopLinkFloater(this, fLink));





    }


}