package com.luxlunaris.gotolauncher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luxlunaris.gotolauncher.model.AppLink;

public class MainActivity extends AppCompatActivity {


    ConstraintLayout consLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consLay = (ConstraintLayout) findViewById(R.id.layout_main);


        /*
        Floater f = new Floater(this);
        AppLink appLink = new AppLink("com.android.chrome", "com.google.android.apps.chrome.Main");

        f.addFragment(AppLinkFragment.newInstance(appLink));
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TEST", "click!");
            }
        });
        consLay.addView(f);

         */

        AppLink appLink = new AppLink("com.android.chrome", "com.google.android.apps.chrome.Main");
        AppLinkFloater f = new AppLinkFloater(this, appLink);

        consLay.addView(f);



    }
}