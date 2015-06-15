package me.chenfuduo.moonnewsclient.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        view.setText("MyFragment");
        view.setGravity(Gravity.CENTER);
        view.setTextSize(20);
        return view;
    }


}
