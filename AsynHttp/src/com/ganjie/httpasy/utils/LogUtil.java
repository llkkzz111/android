package com.ganjie.httpasy.utils;

import android.util.Log;

/**
 * log 工具类 debug  error info verbose add
 * @author james
 *
 */
public  class LogUtil {

	public LogUtil(){
		super();
	}
	
	
	
	/**
	 * debug  _out  info 
	 * @param clazz
	 * @param info
	 */
	public static void log_debug(Class clazz,String info) {
		try{
			Log.d(clazz.getName(), "log_debug -> "+ info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * error _out info
	 * @param clazz
	 * @param info
	 */
	public static void log_error (Class clazz,String info){
		try{
			
			Log.e(clazz.getName(), "log_error -> "+ info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * info _out info
	 * @param clazz
	 * @param info
	 */
	public static void log_info(Class clazz , String info){
		
		try{
			Log.i(clazz.getName(), "log_info  ->"+ info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * verbose _out info
	 * @param clazz
	 * @param info
	 */
	public static void log_verbose(Class clazz, String info){
		try{
			
			Log.v(clazz.getName(), "log_verbose" + info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 *  
	* @Title: httpRequest 
	* @Description: TODO 地址 请求参数  返回码 返回过来参数
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void httpRequestLog(Class clazz,String url ,String requestInfo,int responseCode,String responseInfo){
		Log.d(clazz.toString(), "\n==============网络请求==========\n" +
							     "请求地址 = ［"+url+"］\n" +
							     "请求参数 = ［"+requestInfo+"］\n" +
							     "返回码 = ［"+responseCode+"］\n" +
							     "返回参数 = ［"+responseInfo+"］\n"+
							     "=============网络请求==========\n" );
	}
	
	
}
