package com.utest.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.utest.manager.R;


public class ZnoeFragment extends Fragment{
	private LinearLayout layout = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment3, null);
		layout = (LinearLayout)view.findViewById(R.id.layout_zone);
		layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MyApplication.APPLICATION_CONTEXT,DetailsActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}	
}