package module;

public class Inandout implements java.io.Serializable{
	private String RFIDid;
	private String MACid;
	private String date;
	private String time;
	private int id;
	public Inandout(String rFIDid, String mACid, String date, String time) {
		super();
		RFIDid = rFIDid;
		MACid = mACid;
		this.date = date;
		this.time = time;
	}
	public Inandout(String rFIDid, String mACid, String date, String time, int id) {
		super();
		RFIDid = rFIDid;
		MACid = mACid;
		this.date = date;
		this.time = time;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Inandout() {
	}
	public String getRFIDid() {
		return RFIDid;
	}
	public void setRFIDid(String rFIDid) {
		RFIDid = rFIDid;
	}
	public String getMACid() {
		return MACid;
	}
	public void setMACid(String mACid) {
		MACid = mACid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}	
}
