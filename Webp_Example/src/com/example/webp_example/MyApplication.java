package com.example.webp_example;

import android.app.Application;

/**
 * 
 * @author james
 *
 */
public class MyApplication extends Application {

	static {
		System.loadLibrary("webp");
	}
	
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
}
