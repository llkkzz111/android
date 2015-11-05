package com.ganjie.httpasy;

import com.ganjie.httpasy.asyn.HttpFileDownloadAsyn;
import com.ganjie.httpasy.asyn.HttpGetAsyn;
import com.ganjie.httpasy.asyn.HttpImageDownloadAsyn;
import com.ganjie.httpasy.asyn.HttpImagesDownloadAsyn;
import com.ganjie.httpasy.asyn.HttpPostAsyn;
import com.ganjie.httpasy.asyn.HttpUploadAsyn;
import com.ganjie.httpasy.datahandler.HttpNetWorkDataHandler;
import com.ganjie.httpasy.executorutil.InitExecutorUtil;

import android.os.Handler;

/**
 * 
 * @ClassName: AsynHttpClient
 * @Description: TODO  提供http 请求的两种方式：
 * 						get： 以 get方式上传数据，并请求数据（url 执行－－》 返回参数）
 * 						post： 以post方式上传数据，并请求数据 （url －－执行－写出数据 － 返回参数）
 * 						upload 上传文件 （url － 上传头数据 －－ 上传字节流 －－ 返回给我数据 ）
 * 						download 下载文件(url －－ 返回字节流)
 * 						downloadBitmap 下载图片返回bitmap （url －－ 得到字节流－－转bitmap）
 * @author james
 * @date 2015-5-24 上午11:35:03
 * 
 */
public class AsynHttpClient {

	private static AsynHttpClient asynHttpClient;

	public AsynHttpClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 对象实例化
	 * 
	 * @return
	 */
	public static AsynHttpClient getInstance() {
		if (asynHttpClient == null) {
			asynHttpClient = new AsynHttpClient();
		}
		return asynHttpClient;
	}

	/**
	 * get 方式网络请求
	 * 
	 * @param url
	 *            请求地址
	 * @param dataHandler
	 *            数据处理对象
	 */
	public void get(String url_path, HttpNetWorkDataHandler dataHandler) {
		Handler handler;
		try {

			handler = dataHandler.handler;// 拿到数据处理对象
			InitExecutorUtil.init().executor.addTask(new HttpGetAsyn(url_path,handler));// 添加任务
		} catch (Exception e) {

		}

	}

	/**
	 * post 方式 网络请求
	 * 
	 * @param url_path
	 *            请求地址
	 * @param content_data
	 *            请求内容
	 * @param dataHandler
	 *            数据处理对象
	 */
	public void post(String url_path, String content_data,
			HttpNetWorkDataHandler dataHandler) {
		Handler handler;
		try {
			handler = dataHandler.handler;// 拿到数据处理对象
			InitExecutorUtil.init().addTask(
					new HttpPostAsyn(handler, content_data, url_path));// 添加任务
		} catch (Exception e) {

		}
	}

	/**
	 * 上传文件
	 * 
	 * @param url_path
	 *            请求地址
	 * @param filepath
	 *            文件地址
	 * @param dataHandler
	 *            数据处理对象
	 */
	public void upload(String url_path, String filepath,
			HttpNetWorkDataHandler dataHandler) {
		Handler handler;
		try {
			handler = dataHandler.handler; // 拿到数据处理对象

			InitExecutorUtil.init().addTask(
					new HttpUploadAsyn(url_path, filepath, handler));// 添加任务
		} catch (Exception e) {

		}
	}

	/**
	 * 文件下载
	 * 
	 * @param url_path
	 *            要下载的文件路径
	 * @param dataHandler
	 *            数据处理对象
	 */
	public void download(String url_path, String filePath,
			HttpNetWorkDataHandler dataHandler) {
		Handler handler;
		try {

			handler = dataHandler.handler; // 拿到处理对象
			InitExecutorUtil.init().addTask(new HttpFileDownloadAsyn(url_path, filePath, handler));// 添加任务
		} catch (Exception e) {

		}

	}

	/**
	 * 图片下载 设置线程优先级
	 * 
	 * @Title: downloadImage
	 * @Description: TODO
	 * @param @param url_path
	 * @param @param filePath
	 * @param @param priority 线程优先级 : 不要在依赖于线程优先级
	 * @param @param dataHandler 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void downloadImagePriority(String url_path, String filePath,
			int priority, int processPriority,
			HttpNetWorkDataHandler dataHandler) {
		Handler handler;
		try {
			handler = dataHandler.handler;
			Thread thread = new Thread(new HttpImagesDownloadAsyn(url_path,filePath, handler, processPriority));
			thread.setPriority(priority);
			InitExecutorUtil.init().addTask(thread);// 添加任务
		} catch (Exception e) {

		}

	}

	/**
	 * 图片下载
	 * 
	 * @Title: downloadImage
	 * @Description: TODO
	 * @param @param url_path
	 * @param @param filePath
	 * @param @param dataHandler 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void downloadImage(String url_path, String filePath,
			HttpNetWorkDataHandler dataHandler) {
		Handler handler;
		try {
			handler = dataHandler.handler;
			InitExecutorUtil.init().addTask(new HttpImagesDownloadAsyn(url_path, filePath, handler,android.os.Process.THREAD_PRIORITY_DEFAULT));
		} catch (Exception e) {

		}

	}

	/**
	 * 图片下载 返回bitmap
	 * 
	 * @param url_path
	 *            下载的文件路径
	 * @param dataHandler
	 *            数据处理对象
	 */
	public void downloadBitMap(String url_path,HttpNetWorkDataHandler dataHandler) {
		Handler handler;
		try {

			handler = dataHandler.handler; // 拿到处理对象
			InitExecutorUtil.init().addTask(new HttpImageDownloadAsyn(url_path, handler));// 添加任务
		} catch (Exception e) {

		}

	}
	

}
