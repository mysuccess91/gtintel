package gtintel.dictionary.entity;

public class GetByNameReq {
	private Integer caseId;
	private String name;
	private String parentId;
	private String reponse;
	private int isPassed;

	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	@Override
	public String toString() {
		return "name="+name+"&parentId="+parentId;
	}
}
