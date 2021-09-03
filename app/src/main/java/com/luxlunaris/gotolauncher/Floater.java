package com.luxlunaris.gotolauncher;


import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.luxlunaris.gotolauncher.control.Paths;
import com.luxlunaris.skratchbook.interfaces.Metadata;
import com.luxlunaris.skratchbook.model.MetadataFile;
import com.luxlunaris.skratchbook.model.Tag;

import java.io.File;
import java.util.Random;

/**
 * A floating container for views and fragments.
 */
public class Floater extends LinearLayout implements View.OnTouchListener {

    float downRawX, downRawY, dX, dY;

    float oldXPos, oldYPos = -1;

    OnClickListener onClickListener;


    public Floater(Context context) {
        super(context);
        setOnTouchListener(this);
        setOrientation(LinearLayout.VERTICAL);
        setId(new Random().nextInt());
        dX = dY = 0;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                downRawX = event.getRawX();
                downRawY = event.getRawY();
                dX = v.getX() - downRawX;
                dY = v.getY() - downRawY;

                return true;

            case MotionEvent.ACTION_MOVE:

                float newX = event.getRawX() + dX;
                float newY = event.getRawY() + dY;


                setPosition(newX, newY);
                return true;

            case MotionEvent.ACTION_UP:

                newX = event.getRawX() + dX;
                newY = event.getRawY() + dY;

                if(oldXPos==newX && oldYPos==newY) {
                    onClick();
                }

                oldXPos = newX;
                oldYPos = newY;

                onStoppedMoving(newX, newY);

                return true;
        }

        return false;
    }

    /**
     * Move this Floater to a new position relative to the screen.
     * @param x
     * @param y
     */
    public void setPosition(float x, float y){
        this.animate().x(x).y(y).setDuration(0).start();
    }

    /**
     * Add a fragment to this Floater.
     * @param fragment
     */
    public void addFragment(Fragment fragment){
        try{
            ((AppCompatActivity)getContext()).getSupportFragmentManager().beginTransaction().add(getId(), fragment, "").commit();
        }catch (ClassCastException e){
            Log.d("CLASSCASTEXCEPTION", "context was not an AppCompatActivity");
        }
    }


    /**
     * Called when the Floater gets clicked.
     */
    protected void onClick(){
        if(onClickListener!=null){
            onClickListener.onClick(this);
        }
    }

    /**
     * Set the on click "listener".
     * Just a handy way to pass around a procedure/void method.
     * @param onClickListener
     */
    @Override
    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    protected void onStoppedMoving(float x, float y){ }












}
