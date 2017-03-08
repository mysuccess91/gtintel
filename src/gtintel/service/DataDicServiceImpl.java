package gtintel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import gtintel.dao.DataDictDao;
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

@Service("dataDicService")
public class DataDicServiceImpl  implements DataDicService {
	
/*	//@Resource(name="addDataDicReqDao")
	private AddDataDictReqDao addDicDao;
	public void setAddDicdao(AddDataDictReqDao addDicdao){
		this.addDicDao = addDicdao;
	}*/
	private DataDictDao dicDao;

	public void setDicDao(DataDictDao dicDao) {
		this.dicDao = dicDao;
	}
	
	/**AddDic接口*/
	@Override
	public void addAddDic(Integer LftId,Integer RgtId,Integer SortNum,Integer Depth,String FkDictionaryId,String ParentId,String HasChild,String Description,String DisplayName,String Code,String Value,String AddTime,String ModifyUser,String FirstSpell,String FullSpell,String Id,String AddUser,String AppId,String ModifyTime,String DataState) {
		//addDicDao.save(addReq);

	}
	
	public void addAddDic(AddDataDictionaryReq req){
		dicDao.saveAddDic(req);
	}

	@Override
	public void updateAddDataDic(Integer caseId,String result) {
		dicDao.updateAddDataDic(caseId, result);

	}


	@Override
	public List<AddDataDictionaryReq> getAddDataDictionaryReqList() {
		return dicDao.findAddDataDictionaryReqList();
	}
	

	@Override
	public void editAddDic(Integer LftId,Integer RgtId,Integer SortNum,Integer Depth,String FkDictionaryId,String ParentId,String HasChild,String Description,String DisplayName,String Code,String Value,String AddTime,String ModifyUser,String FirstSpell,String FullSpell,String Id,String AddUser,String AppId,String ModifyTime,String DataState) {
		
	}
	
	public void editAddDic(AddDataDictionaryReq req){
		dicDao.editAddDic(req);
	}
	
	/**MoveDic接口*/
	@Override
	public List<MoveDataDicReq> getMoveDataDicList() {
		return dicDao.findMoveDataDicList();
	}

	@Override
	public void updateMoveDataDic(String srcId,String targetId,String response) {
		dicDao.updateMoveDataDic(srcId,targetId,response);
		
	}

	@Override
	public void addMoveDic(Integer id, String srcId, String targetId) {
		dicDao.addMoveDic(id, srcId, targetId);
		
	}

	@Override
	public void editMoveDic(int id,String srcId,String targetId,Integer caseId) {
		dicDao.editMoveDic(id, srcId, targetId, caseId);
	}

	/**Modify接口*/
	public List<ModifyDataDictionaryReq> getModifyDataDicList(){
		return dicDao.getModifyDicList();
	}
	public void updateModifyDic(Integer caseId,String result){
		dicDao.updateModifyDataDic(caseId, result);
	}
	public void addModifyDic(ModifyDataDictionaryReq req){
		dicDao.addModifyDic(req);
	}
	public void editModifyDic(ModifyDataDictionaryReq req){
		dicDao.editModifyDic(req);
	}

	/**Delete接口*/
	public List<DelDataDictionary> getDelDataDicList(){
		return dicDao.getDelDataDicList();
	}
	public void updateDelDic(Integer caseId,String result){
		dicDao.updateDelDic(caseId, result);
	}
	public void addDelDic(DelDataDictionary req){
		dicDao.addDelDic(req);
		
	}
	public void editDelDic(DelDataDictionary req){
		dicDao.editDelDic(req);
	}
	
	/**getDic接口*/
	public List<GetDataDic> getGetDataDicList(){
		return dicDao.getGetDataDicList();
	}
	public void updateGetDic(Integer caseId,String result){
		dicDao.updateGetDic(caseId, result);
	}
	public void addGetDic(GetDataDic req){
		dicDao.addGetDic(req);
	}
	public void editGetDic(GetDataDic req){
		dicDao.editGetDic(req);
	}
	
	/**GetByName接口*/
	public List<GetByNameReq> getGetByNameList(){
		return dicDao.getGetByNameList();
	}
	public void updateGetByName(Integer caseId,String result){
		dicDao.updateGetByName(caseId, result);
	}
	public void addGetByName(GetByNameReq req){
		dicDao.addGetByName(req);
	}
	public void editGetByName(GetByNameReq req){
		dicDao.editGetByName(req);
	}
	
	/**GetIds接口*/
	public List<GetIdsReq> getGetIdsList(){
		return dicDao.getGetIdsList();
	}
	public void updateGetIds(Integer caseId,String result){
		dicDao.updateGetIds(caseId, result);
	}
	public void addGetIds(GetIdsReq req){
		dicDao.addGetIds(req);
	}
	public void editGetIds(GetIdsReq req){
		dicDao.editGetIds(req);
	}

	/**SearchDic接口*/
	public List<SearchDicReq> getSearchDicList(){
		return dicDao.getSearchDicList();
	}
	public void updateSearchDic(Integer caseId,String result){
		dicDao.updateSearchDic(caseId, result);
	}
	public void addSearchDic(SearchDicReq req){
		dicDao.addSearchDic(req);
	}
	public void editSearchDic(SearchDicReq req){
		dicDao.editSearchDic(req);
	}
	
	/**getDictionary接口*/
	public List<GetDictionary> getDictionaryList(){
		return dicDao.getDictionaryList();
	}
	public void updateGetDictionary(Integer caseId,String result){
		dicDao.updateGetDictionary(caseId, result);
	}
	public void addGetDictionary(GetDictionary req){
		dicDao.addGetDictionary(req);
	}
	public void editGetDictionary(GetDictionary req){
		dicDao.editGetDictionary(req);
	}
	
	/**getDictionaries接口*/
	public List<GetDictionaries> getDictionariesList(){
		return dicDao.getDictionariesList();
	}
	public void updateGetDictionaries(Integer caseId,String result){
		dicDao.updateGetDictionaries(caseId, result);
	}
	public void addGetDictionaries(GetDictionaries req){
		dicDao.addGetDictionaries(req);
	}
	public void editGetDictionaries(GetDictionaries req){
		dicDao.editGetDictionaries(req);
	}
	
	/**GetPageIds接口*/
	public List<GetPageIds> getPageIdsList(){
		return dicDao.getPageIdsList();
	}
	public void updateGetPageIds(Integer caseId,String result){
		dicDao.updateGetPageIds(caseId, result);
	}
	public void addGetPageIds(GetPageIds req){
		dicDao.addGetPageIds(req);
	}
	public void editGetPageIDs(GetPageIds req){
		dicDao.editGetPageIDs(req);
	}
	
}
