package com.example.webp_example;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import com.google.webp.libwebp;
import com.google.webp.libwebpJNI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.webp.libwebp;

public class MainActivity extends Activity {
	private WebPUtil webPUtil;

	private String filePath ="/sdcard/DCIM/100MEDIA/IMAG1349.png";
	private String webpFile = "/sdcard/testjames.webp";
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		FileInputStream stream;
		try {
//			File file = new File(webpFile);
//			stream = new FileInputStream(file);
//			Bitmap bitmap = BitmapFactory.decodeStream(stream);
			ImageView imageView = (ImageView) this.findViewById(R.id.imageView1);
//			WebPUtil.with(MainActivity.this).imageFileToWebpBitMap(filePath).into(imageView);
//			WebPUtil.with(MainActivity.this).imageFileToWebpBitMap(file).into(imageView);
//			WebPUtil.with(MainActivity.this).imageFileToWebpBitMap(bitmap).into(imageView);
			
//			WebPUtil.with(MainActivity.this).webpFileToWebpBitMap(webpFile).into(imageView);
//			WebPUtil.with(MainActivity.this).webpFileToWebpBitMap(file).into(imageView);
//			WebPUtil.with(MainActivity.this).webpFileToWebpBitMap(bitmap).into(imageView);
			
//			WebPUtil.with(MainActivity.this).imageToWebp(filePath, webpFile);
//			WebPUtil.with(MainActivity.this).imageToWebp(new File(filePath), new File(webpFile));
//			File fromFile = new File(filePath);
//			stream = new FileInputStream(fromFile);
//			Bitmap fromBitmap = BitmapFactory.decodeStream(stream);
//			WebPUtil.with(MainActivity.this).imageToWebp(fromBitmap, new File(webpFile));
			
			
			
			
			File file = new File(webpFile);
			stream = new FileInputStream(file);
			Bitmap bitmap = BitmapFactory.decodeStream(stream);
			WebPUtil.with(MainActivity.this).webpFileToWebpBitMap(bitmap).into(imageView);
			
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	
	
	
	
}
