package com.ganjie.httpasy.asyn;

import com.ganjie.httpasy.service.NetWorkService;

import android.os.Handler;

/**
 * 
 * @ClassName: HttpPostAsyn
 * @Description: TODO  post 异步操作 (主要 执行post请求的网络操作)
 * @author james
 * @date 2015-5-24 上午11:32:15
 * 
 */
public class HttpPostAsyn implements Runnable {

	private Handler handler; // 数据处理
	private String url_path; // url 路径
	private String content_data; // 数据内容

	public HttpPostAsyn(Handler handler, String content_data, String url_path) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.url_path = url_path;
		this.content_data = content_data;

	}

	/**
	 * 异步请求
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		new NetWorkService().doPost(this.url_path, this.content_data,this.handler);

	}

}
