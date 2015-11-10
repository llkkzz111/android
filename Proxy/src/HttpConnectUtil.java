import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * 
 * @author james
 *
 */
public class HttpConnectUtil {

	
	/**
	 * post 网络请求
	 * 
	 * @param url_path
	 *            url 地址
	 * @param content_data
	 *            请求到服务器的内容
	 * @param handler
	 *            // 数据处理
	 * @return 返回成功 200 返回失败 400
	 */
	public void doGet(String url_path) {


		URL url;
		HttpURLConnection conn;
		StringBuffer buffers;
		try {
			buffers = new StringBuffer();
			url = new URL(url_path);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8088));  
			conn = (HttpURLConnection) url.openConnection(proxy);
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
			conn.connect();
			OutputStream out = conn.getOutputStream();
			out.flush();
			out.close();
			int code = conn.getResponseCode();
			
			if (code == 200) {

				BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				String str;

				while ((str = bufferedreader.readLine()) != null) {

					buffers.append(str);

				}
				
				System.out.println(buffers.toString());
				bufferedreader.close();
				conn.disconnect();
			} else {
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new HttpConnectUtil().doGet("https://www.baidu.com/");
	}
}
