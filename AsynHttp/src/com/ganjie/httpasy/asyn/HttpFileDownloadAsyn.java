package com.ganjie.httpasy.asyn;

import android.os.Handler;

import com.ganjie.httpasy.service.NetWorkService;

/**
 * 
 * @ClassName: HttpFileDownloadAsyn
 * @Description: TODO  文件异步下载（执行文件下载:返回是文件地址）
 * @author james
 * @date 2015-5-24 上午11:27:54
 * 
 */
public class HttpFileDownloadAsyn implements Runnable {

	private String url_path;// url访问地址
	private Handler handler;//数据处理
	private String filePath;//需要下载到那个本地路径

	public HttpFileDownloadAsyn(String url_path, String filePath,Handler handler) {
		// TODO Auto-generated constructor stub
		this.url_path = url_path;
		this.handler = handler;
		this.filePath = filePath;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		new NetWorkService().doFileDownload(this.url_path, this.filePath,
				this.handler);

	}

}
