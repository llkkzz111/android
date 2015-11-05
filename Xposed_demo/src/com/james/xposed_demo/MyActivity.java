package com.james.xposed_demo;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * 
 * @author james	
 * 主Activity
 *
 */
public class MyActivity extends Activity{

		private final static String TAG = MyActivity.class.getName();
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			
			Toast.makeText(getApplicationContext(), "hello xposed", Toast.LENGTH_LONG).show();
//			XposedHelpers.findAndHookMethod("com.james.xposed_demo.MyActivity", "onCreate",
//					new LoadPackageParam(null).classLoader,
//					"updateClock",new XC_MethodHook(){
//				
//				@Override
//				protected void afterHookedMethod(MethodHookParam param)
//						throws Throwable {
//					// TODO Auto-generated method stub
//					super.afterHookedMethod(param);
//				}
//				@Override
//				protected void beforeHookedMethod(MethodHookParam param)
//						throws Throwable {
//					// TODO Auto-generated method stub
//					super.beforeHookedMethod(param);
//				}
//				
//				
//			});
		}


}
