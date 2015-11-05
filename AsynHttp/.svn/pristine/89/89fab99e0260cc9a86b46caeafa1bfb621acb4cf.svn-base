package com.ganjie.httpasy.asyn;

import android.os.Handler;
import android.os.Process;

import com.ganjie.httpasy.service.NetWorkService;

/**
 * 
 * @ClassName: HttpImagesDownloadAsyn
 * @Description: TODO 文件异步下载（执行文件下载:返回是文件地址）
 * @author james
 * @date 2015-5-24 上午11:31:21
 * 
 */
public class HttpImagesDownloadAsyn implements Runnable {

	private String url_path;// 访问路径
	private Handler handler;// 数据处理
	private String filePath;//需要下载到的本地路径
	private int threadPriority;//线程的优先级值

	public HttpImagesDownloadAsyn(String url_path, String filePath,
			Handler handler, int threadPriority) {
		// TODO Auto-generated constructor stub
		this.url_path = url_path;
		this.handler = handler;
		this.filePath = filePath;
		this.threadPriority = threadPriority;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Process.setThreadPriority(this.threadPriority);
		new NetWorkService().doImageDownload(this.url_path, this.filePath,this.handler);

	}

}
