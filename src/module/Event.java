package module;

public class Event {
	private String empName;
	private String Date_;
	private String Time_;
	public Event(String empName, String date_, String time_) {
		super();
		this.empName = empName;
		Date_ = date_;
		Time_ = time_;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDate_() {
		return Date_;
	}
	public void setDate_(String date_) {
		Date_ = date_;
	}
	public String getTime_() {
		return Time_;
	}
	public void setTime_(String time_) {
		Time_ = time_;
	}
	
}
