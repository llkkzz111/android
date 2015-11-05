package com.ganjie.httpasy.download;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpClientConnection;

import com.ganjie.httpasy.service.NetWorkService;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

/**
 * 
 * @ClassName: DownLoadFile
 * @Description: TODO 文件下载
 * @author james
 * @date 2015-5-7 下午1:57:44
 * 
 */
public class DownLoadFile implements Runnable {

	private String  downloadUrl; // 下载的url
	private Handler handler; // 数据处理对象
	private Context mContext;// 上下文
	private String filePath;// 文件路径
	
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param downloadUrl
	* @param handler
	* @param mContext
	 */
	public DownLoadFile(String downloadUrl,Handler handler,Context mContext,String filePath) {
		// TODO Auto-generated constructor stub
		this.downloadUrl =  downloadUrl;
		this.handler = handler;
		this.mContext = mContext;
		this.filePath = filePath;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try{
			
			if(downloadUrl==null){ //ToastUtil.getInstance().toastInject(mContext, "未知错误");return;
			}
			if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
			{//ToastUtil.getInstance().toastInject(mContext, "SD卡未挂载!");return;
			}
			URL url = new URL(downloadUrl);// 设置文件下载的url
			HttpURLConnection connection  = (HttpURLConnection)url.openConnection();
			connection.setReadTimeout(3000);
			connection.setConnectTimeout(3000);
			connection.connect();
			if(connection.getResponseCode() == NetWorkService.SUCCESS){// 链接成功
				// 获取下载文件的长度
				int fileLength = connection.getContentLength();
				
				/*****************发送文件长度**********************/
				
				Message message = new Message();
				//message.what = VersionUpdate.FILELLENGTH;
				message.arg1 = fileLength;
				message.obj = this.filePath;
				this.handler.sendMessage(message);
				
				/******************发送文件长度*********************/
				
				File file = new File(this.filePath);
				//创建可以随机访问对象
				RandomAccessFile accessFile = new RandomAccessFile(file, "rwd");
				// 保存文件的大小
//				accessFile.setLength(fileLength);
				//LogUtil.log_error(DownLoadFile.class,fileLength+"文件总长度");
				// 计算出每个线程的下载大小
				int threadSize = fileLength / DownloadConfig.THREADNUMBER;
				
				// 计算出每个线程的开始位置，结束位置
				for (int threadId = 1; threadId <= DownloadConfig.THREADNUMBER; threadId++) {
					
					int startIndex = (threadId - 1) * threadSize;// 起始位置 0 
					
					int endIndex = threadId * threadSize - 1;// 结束位置 
					
					if (threadId == DownloadConfig.THREADNUMBER) {// 最后一个线程
						
						endIndex = fileLength - 1;
						
					}
					
					//LogUtil.log_error(DownLoadFile.class,"当前线程：" + threadId+ " 开始位置：" + startIndex + " 结束位置："+ endIndex + " 线程所要下载的大小：" + threadSize);
					
					new Thread(new DownloadThread(threadId, startIndex, endIndex, fileLength,this.downloadUrl,this.filePath)).start();
					
				}
				
				if(accessFile!=null)accessFile.close();
				if(connection!=null)connection.disconnect();
			}
		}catch(Exception e){
			//ToastUtil.getInstance().toastInject(mContext, "未知错误！");
		}
		
	}
	
	

}
