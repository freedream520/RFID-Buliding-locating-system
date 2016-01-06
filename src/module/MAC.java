package module;

public class MAC implements java.io.Serializable{
	private String MACid;
	private String posName;
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
	public MAC(String mACid, String posName) {
		super();
		MACid = mACid;
		this.posName = posName;
	}
	public MAC() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
