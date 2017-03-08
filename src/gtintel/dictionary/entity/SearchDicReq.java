package gtintel.dictionary.entity;

public class SearchDicReq {
	private Integer caseId;
	private String name;
	private Integer index;
	private Integer size;
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
	@Override
	public String toString() {
		return "name="+name+"&index="+index+"&size="+size;
	}
}
