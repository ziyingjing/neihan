package com.zhoujing.neihan.fragments;

import com.zhoujing.neihan.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MineFragment extends Fragment {

	public MineFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_mine,container,false);
    	return view;
    }
    @Override
    public void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    }
    @Override
    public void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    }
    @Override
    public void onDestroyView() {
    	// TODO Auto-generated method stub
    	super.onDestroyView();
    }
}
