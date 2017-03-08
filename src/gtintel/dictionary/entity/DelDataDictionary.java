package gtintel.dictionary.entity;

public class DelDataDictionary {
	private Integer caseId;
	private String instanceId;
	private String response;
	private int isPassed;
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	@Override
	public String toString() {
		return "instanceId=" + instanceId;
	}
	
	
}
