package gtintel.dictionary.entity;

public class GetIdsReq {
	private Integer caseId;
	private String parentId;
	private boolean beDeep;
	private String search;
	private String reponse;
	private int isPassed;

	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public boolean isBeDeep() {
		return beDeep;
	}
	public void setBeDeep(boolean beDeep) {
		this.beDeep = beDeep;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	@Override
	public String toString() {
		return "parentId="+parentId+"&beDeep="+beDeep+"&search="+search;
	}
}
