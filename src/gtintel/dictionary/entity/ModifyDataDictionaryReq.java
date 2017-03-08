package gtintel.dictionary.entity;

public class ModifyDataDictionaryReq extends BaseRequest{
	private Integer caseId;
	private Integer LftId;
	private Integer RgtId;
	private Integer SortNum;
	private Integer Depth;
	private String FkDictionaryId;
	private String ParentId;
	private String HasChild;
	private String Description;
	private String DisplayName;
	private String Code;
	private String Value;
	private String AddTime;
	private String ModifyUser;
	private String FirstSpell;
	private String FullSpell;
	private String Id;
	private String AddUser;
	private String AppId;
	private String ModifyTime;
	private String DataState;
	
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getLftId() {
		return LftId;
	}
	public void setLftId(Integer lftId) {
		LftId = lftId;
	}
	public Integer getRgtId() {
		return RgtId;
	}
	public void setRgtId(Integer rgtId) {
		RgtId = rgtId;
	}
	public Integer getSortNum() {
		return SortNum;
	}
	public void setSortNum(Integer sortNum) {
		SortNum = sortNum;
	}
	public Integer getDepth() {
		return Depth;
	}
	public void setDepth(Integer depth) {
		Depth = depth;
	}
	public String getFkDictionaryId() {
		return FkDictionaryId;
	}
	public void setFkDictionaryId(String fkDictionaryId) {
		FkDictionaryId = fkDictionaryId;
	}
	public String getParentId() {
		return ParentId;
	}
	public void setParentId(String parentId) {
		ParentId = parentId;
	}
	public String getHasChild() {
		return HasChild;
	}
	public void setHasChild(String hasChild) {
		HasChild = hasChild;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDisplayName() {
		return DisplayName;
	}
	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getAddTime() {
		return AddTime;
	}
	public void setAddTime(String addTime) {
		AddTime = addTime;
	}
	public String getModifyUser() {
		return ModifyUser;
	}
	public void setModifyUser(String modifyUser) {
		ModifyUser = modifyUser;
	}
	public String getFirstSpell() {
		return FirstSpell;
	}
	public void setFirstSpell(String firstSpell) {
		FirstSpell = firstSpell;
	}
	public String getFullSpell() {
		return FullSpell;
	}
	public void setFullSpell(String fullSpell) {
		FullSpell = fullSpell;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getAddUser() {
		return AddUser;
	}
	public void setAddUser(String addUser) {
		AddUser = addUser;
	}
	public String getAppId() {
		return AppId;
	}
	public void setAppId(String appId) {
		AppId = appId;
	}
	public String getModifyTime() {
		return ModifyTime;
	}
	public void setModifyTime(String modifyTime) {
		ModifyTime = modifyTime;
	}
	public String getDataState() {
		return DataState;
	}
	public void setDataState(String dataState) {
		DataState = dataState;
	}
	public ModifyDataDictionaryReq() {
		super();
	}

}
