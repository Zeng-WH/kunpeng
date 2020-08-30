import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
//import com.alibaba.fastjson.JSON;
public class Jm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		try {
			//创建url远程连接对象
			//HttpURLConnection connection = null;
			URL url = new URL("http://gfapi.mlogcn.com/weather/v001/now?areacode=101010100&key=ckYyw79TNJViz3myLjbhHUxXRTFpjzlJ");
			//强制类型转换
			connection = (HttpURLConnection) url.openConnection(); 
			//设置连接方式：get
			connection.setRequestMethod("GET");
			//设置连接主机服务器的超时时间：20000毫秒
			connection.setConnectTimeout(20000);
			//设置读取远程数据返回时间：60000毫秒
			connection.setReadTimeout(60000);
			//发送请求
			connection.connect();
			//通过connection连接，获取输入流
			if (connection.getResponseCode()==200) {
				is = connection.getInputStream();
				// 封装输入流is, 并指定字符集
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				//存放数据
				StringBuffer sbf = new StringBuffer();
				String temp =null;
				while((temp = br.readLine())!=null) {
					sbf.append(temp);
					System.out.println(temp);
					System.out.println("****");
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			//关闭资源
			if(null!=br) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			connection.disconnect();//关闭远程连接
			
		}
		System.out.println(result);
		//Object succesResponse = JSON.parse(result);
		//Gson gson = new Gson();
		
		//System.out.println(temp);
		//System.out.println(result.indexOf("text"));
		//System.out.println(result.indexOf("\"",result.indexOf("text")));
		int test1 = result.indexOf(":",result.indexOf("\"",result.indexOf("text")));
		int test2 = result.indexOf(",",test1+1);
		//System.out.println(result.charAt(test1+1));
		//System.out.println(result.charAt(test2-1));
		System.out.println(result.substring(test1+1, test2));
		int temp1 = result.indexOf(":",result.indexOf("\"",result.indexOf("temp")));
		int temp2 = result.indexOf(",",temp1+1);
		System.out.println(result.substring(temp1+1, temp2));
		int wind_class1 = result.indexOf(":",result.indexOf("\"",result.indexOf("wind_class")));
		int wind_class2 = result.indexOf(",",wind_class1+1);
		System.out.println(result.substring(wind_class1+1, wind_class2));
		//System.out.println(result.indexOf("\"",result.indexOf("\"",result.indexOf("text"))+1));
		//Map<String, String> map = new HashMap<String, String>();
		//采用哈希表
		//map.put(, value)
		//String locat = "北京";
		//String path = new TestHelper().getPath() + "test.txt";
		final Map<String, String> mapid = new HashMap<String, String>();
        mapid.put("北京","101010100");
        mapid.put("安庆","101220601");
        mapid.put("深圳","101280601");
        //mapid.get("石家庄");
        System.out.println(mapid.get("石家庄"));
        //String.valueOf(obj)
		
		
		
	}

}
