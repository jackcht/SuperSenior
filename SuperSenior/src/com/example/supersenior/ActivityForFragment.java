package com.example.supersenior;

import com.example.supersenior.health.Health_menu_fragment;
import com.example.supersenior.me.Me_fragment;
import com.example.supersenior.reminder.Reminder_menu_fragment;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

@SuppressLint("NewApi")
public class ActivityForFragment extends FragmentActivity implements android.app.ActionBar.TabListener {

	ActionBar actionBar;
	ViewPager viewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_for_fragment);
		
		viewPager = (ViewPager)findViewById(R.id.pager);
		FragmentManager fm = getSupportFragmentManager();
		viewPager.setAdapter(new MyAdapter(fm));
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("Reminder");
		tab1.setTabListener(this);
		
		ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText("Health");
		tab2.setTabListener(this);
		
		ActionBar.Tab tab3 = actionBar.newTab();
		tab3.setText("Me");
		tab3.setTabListener(this);
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		actionBar.addTab(tab3);	
		
	}


	
	
	
	
	class MyAdapter extends FragmentPagerAdapter{
		
		public MyAdapter(FragmentManager fm){
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			Fragment fragment = null;
			if(arg0==0){
				fragment = new Reminder_menu_fragment();				
			}
			if(arg0==1){
				fragment = new Health_menu_fragment();				
			}
			if(arg0==2){
				fragment = new Me_fragment();				
			}
			
			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}

	}


	@Override
	public void onTabReselected(android.app.ActionBar.Tab arg0,
			android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void onTabSelected(android.app.ActionBar.Tab tab,
			android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}






	@Override
	public void onTabUnselected(android.app.ActionBar.Tab arg0,
			android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}
