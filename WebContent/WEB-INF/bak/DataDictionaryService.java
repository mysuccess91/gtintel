package gtintel.ws;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import gtintel.dictionary.entity.AddDataDictionaryReq;
import gtintel.dictionary.entity.DelDataDictionary;
import gtintel.dictionary.entity.GetByNameReq;
import gtintel.dictionary.entity.GetDataDic;
import gtintel.dictionary.entity.GetDictionaries;
import gtintel.dictionary.entity.GetDictionary;
import gtintel.dictionary.entity.GetIdsReq;
import gtintel.dictionary.entity.GetPageIds;
import gtintel.dictionary.entity.ModifyDataDictionaryReq;
import gtintel.dictionary.entity.MoveDataDicReq;
import gtintel.dictionary.entity.SearchDicReq;
import gtintel.service.DataDicService;
import gtintel.servlet.SysConfig;
import gtintel.util.ServiceClient;

@Path("/dataDic")
public class DataDictionaryService {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("schema.xml");
	
	/**AddDictionary接口*/
	
	//发送接口
	@GET
	@Path("/postAddDicReq")
	@Produces(MediaType.APPLICATION_JSON)
	public String PostAddDicReq(@QueryParam("url")String url) throws IOException{

		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<AddDataDictionaryReq> list = service.getAddDataDictionaryReqList();
		for(AddDataDictionaryReq req : list){			
			JSONObject data=JSON.parseObject(JSON.toJSONString(req));
			data.remove("caseId");
			String result = JSONObject.toJSONString(ServiceClient.sendPost(url, data.toJSONString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			Integer caseId = req.getCaseId();	
			service.updateAddDataDic(caseId,postData);
		}	
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	
	//获取集合
	@GET
	@Path("/getAddDicCaseList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAddDicCaseList(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<AddDataDictionaryReq> list = service.getAddDataDictionaryReqList();
		return JSONObject.toJSONString(list);
	}
	
	//添加
	@POST
	@Path("/saveAddDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String saveAddDic(
			@FormParam("LftId") Integer LftId,
			@FormParam("RgtId") Integer RgtId,
			@FormParam("SortNum") Integer SortNum,
			@FormParam("Depth") Integer Depth,
			@FormParam("FkDictionaryId") String FkDictionaryId,
			@FormParam("ParentId") String ParentId,
			@FormParam("HasChild") String HasChild,
			@FormParam("Description") String Description,
			@FormParam("DisplayName") String DisplayName,
			@FormParam("Code") String Code,
			@FormParam("Value") String Value,
			@FormParam("AddTime") String AddTime,
			@FormParam("ModifyUser") String ModifyUser,
			@FormParam("FirstSpell") String FirstSpell,
			@FormParam("FullSpell") String FullSpell,
			@FormParam("Id") String Id,
			@FormParam("AddUser") String AddUser,
			@FormParam("AppId") String AppId,
			@FormParam("ModifyTime") String ModifyTime,
			@FormParam("DataState") String DataState){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		
		service.addAddDic(new AddDataDictionaryReq(LftId, RgtId, SortNum, Depth, FkDictionaryId, ParentId, HasChild, Description, DisplayName, Code, Value, AddTime, ModifyUser, FirstSpell, FullSpell, Id, AddUser, AppId, ModifyTime, DataState));
		//service.addAddDic(LftId,RgtId,SortNum,Depth,FkDictionaryId,ParentId,HasChild, Description,DisplayName,Code,Value,AddTime,ModifyUser, FirstSpell,FullSpell, Id, AddUser, AppId, ModifyTime, DataState);
		return "{\"code\":0, \"message\":\"save successfully\"}";
	}
	
	//修改数据
	@POST
	@Path("/updateAddDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String  updateAddDic(
			@FormParam("CaseId") Integer CaseId,
			@FormParam("LftId") Integer LftId,
			@FormParam("RgtId") Integer RgtId,
			@FormParam("SortNum") Integer SortNum,
			@FormParam("Depth") Integer Depth,
			@FormParam("FkDictionaryId") String FkDictionaryId,
			@FormParam("ParentId") String ParentId,
			@FormParam("HasChild") String HasChild,
			@FormParam("Description") String Description,
			@FormParam("DisplayName") String DisplayName,
			@FormParam("Code") String Code,
			@FormParam("Value") String Value,
			@FormParam("AddTime") String AddTime,
			@FormParam("ModifyUser") String ModifyUser,
			@FormParam("FirstSpell") String FirstSpell,
			@FormParam("FullSpell") String FullSpell,
			@FormParam("Id") String Id,
			@FormParam("AddUser") String AddUser,
			@FormParam("AppId") String AppId,
			@FormParam("ModifyTime") String ModifyTime,
			@FormParam("DataState") String DataState
			) throws UnsupportedEncodingException{
		
		
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		//service.editAddDic(LftId, RgtId, SortNum, Depth, FkDictionaryId, ParentId, HasChild, Description, DisplayName, Code, Value, AddTime, ModifyUser, FirstSpell, FullSpell, Id, AddUser, AppId, ModifyTime, DataState);
		AddDataDictionaryReq addDicReq = new AddDataDictionaryReq();
		addDicReq.setCaseId(CaseId);
		addDicReq.setLftId(LftId);
		addDicReq.setRgtId(RgtId);
		addDicReq.setSortNum(SortNum);
		addDicReq.setDepth(Depth);
		addDicReq.setFkDictionaryId(FkDictionaryId);
		addDicReq.setParentId(ParentId);
		addDicReq.setHasChild(HasChild);
		addDicReq.setDescription(Description);
		addDicReq.setDisplayName(DisplayName);
		addDicReq.setCode(Code);
		addDicReq.setValue(Value);
		addDicReq.setAddTime(AddTime);
		addDicReq.setModifyUser(ModifyUser);
		addDicReq.setFirstSpell(FirstSpell);
		addDicReq.setFullSpell(FullSpell);
		addDicReq.setId(Id);
		addDicReq.setAddUser(AddUser);
		addDicReq.setAppId(AppId);
		addDicReq.setModifyTime(ModifyTime);
		addDicReq.setDataState(DataState);
		service.editAddDic(addDicReq);
		return "{\"code\":0, \"message\":\"update successfully\"}";
	}
	
	/*MoveDic接口*/
	
	//调用测试接口
	@GET
	@Path("/getMoveDicReq")
	@Produces(MediaType.APPLICATION_JSON)
	public String  getMoveDicReq(@QueryParam("url")String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<MoveDataDicReq> list = service.getMoveDataDicList();
		for(MoveDataDicReq req : list){
			String result = JSONObject.toJSONString(ServiceClient.sendGet(url, req.toString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateMoveDataDic(req.getSrcId(),req.getTargetId(),postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	
	//获取MoveDicList
	@GET
	@Path("/getMoveDicList")
	@Produces(MediaType.APPLICATION_JSON)
	public String  getMoveDicList() throws UnsupportedEncodingException{
		
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<MoveDataDicReq> list = service.getMoveDataDicList();
		return JSON.toJSONString(list);
	}
	
	//插入数据
	@POST
	@Path("/addMoveDic")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//@Consumes("application/x-www-form-urlencoded")
	public String  AddMoveDic(@FormParam("id") Integer  id,
			@FormParam("srcId") String srcId,@FormParam("targetId") String targetId) throws UnsupportedEncodingException{
		System.out.println(id);
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		service.addMoveDic(id,srcId,targetId);
		return "{\"code\":0, \"message\":\"add successfully\"}";
	}
	
	
	//修改数据
	@POST
	@Path("/updateMoveDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String  updateMoveDic(@FormParam("id") Integer id,
			@FormParam("srcId") String srcId,@FormParam("targetId") String targetId,@FormParam("caseId") Integer caseId) throws UnsupportedEncodingException{
		
		
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		service.editMoveDic(id,srcId,targetId,caseId);
		//service.updateMoveDataDic(id,srcId, targetId,"");
		return "{\"code\":0, \"message\":\"update successfully\"}";
	}
	
	
	/**Modify接口*/
	//调用测试接口
	@GET
	@Path("/postModifyDicReq")
	@Produces(MediaType.APPLICATION_JSON)
	public String  getModifyDicReq(@QueryParam("url")String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<ModifyDataDictionaryReq> list = service.getModifyDataDicList();
		for(ModifyDataDictionaryReq req : list){
			JSONObject data=JSON.parseObject(JSON.toJSONString(req));
			data.remove("caseId");
			String result = JSONObject.toJSONString(ServiceClient.sendGet(url, data.toJSONString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateModifyDic(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	
	//获取ModifyDicList
	@GET
	@Path("/getModifyDicList")
	@Produces(MediaType.APPLICATION_JSON)
	public String  getModifyDicList() throws UnsupportedEncodingException{
		
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<ModifyDataDictionaryReq> list = service.getModifyDataDicList();
		return JSON.toJSONString(list);
	}
	
	
	//添加
	@POST
	@Path("/addModifyDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String addModifyDic(
			@FormParam("LftId") Integer LftId,
			@FormParam("RgtId") Integer RgtId,
			@FormParam("SortNum") Integer SortNum,
			@FormParam("Depth") Integer Depth,
			@FormParam("FkDictionaryId") String FkDictionaryId,
			@FormParam("ParentId") String ParentId,
			@FormParam("HasChild") String HasChild,
			@FormParam("Description") String Description,
			@FormParam("DisplayName") String DisplayName,
			@FormParam("Code") String Code,
			@FormParam("Value") String Value,
			@FormParam("AddTime") String AddTime,
			@FormParam("ModifyUser") String ModifyUser,
			@FormParam("FirstSpell") String FirstSpell,
			@FormParam("FullSpell") String FullSpell,
			@FormParam("Id") String Id,
			@FormParam("AddUser") String AddUser,
			@FormParam("AppId") String AppId,
			@FormParam("ModifyTime") String ModifyTime,
			@FormParam("DataState") String DataState){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		ModifyDataDictionaryReq req = new ModifyDataDictionaryReq();
		//req.setCaseId(CaseId);
		req.setLftId(LftId);
		req.setRgtId(RgtId);
		req.setSortNum(SortNum);
		req.setDepth(Depth);
		req.setFkDictionaryId(FkDictionaryId);
		req.setParentId(ParentId);
		req.setHasChild(HasChild);
		req.setDescription(Description);
		req.setDisplayName(DisplayName);
		req.setCode(Code);
		req.setValue(Value);
		req.setAddTime(AddTime);
		req.setModifyUser(ModifyUser);
		req.setFirstSpell(FirstSpell);
		req.setFullSpell(FullSpell);
		req.setId(Id);
		req.setAddUser(AddUser);
		req.setAppId(AppId);
		req.setModifyTime(ModifyTime);
		req.setDataState(DataState);
		service.addModifyDic(req);
		return "{\"code\":0, \"message\":\"save successfully\"}";
	}
	
	//修改数据
	@POST
	@Path("/updateModifyDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String  updateModifyDic(
			@FormParam("CaseId") Integer CaseId,
			@FormParam("LftId") Integer LftId,
			@FormParam("RgtId") Integer RgtId,
			@FormParam("SortNum") Integer SortNum,
			@FormParam("Depth") Integer Depth,
			@FormParam("FkDictionaryId") String FkDictionaryId,
			@FormParam("ParentId") String ParentId,
			@FormParam("HasChild") String HasChild,
			@FormParam("Description") String Description,
			@FormParam("DisplayName") String DisplayName,
			@FormParam("Code") String Code,
			@FormParam("Value") String Value,
			@FormParam("AddTime") String AddTime,
			@FormParam("ModifyUser") String ModifyUser,
			@FormParam("FirstSpell") String FirstSpell,
			@FormParam("FullSpell") String FullSpell,
			@FormParam("Id") String Id,
			@FormParam("AddUser") String AddUser,
			@FormParam("AppId") String AppId,
			@FormParam("ModifyTime") String ModifyTime,
			@FormParam("DataState") String DataState
			) throws UnsupportedEncodingException{
		
		
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		//service.editAddDic(LftId, RgtId, SortNum, Depth, FkDictionaryId, ParentId, HasChild, Description, DisplayName, Code, Value, AddTime, ModifyUser, FirstSpell, FullSpell, Id, AddUser, AppId, ModifyTime, DataState);
		ModifyDataDictionaryReq req = new ModifyDataDictionaryReq();
		req.setCaseId(CaseId);
		req.setLftId(LftId);
		req.setRgtId(RgtId);
		req.setSortNum(SortNum);
		req.setDepth(Depth);
		req.setFkDictionaryId(FkDictionaryId);
		req.setParentId(ParentId);
		req.setHasChild(HasChild);
		req.setDescription(Description);
		req.setDisplayName(DisplayName);
		req.setCode(Code);
		req.setValue(Value);
		req.setAddTime(AddTime);
		req.setModifyUser(ModifyUser);
		req.setFirstSpell(FirstSpell);
		req.setFullSpell(FullSpell);
		req.setId(Id);
		req.setAddUser(AddUser);
		req.setAppId(AppId);
		req.setModifyTime(ModifyTime);
		req.setDataState(DataState);
		service.editModifyDic(req);
		return "{\"code\":0, \"message\":\"update successfully\"}";
	}
	
	/**DelDictionary接口*/
	@GET
	@Path("/getDelDicReq")
	@Produces(MediaType.APPLICATION_JSON)
	public String  getDelDicReq(@QueryParam("url")String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<DelDataDictionary> list = service.getDelDataDicList();
		for(DelDataDictionary req : list){
			String result = JSONObject.toJSONString(ServiceClient.sendDelete(url, req.toString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateDelDic(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	
	@GET
	@Path("/getDelDicReqList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDelDataDicList(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<DelDataDictionary> list = service.getDelDataDicList();
		return JSON.toJSONString(list);
	}
	@POST
	@Path("/addDelDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String addDelDic(@FormParam("instanceId") String instanceId){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		DelDataDictionary req = new DelDataDictionary();
		req.setInstanceId(instanceId);
		service.addDelDic(req);
		return "{\"code\":0, \"message\":\"save successfully\"}";
	}
	@POST
	@Path("/editDelDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String editDelDic(@FormParam("CaseId") Integer caseId,@FormParam("InstanceId") String instanceId){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		DelDataDictionary req = new DelDataDictionary();
		req.setCaseId(caseId);
		req.setInstanceId(instanceId);
		service.editDelDic(req);
		return "{\"code\":0, \"message\":\"edit successfully\"}";
	}
	
	/**GetDataDic接口*/
	@GET
	@Path("/getGetDicReq")
	@Produces(MediaType.APPLICATION_JSON)
	public String  getGetDicReq(@QueryParam("url")String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetDataDic> list = service.getGetDataDicList();
		for(GetDataDic req : list){
			String result = JSONObject.toJSONString(ServiceClient.sendGetPath(url, req.getId()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateGetDic(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}

	@GET
	@Path("/getGetDicReqList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGetDataDicList(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetDataDic> list = service.getGetDataDicList();
		return JSON.toJSONString(list);
	}
	
	@POST
	@Path("/addGetDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String addGetDic(@FormParam("Id") String Id){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetDataDic req = new GetDataDic();
		req.setId(Id);
		service.addGetDic(req);
		return "{\"code\":0, \"message\":\"save successfully\"}";
	}
	
	@POST
	@Path("/editGetDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String editGetDic(@FormParam("CaseId") Integer caseId,@FormParam("Id") String Id){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetDataDic req = new GetDataDic();
		req.setCaseId(caseId);
		req.setId(Id);
		service.editGetDic(req);
		return "{\"code\":0, \"message\":\"edit successfully\"}";
	}
	
	
	/**GetByName接口*/
	@GET
	@Path("/getGetByName")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGetByName(@QueryParam("url") String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetByNameReq> list = service.getGetByNameList();
		for(GetByNameReq req : list){
			String result = JSONObject.toJSONString(ServiceClient.sendGet(url, req.toString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateGetByName(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	
	@GET
	@Path("/getByNameList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getByNameList(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetByNameReq> list = service.getGetByNameList();
		return JSON.toJSONString(list);
	}
	
	@POST
	@Path("/addGetByName")
	@Produces(MediaType.APPLICATION_JSON)
	public String addGetByName(@FormParam("name") String name,@FormParam("parentId") String parentId) throws UnsupportedEncodingException{
		byte[] bytes=name.getBytes("ISO-8859-1");	 
		String realname=new String(bytes,"utf-8");
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetByNameReq req = new GetByNameReq();
		req.setName(name);
		req.setParentId(parentId);
		service.addGetByName(req);
		return"{\"code\":0, \"message\":\"save successfully\"}";
	}
	
	@POST
	@Path("/editGetByName")
	@Produces(MediaType.APPLICATION_JSON)
	public String editGetByName(@FormParam("CaseId") Integer caseId,@FormParam("name") String name,@FormParam("parentId") String parentId) throws UnsupportedEncodingException{
		byte[] bytes=name.getBytes("ISO-8859-1");	 
		String realname=new String(bytes,"utf-8");
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetByNameReq req = new GetByNameReq();
		req.setCaseId(caseId);
		req.setName(name);
		req.setParentId(parentId);
		service.editGetByName(req);
		return "{\"code\":0, \"message\":\"edit successfully\"}";
	}
	
	/**GetIds接口 */
	//发送
	@GET
	@Path("/getGetIds")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGetIdsReq(@QueryParam("url") String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetIdsReq> list = service.getGetIdsList();
		for(GetIdsReq req : list){
			String result =  JSONObject.toJSONString(ServiceClient.sendGet(url, req.toString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateGetIds(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	//获取List
	@GET
	@Path("/getIdsList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getIdsList(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetIdsReq> list = service.getGetIdsList();
		return JSON.toJSONString(list);
	}
	//添加
	@POST
	@Path("/addGetIds")
	@Produces(MediaType.APPLICATION_JSON)
	public String addGetIds(
			@FormParam("parentId") String parentId,
			@FormParam("beDeep") boolean beDeep,
			@FormParam("search") String search){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetIdsReq req = new GetIdsReq();
		req.setParentId(parentId);
		req.setBeDeep(beDeep);
		req.setSearch(search);
		service.addGetIds(req);
		return"{\"code\":0, \"message\":\"save successfully\"}";
	}
	//修改
	@POST
	@Path("/editGetIds")
	@Produces(MediaType.APPLICATION_JSON)
	public String editGetIds(
			@FormParam("parentId") String parentId,
			@FormParam("beDeep") boolean beDeep,
			@FormParam("search") String search,
			@FormParam("caseId") Integer caseId){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetIdsReq req = new GetIdsReq();
		req.setParentId(parentId);
		req.setBeDeep(beDeep);
		req.setSearch(search);
		req.setCaseId(caseId);
		service.editGetIds(req);
		return "{\"code\":0, \"message\":\"edit successfully\"}";
	}
	
	
	/**searchDic接口 
	 * @throws UnsupportedEncodingException */
	//发送
	@GET
	@Path("/sendSearchDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String sendSearchDic(@QueryParam("url") String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<SearchDicReq> list = service.getSearchDicList();
		for(SearchDicReq req : list){
			String result =  JSONObject.toJSONString(ServiceClient.sendGet(url, req.toString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateSearchDic(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	
	@GET
	@Path("/searchDicList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSearchDicList(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<SearchDicReq> list = service.getSearchDicList();
		return JSON.toJSONString(list);	
	}
	
	@POST
	@Path("/addSearchDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String addSearchDic(
			@FormParam("name") String name,
			@FormParam("index") Integer index,
			@FormParam("size") Integer size){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		SearchDicReq req = new SearchDicReq();
		req.setIndex(index);
		req.setName(name);
		req.setSize(size);
		service.addSearchDic(req);
		return "{\"code\":0, \"message\":\"add successfully\"}";
	}
	
	@POST
	@Path("/editSearchDic")
	@Produces(MediaType.APPLICATION_JSON)
	public String editSearchDic(
			@FormParam("name") String name,
			@FormParam("index") Integer index,
			@FormParam("size") Integer size,
			@FormParam("caseId") Integer caseId){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		SearchDicReq req = new SearchDicReq();
		req.setIndex(index);
		req.setName(name);
		req.setSize(size);
		req.setCaseId(caseId);
		service.editSearchDic(req);
		return "{\"code\":0, \"message\":\"edit successfully\"}";
	}
	
	/**getDictionary接口*/
	@GET
	@Path("/getGetDictionaryReq")
	@Produces(MediaType.APPLICATION_JSON)
	public String  getGetDictionary(@QueryParam("url")String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetDictionary> list = service.getDictionaryList();
		for(GetDictionary req : list){
			String result = JSONObject.toJSONString(ServiceClient.sendGetPath(url, req.getId()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateGetDictionary(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}

	@GET
	@Path("/getGetDictionaryList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGetDictionary(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetDictionary> list = service.getDictionaryList();
		return JSON.toJSONString(list);
	}
	
	@POST
	@Path("/addGetDictionary")
	@Produces(MediaType.APPLICATION_JSON)
	public String addGetDictionary(@FormParam("Id") String Id){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetDictionary req = new GetDictionary();
		req.setId(Id);
		service.addGetDictionary(req);
		return "{\"code\":0, \"message\":\"save successfully\"}";
	}
	
	@POST
	@Path("/editGetDictionary")
	@Produces(MediaType.APPLICATION_JSON)
	public String editGetDictionary(@FormParam("CaseId") Integer caseId,@FormParam("Id") String Id){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetDictionary req = new GetDictionary();
		req.setCaseId(caseId);
		req.setId(Id);
		service.editGetDictionary(req);
		return "{\"code\":0, \"message\":\"edit successfully\"}";
	}
	
	
	/**GetDictionaries接口 */
	//发送
	@GET
	@Path("/sendGetDictionaries")
	@Produces(MediaType.APPLICATION_JSON)
	public String sendGetDictionaries(@QueryParam("url") String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetDictionaries> list = service.getDictionariesList();
		for(GetDictionaries req : list){
			String result =  JSONObject.toJSONString(ServiceClient.sendGet(url, req.toString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateGetDictionaries(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	//获取List
	@GET
	@Path("/getDictionaries")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDictionariesList(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetDictionaries> list = service.getDictionariesList();
		return JSON.toJSONString(list);
	}
	//添加
	@POST
	@Path("/addGetDictionaries")
	@Produces(MediaType.APPLICATION_JSON)
	public String addGetDictionaries(
			@FormParam("parentId") String parentId,
			@FormParam("beDeep") boolean beDeep,
			@FormParam("search") String search){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetDictionaries req = new GetDictionaries();
		req.setParentId(parentId);
		req.setBeDeep(beDeep);
		req.setSearch(search);
		service.addGetDictionaries(req);
		return"{\"code\":0, \"message\":\"save successfully\"}";
	}
	//修改
	@POST
	@Path("/editGetDictinaries")
	@Produces(MediaType.APPLICATION_JSON)
	public String editGetDictionaries(
			@FormParam("parentId") String parentId,
			@FormParam("beDeep") boolean beDeep,
			@FormParam("search") String search,
			@FormParam("caseId") Integer caseId){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetDictionaries req = new GetDictionaries();
		req.setParentId(parentId);
		req.setBeDeep(beDeep);
		req.setSearch(search);
		req.setCaseId(caseId);
		service.editGetDictionaries(req);
		return "{\"code\":0, \"message\":\"edit successfully\"}";
	}
	
	
	/**GetPageIds接口 */
	//发送
	@GET
	@Path("/sendGetPageIds")
	@Produces(MediaType.APPLICATION_JSON)
	public String sendGetPageIds(@QueryParam("url") String url) throws UnsupportedEncodingException{
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetPageIds> list = service.getPageIdsList();
		for(GetPageIds req : list){
			String result =  JSONObject.toJSONString(ServiceClient.sendGet(url, req.toString()));
			String postData = new String(result.getBytes("gbk"),"utf-8");
			service.updateGetPageIds(req.getCaseId(), postData);
		}
		return "{\"code\":0, \"message\":\"submit successfully\"}";
	}
	//获取List
	@GET
	@Path("/GetPageIdsList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPageIdsList(){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		List<GetPageIds> list = service.getPageIdsList();
		return JSON.toJSONString(list);
	}
	//添加
	@POST
	@Path("/addGetPageIds")
	@Produces(MediaType.APPLICATION_JSON)
	public String addGetpageIds(
			@FormParam("parentId") String parentId,
			@FormParam("index") Integer index,
			@FormParam("size") Integer size,
			@FormParam("search") String search){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetPageIds req = new GetPageIds();
		req.setParentId(parentId);
		req.setIndex(index);
		req.setSize(size);
		req.setSearch(search);
		service.addGetPageIds(req);
		return"{\"code\":0, \"message\":\"save successfully\"}";
	}
	//修改
	@POST
	@Path("/editGetPageIds")
	@Produces(MediaType.APPLICATION_JSON)
	public String editGetPageIds(
			@FormParam("parentId") String parentId,
			@FormParam("index") Integer index,
			@FormParam("size") Integer size,
			@FormParam("search") String search,
			@FormParam("caseId") Integer caseId){
		DataDicService service = (DataDicService) SysConfig.ac.getBean("dataDicService");
		GetPageIds req = new GetPageIds();
		req.setParentId(parentId);
		req.setIndex(index);
		req.setSize(size);
		req.setSearch(search);
		req.setCaseId(caseId);
		service.editGetPageIDs(req);
		return "{\"code\":0, \"message\":\"edit successfully\"}";
	}
	
}
