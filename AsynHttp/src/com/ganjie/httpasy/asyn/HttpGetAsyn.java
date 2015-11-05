package com.ganjie.httpasy.asyn;

import com.ganjie.httpasy.service.NetWorkService;

import android.os.Handler;

/**
 * 
 * @ClassName: HttpGetAsyn
 * @Description: TODO get 异步操作 (主要 执行get请求的网络操作)
 * @author james
 * @date 2015-5-24 上午11:28:11
 * 
 */
public class HttpGetAsyn implements Runnable {

	private String url_path;//访问路径
	private Handler handler;//数据处理

	public HttpGetAsyn(String url_path, Handler handler) {
		// TODO Auto-generated constructor stub
		this.url_path = url_path;
		this.handler = handler;
	}

	/**
	 * get 异步请求
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		new NetWorkService().doGet(url_path, handler);
	}

}
