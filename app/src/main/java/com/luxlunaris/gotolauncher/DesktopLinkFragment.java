package com.luxlunaris.gotolauncher;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luxlunaris.gotolauncher.model.AppLink;
import com.luxlunaris.gotolauncher.model.DesktopLink;


public class DesktopLinkFragment extends Fragment {


    DesktopLink desktopLink;
    TextView titleView;
    ImageView imageView;

    public DesktopLinkFragment() {
        // Required empty public constructor
    }

    public static DesktopLinkFragment newInstance(DesktopLink appLink) {
        DesktopLinkFragment fragment = new DesktopLinkFragment();
        fragment.desktopLink = appLink;
        return fragment;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_app_link, container, false);
        titleView = v.findViewById(R.id.title_view);
        imageView = v.findViewById(R.id.imageView);


        titleView.setText(desktopLink.getLabel(getContext()));
        imageView.setForeground(desktopLink.getIcon(getContext()));
        return v;
    }
}