package module;

public class Event {
	private String RFIDid;
	private String empName;
	private String MACid;
	private String posName;
	private String D;
	private String T;
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getMACid() {
		return MACid;
	}
	public void setMACid(String mACid) {
		MACid = mACid;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getD() {
		return D;
	}
	public void setD(String date_) {
		D = date_;
	}
	public String getT() {
		return T;
	}
	public void setT(String time_) {
		T = time_;
	}
	public Event(String rFIDid, String empName, String mACid, String posName, String date_, String time_) {
		super();
		RFIDid = rFIDid;
		this.empName = empName;
		MACid = mACid;
		this.posName = posName;
		D = date_;
		T = time_;
	}
	
}
