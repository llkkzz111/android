package com.example.webp_example;

import java.io.File;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

/**
 * webp 工具类
 * 
 * @author james
 * 
 */
public class WebPUtil {

	private Context mContext;
	private LoadImage image;
	private volatile static WebPUtil webPUtil;

	private static final String TAG = WebPUtil.class.getSimpleName();

	public WebPUtil(Context mContext) {
		if (mContext == null)
			throw new NullPointerException("当前上下文不能为空！！！");
		this.mContext = mContext;
		this.image = new LoadImage();
	}

	/**
	 * 初始化上下文
	 * 
	 * @param mContext
	 * @return
	 */
	public synchronized static WebPUtil with(Context mContext) {
		if (webPUtil != null) {
			return webPUtil;
		}
		webPUtil = new WebPUtil(mContext);
		return webPUtil;
	}

	/********************** 三大格式[png/jpg/jpeg]图片转换webp Bitmap **********************************/

	/**
	 * 普通图片 转 webpBitmap
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
	 */
	public LoadImage imageFileToWebpBitMap(String filePath) {
		if (filePath == null)
			throw new NullPointerException(
					"普通图片转webpBitmap 失败， 需要转换的文件路径不能为null");
		Bitmap bitmap = image.imageFileTowebBitmap(filePath);
		image.setBitmap(bitmap);
		return image;
	}

	/**
	 * 普通图片 转 webpBitmap
	 * 
	 * @param file
	 *            文件对象
	 * @return
	 */
	public LoadImage imageFileToWebpBitMap(File file) {
		if (file == null)
			throw new NullPointerException(
					"普通图片转webpBitmap 失败， 需要转换的文件对象不能为null");
		return imageFileToWebpBitMap(file.getAbsolutePath());
	}

	/**
	 * 普通图片bitmap 转 webpBitmap
	 * 
	 * @param bitmap
	 * @return
	 */
	public LoadImage imageFileToWebpBitMap(Bitmap bitmap) {
		if (bitmap == null)
			throw new NullPointerException(
					"普通图片转webpBitmap 失败， 需要转换的Bitmap对象不能为null");
		byte[] encoded = image.imageFileTowebBitmap(bitmap);
		image.setBitmap(image.webpToBitmap(encoded));
		return image;
	}

	/************************* webp 转 bitmap ******************************************/

	/**
	 * webp文件路径 转 bitmap
	 * 
	 * @param filePath
	 * @return
	 */
	public LoadImage webpFileToWebpBitMap(String filePath) {
		try {
			byte[] encoded = image.getBytes(filePath);
			image.setBitmap(image.webpToBitmap(encoded));
			return image;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.d(TAG, "webp文件路径 转 bitmap 失败 " + e.getMessage());
		}

		return null;
	}

	/**
	 * webp 文件对象 转 webp bitmap
	 * 
	 * @param file
	 * @return
	 */
	public LoadImage webpFileToWebpBitMap(File file) {
		if (file == null)
			throw new NullPointerException(
					"webp 文件对象 转 webp bitmap 失败， 需要转换的File 对象不能为null");
		return webpFileToWebpBitMap(file.getAbsoluteFile());
	}

	/**
	 * webp bitmap 对象 显示 imageview;
	 * 
	 * @param bitmap
	 * @return
	 */
	public LoadImage webpFileToWebpBitMap(Bitmap bitmap) {
		if (bitmap == null)
			throw new NullPointerException(
					"webp 文件对象 转 webp bitmap 失败， 需要转换的Bitmap 对象不能为null");
		image.setBitmap(bitmap);
		return image;
	}

	/************************* 三个格式[png/jpg/jpeg]图片 转换为webp文件 ******************************************/

	/**
	 * 普通图片转webp 图片
	 * 
	 * @param fromFilePath
	 *            需要转的 文件路径
	 * @param toFilePath
	 *            写入 文件路径
	 * @return true:success false:error
	 */
	public boolean imageToWebp(String fromImagePath, String toImagePath) {
		if (fromImagePath == null && toImagePath == null)
			throw new NullPointerException(
					"普通图片转webp 图片， fromImagePath 或 toImagePath不能为null");
		return image.imageFileTowebpFile(fromImagePath, toImagePath);
	}

	/**
	 * 普通图片转webp图片
	 * 
	 * @param fromFile
	 *            需要转的 文件对象
	 * @param toFile
	 *            写入 文件对象
	 * @return true:success false:error
	 */
	public boolean imageToWebp(File fromFile, File toFile) {
		if (fromFile == null && fromFile == null)
			throw new NullPointerException(
					"普通图片转webp 图片， fromFile 或 fromFile不能为null");
		return imageToWebp(fromFile.getAbsolutePath(), toFile.getAbsolutePath());
	}

	/**
	 * 普通图片bitmap 转 webp 文件
	 * 
	 * @param bitmap
	 *            需要转的bitmap对象
	 * @param toFile
	 *            写入文件对象
	 * @return
	 */
	public boolean imageToWebp(Bitmap bitmap, File toFile) {
		if (bitmap == null && toFile == null)
			throw new NullPointerException(
					"普通图片转webp 图片， bitmap 或 toFile不能为null");
		return image.writeFileFromByteArray(toFile.getAbsolutePath(),
				image.imageFileTowebBitmap(bitmap));
	}

	/************************* webp图片 转换 三个格式[png/jpg/jpeg] ******************************************/

	/**
	 * 
	 * @param fromWebpFilePath
	 * @param toImageFilePath
	 * @return
	 */
	public boolean webpToImage(String fromWebpFilePath, String toImageFilePath) {

		return false;
	}

}
