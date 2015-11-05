package com.ganjie.httpasy.executorutil;

/**
 * 
 * @ClassName: InitExecutorUtil
 * @Description: TODO 初始化 退出
 * @author james
 * @date 2015-5-24 上午11:15:24
 * 
 */
public class InitExecutorUtil {

	public static TaskSetExecutor executor;

	public InitExecutorUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: init
	 * @Description: TODO
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public static TaskSetExecutor init() {
		if(executor==null){
			
			executor = TaskSetExecutor.getExSetExecutor();
			executor.initExecutor();
		}
		return executor;
		
	}

	/**
	 * 
	 * @Title: exit
	 * @Description: TODO
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public boolean exit() {
		if(executor!=null)executor.shutdownNow();
		return true;
	}
}
