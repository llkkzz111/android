package com.james.xposed_demo;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 *  
 * @author james
 *
 */
public class Demo1_Hook implements IXposedHookLoadPackage{

	private static final String TAG = Demo1_Hook.class.getSimpleName();
	public Demo1_Hook(){

	}
	
	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		// TODO Auto-generated method stub
		 Log.e(TAG,"Loaded app: " + lpparam.packageName);
		
		 if (!lpparam.packageName.equals("com.android.systemui"))
	            return;

	       XposedHelpers.findAndHookMethod("com.android.systemui.statusbar.policy.Clock", lpparam.classLoader, "updateClock", new XC_MethodHook() {
	            @Override
	            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
	                // this will be called before the clock was updated by the original method
	            }
	            @Override
	            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
	                // this will be called after the clock was updated by the original method
	            }
	    });
	}

}
