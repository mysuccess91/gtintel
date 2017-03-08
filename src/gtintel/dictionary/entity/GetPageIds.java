package gtintel.dictionary.entity;

public class GetPageIds {
	
	private Integer caseId;
	private String parentId;
	private Integer index;
	private Integer size;
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
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	@Override
	public String toString() {
		return "parentId="+parentId+"&index="+index+"&size="+size+"&search="+search;
	}
	

}
