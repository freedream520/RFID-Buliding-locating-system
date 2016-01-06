package module;

public class RFID implements java.io.Serializable{
	private String RFIDid;
	private String empName;
	public String getRFIDid() {
		return RFIDid;
	}
	public void setRFIDid(String rFIDid) {
		RFIDid = rFIDid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public RFID(String rFIDid, String empName) {
		super();
		RFIDid = rFIDid;
		this.empName = empName;
	}
	public RFID() {
		super();
	}
	
}
