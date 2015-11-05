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
	static {
		System.loadLibrary("webp");
	}

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		// Read a webp
//		byte[] webpEncodedData = loadFileAsByteArray("/sdcard/test.webp");
//		Bitmap bitmap = webpToBitmap(webpEncodedData);
//		ImageView imageView1 = (ImageView) this.findViewById(R.id.imageView1);
//		imageView1.setImageBitmap(bitmap);

		// Write a webp
//		byte[] webpData = bitmapToWebp("/sdcard/James/IMAG0006.jpg");
//		writeFileFromByteArray("/sdcard/tests.webp", webpData);
		
		try {
//			byte[] imageData = getBytes("/sdcard/James/IMAG0006.jpg");
			File file1 = new File("/sdcard/DCIM/100MEDIA/IMAG1349.png");
//			File file1 = new File("/sdcard/sss.png");
			
			
			
			FileInputStream stream1 = new FileInputStream(file1);
			Bitmap bitmap1 = BitmapFactory.decodeStream(stream1);
			int bytes = bitmap1.getByteCount();
			ByteBuffer buffer  = ByteBuffer.allocate(bytes);
			bitmap1.copyPixelsToBuffer(buffer);
			byte[] pixels = buffer.array();
			int stride = bytes / bitmap1.getHeight();
			int quality = 100; //WebPEncodeRGBA  --> png
//			byte[] encoded = libwebp.WebPEncodeRGBA(pixels,  bitmap1.getWidth(), bitmap1.getHeight(),stride,quality);
			//(pixels, bitmap1.getWidth(), bitmap1.getHeight(),stride,quality);
			System.out.println("宽高"+bitmap1.getWidth()+bitmap1.getHeight()+"质量"+stride);
			byte[] encoded = libwebp.WebPEncodeRGBA(pixels, bitmap1.getWidth(),  bitmap1.getHeight(), stride,80);
			//RGBA(pixels,  bitmap1.getWidth(), bitmap1.getHeight(),stride,quality);
			writeFileFromByteArray("/sdcard/test.webp", encoded);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	/**
	 * 获得指定文件的byte数组
	 * @throws Exception 
	 */
	public static byte[] getBytes(String filePath) throws Exception{
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer ;
	}
	
	
	

	
	
	
	private byte[] loadFileAsByteArray(String filePath) {
		File file = new File(filePath);
		byte[] data = new byte[(int) file.length()];
		try {
			FileInputStream inputStream;
			inputStream = new FileInputStream(file);
			inputStream.read(data);
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	private Bitmap webpToBitmap(byte[] encoded) {
		int[] width = new int[] { 0 };
		int[] height = new int[] { 0 };
		byte[] decoded = libwebp.WebPDecodeARGB(encoded, encoded.length, width,
				height);
		int[] pixels = new int[decoded.length / 4];
		ByteBuffer.wrap(decoded).asIntBuffer().get(pixels);
		return Bitmap.createBitmap(pixels, width[0], height[0],Bitmap.Config.ARGB_8888);
	}

	@SuppressLint("NewApi")
	private byte[] bitmapToWebp(String filePath) {
		Bitmap bitmap = BitmapFactory.decodeFile(filePath);
		int bytes = bitmap.getByteCount();
		ByteBuffer buffer = ByteBuffer.allocate(bytes);
		bitmap.copyPixelsToBuffer(buffer);
		byte[] pixels = buffer.array();

		int height = bitmap.getHeight();
		int width = bitmap.getWidth();
		int stride = width;
		int quality = 100;
		byte[] rgb = new byte[3];

		for (int y = 0; y < height * 4; y++) {
			for (int x = 0; x < width; x += 4) {
				for (int i = 0; i < 3; i++) {
					rgb[i] = pixels[x + y * width + i];
				}
				for (int i = 0; i < 3; i++) {
					pixels[x + y * width + 2 - i] = rgb[i];
				}
			}
		}
		byte[] encoded = libwebp.WebPEncodeBGRA(pixels, width, height, stride,quality);
		return encoded;
	}

	private void writeFileFromByteArray(String filePath, byte[] data) {
		File webpFile = new File(filePath);
		BufferedOutputStream bos;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(webpFile));
			bos.write(data);
			bos.flush();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
