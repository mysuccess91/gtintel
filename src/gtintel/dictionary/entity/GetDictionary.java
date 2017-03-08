package gtintel.dictionary.entity;

public class GetDictionary {
	private Integer caseId;
	private String id;
	private String response;
	private int isPassed;
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public GetDictionary() {
		super();
	}
	
	public GetDictionary(String id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "id = "+id;
	}
}
