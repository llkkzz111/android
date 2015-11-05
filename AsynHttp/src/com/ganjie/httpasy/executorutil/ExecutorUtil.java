package com.ganjie.httpasy.executorutil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @ClassName: ExecutorUtil
 * @Description: TODO  线程池
 * @author james
 * @date 2015-5-24 上午11:33:33
 * 
 */
public class ExecutorUtil extends ThreadPoolExecutor {

	/**
	 * @param corePoolSize
	 *            线程池的最小数量
	 * @param maximumPoolSize
	 *            线程池的最大数量
	 * @param keepAliveTime
	 *            线程池维护线程所允许的空闲时间
	 * @param unit
	 *            表示给定单元粒度的时间段
	 * @param workQueue
	 *            线程池所使用的缓冲队列
	 * @param handler
	 *            失败策略
	 */
	public ExecutorUtil(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				handler);
		// TODO Auto-generated constructor stub
	}

}
