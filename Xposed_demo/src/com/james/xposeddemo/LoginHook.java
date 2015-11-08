package com.james.xposeddemo;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * 
 * @author james
 * 
 */
public class LoginHook implements IXposedHookLoadPackage {

	private static final String TAG = LoginHook.class.getSimpleName();

	public LoginHook() {

	}

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		// TODO Auto-generated method stub
		Log.e(TAG, "Loaded app: " + lpparam.packageName);

		// 判断是否是要Hook的包名(被Hook函数所在的包为com.droider.crackme0201)
		if (lpparam.packageName.equals("com.example.xposedlogin")) {
			XposedBridge.log("Loaded App:" + lpparam.packageName);

			// 查找要Hook的函数
			XposedHelpers.findAndHookMethod(
					"com.example.xposedlogin.LoginActivity", // 被Hook函数所在的类com.droider.crackme0201.MainActivity
					lpparam.classLoader, "login", // 被Hook函数的名称checkSN
					String.class, // 被Hook函数的第一个参数String
					String.class, // 被Hook函数的第二个参数String
					new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							// Hook函数之前执行的代码

							param.args[0]="zxp";
							param.args[1]="654321";
							// 传入参数1
							XposedBridge.log("beforeHookedMethod userName:"+ param.args[0]);
							// 传入参数2
							XposedBridge.log("beforeHookedMethod sn:"+ param.args[1]);
							// 函数返回值
							XposedBridge.log("beforeHookedMethod result:"+ param.getResult());
							
							
						}
						

						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							// Hook函数之后执行的代码

							// 通过对函数的分析发现，只要修改函数的返回值即可实现注册的破解
							param.setResult(true);

							// 传入参数1
							XposedBridge.log("afterHookedMethod userName:"+ param.args[0]);
							// 传入参数2
							XposedBridge.log("afterHookedMethod sn:"+ param.args[1]);
							// 函数返回值
							XposedBridge.log("afterHookedMethod result:"+ param.getResult());
						}
					});
		}
	}

}
