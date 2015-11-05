package com.ganjie.httpasy.download;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * 
 * @ClassName: DownloadThread
 * @Description: TODO 下载的线程
 * @author james
 * @date 2015-5-7 下午1:55:39
 * 
 */
public class DownloadThread implements Runnable {

	private int threadId;// 线程id
	private int startIndex; // 需要下载的起始位置
	private int endIndex; // 需要下载的结束位置
	private int spec;//文件长度
	private String downloadUrl;// 下载的url
	private String filePath;// 文件路径
	
	public DownloadThread(int threadId,int startIndex,int endIndex,int spec,String downloadUrl,String filePath) {
		// TODO Auto-generated constructor stub
		this.threadId = threadId;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.spec = spec;
		this.downloadUrl = downloadUrl;
		this.filePath = filePath;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			InputStream inputStream;// 
			RandomAccessFile access;//
			URL url = new URL(downloadUrl);// 要下载的url
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();// 打开链接
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			connection.setRequestProperty("Range","bytes="+ startIndex + "-" + endIndex);// 设置要下载文件的开始位置和结束位置
			connection.connect();
			int code = connection.getResponseCode();
		//	LogUtil.log_error(getClass(), code+"---");
			if(code == 206){// 判断是否链接成功
				inputStream = connection.getInputStream();
				File file = new File(this.filePath);
				access = new RandomAccessFile(file, "rwd");
				access.seek(startIndex);
				int len = 0;
				byte[] buffer = new byte[256];
				int total = 0;
				while((len = inputStream.read(buffer)) != -1){// 循环读取
					
					access.write(buffer, 0,len);
					total += len;
//					LogUtil.log_error(getClass(), threadId+"下载了"+"---"+total);
				}
				if(inputStream!=null)inputStream.close();
				if(access!=null)access.close();
				if(connection!=null)connection.disconnect();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
