package gtintel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

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

public class DataDicDaoImpl 
		extends JdbcDaoSupport implements DataDictDao {
	
	public List<?> getList(String itfName) throws ClassNotFoundException{
		//Class<?> clazz = Class.forName("gtintel.dictionary.entity."+_map.get("itfName"));
		//clazz.getClassLoader().loadClass(itfName).getClass();
		String sql = "select * from t_"+itfName;
		List list = this.getJdbcTemplate().queryForList(sql);
		return list;
	}
	/**AddDictionary接口*/
	
	@Override
	public List<AddDataDictionaryReq> findAddDataDictionaryReqList() {
		String sql = "select * from t_adddatadictionary";
		List<AddDataDictionaryReq> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<AddDataDictionaryReq>(AddDataDictionaryReq.class));
		return list;
	}
	
	//添加
	@Override
	public void saveAddDic(Integer LftId,Integer RgtId,Integer SortNum,Integer Depth,String FkDictionaryId,String ParentId,String HasChild,String Description,String DisplayName,String Code,String Value,String AddTime,String ModifyUser,String FirstSpell,String FullSpell,String Id,String AddUser,String AppId,String ModifyTime,String DataState) {
		String sql = "insert into t_adddatadictionary (id,srcId,targetId) values(?,?,?)";
		this.getJdbcTemplate().update(sql,new Object[]{});
	}
	public void saveAddDic(final AddDataDictionaryReq req){
		
	/*	List l = new ArrayList();
		String str= "(";
		String val = "(";
		String sql = "insert into t_adddatadictionary "+
				"("+ str +") values("+ val +")";
		for (int i =0; i<keys.length; i++){
			str += keys[i].name+","
			var += "?,";
		}
		//TODO:remove the last "," symbol.

		if (str!="") val = str.substring(0, val.length-1);
		if (var!="") val = val.substring(0, val.length-1);
		str += ")";
		val += ")";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int len = keys.length;
				for (int i= 0; i< len; i++){
					switch (keys[i].type) {
					case "string":
						ps.setString(keys[i].name, req.getFkDictionaryId());
						break;
					case "int":
					case "float":
					case "double":
						ps.setDouble(keys[i].name, );
						break;
					}
					default:
						ps.setString(keys[i].name, req.getFkDictionaryId());
						break;
				}
			}
			
		});*/
	}

	//保存报文
	@Override
	public void updateAddDataDic(final Integer caseId,final String result) {
		String sql = "update t_adddatadictionary set response =? "+"where caseId = ?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);			
			}
		});
		
	}
	
	public void editAddDic(Integer LftId,Integer RgtId,Integer SortNum,Integer Depth,String FkDictionaryId,String ParentId,String HasChild,String Description,String DisplayName,String Code,String Value,String AddTime,String ModifyUser,String FirstSpell,String FullSpell,String Id,String AddUser,String AppId,String ModifyTime,String DataState){
		String sql = "update t_adddatadictionary set id =? ,srcId=?, targetId=?"+"where caseId=?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				//ps.setString(1, addDicReq.getId());
			}		
		});	
	}
	
	public void editAddDic(final AddDataDictionaryReq req){
		String sql = 
				"update t_adddatadictionary set LftId =?,RgtId =?,SortNum =?,Depth =?,FkDictionaryId =?,ParentId =?,HasChild =?,Description =?,DisplayName =?,Code =?,Value =?,AddTime =?,ModifyUser =?,FirstSpell =?,FullSpell =?,Id =?,AddUser =?,AppId =?,ModifyTime =?,DataState =? "+" where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, req.getLftId());
				ps.setInt(2, req.getRgtId());
				ps.setInt(3, req.getSortNum());
				ps.setInt(4, req.getDepth());
				ps.setString(5, req.getFkDictionaryId());
				ps.setString(6, req.getParentId());
				ps.setString(7, req.getHasChild());
				ps.setString(8, req.getDescription());
				ps.setString(9, req.getDisplayName());
				ps.setString(10, req.getCode());
				ps.setString(11, req.getValue());
				ps.setString(12, req.getAddTime());
				ps.setString(13, req.getModifyUser());
				ps.setString(14, req.getFirstSpell());
				ps.setString(15, req.getFullSpell());
				ps.setString(16, req.getId());
				ps.setString(17, req.getAddUser());
				ps.setString(18, req.getAppId());
				ps.setString(19, req.getModifyTime());
				ps.setString(20, req.getDataState());
				ps.setInt(21, req.getCaseId());
			}
		});	
	}
	
	//删除
/*	@Override
	public void deleteById(int id) {
		String sql = "delete from adddatadictionary where caseId=?";
		
		this.getJdbcTemplate()
		.update(sql,new Object[]{id});
		
	}*/

	//查找AddDic
/*	@Override
	public AddDataDictionaryReq findById(int id) {
		String sql="select * from adddatadictionary where caseId = ?";
		final AddDataDictionaryReq addDicReq = new AddDataDictionaryReq();
		this.getJdbcTemplate().query(sql,new Object[]{id},
				new RowCallbackHandler() {	
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					
					addDicReq.setLftId(rs.getInt("LftId"));
					addDicReq.setRgtId(rs.getInt("RgtId"));
					addDicReq.setSortNum(rs.getInt("SortNum"));
					addDicReq.setDepth(rs.getInt("Depth"));
					addDicReq.setFkDictionaryId(rs.getString("FkDictionaryId"));
					addDicReq.setParentId(rs.getString("ParentId"));
					addDicReq.setHasChild(rs.getString("HasChild"));
					addDicReq.setDescription(rs.getString("Description"));
					addDicReq.setDisplayName(rs.getString("DisplayName"));
					addDicReq.setCode(rs.getString("Code"));
					addDicReq.setValue(rs.getString("Value"));
					addDicReq.setAddTime(rs.getString("AddTime"));
					addDicReq.setModifyUser(rs.getString("ModifyUser"));
					addDicReq.setFirstSpell(rs.getString("FirstSpell"));
					addDicReq.setFullSpell(rs.getString("FullSpell"));
					addDicReq.setId(rs.getString("Id"));
					addDicReq.setAddUser(rs.getString("AddUser"));
					addDicReq.setAppId(rs.getString("AppId"));
					addDicReq.setModifyTime(rs.getString("ModifyTime"));
					addDicReq.setDataState(rs.getString("DataState"));
					
				}
			});
		
		return addDicReq;
	}*/

	//查找全部AddDictionary


	/**MoveDictionary接口*/
	//获取dMoveDataDic集合
	@Override
	public List<MoveDataDicReq> findMoveDataDicList() {
		String sql = "select caseId, id, srcId,targetId,response,isPassed from t_movedatadict";
		List<MoveDataDicReq> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<MoveDataDicReq>(MoveDataDicReq.class));
		//List list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(MoveDataDicReq.class));
		return list;
	}


	@Override
	public void updateMoveDataDic(final String srcId,final String targetId,final String response) {
		String sql = "update t_movedatadict set response =? "+"where srcId=?"+" and targetId=?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, response);
				ps.setString(2, srcId);
				ps.setString(3, targetId);
				
			}
		});
		
	}


	@Override
	public void addMoveDic(final Integer id, final String srcId, final String targetId) {
		String sql = "insert into t_movedatadict (id,srcId,targetId) values(?,?,?)";
		this.getJdbcTemplate().update(sql,new Object[]{id,srcId,targetId});
		
	}
	
//	public static void main(String[] args) {
//		//new DataDicDaoImpl().addMoveDic(new MoveDataDicReq(3, "1005", "1006"));
//		//new DataDicDaoImpl().updateMoveDataDic("1001", "1002", "123");
//		new DataDicDaoImpl().findMoveDataDicList();
//	}


	@Override
	public void editMoveDic(final int id, final String srcId, final String targetId,final Integer caseId) {
		String sql = "update t_movedatadict set id =? ,srcId=?, targetId=?"+"where caseId=?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
				ps.setString(2, srcId);
				ps.setString(3, targetId);
				ps.setInt(4, caseId);
			}
			
		});
		
	}

	
	/**Modify接口*/
	public List<ModifyDataDictionaryReq> getModifyDicList(){
		String sql = "select * from t_modifydatadic";
		List<ModifyDataDictionaryReq> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<ModifyDataDictionaryReq>(ModifyDataDictionaryReq.class));
		return list;
	}
	public void updateModifyDataDic(final Integer caseId,final String result){
		String sql = "update t_modifydatadic set response =? "+"where caseId = ?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);			
			}
		});
	}
	public void addModifyDic(final ModifyDataDictionaryReq req){
		String sql = "insert into t_modifydatadic "+
				"(LftId,RgtId,SortNum,Depth,FkDictionaryId,ParentId,HasChild,Description,DisplayName,Code,Value,AddTime,ModifyUser,FirstSpell,FullSpell,Id,AddUser,AppId,ModifyTime,DataState) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, req.getLftId());
				ps.setInt(2, req.getRgtId());
				ps.setInt(3, req.getSortNum());
				ps.setInt(4, req.getDepth());
				ps.setString(5, req.getFkDictionaryId());
				ps.setString(6, req.getParentId());
				ps.setString(7, req.getHasChild());
				ps.setString(8, req.getDescription());
				ps.setString(9, req.getDisplayName());
				ps.setString(10, req.getCode());
				ps.setString(11, req.getValue());
				ps.setString(12, req.getAddTime());
				ps.setString(13, req.getModifyUser());
				ps.setString(14, req.getFirstSpell());
				ps.setString(15, req.getFullSpell());
				ps.setString(16, req.getId());
				ps.setString(17, req.getAddUser());
				ps.setString(18, req.getAppId());
				ps.setString(19, req.getModifyTime());
				ps.setString(20, req.getDataState());
			}
			
		});
	}
	public void editModifyDic(final ModifyDataDictionaryReq req){
		String sql = 
				"update t_modifydatadic set LftId =?,RgtId =?,SortNum =?,Depth =?,FkDictionaryId =?,ParentId =?,HasChild =?,Description =?,DisplayName =?,Code =?,Value =?,AddTime =?,ModifyUser =?,FirstSpell =?,FullSpell =?,Id =?,AddUser =?,AppId =?,ModifyTime =?,DataState =? "+" where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, req.getLftId());
				ps.setInt(2, req.getRgtId());
				ps.setInt(3, req.getSortNum());
				ps.setInt(4, req.getDepth());
				ps.setString(5, req.getFkDictionaryId());
				ps.setString(6, req.getParentId());
				ps.setString(7, req.getHasChild());
				ps.setString(8, req.getDescription());
				ps.setString(9, req.getDisplayName());
				ps.setString(10, req.getCode());
				ps.setString(11, req.getValue());
				ps.setString(12, req.getAddTime());
				ps.setString(13, req.getModifyUser());
				ps.setString(14, req.getFirstSpell());
				ps.setString(15, req.getFullSpell());
				ps.setString(16, req.getId());
				ps.setString(17, req.getAddUser());
				ps.setString(18, req.getAppId());
				ps.setString(19, req.getModifyTime());
				ps.setString(20, req.getDataState());
				ps.setInt(21, req.getCaseId());
			}
		});	
	}
	
	
	/**delete接口*/
	public List<DelDataDictionary> getDelDataDicList(){
		String sql = "select * from t_deldatadic";
		List<DelDataDictionary> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<DelDataDictionary>(DelDataDictionary.class));
		return list;
	}
	public void updateDelDic(final Integer caseId,final String result){
		String sql = "update t_deldatadic set response =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);
			}
			
		});
	}
	public void addDelDic(final DelDataDictionary req){
		String sql = "insert into t_deldatadic (instanceId) values(?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getInstanceId());
			}});
	}
	public void editDelDic(final DelDataDictionary req){
		String sql = "update  t_deldatadic set instanceId =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getInstanceId());
				ps.setInt(2, req.getCaseId());
			}});
	}
	
	
	/**getDic接口*/
	public List<GetDataDic> getGetDataDicList(){
		String sql = "select * from t_getdatadic";
		List<GetDataDic> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<GetDataDic>(GetDataDic.class));
		return list;
	}
	public void updateGetDic(final Integer caseId,final String result){
		String sql = "update t_getdatadic set response =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);
			}});
	}
	public void addGetDic(final GetDataDic req){
		String sql = "insert into t_getdatadic (id) values(?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getId());
			}
			
		});
	}
	public void editGetDic(final GetDataDic req){
		String sql = "update t_getdatadic set id =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getId());
				ps.setInt(2, req.getCaseId());
			}});
	}
	
	
	/**GetByName接口*/
	public List<GetByNameReq> getGetByNameList(){
		String sql = "select * from t_getbynamedic";
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<GetByNameReq> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(GetByNameReq.class));
		return list;
	}
	public void updateGetByName(final Integer caseId,final String result){
		String sql = "update t_getbynamedic set response =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);
			}		
		});
	}
	public void addGetByName(final GetByNameReq req){
		String sql = "insert into t_getbynamedic (name,parentId) value(?,?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getName());
				ps.setString(2, req.getParentId());
			}
		});
	}
	public void editGetByName(final GetByNameReq req){
		String sql = "update t_getbynamedic set name =?, parentId =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getName());
				ps.setString(2, req.getParentId());
				ps.setInt(3, req.getCaseId());
			}
		});
	}
	
	/**GetIds接口*/
	public List<GetIdsReq> getGetIdsList(){
		String sql ="select * from t_getids";
		List<GetIdsReq> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<GetIdsReq>(GetIdsReq.class));
		return list;
	}
	public void updateGetIds(final Integer caseId,final String result){
		String sql ="update t_getids set response =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);
			}
		});
	}
	public void addGetIds(final GetIdsReq req){
		String sql = "insert into t_getids (parentId,beDeep,search) values(?,?,?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getParentId());
				ps.setBoolean(2, req.isBeDeep());
				ps.setString(3, req.getSearch());
			}
		});
	}
	public void editGetIds(final GetIdsReq req){
		String sql ="update t_getids set parentId =?,beDeep =?,search =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getParentId());
				ps.setBoolean(2, req.isBeDeep());
				ps.setString(3, req.getSearch());
				ps.setInt(4, req.getCaseId());
			}
		});
	}
	
	/**SearchDic接口*/
	public List<SearchDicReq> getSearchDicList(){
		String sql = "select * from t_searchdic";
		List<SearchDicReq> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<SearchDicReq>(SearchDicReq.class));
		return list;
	}
	public void updateSearchDic(final Integer caseId,final String result){
		String sql = "update t_searchdic set response =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);
			}
		});
	}
	public void addSearchDic(final SearchDicReq req){
		String sql = "insert into t_searchdic (`name`,`index`,size) values(?,?,?)";
		//String sql = "insert into t_searchdic (name,index,size) values(?,?,?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getName());
				ps.setInt(2,req.getIndex());
				ps.setInt(3, req.getSize());
			}
		});
	}
	public void editSearchDic(final SearchDicReq req){
		String sql = "update t_searchdic set `name` =?,`index` =?,size =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getName());
				ps.setInt(2,req.getIndex());
				ps.setInt(3, req.getSize());
				ps.setInt(4, req.getCaseId());
			}
		});
	}
	
	/**getDictionary接口*/
	public List<GetDictionary> getDictionaryList(){
		String sql = "select * from t_getdictionary";
		List<GetDictionary> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<GetDictionary>(GetDictionary.class));
		return list;
	}
	public void updateGetDictionary(final Integer caseId,final String result){
		String sql = "update t_getdictionary set response =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);
			}
		});
	}
	public void addGetDictionary(final GetDictionary req){
		String sql = "insert into t_getdictionary (`id`) value(?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getId());
			}
		});
	}
	public void editGetDictionary(final GetDictionary req){
		String sql = "update t_getdictionary set id =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getId());
				ps.setInt(2, req.getCaseId());
			}});
	}
	
	/**getDictionaries接口*/
	public List<GetDictionaries> getDictionariesList(){
		String sql = "select * from t_getdictionaries";
		List<GetDictionaries> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<GetDictionaries>(GetDictionaries.class));
		return list;
	}
	
	public void updateGetDictionaries(final Integer caseId,final String result){
		String sql = "update t_getdictionaries set response =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);
			}
		});
	}
	
	public void addGetDictionaries(final GetDictionaries req){
		String sql = "insert into t_getdictionaries (parentId,beDeep,search) values(?,?,?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getParentId());
				ps.setBoolean(2, req.isBeDeep());
				ps.setString(3, req.getSearch());
			}
		});
	}
	public void editGetDictionaries(final GetDictionaries req){
		String sql ="update t_getdictionaries set parentId =?,beDeep =?,search =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getParentId());
				ps.setBoolean(2, req.isBeDeep());
				ps.setString(3, req.getSearch());
				ps.setInt(4, req.getCaseId());
			}
		});
	}
	
	/**GetPageIds接口*/
	public List<GetPageIds> getPageIdsList(){
		String sql = "select * from t_getpageids";
		List<GetPageIds> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<GetPageIds>(GetPageIds.class));
		return list;
	}
	public void updateGetPageIds(final Integer caseId,final String result){
		String sql = "update t_getpageids set response = ? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, result);
				ps.setInt(2, caseId);
			}
		});
	}
	public void addGetPageIds(final GetPageIds req){
		String sql = "insert into t_getpageids (parentId,`index`,`size`,search) values(?,?,?,?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getParentId());
				ps.setInt(2, req.getIndex());
				ps.setInt(3, req.getSize());
				ps.setString(4, req.getSearch());
			}
		});
	}
	public void editGetPageIDs(final GetPageIds req){
		String sql ="update t_getpageids set parentId =?,`index` =?,`size` =?,search =? where caseId =?";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, req.getParentId());
				ps.setInt(2, req.getIndex());
				ps.setInt(3, req.getSize());
				ps.setString(4, req.getSearch());
				ps.setInt(5, req.getCaseId());
			}
		});
	}
}
