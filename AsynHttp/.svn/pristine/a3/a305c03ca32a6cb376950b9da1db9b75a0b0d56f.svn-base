package com.ganjie.httpasy.asyn;

import android.os.Handler;

import com.ganjie.httpasy.service.NetWorkService;

/**
 * 
 * @ClassName: HttpImageDownloadAsyn
 * @Description: TODO  图片异步下载（执行图片异步加载 返回bitmap）
 * @author james
 * @date 2015-5-24 上午11:30:54
 * 
 */
public class HttpImageDownloadAsyn implements Runnable {

	private String imgurl; // 图片路径
	private Handler handler; // 数据处理

	public HttpImageDownloadAsyn(String imgurl, Handler handler) {
		// TODO Auto-generated constructor stub
		this.imgurl = imgurl;
		this.handler = handler;
	}

	/**
	 * 执行图片下载
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		new NetWorkService().doReadBitmap(imgurl, handler);

	}

}
