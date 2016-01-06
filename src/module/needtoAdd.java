package module;

public class needtoAdd implements java.io.Serializable{
	private String id;
	private String type;// RFID / MAC(position)
	
	public needtoAdd(String id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public needtoAdd() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
