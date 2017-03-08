package gtintel.service;

import java.util.List;

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
public interface DataDicService {
	
	/**AddDictionary接口*/
	public List<AddDataDictionaryReq> getAddDataDictionaryReqList();
	//public void getAddDataDicList();
	public void updateAddDataDic(Integer caseId,String result);
	public void addAddDic(Integer LftId,Integer RgtId,Integer SortNum,Integer Depth,String FkDictionaryId,String ParentId,String HasChild,String Description,String DisplayName,String Code,String Value,String AddTime,String ModifyUser,String FirstSpell,String FullSpell,String Id,String AddUser,String AppId,String ModifyTime,String DataState);
	public void addAddDic(AddDataDictionaryReq req);
	public void editAddDic(Integer LftId,Integer RgtId,Integer SortNum,Integer Depth,String FkDictionaryId,String ParentId,String HasChild,String Description,String DisplayName,String Code,String Value,String AddTime,String ModifyUser,String FirstSpell,String FullSpell,String Id,String AddUser,String AppId,String ModifyTime,String DataState);
	public void editAddDic(AddDataDictionaryReq req);
	//public AddDataDictionaryReq findById(int id);
	//public void deleteById(int id);
	
	/**MoveDictionary接口*/
	public List getMoveDataDicList();
	public void updateMoveDataDic(String srcId,String targetId,String response);
	public void addMoveDic(Integer id, String srcId, String targetId);
	public void editMoveDic(int id,String srcId,String targetId,Integer caseId);
	
	/**Modify接口*/
	public List<ModifyDataDictionaryReq> getModifyDataDicList();
	public void updateModifyDic(Integer caseId,String result);
	public void addModifyDic(ModifyDataDictionaryReq req);
	public void editModifyDic(ModifyDataDictionaryReq req);
	
	/**Delete接口*/
	public List<DelDataDictionary> getDelDataDicList();
	public void updateDelDic(Integer caseId,String result);
	public void addDelDic(DelDataDictionary req);
	public void editDelDic(DelDataDictionary req);
	
	/**getDic接口*/
	public List<GetDataDic> getGetDataDicList();
	public void updateGetDic(Integer caseId,String result);
	public void addGetDic(GetDataDic req);
	public void editGetDic(GetDataDic req);
	
	/**GetByName接口*/
	public List<GetByNameReq> getGetByNameList();
	public void updateGetByName(Integer caseId,String result);
	public void addGetByName(GetByNameReq req);
	public void editGetByName(GetByNameReq req);
	
	/**GetIds接口*/
	public List<GetIdsReq> getGetIdsList();
	public void updateGetIds(Integer caseId,String result);
	public void addGetIds(GetIdsReq req);
	public void editGetIds(GetIdsReq req);
	
	/**SearchDic接口*/
	public List<SearchDicReq> getSearchDicList();
	public void updateSearchDic(Integer caseId,String result);
	public void addSearchDic(SearchDicReq req);
	public void editSearchDic(SearchDicReq req);
	
	/**getDictionary接口*/
	public List<GetDictionary> getDictionaryList();
	public void updateGetDictionary(Integer caseId,String result);
	public void addGetDictionary(GetDictionary req);
	public void editGetDictionary(GetDictionary req);
	
	/**getDictionaries接口*/
	public List<GetDictionaries> getDictionariesList();
	public void updateGetDictionaries(Integer caseId,String result);
	public void addGetDictionaries(GetDictionaries req);
	public void editGetDictionaries(GetDictionaries req);
	
	/**GetPageIds接口*/
	public List<GetPageIds> getPageIdsList();
	public void updateGetPageIds(Integer caseId,String result);
	public void addGetPageIds(GetPageIds req);
	public void editGetPageIDs(GetPageIds req);
}
