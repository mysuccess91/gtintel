package gtintel.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
//import com.chebao.remote.IOUtils;

public class ServiceClient {
	public static JSONObject  sendPost(String uri,String data) throws IOException{
	  	 try {
			URL url = new URL(uri);
			 URLConnection urlConnection = url.openConnection();
			 urlConnection.setDoOutput(true);
			 urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			 OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
			 
			 // 锟斤拷锟斤拷锟斤拷写锟斤拷锟斤拷锟斤拷锟紹ody
			 out.write(data);
			 //out.wr
			 out.flush();
			 out.close();
			  
			// 锟接凤拷锟斤拷锟斤拷锟斤拷取锟斤拷应  
			 InputStream inputStream = urlConnection.getInputStream();
			 String encoding = urlConnection.getContentEncoding();
			 String body = IOUtils.toString(inputStream,encoding);
			 //System.out.println(body);
			 return (JSONObject) JSONObject.parse(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  	 return null;
		
	}
	
	
	
    public static JSONObject sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
/*            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }*/
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return (JSONObject) JSONObject.parse(result);
    }
    
    public static JSONObject sendGetPath(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "/" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
/*            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }*/
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return (JSONObject) JSONObject.parse(result);
    }
    
    public static JSONObject sendDelete(String url,String param){
    	 String result = "";
    	String urlNameString = url + "?" + param;
    	 URL delUrl = null;
    	try {
    	    delUrl = new URL(urlNameString);
    	} catch (MalformedURLException exception) {
    	    exception.printStackTrace();
    	}
    	HttpURLConnection httpURLConnection = null;
    	try {
    	    httpURLConnection = (HttpURLConnection) delUrl.openConnection();
    	    httpURLConnection.setRequestProperty("Content-Type",
    	                "application/x-www-form-urlencoded");
    	    httpURLConnection.setRequestMethod("DELETE");
    	    BufferedReader in = new BufferedReader(new InputStreamReader(
    	    		httpURLConnection.getInputStream()));
    	    String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
    	    System.out.println(result);
    	    
    	} catch (IOException exception) {
    	    exception.printStackTrace();
    	} finally {         
    	    if (httpURLConnection != null) {
    	        httpURLConnection.disconnect();
    	    }
    	}
		return  (JSONObject) JSONObject.parse(result);
    }
    
    public static void main(String[] args) {
		System.out.println(sendDelete("http://192.168.1.201:9001/gaeaapi/DataDictionaryInstance/Delete", "instanceId=1"));
	}
    
}
