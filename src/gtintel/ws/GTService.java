package gtintel.ws;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSONObject;
import gtintel.service.DataDicService;
import gtintel.servlet.SysConfig;

@Path("/itf")
public class GTService {
	DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
	//获取集合
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public void getlist(@Context HttpServletRequest  req) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Map<String,String[]> map = req.getParameterMap();
		for (Map.Entry<String,String[]> entry : map.entrySet()) {  
			  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		  
		}
		//List<?> list = service.getList(itfName);
		//System.out.println(JSONObject.toJSONString(list));
		//return JSONObject.toJSONString(list);
	}
}
