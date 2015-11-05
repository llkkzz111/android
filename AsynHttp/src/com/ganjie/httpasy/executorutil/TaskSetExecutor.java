package com.ganjie.httpasy.executorutil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.ganjie.httpasy.utils.LogUtil;

/**
 * 
 * @ClassName: TaskSetExecutor
 * @Description: TODO  任务线程 －－》 线程管理 －－》 添加任务到线程池中
 * @author james
 * @date 2015-5-24 上午11:33:54
 * 
 */
public class TaskSetExecutor {

	public static int corePoolSize = 0;// 线程池的最小数量
	public static int maximumPoolSize = 5;// 线程池的最大数量
	public static int keepAliveTime = 3000;// 线程池维护线程所允许的空闲时间
	// 线程之间的进行移交的机制
	public static BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(
			20);// 线程池所使用的缓冲队列
	public static List<Runnable> runnables = new ArrayList<Runnable>();
	// public ExecutorUtil exceptionUtils;
	public static ExecutorService service;
	public static TaskSetExecutor executor;

	public TaskSetExecutor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 实例化
	 * 
	 * @return
	 */
	public synchronized static TaskSetExecutor getExSetExecutor() {
		if (executor == null) {

			executor = new TaskSetExecutor();
		}
		return executor;
	}

	/**
	 * 初始化线程池
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean initExecutor() {

		try {
			service = Executors.newCachedThreadPool();
			if (service != null)
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 添加线程池
	 * 
	 * @param command
	 */
	public void addTask(Runnable command) {
		try {
			service.execute(command);
			LogUtil.log_debug(getClass(), command.toString() + "add task success");

		} catch (Exception e) {
			LogUtil.log_error(getClass(), "add task failure");
		}
	}

	/**
	 * 关闭线程池 不接受新的任务，同时等待已经提交任务执行完成－包括哪些还未开始执行的任务
	 */
	public void shutdown() {
		try {
			if (!service.isShutdown()) {
				service.awaitTermination(30, TimeUnit.SECONDS);// 等待超时
				service.shutdown();

			}
		} catch (Exception e) {
			LogUtil.log_error(getClass(), "executor close failure");
		}
	}

	/**
	 * 强制关闭线程池 它将尝试取消所有运行中的任务，并且不再启动队列中尚未开始执行的任务。
	 */
	public void shutdownNow() {
		try {
			if (!service.isShutdown())
				service.shutdownNow();
		} catch (Exception e) {
			LogUtil.log_error(getClass(), "executor close failure");
		}
	}

	/**
	 * 
	 * @Title: closeErrorTask
	 * @Description: TODO
	 * @param @param runnable 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void closeErrorTask(Runnable runnable, ThreadPoolExecutor executor) {
		try {

			runnables.add(runnable);

			for (int i = 0; i < runnables.size(); i++) {
				if (runnables.size() >= 2) {
					if (runnables.get(i).toString()
							.equals(runnables.get(i + 1))) {

					}
				} else {
					executor.execute(runnable);// 如果执行失败，则继续执行此任务
				}
			}
			// }

		} catch (Exception e) {

		}
	}
}
