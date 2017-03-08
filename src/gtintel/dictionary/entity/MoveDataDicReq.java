package gtintel.dictionary.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class MoveDataDicReq {
	private Integer id;
	private String srcId;
	private String targetId;
	private Integer caseId;
	private String reponse;
	private int isPassed;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSrcId() {
		return srcId;
	}
	public void setSrcId(String srcId) {
		this.srcId = srcId;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
/*	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public int getIsPassed() {
		return isPassed;
	}
	public void setIsPassed(int isPassed) {
		this.isPassed = isPassed;
	}*/
	@Override
	public String toString() {
		return "srcId=" + srcId + "&targetId=" + targetId;
	}
	

	public MoveDataDicReq(Integer id, String srcId, String targetId,Integer caseId) {
		super();
		this.id = id;
		this.srcId = srcId;
		this.targetId = targetId;
		this.caseId = caseId;
	}
	
	
	public MoveDataDicReq() {
		super();
	}
/*	public MoveDataDicReq(Integer id, String srcId, String targetId, String reponse, int isPassed) {
		super();
		this.id = id;
		this.srcId = srcId;
		this.targetId = targetId;
		this.reponse = reponse;
		this.isPassed = isPassed;
	}*/

	
}
