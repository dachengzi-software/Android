package com.ftfl.ftflnavigationdrawer.fragment;

import com.ftfl.ftflnavigationdrawer.R;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GeneralFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_general, container, false);
        
        return rootView;
	}

}
