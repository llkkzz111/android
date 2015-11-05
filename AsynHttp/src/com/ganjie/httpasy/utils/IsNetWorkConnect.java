package com.ganjie.httpasy.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 
 * @ClassName: IsNetWorkConnect
 * @Description: TODO 判断是否网络链接
 * @author james
 * @date 2015-5-24 上午11:34:46
 * 
 */
public class IsNetWorkConnect {

	public IsNetWorkConnect() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 判断是否有网络链接
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

}
