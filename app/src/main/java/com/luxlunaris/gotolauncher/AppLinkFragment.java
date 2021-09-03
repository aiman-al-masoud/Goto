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


public class AppLinkFragment extends Fragment {


    AppLink appLink;
    TextView titleView;
    ImageView imageView;

    public AppLinkFragment() {
        // Required empty public constructor
    }


    public static AppLinkFragment newInstance(AppLink appLink) {
        AppLinkFragment fragment = new AppLinkFragment();
        fragment.appLink = appLink;
        return fragment;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_app_link, container, false);
        titleView = v.findViewById(R.id.title_view);
        imageView = v.findViewById(R.id.imageView);


        titleView.setText(appLink.getName(getContext()));
        imageView.setForeground(appLink.getIcon(getContext()));
        return v;
    }
}