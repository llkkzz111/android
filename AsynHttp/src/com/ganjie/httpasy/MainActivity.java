package com.ganjie.httpasy;

import com.ganjie.httpasy.datahandler.HttpNetWorkDataHandler;
import com.ganjie.httpasy.utils.LogUtil;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	public MainActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

//		AsynHttpClient
//				.getInstance()
//				.downloadImage(
//						"http://image.baidu.com/channel/listdownload?word=download&fr=detail&ie=utf8&countop=0&url"
//								+ "=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fs%253D550%253Bc%253Dwantu%252C8%252C95%2Fsign%3Dae3332e0f503918fd3d13dcf610645aa"
//								+ "%2Fb999a9014c086e06d0815a4b00087bf40ad1cb81.jpg%3Freferer%3Dc752a22fbc096b63d80e6b60359f&image_id=9400489165&col=%E5%A3%81%E7%BA%B8&tag=undefined",
//						"/sdcard/" + System.currentTimeMillis() + ".png",
//						new HttpNetWorkDataHandler() {
//
//							@Override
//							public void success(int statusCode, Object obj) {
//								// TODO Auto-generated method stub
//
//							}
//
//							@Override
//							public void failure(int statusCode, Object obj) {
//								// TODO Auto-generated method stub
//
//							}
//						});
//
//		AsynHttpClient.getInstance().post("http://download.com?index=3", "",
//				new HttpNetWorkDataHandler() {
//
//					@Override
//					public void success(int statusCode, Object obj) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void failure(int statusCode, Object obj) {
//						// TODO Auto-generated method stub
//
//					}
//				});
		
		
		AsynHttpClient.getInstance().get("http://www.study-area.org/menu2.htm", new HttpNetWorkDataHandler() {
			
			@Override
			public void success(int statusCode, Object obj) {
				// TODO Auto-generated method stub
				LogUtil.log_error(getClass(),obj.toString());
			}
			
			@Override
			public void failure(int statusCode, Object obj) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

}
