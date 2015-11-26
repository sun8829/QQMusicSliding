package com.example.Android;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MainViewPagerAdapter extends PagerAdapter{

	private List<View> allViews;
	private Context ctx;
	
	public MainViewPagerAdapter(List<View> allView,Context context) {
		// TODO Auto-generated constructor stub
		this.allViews=allView;
		this.ctx=context;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return allViews.size()>0?allViews.size():0;
	}

	@Override  
    public boolean isViewFromObject(View arg0, Object arg1) {             
        return arg0==arg1;//官方提示这样写  
    }  
	
	@Override  
    public void destroyItem(ViewGroup container, int position,  
            Object object) {  
        container.removeView(allViews.get(position));  

    }  
	
	@Override  
    public int getItemPosition(Object object) {  
        return super.getItemPosition(object);  
    }  
	
	 @Override  
     public Object instantiateItem(ViewGroup container, int position) {  
         container.addView(allViews.get(position));  
         return allViews.get(position);  
     }  

}
