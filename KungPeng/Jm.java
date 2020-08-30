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
		// TODO �Զ����ɵķ������
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		try {
			//����urlԶ�����Ӷ���
			//HttpURLConnection connection = null;
			URL url = new URL("http://gfapi.mlogcn.com/weather/v001/now?areacode=101010100&key=ckYyw79TNJViz3myLjbhHUxXRTFpjzlJ");
			//ǿ������ת��
			connection = (HttpURLConnection) url.openConnection(); 
			//�������ӷ�ʽ��get
			connection.setRequestMethod("GET");
			//�������������������ĳ�ʱʱ�䣺20000����
			connection.setConnectTimeout(20000);
			//���ö�ȡԶ�����ݷ���ʱ�䣺60000����
			connection.setReadTimeout(60000);
			//��������
			connection.connect();
			//ͨ��connection���ӣ���ȡ������
			if (connection.getResponseCode()==200) {
				is = connection.getInputStream();
				// ��װ������is, ��ָ���ַ���
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				//�������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			//�ر���Դ
			if(null!=br) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			connection.disconnect();//�ر�Զ������
			
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
		//���ù�ϣ��
		//map.put(, value)
		//String locat = "����";
		//String path = new TestHelper().getPath() + "test.txt";
		final Map<String, String> mapid = new HashMap<String, String>();
        mapid.put("����","101010100");
        mapid.put("����","101220601");
        mapid.put("����","101280601");
        //mapid.get("ʯ��ׯ");
        System.out.println(mapid.get("ʯ��ׯ"));
        //String.valueOf(obj)
		
		
		
	}

}
