package com.example.Android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ViewPager myViewPager;
	
	private LayoutInflater layoutInflater;
	
	private RelativeLayout bottomLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		layoutInflater=LayoutInflater.from(this);
		bottomLayout=(RelativeLayout)findViewById(R.id.bottomLayout);
		View view1=layoutInflater.inflate(R.layout.view_one, null);
		View view2=layoutInflater.inflate(R.layout.view_two, null);
		View view3=layoutInflater.inflate(R.layout.view_three, null);
		myViewPager=(ViewPager)findViewById(R.id.mainViewPager);
		
		List<View> allViews=new ArrayList<View>();
		allViews.add(view1);
		allViews.add(view2);
		allViews.add(view3);
		
		
		MainViewPagerAdapter adapter=new MainViewPagerAdapter(allViews, this);
		myViewPager.setAdapter(adapter);
		myViewPager.setCurrentItem(1);
		
		myViewPager.setOnPageChangeListener(listen);
	}

	OnPageChangeListener listen=new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
			Log.e("arg1------>", arg1+"");
			int nu=(int) (255*(1-arg1)+50);
			if (nu>255) {
				nu=255;
			}
			bottomLayout.getBackground().setAlpha(nu);
			
//			WindowManager.LayoutParams lp=bottomLayout.getAttributes();
//			lp.dimAmount=arg1;
			
			if (arg0!=1) {
				bottomLayout.getBackground().setAlpha(50);
			}
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	

}
